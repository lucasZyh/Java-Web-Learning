package com.itheima.service.impl;

import com.itheima.mapper.BrandMapperFinal;
import com.itheima.pojo.BrandFinal;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandFinalService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * User: yuan_hao
 * Date: 2022/12/24
 * Time: 14:54
 */
public class BrandFinalServiceImpl implements BrandFinalService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<BrandFinal> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);
        //4. 调用方法
        List<BrandFinal> brandFinals = mapper.selectAll();
        //5. 释放资源
        sqlSession.close();
        return brandFinals;
    }

    /**
     * 添加
     *
     * @param brandFinal
     */
    @Override
    public void add(BrandFinal brandFinal) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);
        //4. 调用方法
        mapper.add(brandFinal);
        sqlSession.commit();//提交事务
        //5. 释放资源
        sqlSession.close();
    }

    /**
     * 修改
     *
     * @param BrandFinal
     */
    @Override
    public void update(BrandFinal BrandFinal) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);

        //4. 调用方法
        mapper.update(BrandFinal);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(int id) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);

        //4. 调用方法
        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页展示条数
     * @return
     */
    @Override
    public PageBean<BrandFinal> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);

        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;
        //5. 查询当前页数据
        List<BrandFinal> rows = mapper.selectByPage(begin, size);
        //6. 查询总记录数
        int totalCount = mapper.selectTotalCount();

        //7. 封装PageBean对象
        PageBean<BrandFinal> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param brandFinal
     * @return
     */
    @Override
    public PageBean<BrandFinal> selectByPageAndCondition(int currentPage, int pageSize, BrandFinal brandFinal) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapperFinal mapper = sqlSession.getMapper(BrandMapperFinal.class);

        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 处理brand条件，模糊表达式
        String brandName = brandFinal.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brandFinal.setBrandName("%" + brandName + "%");
        }

        String companyName = brandFinal.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brandFinal.setCompanyName("%" + companyName + "%");
        }

        //5. 查询当前页数据
        List<BrandFinal> rows = mapper.selectByPageAndCondition(begin, size, brandFinal);
        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brandFinal);

        //7. 封装PageBean对象
        PageBean<BrandFinal> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }
}
