package com.javaprojects.soapdemo.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javaprojects.soapdemo.CreateUserRequest;
import com.javaprojects.soapdemo.CreateUserResponse;
import com.javaprojects.soapdemo.GetUserRequest;
import com.javaprojects.soapdemo.GetUserResponse;
import com.javaprojects.soapdemo.GetUsersRequest;
import com.javaprojects.soapdemo.GetUsersResponse;
import com.javaprojects.soapdemo.jpa.User;
import com.javaprojects.soapdemo.service.UserService;

@Endpoint
public class UserEndpoint {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String NAMESPACE_URI = "http://javaprojects.com/SoapDemo";
	
	@Autowired
	UserService userService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
		
		logger.debug("ENDPOINT: Getting User: {}", request.getUsername());
		
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.findUser(request.getUsername()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
	@ResponsePayload
	public GetUsersResponse getUser(@RequestPayload GetUsersRequest request) {
		
		logger.debug("ENDPOINT: Getting Users");
		
		GetUsersResponse response = new GetUsersResponse();
		response.getUsers().addAll(this.userService.listUsers());
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
	@ResponsePayload
	public CreateUserResponse getUser(@RequestPayload CreateUserRequest request) {
		
		logger.debug("ENDPOINT: Getting Users: {}", this.createUserBean(request));
		
		CreateUserResponse response = new CreateUserResponse();
		response.setUser(this.userService.createUser(this.createUserBean(request)));
		
		return response;
	}
	
    private User createUserBean(CreateUserRequest req) {
    	
    	User user = new User();
    	user.setIdUser(0);
    	user.setUsername(req.getUsername());
    	user.setFirstName(req.getFirstName());
    	user.setLastName(req.getLastName());
    	user.setPassword(req.getPassword());
    	user.setBirth(req.getBirth().toGregorianCalendar().getTime());
    	user.setStatus("A");
    	
    	return user;
    }

    /*private User createUserBean(UpdateUserRequest req) {

        return new User(req.getIdUser(),req.getUsername(),"", req.getFirstName(),
                req.getLastName(), req.getBirth().toGregorianCalendar().getTime(), "");
    }*/
	
}