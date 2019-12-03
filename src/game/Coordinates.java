package game;


/**
 * Just has x and y coordinates
 * @author zohair
 *
 */
public class Coordinates {
	private int x;
	private int y;
	
	/**
	 * Creates x and y Coordinates
	 * @param x the x value
	 * @param y the y value
	 */
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * 
	 * @return gets x value
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * sets x value
	 * @param x the x value
	 */
	public void setX(int x){
		this.x=x;
	}
	
	/**
	 * gets y value
	 * @return the y value
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * sets y value
	 * @param y the y value
	 */
	public void setY(int y){
		this.y=y;
	}

}
