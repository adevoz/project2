package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity//the class is mapped to a database
@Table(name="trade")//this class is mapped to table trade in database
public class Trade {
	
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id //this variable is mapped to the primary key in column
	@SequenceGenerator(name="trade_tradeID_seq",
    sequenceName="trade_tradeID_seq",
    allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator="trade_tradeID_seq")
	@Column(name="tradeID")//mapped to column name tradeID
	private int tradeID;
 
	
	
	
	@JoinColumn(name = "userId")//foreign key constraint game1ID reference gameId from gametradeuser table
	private int	game1ID;
	
	
	@JoinColumn(name = "userId")
	private int game2ID;
		
	@Column(name="status")
	private String	status;

	public Trade(int tradeID, int game1id, int game2id, String status) {
		super();
		this.tradeID = tradeID;
		game1ID = game1id;
		game2ID = game2id;
		this.status = status;
	}

	public int getTradeID() {
		return tradeID;
	}

	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}

	public int getGame1ID() {
		return game1ID;
	}

	public void setGame1ID(int game1id) {
		game1ID = game1id;
	}

	public int getGame2ID() {
		return game2ID;
	}

	public void setGame2ID(int game2id) {
		game2ID = game2id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
