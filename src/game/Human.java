package game;

import java.util.Scanner;

/**
 * The subclass of Player for Human Players
 * @author zohair
 */
public class Human extends Player{
	
	Scanner scanner = new Scanner(System.in);

	/**
	 * Initializes super as Human
	 */
	public Human() {
		super(PlayerType.HUMAN);
	}
	
	/**
	 * Gets the orientation from the command prompt
	 * @param view The view that tells what is going on
	 * @return vertical or horizontal
	 */
	public ShipOrientation getOrientation(GameView view) {
		String orientation=null;
		do {
			orientation = scanner.nextLine();
			if (GameModel.isInvalidOrientation(orientation)) {
				view.tellInvalidOrientation();
			}
		} while (GameModel.isInvalidOrientation(orientation));
		if (orientation.equals("H") || orientation.equals("h")) {
			return ShipOrientation.HORIZONTAL;
		} else if (orientation.equals("V") || orientation.equals("v")) {
			return ShipOrientation.VERTICAL;
		}
		return ShipOrientation.HORIZONTAL;
	}
	
	/**
	 * Gets the coordinates from the command prompt
	 * @param view The view that tells what is going on
	 * @return a coordinate
	 */
	public Coordinates getCoordinates(GameView view) {
		int x = -1, y = -1;
		view.askShipCoordinate('x');
		String xCoordinate = "";
		boolean isValid = false;
		do {
			xCoordinate = scanner.nextLine();
			try {
				x = Integer.parseInt(xCoordinate);
				getBoard().validateXCoordinate(x);
				isValid = true;
			} catch (Exception e) {
				view.tellInvalidCoordinate();
			}
		} while (!isValid);
		view.askShipCoordinate('y');
		String yCoordinate = "";
		isValid = false;
		do {
			yCoordinate = scanner.nextLine();
			try {
				y = Integer.parseInt(yCoordinate);
				getBoard().validateYCoordinate(y);
				isValid = true;
			} catch (Exception e) {
				view.tellInvalidCoordinate();
			}
		} while (!isValid);
		return new Coordinates(x, y);
	}
	
	/**
	 * Gets the user to set-up their board from the command prompt
	 * @param view the view that tells the user what is going on
	 * @param board the user's Board
	 */
	public void setUp(GameView view, Board board) {
		for (Ship s : getShips()) {
			boolean validShipPosition = false;
			Coordinates c=null;
			String orientation;
			do {
				view.tellShipAndLength(s);
				view.askShipOrientation();
				s.setOrientation(getOrientation(view));
				c=getCoordinates(view);
				try {
					getBoard().validateShip(c, s);
					validShipPosition = true;
				} catch (Exception e) {
					view.tellInvalidPosition();
				}
			} while (!validShipPosition);
			getBoard().placeShip(c, s);
			view.printBoard(board, getBoard());
		}
	}
	
}
