package com.revature.driver;

import com.revature.dao.GameQualityCheckDao;
import com.revature.dao.GameTradeUserDao;
import com.revature.domain.GameQualityCheck;
import com.revature.domain.GameTradeUser;
import com.revature.service.LoginService;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(99999);
//		GameQualityCheck gm=new GameQualityCheck(4,"newgame",2);	
//		System.out.println(99999);
//		GameQualityCheckDao dao =new GameQualityCheckDao();
	
     
//		dao.insertIntoTable(gm);
		GameTradeUserDao uDao = new GameTradeUserDao();
		LoginService userService = new LoginService();
		GameTradeUser tmpUser = uDao.getUserById(1);
		System.out.println(tmpUser.getUsername().toString());
		System.out.println(userService.authenticate(tmpUser));
	}

}
