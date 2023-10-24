package com.javaprojects.applicationcontextdemo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {

	public Object preProcessBeforeInitializaition(Object bean, String beanName) throws BeansException{
		System.out.println("preProcessBeforeInit for Bean Name: " + beanName);
		return bean;
	}
	
	public Object postProcessAfterInitializaition(Object bean, String beanName) throws BeansException{
		Connection con = (Connection)bean;
		String password = con.getPassword();
		con.setPassword(password.replace('p', 'b'));
		System.out.println("postProcessBeforeInit for Bean: " + beanName);
		return con;
	}
	
}