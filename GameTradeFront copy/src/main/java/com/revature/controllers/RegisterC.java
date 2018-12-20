//package com.revature.controllers;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.revature.domain.GameTradeUser;
//import com.revature.domain.User;
//import com.revature.service.LoginService;
//
//@Controller
//@CrossOrigin(origins = "*")
//public class RegisterC {
//	
////	@Autowired
////	private LoginService authService;
////	
////	public RegisterC(){
////		System.out.println("Creating Servlet");
////	}
////	
////	@GetMapping("/register")
////	public void loginTest(User user) 
////	{
////			
////			System.out.println("Receiving Get Request register");
////	}
////	
////	
////	//need to add register function
////	@PostMapping("/register")
////	public @ResponseBody void registerpost(@RequestBody GameTradeUser user) {
////		
////		authService.registerUser(user);
////			
////	}
//	
//}