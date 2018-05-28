package main.java.edu.uga.miashs.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import main.java.edu.uga.miashs.application.Trade;
import main.java.edu.uga.miashs.resources.ComponentsSize;

public class TradeButton extends Button{
	private Trade trade;
	
	
	
	public TradeButton(Trade trade) {
		this.trade = trade;
		initBox();
	}

	private void initBox() {
		this.setPrefSize(ComponentsSize.getComponentSize().getAppWidthHalfSize(), Control.USE_COMPUTED_SIZE);
		this.setMaxSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		this.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		this.setText("name : " + this.trade.getCard().getName() + "\t Price : " + this.trade.getPrice());
		this.setAlignment(Pos.BASELINE_LEFT);
		
	}
	
	/**
	 * Get the trade of the button.
	 */
	public Trade getTrade(){
		return this.trade;
	}
	
}
