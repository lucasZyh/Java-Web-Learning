package com.itheima.service;

import com.itheima.pojo.BrandFinal;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandFinalService {
    /**
     * 查询所有
     *
     * @return
     */
    List<BrandFinal> selectAll();

    /**
     * 添加数据
     *
     * @param brandFinal
     */
    void add(BrandFinal brandFinal);

    /**
     * 修改
     *
     * @param brand
     */
    void update(BrandFinal BrandFinal);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页展示条数
     * @return
     */
    PageBean<BrandFinal> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     *
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    PageBean<BrandFinal> selectByPageAndCondition(int currentPage, int pageSize, BrandFinal brandFinal);

}
