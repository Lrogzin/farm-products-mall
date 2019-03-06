package com.nuzoul.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: nuzoul
 * @Date: 2019/2/23 23:41
 */
public class UserStart {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo.xml"});
        context.start();
        System.out.println("======app-mall-user-started======");
        System.in.read();
    }
}
