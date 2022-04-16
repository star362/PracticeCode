package com.mvtech;

import org.graylog2.syslog4j.Syslog;
import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.SyslogIF;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class SyslogClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 32376;

    public void generate() {
        SyslogIF syslog = Syslog.getInstance(SyslogConstants.UDP);
        syslog.getConfig().setHost(HOST);
        syslog.getConfig().setPort(PORT);

        StringBuffer buffer = new StringBuffer();
//        buffer.append("LOG_DBA;3;101.28.249.24;192.168.2.139;0;");
//        buffer.append("LOG_DBA;4;192.168.2.139;192.168.0.202;5010001;update asset_application_info set is_del=0 where app_host_id in;update");
//        buffer.append("LOG_DBA;5;192.168.2.139;192.168.0.202;5010000;insert cpu,host=servera,region=us_west value=0.64;insert");
//        buffer.append("LOG_DBA;1;192.168.2.139;192.168.0.202;5050001;SELECT * FROM \"test\" WHERE eeeeeeeeee;select");
//        buffer.append("LOG_DBA;2;192.168.2.139;192.168.0.202;5000012;DELETE FROM \"test\" WHERE id=1;delet*");

//         buffer.append("LOG_DBA;6;BDS;low;5090000;asset_agent;medium;select name as eeeeeeeeee from asset_agent");
        buffer.append("LOG_DBA;8;BDS;sun;5092000;asset_agent;medium;select name as eeeeeeeeee from asset_agent;mon");
//        buffer.append("LOG_DBA;7;BDS;asset_agent;5090000;update;stop");

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("message", buffer.toString());





        try {
            syslog.log(0, URLDecoder.decode(buffer.toString(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("generate log get exception " + e);
        }
        System.out.println("发送成功!");
    }

    public static void main(String[] args) {
        new SyslogClient().generate();
    }
}