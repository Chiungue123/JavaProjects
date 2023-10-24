package com.javaprojects.beanfactorydemo;

import com.javaprojects.beanfactorydemo.bean.Connection;

import org.springframework.beans.factory.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Welcome to Spring Core IoC and Bean Factory" );
        
        // Inversion of Control
        
        
        /* Traditional Instantiation of Objects
        Connection con  = new Connection();
        con.setUrl("jdbc:mysql://localhost/javaprojects");
        con.setUsername("root");
        con.setPassword("root1");
        
        System.out.println("con: " + con);
        */
        
        // Spring Creates Objects via Spring FM IoC Container
        Resource resource = new ClassPathResource("context.xml");
        //BeanFactory beanFactory = new XMLBeanFactory(resource);
    }
}
