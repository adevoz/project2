package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.Games;
import com.revature.domain.Trade;
import com.revature.util.SessionUtil;

@Component
public class TradeDao {
	
//	 @Autowired
//	 private SessionUtil tempUtil;//will be using Spring autowiring
//	 private Session tempSession = tempUtil.getSession(); //create a new session from sessionutil class
	 
	 public void insertIntoTable(Trade trade)//insert into user table
	 {
		 Session tempSession = SessionUtil.getSession();
		tempSession.beginTransaction();//begin a new transaction
		
		Integer newId = (Integer) tempSession.save(trade);//save to table in database, returning the newId for testing only
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		
		tempSession.close();//close the session
		
	}

	 public void deleteById(int tradeId)//delete from database by username
		{
		 Session tempSession = SessionUtil.getSession();
		tempSession.beginTransaction();//begin a new transaction
			
			
			Trade trade=tempSession.get(Trade.class, tradeId);//get user by username
			
			tempSession.delete(trade);//delete by object
		//tempSession.createQuery("delete from gametradeuser where username='"+username+"'").executeUpdate();another way to perform delete
			tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
			tempSession.close();//close the session
			
		}

	 public void updateStatus(int tradeId, String status)//update street in table
	 {
		 Session tempSession = SessionUtil.getSession();
		 tempSession.beginTransaction();//begin a new transaction
			
			
			Trade trade=tempSession.get(Trade.class, tradeId);//get user by username
			
			trade.setStatus(status);//set password

			tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
			tempSession.close();//close the session
	}

	 public List<Trade> getAllTrade()//get a list of all user from table
		{
		 Session tempSession = SessionUtil.getSession();
				tempSession.beginTransaction();//begin a new transaction	
				List <Trade> trade=tempSession.createQuery("from Trade").list();//hql get all statement from table
				
				tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
				tempSession.close();//close the session
				return trade;
				
				/*add try/catch
				return null if table dosent exist*/
			}
	 public Trade getTradeByOwnerId(int gametradeId)//get a user from table by id
	 {
		
		 Session tempSession = SessionUtil.getSession();
		tempSession.beginTransaction();//begin a new transaction
		
		Trade trade=(Trade) tempSession.createQuery("from Trade s where s.game1ID="+gametradeId+" or s.game2ID="+gametradeId+"").getSingleResult();//pull user with userid and make a new user obj
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		
		tempSession.close();//close the session
		
		/*should be 
		surrounded with try/catch
		return null if user dosent exist*/
		return trade;
		
	}	
	 
	 public Trade getTradeByTradeId(int tradeId)//get a user from table by id
	 {
		
		 Session tempSession = SessionUtil.getSession();
		tempSession.beginTransaction();//begin a new transaction
		
		Trade trade=(Trade) tempSession.createQuery("from Trade s where s.tradeID="+tradeId+"").getSingleResult();//pull user with userid and make a new user obj
		
		tempSession.getTransaction().commit();//accept changes, surround with try catch to rollback on failure/exception
		
		tempSession.close();//close the session
		
		/*should be 
		surrounded with try/catch
		return null if user dosent exist*/
		return trade;
		
	}

	public TradeDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
	 
}
