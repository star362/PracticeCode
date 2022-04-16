package com.aes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.aes.SyskeyCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Description: 秘钥更新接口<br>
 * Create Date: 2020年2月24日<br>
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 * Copyright (C) 2020 botany.com All Right Reserved.<br>
 *
 * @author botany
 * @version 1.0
 */
public class SyskeyCollectorByRest implements SyskeyCollector {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 秘钥刷新rest接口地址
     */
    private String syskeyRestUrl;

//    private RestTemplate restTemplate = new RestTemplate();

    public SyskeyCollectorByRest(String syskeyRestUrl) {
        this.syskeyRestUrl = syskeyRestUrl;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Map<Integer, String> collectSyskey() {
        /*if (StringUtils.isEmpty(this.syskeyRestUrl)) {
            return null;
        }
        try {
            ResponseEntity<Map> message = this.restTemplate.postForEntity(this.syskeyRestUrl, null, Map.class);
            Map result = message.getBody();
            Map<Integer, String> keyMap = new HashMap<>(result.size());
            Set<Map.Entry> resultSet = result.entrySet();
            for (Map.Entry entry : resultSet) {
                Integer key = null;
                if (entry.getKey() instanceof String) {
                    key = Integer.valueOf((String) entry.getKey());
                } else {
                    key = (Integer) entry.getKey();
                }
                keyMap.put(key, (String) entry.getValue());
            }
            return keyMap;
        } catch (Exception e) {
            logger.warn("Synchronization crypt syskey from {} failure !", this.syskeyRestUrl);
        }*/
        return null;
    }

}
