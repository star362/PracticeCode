package com.httpclient;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * Description: <br>
 * Create Date: 2021/5/7 10:00 上午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class HttpDemo {


    static String[] ch= {"1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","0"};
    static String[]  ch2 ={"f","0","1","2","3","4","5","6","7","8","9","a","b","c","d","e"};
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "javahahaha123";
        System.out.println(s + " --的unicode编码是：" + gbEncoding(s));
        StringBuilder ret=new StringBuilder();
        StringBuilder ret2=new StringBuilder();
//        System.out.println(gbEncoding(s) + " --转换成中文是："+decodeUnicode(gbEncoding(s)));

        System.out.println("----变换----");

        final char[] x = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            final String s1 = gbEncoding(String.valueOf(x[i]));
            String str = s1.substring(s1.length() - 1);
            final int strch = new BigInteger(str, 16).intValue();

            final String concat = s1.substring(0, s1.length() - 1).concat(ch[strch]);
            final String str1 = decodeUnicode(concat);
            ret.append(str1);
        }
            System.out.println(ret);


        System.out.println("-------还原-------------");

        final char[] x2 = ret.toString().toCharArray();

        for (int i = 0; i < ret.length(); i++) {
            final String s1 = gbEncoding(String.valueOf(x2[i]));
            String str = s1.substring(s1.length() - 1);


            final int strch = new BigInteger(str, 16).intValue();

            final String concat = s1.substring(0, s1.length() - 1).concat(ch2[strch]);

            ret2.append(decodeUnicode(concat));
        }
        System.out.println(ret2);

//        System.out.println(s.toCharArray()[0] + ":::" + Integer.valueOf(s.toCharArray()[0]));
//        System.out.println(Integer.valueOf(s.toCharArray()[0]) + "xxxx" + String.valueOf((char) 99));

//        System.out.println(gbEncoding(s) + " --转换成中文是：" + decodeUnicode("\\u7b80\\u4ecb\\u002dd"));

    }

    /*
     * 中文转unicode编码
     */
    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    /*
     * unicode编码转中文
     */
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
}
