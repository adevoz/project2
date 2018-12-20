package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
public class HomeC {
	
	@Autowired
	private GamesService service;
	
	@GetMapping("/home")
	public @ResponseBody List<Games> HomeGet(BindingResult bindingResult, HttpSession sess, ModelMap modelMap) {
		
		System.out.println("Receiving Get Request home");
		List<Games> gameList = null;
		
		GameTradeUser authUser = (GameTradeUser) sess.getAttribute("user"); //grabs user from session
		
		System.out.println(authUser); //for testing
		
		if(authUser == null){ //checks for user
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return gameList;
		}
		
		if(authUser != null){
			gameList = service.getGames(authUser.getUserID());
			return gameList; // returns json to angular
		}
		return gameList;
	}
}