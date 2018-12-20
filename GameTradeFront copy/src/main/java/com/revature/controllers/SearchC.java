package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.domain.GameTradeUser;
import com.revature.domain.Games;
import com.revature.service.GamesService;

public class SearchC {
	@Autowired
	private GamesService service;
	
	@GetMapping("/search")
	public @ResponseBody List<Games> SearchGet(@RequestBody Games tmpGame, BindingResult bindingResult, HttpSession sess, ModelMap modelMap) {
		
		System.out.println("Receiving Get Request search");
		List<Games> tmpGameList = null;
		
		GameTradeUser authUser = (GameTradeUser) sess.getAttribute("user"); //grabs user from session
		
		System.out.println(authUser); //for testing
		
		if(authUser == null){ //checks for user
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			return tmpGameList;
		}
		
		if(authUser != null){
			tmpGameList = service.searchGames(tmpGame.getGamename(), authUser.getUserID());
			return tmpGameList; // returns json to angular
		}
		return tmpGameList;
	}
}
