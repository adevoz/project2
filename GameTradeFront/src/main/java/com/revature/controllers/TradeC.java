package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.GameTradeUser;
import com.revature.domain.Games;
import com.revature.service.GamesService;

@Controller
@CrossOrigin(origins = "*")
public class TradeC {

	@Autowired
	private GamesService service;
	
	@GetMapping("/trade")
	public @ResponseBody String TradeGet(BindingResult bindingResult, HttpSession sess, ModelMap modelMap) {
		System.out.println("Receiving Get Request trade");
		ObjectMapper mapper = new ObjectMapper();
		
		GameTradeUser authUser = (GameTradeUser) sess.getAttribute("user");
		
		System.out.println(authUser);
		
		if(authUser == null){
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return "login";
		}
		String json;
		if(authUser != null){
			List<Games> gameList = service.getAllGames();
			try {
				json = mapper.writeValueAsString(gameList);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json = null;
			}
			return json;
		}
		return "login";
	}
	
	@PostMapping("/trade")
	public @ResponseBody String TradePost(BindingResult bindingResult, HttpSession sess, ModelMap modelMap) {
		
		System.out.println("Receiving Post Request trade");
		ObjectMapper mapper = new ObjectMapper();
		
		GameTradeUser authUser = (GameTradeUser) sess.getAttribute("user"); // grab user from session
		
		System.out.println(authUser);
		
		if(authUser == null){ //check if user existed
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return "login";
		}
		String json;
		if(authUser != null){
			int gameToTrade = 0; // need to grab JSON of game we want and of user
			int userID = 0;
			service.requestTrade(authUser.getUserID(), gameToTrade, userID);
		}
		
		return "home";
	}
}
