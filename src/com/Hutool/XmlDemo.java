package com.Hutool;

import cn.hutool.Hutool;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: <br>
 * Create Date: 2021/5/20 10:32 上午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class XmlDemo {

    public static void main(String[] args) {
//        final Document document = XmlUtil.parseXml("<?xml version=\"1.0\" encoding=\"UTF-8\"?><SSO><RESULT>1</RESULT><RESULT_MSG>成功</RESULT_MSG><RESULT_MSGCODE>OK</RESULT_MSGCODE><ACCOUNT>admin</ACCOUNT><PROJECTID>111</PROJECTID></SSO>");
        final Document document = XmlUtil.parseXml("<?xml version=\"1.0\" encoding=\"UTF-8\"?><SSO><RESULT>1</RESULT><RESULT_MSG>成功</RESULT_MSG><RESULT_MSGCODE>OK</RESULT_MSGCODE><ACCOUNT>admin</ACCOUNT></SSO>");

        //结果为“ok”
        Object value = XmlUtil.getByXPath("//SSO/RESULT", document, XPathConstants.STRING);

        System.out.println(ObjectUtil.equal("1",value));


        //结果为“ok”
        String value2 = (String) XmlUtil.getByXPath("//SSO/PROJECTID", document, XPathConstants.STRING);

        System.out.println(ObjectUtil.equal(value2,""));
        System.out.println(value2);



        String[] strings =new String[]{"token","admin","erp","admin"};
        final LinkedList<String> collect = Stream.of(strings).collect(Collectors.toCollection(LinkedList::new));

        collect.add(2,value2);
        collect.stream().forEach(System.out::println);
//        System.out.println(objects);

        final String collect1 = collect.stream().collect(Collectors.joining("@"));
        System.out.println(collect1);



        String a="token@admin@@erp@admin";
        final String[] split = a.split("@");
        System.out.println();
    }
}
