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

	public String getId() {
		return id;
	}

	public Card getCard() {
		return card;
	}

	public int getBet() {
		return bet;
	}
}
