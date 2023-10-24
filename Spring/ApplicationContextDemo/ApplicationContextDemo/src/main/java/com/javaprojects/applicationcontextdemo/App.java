package com.javaprojects.applicationcontextdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaprojects.applicationcontextdemo.bean.Connection;

public class App {
    public static void main( String[] args ) {
    	
        System.out.println( "Welcome to Spring Core IoC using Application Context!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println( "Application Context Created" );
        
        // Down Casting ApplicationContext as a Connection
        //Connection c1 = (Connection)context.getBean("con1");
        Connection c2 = context.getBean("con2", Connection.class);
        //Connection c3 = context.getBean("con1", Connection.class);
        
        // Down Casting Context to close connection
        ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
        cxt.close();
    }
}