package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.GameTradeUserDao;
import com.revature.domain.GameTradeUser;

@Component
public class LoginService {
	
	private GameTradeUser user;
	
	@Autowired
	private GameTradeUserDao dao;
	
	public GameTradeUser authenticate(GameTradeUser newuser) {
		
		System.out.println(newuser.getUsername());
		user=dao.getUserByUsername(newuser.getUsername());
		System.out.println("checked username for: " + user.getUsername().toString());
		
				if(user!=null) {
					
					if(user.getPass().equals(newuser.getPass())) {
						
						
						return user;
					}
				
					System.out.println("not");
				}
		
		
		
		return null;
	}
   
	 public void registerUser(GameTradeUser user) {
	    	
	    	
	    	dao.insertIntoTable(user);
	    	
	    }	
	 
	 

}