package main.java.edu.uga.miashs.application;

import javafx.scene.image.Image;

public class Card {
	private String id;
	private String name;
	private Image img;
	
	public Card(String id, String name, Image img) {
		this.id = id;
		this.name = name;
		this.img = img;
	}
	
	public Card(String id, String name) {
		this.id = id;
		this.name = name;
	}

	
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Image getImg() {
		return img;
	}
}
