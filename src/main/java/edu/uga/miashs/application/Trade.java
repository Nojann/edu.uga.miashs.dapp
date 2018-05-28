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
	
	/**
	 * @return return the id of the trade contract
	 * */
	public String getId() {
		return id;
	}

	/**
	 * @return return the card used in this trade.
	 * */
	public Card getCard() {
		return this.card;
	}

	/**
	 * @return return the price of the card.
	 * */
	public int getPrice() {
		return price;
	}
}
