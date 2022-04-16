package com.mvtech;



import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyu@mvtech.com.cn
 * @date: 2020-08-27 16:03
 *
 * <p>
 */
public class mvMaskTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

       String info="star-MacBook-Pro.local LOG_DBA;3;101.28.249.24;192.168.2.139;0;";

        System.out.println(info.split(";"));

    }
}
