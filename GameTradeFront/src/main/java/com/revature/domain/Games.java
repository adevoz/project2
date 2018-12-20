package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //the class is mapped to a database
@Table(name="games")//this class is mapped to table games in database
public class Games{
	
	
	@Id       //this variable is mapped to the primary key in column
	@Column(name="gameID")//mapped to column name gameID
	private int gameID;
	
	@Column(name="gamename")
	private String gamename;
	
	@Column(name="value")
	private int value;
	
	@Column(name="gameyear")
	private String gameyear;
	
	@Column(name="loose")
	private String loose;
	
	@Column(name="approved")
	private String approved;
	
	
    @JoinColumn(name = "userID")
	private int ownerID;
	
	@Column(name="img")
	private String img;

	

	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Games(int gameID, String gamename, int value, String gameyear, String loose, String approved, int ownerID,
			String img) {
		
		this.gameID = gameID;
		this.gamename = gamename;
		this.value = value;
		this.gameyear = gameyear;
		this.loose = loose;
		this.approved = approved;
		this.ownerID = ownerID;
		this.img = img;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getGameyear() {
		return gameyear;
	}

	public void setGameyear(String gameyear) {
		this.gameyear = gameyear;
	}

	public String getLoose() {
		return loose;
	}

	public void setLoose(String loose) {
		this.loose = loose;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	} 

	
}
