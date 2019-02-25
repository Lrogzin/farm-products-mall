package com.nuzoul.mall.listener;

import com.alibaba.dubbo.config.ProtocolConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DubboWebServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed");
        ProtocolConfig.destroyAll();
    }
}
