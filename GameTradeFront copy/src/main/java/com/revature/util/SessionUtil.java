package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
	
	public SessionUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static SessionFactory sessFactory;
	
	static {
		StandardServiceRegistry standardRegistry =
				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.applySetting("hibernate.connection.username", "adevoz")
				.applySetting("hibernate.connection.password", "1thatpure1").build();
		Metadata metaData =
				new MetadataSources(standardRegistry).getMetadataBuilder().build();
		sessFactory = metaData.getSessionFactoryBuilder().build();
	}
	
	public static Session getSession(){
		return sessFactory.openSession();
	}

}
