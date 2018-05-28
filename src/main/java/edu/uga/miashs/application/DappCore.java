package main.java.edu.uga.miashs.application;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.stage.Stage;
import main.java.edu.uga.miashs.view.CardButton;
import main.java.edu.uga.miashs.view.DappView;

public class DappCore {
	private DappView view;
	private int myTokens;
	private ArrayList<Card> myCardList;
	private ArrayList<Trade> myTradeList;
	private ArrayList<Fight> myFightList;
	private ArrayList<Card> usedCard;
	private ArrayList<Trade> othersTradeList;
	private ArrayList<Fight> othersFightList;
	
	public DappCore(Stage primaryStage) {
		this.view = new DappView(primaryStage, this);
		this.myCardList = new ArrayList<Card>();
		this.myTradeList = new ArrayList<Trade>();
		this.myFightList = new ArrayList<Fight>();
		this.usedCard = new ArrayList<Card>();
		this.othersTradeList = new ArrayList<Trade>();
		this.othersFightList = new ArrayList<Fight>();
		
		this.refreshTokens(1000);
		
		
		
		
		int[][] bgColor = {{120,10,200}, {20,80,50}, {184,226,185}, {200,100,50}, {255,0,255}};
		int[][] inColor = {{200,140,42}, {40,80,120}, {240,120,60}, {50,100,200}, {42,84,21}};

		
		this.addUserCard("0az52s4dqd23qsda4566", "Pas d'idée 1", bgColor[0], inColor[0]);
		this.addUserCard("ve5g0s2n4l15d6s1152q", "Pas d'idée 2 : le retour", bgColor[1], inColor[1]);
		this.addUserCard("a2c15h621s7d2fg17gfd", "Pas d'idée 3 : ca va trop loin", bgColor[2], inColor[2]);
		
		Card c1 = new Card("a165fdg156dh7sdf1355", "Ceci est un nom aléatoire", bgColor[3], inColor[3]);
		Card c2 = new Card("d1gf5gf1e2er6h1ez6go7", "Ceci n'est pas un nom aléatoire", bgColor[4], inColor[4]);
		this.addOtherFight(c1, 500);
		this.addOtherFight(c2, 20);
		
		Card e1 = new Card("q5h6f0bn2u6y1eer6675", "A échanger!!" , bgColor[4], inColor[2]);
		Card e2 = new Card("s1d5z4th1khj26l4j6h2", "J'ai pas de nom", bgColor[1], inColor[3]);
		this.addOtherTrade(e1, 300);
		this.addOtherTrade(e2, 30);
		
	}
	
	/**
	 * Used for adding a card in the list of user card and display.
	 * @param ID of the card, name of the Card, table of background color (red green and blue)
	 * and table of form color (red green and blue).
	 * */
	public void addUserCard(String id, String name, int[] bgColor, int[] inColor) {
		Card card = new Card(id, name, bgColor, inColor);
		this.myCardList.add(card);
		this.view.newUserCardButton(card);
	}
	
	/**
	 * Used for adding a card in the list of user card and display.
	 * @param Card
	 * */
	public void addUserCard(Card card) {
		this.myCardList.add(card);
		this.view.newUserCardButton(card);
	}
	
	/**
	 * Used for adding a trade in the list of user trade and display it.
	 * @param Card and price
	 * */
	public void addMyTrade(Card card, int price){
		Trade trade = new Trade(card, price);
		this.usedCard.add(card);
		this.myTradeList.add(trade);
		this.view.newUserTradeButton(trade);
	}
	
	/**
	 * Used for adding a card in the list of user fight and display.
	 * @param Card and bet
	 * */
	public void addMyFight(Card card, int bet){
		Fight fight = new Fight(card, bet);
		this.usedCard.add(card);
		this.myFightList.add(fight);
		this.view.newUserFightButton(fight);
	}
	
	/**
	 * Used for adding a card in the list of 
	 * trade proposed by other player and display.
	 * @param Card and price
	 * */
	public void addOtherTrade(Card card, int price){
		Trade trade = new Trade(card, price);
		this.othersTradeList.add(trade);
		this.view.newOthersTradeButton(trade);
	}
	
