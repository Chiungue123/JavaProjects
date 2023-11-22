package com.javaprojects.soapdemo.service;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojects.soapdemo.User;
import com.javaprojects.soapdemo.repository.UserRepository;

@Service
public class UserService {

	final static Logger logger = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    UserRepository userRepository;

    public List<User> listUsers() {
        return this.userRepository.findAll()
    						  .stream()
    						  .map(UserService::mapUser)
    						  .toList();
    }

    public User findUser(String username) {
    	logger.debug("Finding User with username: {} ",username);
    	
        return this.userRepository.findByUsernameIgnoreCase(username)
        						  .map(UserService::mapUser)
        						  .orElse(null);
    }

    // Conversion of the User JPA Entity to the User class generated from the jaxb2 plugin - imported from Spring.io/guides
    // Maps User JPA into SOAP
    static User mapUser(com.javaprojects.soapdemo.jpa.User u) {
    	logger.debug("Mapping JPA User into SOAP: {} ", u);
    	
    	User user = new User();
    	GregorianCalendar cal = new GregorianCalendar();
    	
    	user.setIdUser(u.getIdUser());
    	user.setUsername(u.getUsername());
    	user.setFirstName(u.getFirstName());
    	user.setLastName(u.getLastName());
    	user.setStatus(u.getStatus());
    	
    	cal.setTime(u.getBirth()); // Convert java.util.date into GregorianCalander
    	
    	try {
    		
    		user.setBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal)); // Data factory converts 'cal' into XMLGregorianCalander
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    	
    	return user; // Returns a SOAP user from JPA User
    	
    }

	public User createUser(com.javaprojects.soapdemo.jpa.User user) {
		
		this.validateUser(user);
		
		this.userRepository.save(user);
		
		return UserService.mapUser(user);
	}

	private void validateUser(com.javaprojects.soapdemo.jpa.User user) {
        
		if (user.getFirstName().isEmpty() || 
        	user.getLastName().isEmpty()  || 
        	user.getUsername().isEmpty()) {
            throw new RuntimeException("Invalid User Data: " + user);
        }
    }
    
    /*
    public void createUser(User user) {
        this.validateUser(user);
        user.setStatus("A");
        this.userRepository.save(user);
    }
    
    public void updateUser(User user) {
   
    	this.validateUser(user);
        this.userRepository.findById(user.getIdUser())
	        .ifPresent(u -> {
	        	u.setUsername(user.getUsername());
	        	u.setFirstName(user.getFirstName());
	        	u.setLastName(user.getLastName());
	        	u.setBirth(user.getBirth());
	        	
	        	this.userRepository.save(u);
	        });
    }

    public void deleteUser(int idUser) {
    	this.userRepository.deleteById(idUser);
    }
    */
}