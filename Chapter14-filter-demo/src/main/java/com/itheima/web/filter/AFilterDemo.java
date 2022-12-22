package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * User: yuan_hao
 * Date: 2022/12/22
 * Time: 13:48
 */
@WebFilter("/*")
public class AFilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //1. 放行前，对 request数据进行处理
        System.out.println("aaaaaaaaa.FilterDemo1...");

        //放行
        chain.doFilter(request,response);
        //2. 放行后，对Response 数据进行处理
        System.out.println("5.FilterDemo1...");
    }

    @Override
    public void destroy() {

    }
}
