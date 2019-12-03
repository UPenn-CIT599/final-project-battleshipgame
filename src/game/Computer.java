package game;

import java.util.Random;

/**
 * Gets random values for taking a shot and placing a ship
 * @author zohair
 *
 */
public class Computer extends Player{
	
	private Random rand=new Random();
	
	/**
	 * Initiates super with PlayerType.COMPUTER
	 */
	public Computer() {
		super(PlayerType.COMPUTER);
	}
	
	/**
	 * Gets horizontal or vertical randomly
	 * @return horizontal or vertical
	 */
	public ShipOrientation getRandomOrientation() {
		int orientation=rand.nextInt(2);
		switch(orientation) {
		case 0:
			return ShipOrientation.HORIZONTAL;
		case 1:
			return ShipOrientation.VERTICAL;
		default:
			return ShipOrientation.HORIZONTAL;
		}
	}
	
	/**
	 * Gets random x, y coordinates 
	 * @param view The view that tells what is going on
	 * @return the random x, y coordinates
	 */
	public Coordinates getCoordinates(GameView view) {
		int x=rand.nextInt(getBoard().getWIDTH());
		int y=rand.nextInt(getBoard().getHEIGHT());
		return new Coordinates(x,y);
	}
	
	/**
	 * Places all ships until valid places are found at random
	 * @param view for telling the user that the computer is setting up
	 */
	public void setUp(GameView view) {
		view.tellComputerIsSettingUp();
		for (Ship s : getShips()) {
			boolean validShipPosition = false;
			Coordinates c=null;
			do {
			ShipOrientation orientation = getRandomOrientation();
			c = getCoordinates(view);
				try {
					s.setOrientation(orientation);
					getBoard().validateShip(c, s);
					validShipPosition = true;
				} catch (Exception e) {
					
				}
			} while (!validShipPosition);
			getBoard().placeShip(c, s);
		}
		view.tellComputerFinishedSettingUp();
	}
	
}
