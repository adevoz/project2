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

import com.revature.dao.GameTradeUserDao;
import com.revature.dao.GamesDao;
import com.revature.domain.GameTradeUser;
import com.revature.domain.Games;
import com.revature.domain.User;
import com.revature.service.GamesService;
import com.revature.service.LoginService;

@Controller
@CrossOrigin(origins = "*")
public class GameC {
	private GameTradeUser user;
	
	@Autowired
	private GamesService gameService;
	
	@PostMapping("/games")
	public @ResponseBody Games gamepost(@RequestBody Games tmpGame, BindingResult bindingResult, HttpSession sess, ModelMap modelMap)
	{
		System.out.println("Receiving Post Request games");
		System.out.println(tmpGame.toString());
//		user = (GameTradeUser) sess.getAttribute("user");
		gameService.submitGame(tmpGame); //submit games from angular form
		return tmpGame;
	}
	
}
