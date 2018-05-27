package main.java.edu.uga.miashs.view;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.edu.uga.miashs.application.Card;
import main.java.edu.uga.miashs.application.DappCore;
import main.java.edu.uga.miashs.application.Fight;
import main.java.edu.uga.miashs.application.Main;
import main.java.edu.uga.miashs.application.Trade;
import main.java.edu.uga.miashs.resources.ComponentsSize;

public class DappView {
	@FXML private Text tokens;
	@FXML private Text log;
	
	@FXML private VBox listOfCard;
	@FXML private VBox details;

	@FXML private Button newTradeButton;
	@FXML private Button refreshTradesButton;
	@FXML private VBox listOfMyTrades;
	@FXML private VBox listOfAllTrades;

	@FXML private Button newFightButton;
	@FXML private Button refreshFightButton;
	@FXML private VBox listOfMyFights;
	@FXML private VBox listOfAllFights;
	
	private ArrayList<CardButton> cardsButtonArray = new ArrayList<CardButton>();
	private ArrayList<TradeButton> myTradesButtonArray = new ArrayList<TradeButton>();
	private ArrayList<FightButton> myFightsButtonArray = new ArrayList<FightButton>();
	private ArrayList<TradeButton> othersTradesButtonArray = new ArrayList<TradeButton>();
	private ArrayList<FightButton> othersFightsButtonArray = new ArrayList<FightButton>();
	private TextField priceOrBet = new TextField();
	private int fixedPriceOrBet;
	private Card fixedCard;
	private Trade fixedTrade;
	private Fight fixedFight;
	
	private DappCore core;
	
