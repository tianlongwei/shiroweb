package com.loong.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(this.getClass().getName()+"初始化");
        //获取参数信息
        Object aa = servletContextEvent.getServletContext().getInitParameter("listener");
        //100000
        System.out.println(aa);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(this.getClass().getName()+"销毁");
    }
}
