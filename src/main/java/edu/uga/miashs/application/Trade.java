package main.java.edu.uga.miashs.application;

public class Trade {
	private String id;
	private String cardID;
	private int price;
	
	public Trade(String id, String cardID, int price) {
		this.id = id;
		this.cardID = cardID;
		this.price = price;
	}
	
	public Trade(String cardID, int price) {
		this.cardID = cardID;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getCardID() {
		return cardID;
	}

	public int getPrice() {
		return price;
	}
}
