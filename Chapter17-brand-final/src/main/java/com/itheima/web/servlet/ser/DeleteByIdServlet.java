package com.itheima.web.servlet.ser;

import com.alibaba.fastjson.JSON;
import com.itheima.service.BrandFinalService;
import com.itheima.service.impl.BrandFinalServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private BrandFinalService brandFinalService = new BrandFinalServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //2. 调用service删除
        brandFinalService.deleteById(Integer.parseInt(params));

        ///3. 响应成功的标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
