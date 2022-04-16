package com.subject2;


import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-13 09:16
 * @describe:
 */
public class SubMain {


    public static void main(String[] args) throws UnsupportedEncodingException {
        final String s = "* * 8 * * ?";


        // 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString("* * 8 * * ?".getBytes("utf-8"));

        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

        System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
        base64encodedString = Base64.getUrlEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
        System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
        }

        byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

    }
}
