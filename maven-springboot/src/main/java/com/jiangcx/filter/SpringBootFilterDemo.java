package com.jiangcx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by jiangcx on 2019/3/7
 * springboot 整合 Filter
 */
@WebFilter(filterName = "filterDemo",urlPatterns = "/filter")
public class SpringBootFilterDemo implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SpringBootFilterDemo init success！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
