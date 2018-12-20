package com.revature.dao;


import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.hibernate.Transaction;   //remove comment from this import if code throws error
import com.revature.domain.Games;
import com.revature.util.SessionUtil;



@Component
public class GamesDao {
	
	public GamesDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

//	@Autowired
//	private SessionUtil tempUtil;//will be using Spring autowiring
//	private Session tempSession = SessionUtil.getSession(); //create a new session from sessionutil class
	
	public void insertIntoTable(Games game)//insert into user table
	 {
		Session tempSession = SessionUtil.getSession();
		tempSession.beginTransaction();//begin a new transaction
		
		Integer newId = (Integer) tempSession.save(game);//save to table in database, returning the newId for testing only
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		
		tempSession.close();//close the session
		
	}

	public List<Games> getGamesByOwnerId(int ownerId)//get a user from table by id
	 {
		Session tempSession = SessionUtil.getSession();
		
		tempSession.beginTransaction();//begin a new transaction	
		List <Games> games=tempSession.createQuery("from Games G where G.ownerID=" + ownerId).list();//hql get all statement from table
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		tempSession.close();//close the session
		
		/*should be 
		surrounded with try/catch
		return null if user dosent exist*/
		return games;
		
	}

	
	public List<Games> getAllGames()//get a list of all user from table
	{
			Session tempSession = SessionUtil.getSession();
			tempSession.beginTransaction();//begin a new transaction	
			List <Games> games=tempSession.createQuery("from Games").list();//hql get all statement from table
			
			tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
			tempSession.close();//close the session
			return games;
			
			/*add try/catch
			return null if table dosent exist*/
		}

	public List <Games> getGamerByName(String gamename, int userID)//get a user from table by username
	 {
		
		Session tempSession = SessionUtil.getSession();
		tempSession.beginTransaction();//begin a new transaction
		
		/*hql query 
		get record from table gametradeuser
		by username*/
		List <Games> tempgame= tempSession.createQuery("from Games g where g.gamename='"+gamename+"'" + "& g.ownerid !=" + userID).list(); 


		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		tempSession.close();//close the session
		return tempgame;
		
		
		/*add try/catch
		return null if user doesn't exist*/
	}

	public void updateGameName(int gameId, String gamename)//update password in table by username
	 {
		
		
		Session tempSession = SessionUtil.getSession();
	 tempSession.beginTransaction();//begin a new transaction
		
		
		Games game=tempSession.get(Games.class, gameId);//get user by username
		
		game.setGamename(gamename);//set password

		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		tempSession.close();//close the session
	}
	public void updateValue(int gameId, int value)//update street in table
	 {
		Session tempSession = SessionUtil.getSession();
		 tempSession.beginTransaction();//begin a new transaction
			
			
			Games game=tempSession.get(Games.class, gameId);//get user by username
			
			game.setValue(value);//set password

			tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
			tempSession.close();//close the session
	}
	public void updateApprove(int gameId, String approve)//update state in the table
	 {
		Session tempSession = SessionUtil.getSession();
		 tempSession.beginTransaction();//begin a new transaction
			
			
			Games game=tempSession.get(Games.class, gameId);//get user by username
			
			game.setApproved(approve);//set password

			tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
			tempSession.close();//close the session
	}
	
	
	public void deleteById(int gameId)//delete from database by username
	{
		Session tempSession = SessionUtil.getSession();
	tempSession.beginTransaction();//begin a new transaction
		
		
		Games tempgame=tempSession.get(Games.class, gameId);//get user by username
		
		tempSession.delete(tempgame);//delete by object
	//tempSession.createQuery("delete from gametradeuser where username='"+username+"'").executeUpdate();another way to perform delete
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		tempSession.close();//close the session
		
	}
   
}


