package com.javaprojects.autowireddemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaprojects.autowireddemo.bean.User;

public class App {
    public static void main( String[] args ){
        System.out.println( "Welcome to Autowired Annotation Demo!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        User uRef = context.getBean("user", User.class);
        System.out.println("User: " + uRef.getName());
        
    }
}
