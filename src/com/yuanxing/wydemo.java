package com.yuanxing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Description: <br>
 * Create Date: 2021/7/30 3:08 下午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class wydemo {

    public static void main(String[] args) {
        String tableName = "linkage.tbl_ls_standard_event_db";

        String sql = "SELECT count(1) cou FROM " + tableName + " WHERE datediff(to_date(OPT_TIME)," + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ")>=0";

        System.out.println(sql);

        final String s = "select t11.* from (select row_number() over (order by t10.OPT_TIME desc) as rnum ,t10.*  from " + tableName + " t10 ) t11  where t11.rnum between " + 0 + " and " + 2000;
        System.out.println(s);
    }
}
