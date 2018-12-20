package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.GameQualityCheck;
import com.revature.domain.Games;
import com.revature.util.SessionUtil;

@Component
public class GameQualityCheckDao {
	
	@Autowired
	 private SessionUtil tempUtil;//will be using Spring autowiring
	 private Session tempSession = tempUtil.getSession(); //create a new session from sessionutil class
	
	 public GameQualityCheckDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void insertIntoTable(GameQualityCheck game)//insert into user table
	 {
		tempSession.beginTransaction();//begin a new transaction
		
		Integer newId = (Integer) tempSession.save(game);//save to table in database, returning the newId for testing only
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		
		tempSession.close();//close the session
	}
	
	public void deleteByQualityId(int qualityid)//delete from database by username
	{
		
        tempSession.beginTransaction();//begin a new transaction
		
		
        GameQualityCheck tempgame=tempSession.get(GameQualityCheck.class, qualityid);//get user by username
		
		tempSession.delete(tempgame);//delete by object
	                                //tempSession.createQuery("delete from gametradeuser where username='"+username+"'").executeUpdate();another way to perform delete
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		tempSession.close();//close the session
		
	}
	
	public void updateImage(int gameId,String img)//update street in table
	 {
		
	tempSession.beginTransaction();//begin a new transaction
		
		
	GameQualityCheck game=tempSession.get(GameQualityCheck.class, gameId);//get user by username
		
		game.setImg(img);//set password

		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		tempSession.close();//close the session
	}
	
	public List<GameQualityCheck> getAllGameToCheck()//get a list of all user from table
	{
			
			tempSession.beginTransaction();//begin a new transaction	
			List <GameQualityCheck> games=tempSession.createQuery("from gamequalitycheck").list();//hql get all statement from table
			
			tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
			tempSession.close();//close the session
			return games;
			
			/*add try/catch
			return null if table dosent exist*/
		}

	public GameQualityCheck getGameByOwnerId(int qualityCheckId)//get a user from table by id
	
	{
		
		
		tempSession.beginTransaction();//begin a new transaction
		
		GameQualityCheck gamequality= tempSession.get(GameQualityCheck.class, qualityCheckId);//pull user with userid and make a new user obj
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		
		tempSession.close();//close the session
		
		/*should be 
		surrounded with try/catch
		return null if user dosent exist*/
		return gamequality;
		
	}
}