	/**
	 * Used for adding a card in the list of 
	 * fight proposed by other player and display.
	 * @param Card and bet
	 * */
	public void addOtherFight(Card card, int bet){
		Fight fight = new Fight(card, bet);
		this.othersFightList.add(fight);
		this.view.newOthersFightButton(fight);
	}
	
	/**
	 * Check if new trade is possible and creat it
	 * @param Card and price
	 * */
	public void newTrade(Card fixedCard, int price){
		boolean exist = false;
		for (Card card : this.usedCard) {
			if(card.getId() == fixedCard.getId()) {
				exist = true;
			}
		}
		
		if(exist) {
			this.log("Card already used!");
		}
		else if(true) { // Si on peut créer l'échange.
			//TODO: Partie avec Ethereum (PutToMarket())
			this.addMyTrade(fixedCard, price);
			this.log("New Trade!");
		}
		else {
			this.log("Can't trade!");
		}
		
	}
	
	/**
	 * Check if new fight is possible and creat it
	 * @param Card and bet
	 * */
	public void newFight(Card fixedCard, int bet) {
		boolean exist = false;
		for (Card card : this.usedCard) {
			if(card.getId() == fixedCard.getId()) {
				exist = true;
			}
		}
		
		if(exist) {
			this.log("Card already used!");
		}
		else if(bet<this.myTokens) { // Si on peut créer le combat
			this.refreshTokens(myTokens-bet);
			this.addMyFight(fixedCard, bet);
			this.log("New fight");
		}
		else {
			this.log("Not enough money");
		}
	}
	
	/**
	 * Check if buy the card proposed by the trade is possible and buy it
	 * @param Trade
	 * */
	public void buyCard(Trade trade) {
		if(trade.getPrice() < this.myTokens) {
			this.refreshTokens(this.myTokens-trade.getPrice());
			this.addUserCard(trade.getCard());
			this.refreshCard();
			this.othersTradeList.remove(trade);
			this.refreshTrades();
		}
		else {
			this.log("Not enough money");
		}
	}
	
	/**
	 * Check if fighting is possible and accept the fight.
	 * @param Fight and choosen card
	 * */
	public void fight(Fight fixedFight, Card fixedCard) {
		boolean exist = false;
		for (Card card : this.usedCard) {
			if(card.getId() == fixedCard.getId()) {
				exist = true;
			}
		}
		
		if(exist) {
			this.log("Card already used!");
		}
		else if(fixedFight.getBet() < this.myTokens) {
			this.refreshTokens(this.myTokens-fixedFight.getBet());
			this.usedCard.add(fixedCard);
			this.othersFightList.remove(fixedFight);
			this.refreshFight();
			this.refreshCard();
			this.log("Wait for result");
		}
		else {
			this.log("Not enough money");
		}
	}
	
	/**
	 * log
	 * @param message
	 * */
	private void log(String log){
		this.view.log(log);
	}
	
	/**
	 * Display the new amount of tokens.
	 * @param nomber of tokens
	 * */
	private void refreshTokens(int tokens) {
		this.myTokens = tokens;
		this.view.displayTokens(myTokens);
	}
	
	/**
	 * Refresh the Card section
	 * */
	public void refreshCard() {
		this.view.clearCards();
		for (Card card : this.myCardList) {
			this.view.newUserCardButton(card);
		}
	}
	
	/**
	 * Refresh trade section
	 * */
	public void refreshTrades() {
		this.view.clearTrades();
		for (Trade trade : this.myTradeList) {
			this.view.newUserTradeButton(trade);
		}
		for (Trade trade : this.othersTradeList) {
			this.view.newOthersTradeButton(trade);
		}
	}
	
	/**
	 * Refresh fight section
	 * */
	public void refreshFight() {
		this.view.clearFights();
		for (Fight fight : this.myFightList) {
			this.view.newUserFightButton(fight);
		}
		for (Fight fight : this.othersFightList) {
			this.view.newOthersFightButton(fight);
		}
	}
	
	/**
	 * refresh all sections
	 * */
	public void refreshAll() {
		this.refreshCard();
		this.refreshFight();
		this.refreshTrades();
	}
}
