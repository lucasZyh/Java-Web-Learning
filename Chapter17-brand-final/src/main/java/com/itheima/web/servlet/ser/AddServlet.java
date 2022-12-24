package com.itheima.web.servlet.ser;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.BrandFinal;
import com.itheima.service.BrandFinalService;
import com.itheima.service.impl.BrandFinalServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandFinalService brandFinalService = new BrandFinalServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
