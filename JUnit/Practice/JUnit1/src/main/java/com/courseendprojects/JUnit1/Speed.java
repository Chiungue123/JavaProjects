package com.courseendprojects.JUnit1;

public class Speed {

	static int process() {
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < 1_000_000; i++) {
			
			if (i > max) {
				max = i;
			}
			
		}
		
		return max;
	}
	
}