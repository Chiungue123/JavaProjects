package com.javaprojects.dependencyinjectiondemo;

import com.javaprojects.dependencyinjectiondemo.bean.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Welcome to DependancyInjectionDemo!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Restaurant restaurant = context.getBean("rRef", Restaurant.class);
        
        System.out.println(restaurant);
        System.out.println(restaurant.getAddress());
        
        System.out.println("SEARCH KEYWORDS");
        System.out.println(restaurant.getSearchKeywords());
        
    }
}