	public DappView(Stage primaryStage, DappCore dappCore) {
		try {
			this.core = dappCore;
			Pane root = new Pane();
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/main/java/edu/uga/miashs/view/dappInterface.fxml"));
            loader.setController(this);
            root = loader.load();
            
			primaryStage.setTitle("DAPP");
//	        primaryStage.getIcons().add(new Image(""));
	        StackPane rootLayout = new StackPane();
	        rootLayout.getStyleClass().add("root-layout");
	        rootLayout.getStylesheets().add(Main.class.getResource("/main/java/edu/uga/miashs/view/application.css").toExternalForm());

	        primaryStage.setScene(new Scene(rootLayout));
	        primaryStage.setFullScreen(false);
	        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	        primaryStage.setMinHeight(ComponentsSize.getComponentSize().getAppHeightSize());
	        primaryStage.setMinWidth(ComponentsSize.getComponentSize().getAppWidthSize()+50);
	        primaryStage.setMaxHeight(ComponentsSize.getComponentSize().getAppHeightSize());
	        primaryStage.setMaxWidth(ComponentsSize.getComponentSize().getAppWidthSize()+50);
	        primaryStage.show();
            ((StackPane)primaryStage.getScene().getRoot()).getChildren().addAll(root);
            
            double heightHalfSize = ComponentsSize.getComponentSize().getAppHeightHalfSize();
            double widthHalfSize = ComponentsSize.getComponentSize().getAppWidthHalfSize();
            this.setPaneSize(listOfCard, widthHalfSize, heightHalfSize/1.5);
            this.setPaneSize(listOfAllFights, widthHalfSize, heightHalfSize/2);
            this.setPaneSize(listOfAllTrades, widthHalfSize, heightHalfSize/2);
            this.setPaneSize(listOfMyFights, widthHalfSize, heightHalfSize/2);
            this.setPaneSize(listOfMyTrades, widthHalfSize, heightHalfSize/2);
            this.setPaneSize(this.details, widthHalfSize, heightHalfSize/2);
			priceOrBet.setMaxWidth(200);
                       
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*--------------------	shortcut / Display  --------------------*/
	private void setPaneSize(Pane n, double width, double height) {
		n.setMaxSize(width, height);
		n.setMinSize(width, height);
		n.setPrefSize(width, height);
	}
	
	private void clearAndAddToDetails(Node...nodes) {
		this.details.getChildren().clear();
		this.details.getChildren().addAll(nodes);
	}
	
	public void clearCards() {
		this.details.getChildren().clear();
		this.listOfCard.getChildren().clear();
	}
	
	public void clearTrades() {
		this.details.getChildren().clear();
		this.listOfAllTrades.getChildren().clear();
		this.listOfMyTrades.getChildren().clear();
	}
	public void clearFights() {
		this.details.getChildren().clear();
		this.listOfAllFights.getChildren().clear();
		this.listOfMyFights.getChildren().clear();
	}
	
	public void log(String log) {
		this.log.setText(log);
	}
	
	public void displayTokens(int tokens) {
		this.tokens.setText(""+tokens);
	}
	
	private AnchorPane cardPanel(Card card) {
		AnchorPane p = new AnchorPane();
		Rectangle bg = new Rectangle(100, 100);
		bg.setFill(Color.rgb(card.getRGBBGColor()[0], card.getRGBBGColor()[1], card.getRGBBGColor()[2]));
		Rectangle in = new Rectangle(80, 80);
		in.setFill(Color.rgb(card.getRGBINColor()[0], card.getRGBINColor()[1], card.getRGBINColor()[2]));
		AnchorPane.setTopAnchor(in, 10.0);
		AnchorPane.setLeftAnchor(in, 10.0);
		p.getChildren().addAll(bg, in);
		return p;
	}

	/*--------------------	new Buttons --------------------*/
	public void newUserFightButton(Fight fight) {
		FightButton btn = new FightButton(fight);
		this.myFightsButtonArray.add(btn);
		this.listOfMyFights.getChildren().add(btn);
		this.defaultMyFightButtonEvent(btn);
	}
	
	public void newUserTradeButton(Trade trade) {
		TradeButton btn = new TradeButton(trade);
		this.myTradesButtonArray.add(btn);
		this.listOfMyTrades.getChildren().add(btn);
		this.defaultMyTradeButtonEvent(btn);
	}
	
	public void newUserCardButton(final Card card){
		CardButton btn = new CardButton(card);
		this.cardsButtonArray.add(btn);
		this.listOfCard.getChildren().add(btn);
		defaultCardButtonEvent(btn);
	}
	
	public void newOthersTradeButton(Trade trade) {
		TradeButton btn = new TradeButton(trade);
		this.othersTradesButtonArray.add(btn);
		this.listOfAllTrades.getChildren().add(btn);
		this.defaultOtherTradeButtonEvent(btn);
	}
	
	public void newOthersFightButton(Fight fight) {
		FightButton btn = new FightButton(fight);
		this.othersFightsButtonArray.add(btn);
		this.listOfAllFights.getChildren().add(btn);
		this.defaultOtherFightButtonEvent(btn);
	}
	
	/*--------------------	FXML Buttons --------------------*/
	@FXML
	private void newTradeButtonAction() {
		for(CardButton card : this.cardsButtonArray) {
			card.setOnAction(selectNewTradeCardEvent);
		}
		this.noEventForAllButtonsExceptCardButtons();
		log.setText("Select a card to exchange.");
		details.getChildren().clear();
	}
	
	@FXML 
	private void refreshTradesButtonAction() {
		this.log.setText("Refresh Trades");
		this.core.refreshTrades();
	}
	
	@FXML 
	private void newFightButtonAction() {
		for(CardButton card : this.cardsButtonArray) {
			card.setOnAction(selectNewFightCardEvent);
		}
		this.noEventForAllButtonsExceptCardButtons();
		log.setText("Select a card for the fight.");
		details.getChildren().clear();
	}
	
	@FXML 
	private void refreshFightsButtonAction() {
		this.log.setText("Refresh Fights");
		this.core.refreshFight();
	}

	/*--------------------	default Buttons Event Action --------------------*/
	private void defaultCardButtonEvent(final CardButton cardButtons) {
		cardButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Card card = cardButtons.getCard();
				Text textId = new Text("Card ID : " + card.getId());
				Text textName = new Text("Card Name : " + card.getName());
				AnchorPane p = cardPanel(card);
				
				clearAndAddToDetails(textId, textName, p);
			}
		});
	}
	
	private void defaultMyTradeButtonEvent(final TradeButton tradeButtons) {
		tradeButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Trade trade = tradeButtons.getTrade();
				Text textId = new Text("Card ID : " + trade.getCard().getId());
				Text textName = new Text("Card name : " + trade.getCard().getName());
				Text textPrice = new Text("Price : " + trade.getPrice());
				AnchorPane p = cardPanel(trade.getCard());
				clearAndAddToDetails(textId, textName, textPrice, p);
			}
		});
	}
	
	private void defaultMyFightButtonEvent(final FightButton fightButtons) {
		fightButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Fight fight = fightButtons.getFight();
				Text textId = new Text("Card ID : " + fight.getCard().getId());
				Text textName = new Text("Card name : " + fight.getCard().getName());
				Text textBet = new Text("Bet : " + fight.getBet());
				AnchorPane p = cardPanel(fight.getCard());
				clearAndAddToDetails(textId, textName, textBet, p);
			}
		});
	}

	private void defaultOtherTradeButtonEvent(final TradeButton tradeButtons) {
		tradeButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				fixedTrade = tradeButtons.getTrade();
				Trade trade = tradeButtons.getTrade();
				Text textId = new Text("Card ID : " + trade.getCard().getId());
				Text textName = new Text("Card name : " + trade.getCard().getName());
				Text textPrice = new Text("Price : " + trade.getPrice());
				AnchorPane p = cardPanel(trade.getCard());
				
				BorderPane tradePanel = new BorderPane();
				Button validation = new Button("Buy this card");
				Button cancel = new Button("Cancel");
				tradePanel.setLeft(cancel);
				tradePanel.setRight(validation);
				
				cancel.setOnAction(cancelEvent);
				validation.setOnAction(buyCardEvent);
				
				clearAndAddToDetails(textId, textName, textPrice, p, tradePanel);
			}
		});
	}
	
	private void defaultOtherFightButtonEvent(final FightButton fightButtons) {
		fightButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				fixedFight = fightButtons.getFight();
				Fight fight = fightButtons.getFight();
				Text textId = new Text("Card ID : " + fight.getCard().getId());
				Text textName = new Text("Card name : " + fight.getCard().getName());
				Text textBet = new Text("Bet : " + fight.getBet());
				AnchorPane p = cardPanel(fight.getCard());
				
				Button validation = new Button("Let's Go!");
				Button cancel = new Button("Cancel");
				BorderPane fightPanel = new BorderPane(null, null, validation, null, cancel);
				
				cancel.setOnAction(cancelEvent);
				validation.setOnAction(acceptFightEvent);
				
				clearAndAddToDetails(textId, textName, textBet, p, fightPanel);
			}
		});
	}

	/*--------------------	default Buttons Event Action For All--------------------*/
	private void defaultEventForAllButtons() {
		for(final CardButton cardButton : this.cardsButtonArray) {
			defaultCardButtonEvent(cardButton);
		}
		for(final TradeButton tradeButton : this.myTradesButtonArray) {
			defaultMyTradeButtonEvent(tradeButton);
		}
		for(final FightButton fightButton : this.myFightsButtonArray) {
			defaultMyFightButtonEvent(fightButton);
		}
		for(final TradeButton tradeButton : this.othersTradesButtonArray) {
			defaultOtherTradeButtonEvent(tradeButton);
		}
		for(final FightButton fightButton : this.othersFightsButtonArray) {
			defaultOtherFightButtonEvent(fightButton);
		}
	}
	
	private void noEventForAllButtons() {
		for(final TradeButton tradeButton : this.myTradesButtonArray) {
			tradeButton.setOnAction(null);
		}
		for(final FightButton fightButton : this.myFightsButtonArray) {
			fightButton.setOnAction(null);
		}
		for(final CardButton cardButton : this.cardsButtonArray) {
			cardButton.setOnAction(null);
		}
		for(final TradeButton tradeButton : this.othersTradesButtonArray) {
			tradeButton.setOnAction(null);
		}
		for(final FightButton fightButton : this.othersFightsButtonArray) {
			fightButton.setOnAction(null);
		}
	}
	
	private void noEventForAllButtonsExceptCardButtons() {
		for(final TradeButton tradeButton : this.myTradesButtonArray) {
			tradeButton.setOnAction(null);
		}
		for(final FightButton fightButton : this.myFightsButtonArray) {
			fightButton.setOnAction(null);
		}
		for(final TradeButton tradeButton : this.othersTradesButtonArray) {
			tradeButton.setOnAction(null);
		}
		for(final FightButton fightButton : this.othersFightsButtonArray) {
			fightButton.setOnAction(null);
		}
	}
	
	/*--------------------	Buttons Events --------------------*/
	/*--------------------	New Trade --------------------*/
	private EventHandler<ActionEvent> selectNewTradeCardEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			CardButton card = ((CardButton)event.getTarget());
			fixedCard = card.getCard();
			log.setText("Fix the price of the card.");
			
			Text textId = new Text("Card ID : " + card.getCard().getId());
			Text textName = new Text("Card Name : " + card.getCard().getName());
			
			BorderPane tradePanel = new BorderPane();
			Button validation = new Button("Send this card");
			Button cancel = new Button("Cancel");

            priceOrBet.setPromptText("Price");
			tradePanel.setLeft(cancel);
			tradePanel.setRight(validation);
			tradePanel.setCenter(priceOrBet);
			
			clearAndAddToDetails(textId, textName, tradePanel);
			
			cancel.setOnAction(cancelEvent);
			validation.setOnAction(tradeValidationEvent);
		}
	};
	
	private EventHandler<ActionEvent> tradeValidationEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			try {
				fixedPriceOrBet = Integer.parseInt(priceOrBet.getText());
				Text validationText = new Text("Are you sure to sell this card for : " + fixedPriceOrBet
						+ " token(s)?");
				Button yes = new Button("Yes");
				Button no = new Button("No");
				BorderPane tradePanel = new BorderPane(null, null, yes, null, no);
				no.setOnAction(cancelEvent);
				yes.setOnAction(yesTradeEvent);
				
				noEventForAllButtons();
				clearAndAddToDetails(validationText, tradePanel);
			} catch(NumberFormatException e) {
				log.setText("The price is incorrect, must contain only numbers");
			}
			priceOrBet.setText(null);
		}
	};	
	
	private EventHandler<ActionEvent> yesTradeEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			core.newTrade(fixedCard, fixedPriceOrBet);
			fixedCard = null;
		}
	};

	/*-------------------- New Fight --------------------*/
	private EventHandler<ActionEvent> selectNewFightCardEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			CardButton card = ((CardButton)event.getTarget());
			fixedCard = card.getCard();
			log.setText("Fix the amount of bet.");
			
			Text textId = new Text("Card ID : " + card.getCard().getId());
			Text textName = new Text("Card Name : " + card.getCard().getName());
			
			BorderPane tradePanel = new BorderPane();
			Button validation = new Button("Fight");
			Button cancel = new Button("Cancel");
			
            priceOrBet.setPromptText("Bet");
			tradePanel.setLeft(cancel);
			tradePanel.setRight(validation);
			tradePanel.setCenter(priceOrBet);
			
			clearAndAddToDetails(textId, textName, tradePanel);
			
			cancel.setOnAction(cancelEvent);
			validation.setOnAction(newFightValidationEvent);
		}
	};
	
	private EventHandler<ActionEvent> newFightValidationEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			try {
				fixedPriceOrBet = Integer.parseInt(priceOrBet.getText());
				Text validationText = new Text("Are you sure to sell this card for : " + fixedPriceOrBet
						+ " token(s)?");
				Button yes = new Button("Yes");
				Button no = new Button("No");
				BorderPane tradePanel = new BorderPane(null, null, yes, null, no);
				no.setOnAction(cancelEvent);
				yes.setOnAction(yesFightEvent);
				
				noEventForAllButtons();
				clearAndAddToDetails(validationText, tradePanel);
			} catch(NumberFormatException e) {
				log.setText("The price is incorrect, must contain only numbers");
			}
			priceOrBet.setText(null);
		}
	};	
	
	private EventHandler<ActionEvent> yesFightEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			core.newFight(fixedCard, fixedPriceOrBet);
			fixedCard = null;
		}
	};
	
	/*-------------------- Buy Card --------------------*/
	private EventHandler<ActionEvent> buyCardEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			Text validationText = new Text("Are you sure to buy this card for : " + fixedTrade.getPrice()
					+ " token(s)?");
			Button yes = new Button("Yes");
			Button no = new Button("No");
			BorderPane tradePanel = new BorderPane(null, null, yes, null, no);
			no.setOnAction(cancelEvent);
			yes.setOnAction(yesBuyEvent);
			
			noEventForAllButtons();
			clearAndAddToDetails(validationText, tradePanel);
			priceOrBet.setText(null);
		}
	};	
	
	private EventHandler<ActionEvent> yesBuyEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			core.buyCard(fixedTrade);
			fixedTrade = null;
		}
	};
	
	
	/*-------------------- Accept fight --------------------*/
	private EventHandler<ActionEvent> acceptFightEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			Text validationText = new Text("Select your card !");
			clearAndAddToDetails(validationText);
			
			noEventForAllButtonsExceptCardButtons();
			for(CardButton card : cardsButtonArray) {
				card.setOnAction(selectCardForFightEvent);
			}
			priceOrBet.setText(null);
		}
	};	
	
	private EventHandler<ActionEvent> selectCardForFightEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			CardButton card = ((CardButton)event.getTarget());
			fixedCard = card.getCard();
			
			Text textId = new Text("Card ID : " + card.getCard().getId());
			Text textName = new Text("Card Name : " + card.getCard().getName());

			AnchorPane p = cardPanel(card.getCard());
			Button validation = new Button("Fight");
			Button cancel = new Button("Cancel");
			BorderPane fightPanel = new BorderPane(null, null, validation, null, cancel); 
			
			clearAndAddToDetails(textId, textName, p, fightPanel);
			
			cancel.setOnAction(cancelEvent);
			validation.setOnAction(fightEvent);
		}
	};
	
	private EventHandler<ActionEvent> fightEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			Text validationText = new Text("Are you sure ?");
			Button yes = new Button("Yes");
			Button no = new Button("No");
			BorderPane tradePanel = new BorderPane(null, null, yes, null, no);
			no.setOnAction(cancelEvent);
			yes.setOnAction(challengeAccepted);
			
			noEventForAllButtons();
			clearAndAddToDetails(validationText, tradePanel);
		}
	};	
	
	private EventHandler<ActionEvent> challengeAccepted = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			core.fight(fixedFight, fixedCard);
			fixedFight = null;
			fixedCard = null;
		}
	};	
	
	/*-------------------- Cancel --------------------*/
	private EventHandler<ActionEvent> cancelEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			fixedCard = null;
			fixedTrade = null;
			fixedFight = null;
			log.setText("Cancel");
		}
	};


	
}
