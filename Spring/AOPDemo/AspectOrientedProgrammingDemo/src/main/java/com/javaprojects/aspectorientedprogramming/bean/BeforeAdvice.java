package com.javaprojects.aspectorientedprogramming.bean;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("Method method: " + method);
		System.out.println("Object target: " + target);
		
		if (method.getName().equals("purchaseProduct")) {
			
			System.out.println();
			System.out.println("BEFORE ADVICE: " + method.getName());
			System.out.println();
			
			// 1. Validate Stock: Pre-Processing
			Product product = (Product)target;
			if (product.getStock() <= 0) {
				product.canBuy = false;
				System.out.println("BEFORE ADVICE: Out of Stock for " + product.getName());
			} else {
				// 2. Perform Pre-processing
				product.canBuy = true;
				System.out.println("----------------------------------------------------------------------");
				System.out.println("BEFORE ADVICE: Sending Invoice to " + args[2] + " with amount: " + product.getPrice());
			
			}
		} 
	}
}
