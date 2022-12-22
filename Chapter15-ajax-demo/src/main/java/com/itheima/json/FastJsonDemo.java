package com.itheima.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * User: yuan_hao
 * Date: 2022/12/22
 * Time: 21:26
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        //1. 将Java对象转为JSON字符串
        User user = new User(1, "zhangsan", "123");//{"id":1,"password":"123","username":"zhangsan"}

        String s = JSON.toJSONString(user);
        System.out.println(s);

        //2. 将JSON字符串转为Java对象
        User user1 = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(user1);
    }
}
