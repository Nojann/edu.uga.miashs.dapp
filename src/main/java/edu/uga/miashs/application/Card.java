package main.java.edu.uga.miashs.application;

import javafx.scene.image.Image;

public class Card {
	private String id;
	private String name;
	private int[] rgbBGColor;
	private int[] rgbINColor;
	
	public Card(String id, String name, int bgColorRed, int bgColorGreen, int bgColorBlue,
			int inColorRed, int inColorGreen, int inColorBlue) {
		this.id = id;
		this.name = name;
		this.rgbBGColor = new int[3];
		this.rgbBGColor[0] = bgColorRed;
		this.rgbBGColor[1] = bgColorGreen;
		this.rgbBGColor[2] = bgColorBlue;
		
		this.rgbINColor = new int[3];
		this.rgbINColor[0] = inColorRed;
		this.rgbINColor[1] = inColorGreen;
		this.rgbINColor[2] = inColorBlue;
	}
	
	public Card(String id, String name, int[] bgColor, int[] inColor) {
		this.id = id;
		this.name = name;
		this.rgbBGColor = bgColor;
		this.rgbINColor = inColor;
	}
	
//	public Card(String id, String name) {
//		this.id = id;
//		this.name = name;
//	}

	
	/**
	 * @return : return the id of the card
	 * */
	public String getId() {
		return this.id;
	}
	
	/**
	 * @return : return the name of the card
	 * */
	public String getName() {
		return this.name;
	}

	/**
	 * @return : return int table, contains red, green 
	 * and blue color of the background card.
	 * */
	public int[] getRGBBGColor() {
		return this.rgbBGColor;
	}
	
	/**
	 * @return : return int table, contains red, green 
	 * and blue color of the card form.
	 * */
	public int[] getRGBINColor() {
		return this.rgbINColor;
	}
}
