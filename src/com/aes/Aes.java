package com.aes;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AES加解密算法类 Description: Copyright (C) 2020 botany All Right Reserved. Create
 * Date: 2020年2月24日
 *
 * @author：botany
 * @version 3.4
 */
public class Aes {
//    private Logger logger = LoggerFactory.getLogger(Aes.class.getName());

    /**
     * 算法名称
     */
    private String algorithm = "AES";

    /**
     * 集合,key为sid,value为syskey
     */
    public Map<Integer, String> cryptMap = new HashMap<Integer, String>();

    /**
     * sid 集合
     */
    private Integer[] sids;
    private SyskeyCollector collector;

    /**
     * AES算法调用的统一入口 Definition:
     *
     * @author: botany Created date: 2020年2月24日
     * @param in   需要加解密的字符串
     * @param key  加解密的密钥
     * @param type 加解密类型 从该类的静态变量ENCRYPT和DECRYPT获取
     * @return
     */
    public String desgo(String in, String key, boolean type) {
        String str = null;
        if (in != null && !"".equals(in.trim())) {
            if (type) {// 加密
                str = aesEncode(in, key);
            } else {// 解密
                str = aesDecode(in, key);
            }
        }
        return str;

    }

    /**
     * 采用AES算法解密函数 Definition: author: botany Created date: 2020年2月24日
     *
     * @param in
     * @param key
     * @return
     */
    private String aesDecode(String in, String key) {
        try {
            String dest = null;
            String syskey = "";
            byte[] b = Base64.getDecoder().decode(in);
            String src = new String(b, "ISO-8859-1");
            int index = src.indexOf("_iam");
            if (index != -1) {
                String inarr[] = src.split("_iam");
                String sid = inarr[0];
                if (sid.matches("[0-9]+")) {
                    int id = Integer.valueOf(sid);
                    src = src.substring(index + 4);
                    if (sids != null && id > sids[sids.length - 1] && collector != null) {
                        Map<Integer, String> syskeyMap = collector.collectSyskey();
                        setCryptMap(syskeyMap);
                    }
                    syskey = cryptMap.get(id);
                    if (syskey != null && !"".equals(syskey.trim())) {
                        dest = decode(inarr[1], syskey);
                    } else {
                        dest = decode(inarr[1], key);
                    }
                }
            } else {
                dest = decode(src, key);
            }
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 采用AES算法加密 Definition: author: botany Created date: 2020年2月24日
     *
     * @param in
     * @param key
     * @return
     */
    String aesEncode(String in, String key) {
        try {
            String dest = null;
            if (cryptMap.isEmpty() && collector != null) {
                Map<Integer, String> syskeyMap = collector.collectSyskey();
                setCryptMap(syskeyMap);
            }
            if (!cryptMap.isEmpty()) {
                int id = sids[sids.length - 1];
                String syskey = cryptMap.get(id);
                String src = encode(in, syskey);
                dest = String.valueOf(id) + "_iam" + src;
            } else {
                dest = encode(in, key);
            }
            byte[] sorData = dest.getBytes("ISO-8859-1");
            dest = Base64.getEncoder().encodeToString(sorData);
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 初始化syskey集合,collector收集器
     *
     * @param inMap
     * @param collector
     */
    public void init(Map<Integer, String> inMap, SyskeyCollector collector) {
        setCryptMap(inMap);
        setCollector(collector);
    }

    /**
     * 设置syskey集合
     *
     * @param inMap
     */
    private synchronized void setCryptMap(Map<Integer, String> inMap) {
        if (inMap == null || inMap.isEmpty()) {
            return;
        }
        Set<Integer> set = inMap.keySet();
        for (Integer sid : set) {
            if (!cryptMap.containsKey(sid)) {
                String syskey = inMap.get(sid);
                syskey = syskey.replaceAll("\r\n", "");
                byte[] sorData = null;
                String dest = null;
                try {
                    sorData = Base64.getDecoder().decode(syskey);
                    dest = new String(sorData, "ISO-8859-1");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cryptMap.put(sid, dest);
            }
        }
        set = cryptMap.keySet();
        Integer[] ids = new Integer[set.size()];
        Arrays.sort(set.toArray(ids));
        setSids(ids);

    }

    /**
     * 设置sid集合
     *
     * @param sids
     */
    private synchronized void setSids(Integer[] sids) {
        this.sids = sids;
    }

    /**
     * 设置collector收集器
     *
     * @param collector
     */
    private synchronized void setCollector(SyskeyCollector collector) {
        if (collector == null) {
            return;
        }
        this.collector = collector;
    }

    /**
     * 根据字符密钥生成密钥对象
     *
     * @param strKey
     * @return
     */
    private Key getKey(String strKey) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG"); // 追加防止跨操作系统的密钥对象不同问题
            secureRandom.setSeed(strKey.getBytes());
            keyGenerator.init(128, secureRandom);
            Key key = keyGenerator.generateKey();
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     */
    public String decode(String str, String key) {
        try {
            // base64解码
            byte[] b = Base64.getDecoder().decode(str);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, this.getKey(key));
            byte[] byteFina = cipher.doFinal(b);
            return new String(byteFina);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
//            logger.info("Input length must be multiple of 16 when decrypting");
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     */
    public String encode(String str, String key) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, this.getKey(key));
            byte[] byteFina = cipher.doFinal(str.getBytes());
            // base64编码
            return Base64.getEncoder().encodeToString(byteFina);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
//            logger.info("Input length must be multiple of 16 when decrypting");
//			e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
