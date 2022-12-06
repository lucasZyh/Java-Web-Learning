package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

@SuppressWarnings("all")
public class jdbcDemo7 {

    @Test
    public void testPreparedStatement() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itheima?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = ? and password = ?";
        // 获取stmt对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        // 执行sql
        ResultSet rs = preparedStatement.executeQuery();
        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        preparedStatement.close();
        conn.close();
    }

    @Test
    public void testPreparedStatement2() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itheima?useSSL=true&useServerPrepStmts=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        String sql = "select * from tb_user where username = ? and password = ?";
        // 获取stmt对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Thread.sleep(10000);
        ResultSet rs = null;

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        // 执行sql
        rs = preparedStatement.executeQuery();

        preparedStatement.setString(1, "aaa");
        preparedStatement.setString(2, "111");
        // 执行sql
        rs = preparedStatement.executeQuery();

        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        preparedStatement.close();
        conn.close();
    }
}
