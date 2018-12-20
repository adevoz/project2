package com.revature.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.revature.domain.GameTradeUser;
import com.revature.domain.User;
import com.revature.service.LoginService;

@Controller
@CrossOrigin(origins = "*")
public class LoginC {
	
	@Autowired
	private LoginService authService;
	
	public LoginC(){
		System.out.println("Creating Servlet");
	}
	
	@GetMapping("/login")
	public void loginTest(User user) 
	{
			
			System.out.println("Receiving Get Request login");
	}
	
	@PostMapping("/login")
	public @ResponseBody String loginpost(@Valid GameTradeUser user, BindingResult bindingResult, HttpSession sess, ModelMap modelMap) {
		
		System.out.println("Receiving Post Request login");
		
		GameTradeUser authUser = authService.authenticate(user); //Authenticate user
		
		System.out.println(authUser);
		
		if(bindingResult.hasErrors()){
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return "login";
		}
		
		if(authUser != null){ //checks for user
			sess.setAttribute("user", authUser);
			modelMap.addAttribute("user", authUser);
			return "home";
		}
		
		return "login";
	}
	
	//need to add register function
	@PostMapping("/register")
	public @ResponseBody void registerpost(@RequestBody GameTradeUser user) {
		LoginService service=new LoginService();
		
		service.registerUser(user);
			
	}
	
}
