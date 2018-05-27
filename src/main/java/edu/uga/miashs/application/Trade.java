package main.java.edu.uga.miashs.application;

public class Trade {
	private String id;
	private int price;
	private Card card;
	
	public Trade(String id, Card card, int price) {
		this.id = id;
		this.card = card;
		this.price = price;
	}
	
	public Trade(Card card, int price) {
		this.card = card;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public Card getCard() {
		return this.card;
	}

	public int getPrice() {
		return price;
	}
}
