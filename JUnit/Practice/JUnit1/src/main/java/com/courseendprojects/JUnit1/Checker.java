package com.courseendprojects.JUnit1;

public class Checker {

	public boolean isPalindrome(String str) {
		
		StringBuilder stb = new StringBuilder(str);
		String rev = stb.reverse().toString();
		
		return str.equals(rev);	
	}
}