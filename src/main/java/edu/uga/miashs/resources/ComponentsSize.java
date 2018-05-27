package main.java.edu.uga.miashs.resources;


public class ComponentsSize {

	private double appWidthSize;
	private double appWidthHalfSize;
	private double appHeightSize;
	private double appHeightHalfSize;
	
	private static ComponentsSize size;
	
	private ComponentsSize(){
		//screen and board
		this.appWidthSize = 1000;
		this.appWidthHalfSize = 500;
		this.appHeightSize = 800;
		this.appHeightHalfSize = 400;
	}

	public static ComponentsSize getComponentSize(){
		if (size == null){
			size = new ComponentsSize();
		}
		return size;
	}

	public double getAppWidthSize() {
		return appWidthSize;
	}

	public double getAppWidthHalfSize() {
		return appWidthHalfSize;
	}

	public double getAppHeightSize() {
		return appHeightSize;
	}

	public double getAppHeightHalfSize() {
		return appHeightHalfSize;
	}

}
