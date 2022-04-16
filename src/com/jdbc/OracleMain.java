package com.jdbc;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Description: <br>
 * Create Date: 2021/4/2 2:03 下午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class OracleMain {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //第一步：注册驱动
            //第一种方式：类加载(常用)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //第二种方式：利用Driver对象
            Driver driver = new OracleDriver();
            DriverManager.deregisterDriver(driver);

            //第三种方式:利用系统参数  需在idea中配置program arguments为下面的参数
            //-Djdbc.drivers = oracle.jdbc.OracleDriver



            //第二步：获取连接
            //第一种方式：利用DriverManager（常用）
            //connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "你的oracle数据库用户名", "用户名密码");
            connect = DriverManager.getConnection("jdbc:oracle:thin:@172.16.2.186:1521:XE", "scott", "tiger");
//jdbc.url=jdbc\:oracle\:thin\:@(DESCRIPTION\=(ADDRESS\=(PROTOCOL\=TCP)(HOST\=172.16.70.68)(PORT\=1521))
// (ADDRESS\=(PROTOCOL\=TCP)(HOST\=172.16.70.69)(PORT\=1521))(LOAD_BALANCE\=yes)(CONNECT_DATA\=(SERVER\=DEDICATED)
// (SERVICE_NAME\=IPNETDB)(FAILOVER_MODE\=(TYPE\=SELECT)(METHOD\=BASIC)(RETRIES\=180)(DELAY\=5))))
            //第二种方式：直接使用Driver
//            Properties pro = new Properties();
//            pro.put("user", "scott");
//            pro.put("password", "tiger");
//            connect = driver.connect("jdbc:oracle:thin:@127.0.0.1:1521:XE", pro);

            //测试connect正确与否
            System.out.println(connect);
            System.out.println("链接成功");

            //第三步：获取执行sql语句对象
            //第一种方式:statement
            statement = connect.createStatement();

            //第二种方式：PreStatement
            //PreparedStatement preState = connect.prepareStatement("select  * from student");


            //第四步：执行sql语句
            //第一种方式：
            resultSet = statement.executeQuery("select  * from student");

            //第二种方式：
            //      preState.setInt(1, 2);//1是指sql语句中第一个？,  2是指第一个？的values值
            //resultSet = preState.executeQuery();        //执行查询语句
            //查询任何语句，如果有结果集，返回true，没有的话返回false,注意如果是插入一条数据的话，虽然是没有结果集，返回false，但是却能成功的插入一条数据
            //      boolean execute = preState.execute();
            //      System.out.println(execute);

            //第五步：处理结果集
            while (resultSet.next())
            {
                int id = resultSet.getInt("SNO");
                String name = resultSet.getString("SNAME");
                String sex = resultSet.getString("SSEX");
                System.out.println(id+"   "+name+"   "+sex);  //打印输出结果集
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            try {
                if (resultSet!=null) resultSet.close();
                if (statement!=null) statement.close();
                if (connect!=null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
