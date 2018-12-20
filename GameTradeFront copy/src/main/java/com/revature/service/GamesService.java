package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.GamesDao;
import com.revature.dao.TradeDao;
import com.revature.domain.Games;

@Component
public class GamesService {

	@Autowired
	private GamesDao dao;
	
	@Autowired
	private TradeDao tradeDao;
	
	public void submitGame (Games tmpGame) 
	{
		dao.insertIntoTable(tmpGame);
	}
	
	public List<Games> getGames(int userID)
	{
		List<Games> myList = dao.getGamesByOwnerId(userID);
		return myList;
	}
	
	public List<Games> getAllGames()
	{
		List<Games> myList = dao.getAllGames();
		return myList;
	}
	
	public List<Games> searchGames(String gameName, int userID)
	{
		List<Games> myList = dao.getGamerByName(gameName, userID);
		return myList;
	}
	
	public void updateGame(int gameID)
	{
		dao.updateApprove(gameID, "Y");
	}
	
	public void requestTrade(int requesterID, int gameID, int gameOwnerID)
	{
		
	}
}
