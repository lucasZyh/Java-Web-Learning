package com.itheima.jdbc;

import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("all")
public class jdbcDemo6 {

    @Test
    public void testLogin() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itheima?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";
        String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
        // 获取stmt对象
        Statement stmt = conn.createStatement();
        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void testLogin_Inject() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itheima?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "hfkjsfhskj";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
        // 获取stmt对象
        Statement stmt = conn.createStatement();
        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(sql);
        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
