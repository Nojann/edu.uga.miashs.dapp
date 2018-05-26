package main.java.edu.uga.miashs.view;

import java.util.ArrayList;

import javax.lang.model.element.VariableElement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
	private ArrayList<TradeButton> tradesButtonArray = new ArrayList<TradeButton>();
	private ArrayList<FightButton> fightsButtonArray = new ArrayList<FightButton>();
	private TextField priceOrBet = new TextField();
	private int fixedPriceOrBet;
	private Card fixedCard;
	
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
	
	/*--------------------	shortcut --------------------*/
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
		this.listOfAllTrades.getChildren().clear();
		this.listOfMyTrades.getChildren().clear();
	}
	public void clearFights() {
		this.details.getChildren().clear();
		this.listOfAllFights.getChildren().clear();
		this.listOfMyFights.getChildren().clear();
	}

	/*--------------------	new Buttons --------------------*/
	public void newUserFightButton(Fight fight) {
		FightButton btn = new FightButton(fight);
		this.fightsButtonArray.add(btn);
		this.listOfMyFights.getChildren().add(btn);
		this.defaultFightButtonEvent(btn);
	}
	
	public void newUserTradeButton(Trade trade) {
		TradeButton btn = new TradeButton(trade);
		this.tradesButtonArray.add(btn);
		this.listOfMyTrades.getChildren().add(btn);
		this.defaultTradeButtonEvent(btn);
	}
	
	public void newUserCardButton(final Card card){
		CardButton btn = new CardButton(card);
		this.cardsButtonArray.add(btn);
		this.listOfCard.getChildren().add(btn);
		defaultCardButtonEvent(btn);
	}
	
	public void newOthersTradeButton(Trade trade) {
		TradeButton btn = new TradeButton(trade);
		this.tradesButtonArray.add(btn);
		this.listOfAllTrades.getChildren().add(btn);
		this.defaultTradeButtonEvent(btn);
	}
	
	public void newOthersFightButton(Fight fight) {
		FightButton btn = new FightButton(fight);
		this.fightsButtonArray.add(btn);
		this.listOfAllFights.getChildren().add(btn);
		this.defaultFightButtonEvent(btn);
	}
	
	/*--------------------	FXML Buttons --------------------*/
	@FXML
	private void newTradeButtonAction() {
		for(CardButton card : this.cardsButtonArray) {
			card.setOnAction(selectTradeCardEvent);
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
			card.setOnAction(selectFightCardEvent);
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
			public void handle(ActionEvent arg0) {
				Card card = cardButtons.getCard();
				Text textId = new Text("Card ID : " + card.getId());
				Text textName = new Text("Card Name : " + card.getName());
				clearAndAddToDetails(textId, textName);
			}
		});
	}
	
	private void defaultTradeButtonEvent(final TradeButton tradeButtons) {
		tradeButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				Trade trade = tradeButtons.getTrade();
				Text textId = new Text("Card ID : " + trade.getCardID());
				Text textPrice = new Text("Price : " + trade.getPrice());
				clearAndAddToDetails(textId, textPrice);
			}
		});
	}
	
	private void defaultFightButtonEvent(final FightButton fightButtons) {
		fightButtons.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				Fight fight = fightButtons.getFight();
				Text textId = new Text("Card ID : " + fight.getCardID());
				Text textBet = new Text("Bet : " + fight.getBet());
				clearAndAddToDetails(textId, textBet);
			}
		});
	}

	/*--------------------	default Buttons Event Action For All--------------------*/
	private void defaultEventForAllButtons() {
		for(final CardButton cardButton : this.cardsButtonArray) {
			defaultCardButtonEvent(cardButton);
		}
		for(final TradeButton tradeButton : this.tradesButtonArray) {
			defaultTradeButtonEvent(tradeButton);
		}
		for(final FightButton fightButton : this.fightsButtonArray) {
			defaultFightButtonEvent(fightButton);
		}
	}
	
	private void noEventForAllButtons() {
		for(final TradeButton tradeButton : this.tradesButtonArray) {
			tradeButton.setOnAction(null);
		}
		for(final FightButton fightButton : this.fightsButtonArray) {
			fightButton.setOnAction(null);
		}
		for(final CardButton cardButton : this.cardsButtonArray) {
			cardButton.setOnAction(null);
		}
	}
	
	private void noEventForAllButtonsExceptCardButtons() {
		for(final TradeButton tradeButton : this.tradesButtonArray) {
			tradeButton.setOnAction(null);
		}
		for(final FightButton fightButton : this.fightsButtonArray) {
			fightButton.setOnAction(null);
		}
	}
	
	/*--------------------	Buttons Events --------------------*/
	private EventHandler<ActionEvent> selectTradeCardEvent = new EventHandler<ActionEvent>(){
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
	
	private EventHandler<ActionEvent> selectFightCardEvent = new EventHandler<ActionEvent>(){
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
			validation.setOnAction(fightValidationEvent);
		}
	};
	
	private EventHandler<ActionEvent> cancelEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			fixedCard = null;
			log.setText("Cancel");
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
	
	private EventHandler<ActionEvent> fightValidationEvent = new EventHandler<ActionEvent>(){
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
	
	private EventHandler<ActionEvent> yesTradeEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			if(core.newTrade(fixedCard, fixedPriceOrBet))
				log.setText("New Trade!");
			else 
				log.setText("Can't trade!");
		}
	};
	
	private EventHandler<ActionEvent> yesFightEvent = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			defaultEventForAllButtons();
			details.getChildren().clear();
			if(core.newFight(fixedCard, fixedPriceOrBet))
				log.setText("New Fight!");
			else 
				log.setText("Can't fight!");
		}
	};
	
}
