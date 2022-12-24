package com.itheima.web.servlet;


import com.alibaba.fastjson.JSON;
import com.itheima.pojo.BrandFinal;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandFinalService;
import com.itheima.service.impl.BrandFinalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandFinalService brandFinalService = new BrandFinalServiceImpl();

    /**
     * 查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<BrandFinal> brandFinals = brandFinalService.selectAll();
        //2. 转为JSON
        String jsonString = JSON.toJSONString(brandFinals);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 添加
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为Brand对象
        BrandFinal brandFinal = JSON.parseObject(params, BrandFinal.class);

        //2. 调用service添加
        brandFinalService.add(brandFinal);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 修改
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为Brand对象
        BrandFinal brandFinal = JSON.parseObject(params, BrandFinal.class);

        //2. 调用service添加
        brandFinalService.update(brandFinal);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 根据id单独删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //2. 调用service删除
        brandFinalService.deleteById(Integer.parseInt(params));

        ///3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收数据  [1,2,3]
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 int[]
        int[] ids = JSON.parseObject(params, int[].class);

        //2. 调用service添加
        brandFinalService.deleteByIds(ids);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //2. 调用service查询
        PageBean<BrandFinal> pageBean = brandFinalService.selectByPage(currentPage, pageSize);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        /// 获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 Brand
        BrandFinal brand = JSON.parseObject(params, BrandFinal.class);

        //2. 调用service查询
        PageBean<BrandFinal> pageBean = brandFinalService.selectByPageAndCondition(currentPage, pageSize, brand);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
