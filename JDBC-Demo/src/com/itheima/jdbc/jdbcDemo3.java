package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo3 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itcast?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql
        String sql1 = "update account set money = money + 1000 where id = '1'";
        String sql2 = "update account set money = money + 1000 where id = '2'";

        //获取对象
        Statement statement = conn.createStatement();


        try {
            //开启事务
            //conn.setAutoCommit(false);
            //执行SQL
            int count1 = statement.executeUpdate(sql1);
            //处理结果
            System.out.println(count1);

            int i = 3/0;

            //执行SQL
            int count2 = statement.executeUpdate(sql2);
            //处理结果
            System.out.println(count2);

            //提交
            //conn.commit();
        } catch (SQLException e) {
            //回滚
            //conn.rollback();
            throw new RuntimeException(e);
        }

        statement.close();
        conn.close();


    }
}
