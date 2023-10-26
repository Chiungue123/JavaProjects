package com.javaprojects.aspectorientedprogramming.bean;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		if (method.getName().equals("purchaseProduct")) {
			System.out.println();
			System.out.println("AfterAdvice Executed");
			System.out.println();
			Product product = (Product)target;
			
			// 3. Notification: Post Processing
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
			System.out.println("AFTER ADVICE: Sending Invoice to " + args[2] + " with amount: " + product.getPrice());
			System.out.println("AFTER ADVICE: Delivery Location: " + args[0] + ". Delivery Time: " + args[1]);
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
		}	
	}
}