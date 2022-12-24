package com.itheima.web.servlet.ser;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.BrandFinal;
import com.itheima.service.BrandFinalService;
import com.itheima.service.impl.BrandFinalServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandFinalService brandFinalService = new BrandFinalServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<BrandFinal> brandFinals = brandFinalService.selectAll();
        //2. 转为JSON
        String jsonString = JSON.toJSONString(brandFinals);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
