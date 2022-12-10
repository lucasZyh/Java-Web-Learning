package com.itheima.mapper;

import com.itheima.pojo.Brand1;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand1> selectAll();

    /**
     * 查看详情：根据Id查询
     */
    Brand1 selectById(int id);

    /**
     * 条件查询
     *  * 参数接收
     *      1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *      2. 对象参数:对象的属性名称要和参数占位符名称一致
     *      3. map集合参数
     */

    //List<Brand1> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    //List<Brand1> selectByCondition(Brand1 brand);
    List<Brand1> selectByCondition(Map map);




    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand1> selectByConditionSingle(Brand1 brand);

    /**
     * 添加
     */
    void add(Brand1 brand);


    /**
     * 修改
     */
    int update(Brand1 brand);


    /**
     * 根据id删除
     */
    void deleteById(int id);


    /**
     * 批量删除
     */
    void deleteByIds(int[] ids);
}
