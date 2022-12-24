package com.itheima.mapper;

import com.itheima.pojo.BrandFinal;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapperFinal {
    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMapFinal")
    List<BrandFinal> selectAll();

    /**
     * 添加数据
     *
     * @param brandFinal
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(BrandFinal brandFinal);

    /**
     * 删除
     *
     * @param id
     */
    @Delete("delete from tb_brand where id=#{id};")
    void deleteById(int id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     *
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin} , #{size}")
    @ResultMap("brandResultMapFinal")
    List<BrandFinal> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     *
     * @return
     */
    @Select("select count(*) from tb_brand ")
    int selectTotalCount();


    /**
     * 分页条件查询
     *
     * @param begin
     * @param size
     * @param brandFinal
     * @return
     */
    List<BrandFinal> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") BrandFinal brandFinal);

    /**
     * 根据条件查询总记录数
     *
     * @return
     */
    int selectTotalCountByCondition(BrandFinal brand);

    /**
     * 修改
     *
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(BrandFinal BrandFinal);

}
