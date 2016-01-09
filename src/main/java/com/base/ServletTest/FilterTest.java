package com.base.ServletTest;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by liumin on 15/12/3.
 */
public class FilterTest implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println( servletRequest+"Filter测试" );
        filterChain.doFilter( servletRequest,servletResponse );
    }

    public void destroy() {

    }
}
