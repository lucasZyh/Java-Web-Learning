package com.itheima.jdbc;

import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class jdbcDemo5 {

    @Test
    public void testResultSet() throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itcast?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql
        String sql = "select * from account";

        //获取对象
        Statement statement = conn.createStatement();

        //执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            /*int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double money = resultSet.getDouble(3);*/

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double money = resultSet.getDouble("money");
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("---------------------");
        }
        resultSet.close();
        statement.close();
        conn.close();
    }

    /**
     * 查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
     * 1. 定义实体类Account
     * 2. 查询数据，封装到Account对象中
     * 3. 将Account对象存入ArrayList集合中
     */
    @Test
    public void testResultSet2() throws Exception {

        Account account = new Account();
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url = "jdbc:mysql:///itcast?useSSL=true";
        String username = "root";
        String password = "531619";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql
        String sql = "select * from account";

        //获取对象
        Statement statement = conn.createStatement();

        //执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Account> list = new ArrayList<>();
        while (resultSet.next()) {
            /*int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double money = resultSet.getDouble(3);*/

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double money = resultSet.getDouble("money");
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            list.add(account);
        }
        System.out.println(list);
        System.out.println("---------------------");
        resultSet.close();
        statement.close();
        conn.close();
    }
}
