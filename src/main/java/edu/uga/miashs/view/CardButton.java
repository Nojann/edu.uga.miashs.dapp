package main.java.edu.uga.miashs.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.java.edu.uga.miashs.application.Card;
import main.java.edu.uga.miashs.resources.ComponentsSize;

public class CardButton extends Button{

	@FXML private VBox details;
	private Card card;
	
//	private TextField cardID, cardName;
	
	public CardButton(Card card) {
		this.card = card;
		this.initBox();
	}
	
	private void initBox() {		
		// HBox (container)
		this.setPrefSize(ComponentsSize.getComponentSize().getAppWidthHalfSize(), Control.USE_COMPUTED_SIZE);
		this.setMaxSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		this.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		this.setText("ID : " + this.card.getId() + "\t Name : " + this.card.getName());
		this.setAlignment(Pos.BASELINE_LEFT);
	}
	
	public Card getCard(){
		return this.card;
	}
	
	
}
