package main.java.edu.uga.miashs.application;

public class Fight {
	
	private String id;
	private String cardID;
	private int bet;

	public Fight(String id, String cardID, int bet) {
		this.id = id;
		this.cardID = cardID;
		this.bet = bet;
	}
	
	public Fight(String cardID, int price) {
		this.cardID = cardID;
		this.bet = price;
	}

	public String getId() {
		return id;
	}

	public String getCardID() {
		return cardID;
	}

	public int getBet() {
		return bet;
	}
}
