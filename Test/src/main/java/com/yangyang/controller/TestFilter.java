package com.yangyang.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yangyang on 2018/8/13.
 */
public class TestFilter implements Filter {

    @Override   //filter先执行，interceptor后执行
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter before...");
        chain.doFilter(request, response);
        System.out.println("doFilter after...");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
