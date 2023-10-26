package com.javaprojects.aspectorientedprogramming;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaprojects.aspectorientedprogramming.bean.Product;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Welcome to AOP Demo!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Product pRef = context.getBean("productProxy", Product.class);
        
        // System.out.println("Product: " + pRef.getName());
        pRef.purchaseProduct("Home", "6 PM Evening", "john@example.com");
    }
}
