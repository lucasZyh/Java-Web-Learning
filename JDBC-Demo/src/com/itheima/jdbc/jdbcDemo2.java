package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo2 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itcast?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql
        String sql = "update account set money = money + 1000 where name = '张三'";

        //获取对象
        Statement statement = conn.createStatement();

        //执行SQL
        int count = statement.executeUpdate(sql);

        //处理结果
        System.out.println(count);

        statement.close();
        conn.close();


    }
}
