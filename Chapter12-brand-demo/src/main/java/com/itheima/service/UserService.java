package com.itheima.service;

import com.itheima.mapper.UserMappers;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * User: yuan_hao
 * Date: 2022/12/21
 * Time: 16:11
 */
public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */

    public User login(String username, String password) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMappers mapper = sqlSession.getMapper(UserMappers.class);
        //4. 调用方法
        User user = mapper.select(username, password);

        //释放资源
        sqlSession.close();

        return user;
    }


    /**
     * 注册方法
     *
     * @return
     */

    public boolean register(User user) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMappers mapper = sqlSession.getMapper(UserMappers.class);

        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if (u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;

    }
}
