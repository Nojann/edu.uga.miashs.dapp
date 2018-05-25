package main.java.edu.uga.miashs.application;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.stage.Stage;
import main.java.edu.uga.miashs.view.CardButton;
import main.java.edu.uga.miashs.view.DappView;

public class DappCore {
	//TODO: tokens! 
	private DappView view;
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
		
		
		this.addUserCard("0az52s4dqd23qsda4566", "Pas d'idée 1");
		this.addUserCard("ve5g0s2n4l15d6s1152q", "Pas d'idée 2 : le retour");
		this.addUserCard("a2c15h621s7d2fg17gfd", "Pas d'idée 3 : ca va trop loin");
		
		this.addOtherFight("c4e5b4q2d5f4s8d2s1a3", 500);
		this.addOtherFight("a2d3j1i5f7k4m6gfhj9m", 20);
		
		this.addOtherTrade("q5h6f0bn2u6y1eer6675", 300);
		this.addOtherTrade("s1d5z4th1khj26l4j6h2", 30);
		
	}
	
	public void addUserCard(String id, String name) {
		Card card = new Card(id, name);
		this.myCardList.add(card);
		this.view.newUserCardButton(card);
	}
	
	public void addUserCard(Card card) {
		this.myCardList.add(card);
		this.view.newUserCardButton(card);
	}
	
	public void addMyTrade(Card card, int price){
		Trade trade = new Trade(card.getId(), price);
		this.usedCard.add(card);
		this.myTradeList.add(trade);
		this.view.newUserTradeButton(trade);
	}
	
	public void addMyFight(Card card, int bet){
		Fight fight = new Fight(card.getId(), bet);
		this.usedCard.add(card);
		this.myFightList.add(fight);
		this.view.newUserFightButton(fight);
	}
	
	public void addOtherTrade(String id, int price){
		Trade trade = new Trade(id, price);
		this.othersTradeList.add(trade);
		this.view.newOthersTradeButton(trade);
	}
	
	public void addOtherTrade(Card card, int price){
		Trade trade = new Trade(card.getId(), price);
		this.othersTradeList.add(trade);
		this.view.newOthersTradeButton(trade);
	}
	
	public void addOtherFight(String id, int bet){
		Fight fight = new Fight(id, bet);
		this.othersFightList.add(fight);
		this.view.newOthersFightButton(fight);
	}
	
	public void addOtherFight(Card card, int bet){
		Fight fight = new Fight(card.getId(), bet);
		this.othersFightList.add(fight);
		this.view.newOthersFightButton(fight);
	}
	
	
	
	public boolean newTrade(Card fixedCard, int price){
		
		for (Card card : this.usedCard) {
			if(card.getId() == fixedCard.getId())
				return false;
		}
		
		if(true) { // Si on peut créer l'échange.
			//TODO: Partie avec Ethereum (PutToMarket())
			this.addMyTrade(fixedCard, price);
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean newFight(Card fixedCard, int bet) {
		
		for (Card card : this.usedCard) {
			if(card.getId() == fixedCard.getId())
				return false;
		}
		
		if(true) { // Si on peut créer l'échange.
			//TODO: Partie avec Ethereum (PutToMarket())
			this.addMyFight(fixedCard, bet);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void refreshCard() {
		this.view.clearCards();
		for (Card card : this.myCardList) {
			this.view.newUserCardButton(card);
		}
	}
	
	public void refreshTrades() {
		this.view.clearTrades();
		for (Trade trade : this.myTradeList) {
			this.view.newUserTradeButton(trade);
		}
		for (Trade trade : this.othersTradeList) {
			this.view.newOthersTradeButton(trade);
		}
	}
	
	public void refreshFight() {
		this.view.clearFights();
		for (Fight fight : this.myFightList) {
			this.view.newUserFightButton(fight);
		}
		for (Fight fight : this.othersFightList) {
			this.view.newOthersFightButton(fight);
		}
	}
	
	public void refreshAll() {
		this.refreshCard();
		this.refreshFight();
		this.refreshTrades();
	}
}
