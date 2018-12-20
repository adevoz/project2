package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity//the class is mapped to a database
@Table(name="moderator")//this class is mapped to table moderator in database
public class Moderator {
	
	@Id //this variable is mapped to the primary key in column
	@SequenceGenerator(name="moderate_modID_seq",
    sequenceName="moderate_modID_seq",
    allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator="moderate_modID_seq")
	@Column(name="modID")//mapped to column name modID
	private int modID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pass")
	private String pass;

	public Moderator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moderator(int modID, String username, String pass) {
		super();
		this.modID = modID;
		this.username = username;
		this.pass = pass;
	}

	public int getModID() {
		return modID;
	}

	public void setModID(int modID) {
		this.modID = modID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	

}
