package com.itheima.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("all")
public class jdbcDemo4 {

    @Test
    public void testDML() throws Exception {
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
        if (count > 0) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        statement.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itcast?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql
        String sql = "drop database test1";

        //获取对象
        Statement statement = conn.createStatement();

        //执行SQL
        int count = statement.executeUpdate(sql);

        //处理结果

        /*
        DDL执行成功之后也可能返回0
         */
        if (count > 0) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        statement.close();
        conn.close();
    }
}
