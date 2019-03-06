package com.nuzoul.admin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: nuzoul
 * @Date: 2019/3/3 23:48
 */
public class AdminStarter {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo.xml"});
        context.start();
        System.out.println("======app-mall-admin-started======");
        System.in.read();
    }
}
