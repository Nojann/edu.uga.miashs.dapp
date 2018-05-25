package main.java.edu.uga.miashs.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import main.java.edu.uga.miashs.application.Fight;
import main.java.edu.uga.miashs.resources.ComponentsSize;

public class FightButton extends Button{
	private Fight fight;
	
	public FightButton(Fight fight) {
		this.fight = fight;
		initBox();
	}

	private void initBox() {
		this.setPrefSize(ComponentsSize.getComponentSize().getAppWidthHalfSize(), Control.USE_COMPUTED_SIZE);
		this.setMaxSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		this.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		this.setText("Card ID : " + this.fight.getCardID() + "\t Price : " + this.fight.getBet());
		this.setAlignment(Pos.BASELINE_LEFT);
		
	}
	
	public Fight getFight() {
		return this.fight;
	}
}
