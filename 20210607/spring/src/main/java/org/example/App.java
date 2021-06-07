package org.example;

import org.example.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring
 * @description:
 * @author: FENG CHEN
 * @create: 2021-06-07 21:13
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
       LoginController loginController=(LoginController) context.getBean("loginController");
//        System.out.println(loginController);
        LoginController loginController2=context.getBean(LoginController.class);
        //输出为true   由此可见是单例模式
        System.out.println(loginController==loginController2);
        //关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
