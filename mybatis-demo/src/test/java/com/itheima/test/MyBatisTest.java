package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException{
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand1> brands = mapper.selectAll();
        System.out.println(brands);
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException{
        //接收参数
        int id = 1;
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        Brand1 brand1 = mapper.selectById(id);
        System.out.println(brand1);
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException{
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象(方法2)
        Brand1 brand = new Brand1();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //创建map集合
        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //List<Brand1> brand1 = mapper.selectByCondition(brand);
        List<Brand1> brand1 = mapper.selectByCondition(map);
        System.out.println(brand1);
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException{
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象(方法2)
        Brand1 brand = new Brand1();
        //brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //List<Brand1> brand1 = mapper.selectByCondition(brand);
        List<Brand1> brand1 = mapper.selectByConditionSingle(brand);
        System.out.println(brand1);
        //5. 释放资源
        sqlSession.close();
    }
}
