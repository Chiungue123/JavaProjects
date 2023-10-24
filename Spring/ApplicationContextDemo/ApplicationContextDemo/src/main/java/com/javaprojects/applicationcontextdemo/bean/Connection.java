package com.javaprojects.applicationcontextdemo.bean;

public class Connection {
	String url;
	String username;
	String password;
	
	public Connection(){
		System.out.println("Connection Object Created. HashCode: " + hashCode());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// User defined methods for Bean Life Cycle
	// Signature: No return type
	public void myInit() {
		System.out.println("Connection: myInit invoked for user: " + username);
	}
	
	// User defined methods for Bean Life Cycle
	// Signature: No return type
	public void myDestroy() {
		System.out.println("Connection: myDestroy invoked for user: " + username);
	}

	@Override
	public String toString() {
		return "Connection [url=" + url + ", username=" + username + ", password=" + password + "]";
	}
	
}