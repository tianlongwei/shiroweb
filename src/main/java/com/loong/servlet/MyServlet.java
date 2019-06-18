package com.loong.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        //获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token=new UsernamePasswordToken(username,password);
            try {
                subject.login(token);
            }catch (AccountException e){
                //登陆失败去list页面
                System.out.println("aaaaaaa:"+e.getMessage());
                response.sendRedirect("/login.jsp");
                return;
            }
        }
        //登陆成功时
        response.sendRedirect("/list.jsp");
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
