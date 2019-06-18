package com.loong.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(this.getClass().getName()+"---init");
        System.out.println(servletConfig.getInitParameter("servlet"));
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println(this.getClass().getName()+"---getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse)
                            throws ServletException, IOException {
        System.out.println(this.getClass().getName()+"---service");
        //处理登录
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    public String getServletInfo() {
        System.out.println(this.getClass().getName()+"---getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName()+"---destroy");
    }
}
