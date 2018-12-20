package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity//the class is mapped to a database
@Table(name="gamequalitycheck")//this class is mapped to table gamequalitycheck in database
public class GameQualityCheck {
	
	@Id//this variable is mapped to the primary key in column
	@Column(name="qualitycheckID")//mapped to column name qualitycheckID
   private int	qualitycheckID;
	
	@Column(name="img"
			+ "")
   private String img;
	
	
	@JoinColumn(name ="gameID")
   private int gametocheckID;

	
	public GameQualityCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameQualityCheck(int qualitycheckID, String img, int gametocheckID) {
		super();
		this.qualitycheckID = qualitycheckID;
		this.img = img;
		this.gametocheckID = gametocheckID;
	}

	public int getQualitycheckID() {
		return qualitycheckID;
	}

	public void setQualitycheckID(int qualitycheckID) {
		this.qualitycheckID = qualitycheckID;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getGametocheckID() {
		return gametocheckID;
	}

	public void setGametocheckID(int gametocheckID) {
		this.gametocheckID = gametocheckID;
	}
	
	
	
	

}
