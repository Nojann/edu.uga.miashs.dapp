package main.java.edu.uga.miashs.application;

public class Fight {
	
	private String id;
	private Card card;
	private int bet;

	public Fight(String id, Card card, int bet) {
		this.id = id;
		this.card = card;
		this.bet = bet;
	}
	
	public Fight(Card card, int price) {
		this.card = card;
		this.bet = price;
	}

	/**
	 * @return return the id of the fight contract
	 * */
	public String getId() {
		return id;
	}
	/**
	 * @return return the card used in this fight
	 * */
	public Card getCard() {
		return card;
	}

	/**
	 * @return return the amount of the bet.
	 * */
	public int getBet() {
		return bet;
	}
}
