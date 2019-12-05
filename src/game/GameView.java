package game;

/**
 * Responsible for all printing to the console.  The view.
 * @author zohair
 *
 */
public class GameView {
	
	/**
	 * Asks for HumanPlayer's Name
	 */
	public void askForHumanPlayerName() {
		System.out.println("Please enter your name:");
	}
	
	/**
	 * Asks for a shot
	 */
	public void askForShot() {
		System.out.println("Please enter coordinates for where you want to shoot");
	}
	
	/**
	 * Displays a board
	 * @param boardString The String representation of the board
	 */
	public void displayBoard(String boardString) {
		System.out.println(boardString);
	}
	
	/**
	 * Prompts for a ship orientation
	 */
	public void askShipOrientation() {
		System.out.println("Please enter an orientation for your ship, "
				+ "v for vertical or h for horizontal:");
	}
	
	/**
	 * Prompts for an x or y coordinate
	 * @param axis x or y
	 */
	public void askShipCoordinate(char axis) {
		System.out.println("Please enter a "+String.valueOf(axis)+" coordinate.");
	}
	
	/**
	 * Tells a ship can't be placed there
	 */
	public void tellInvalidPosition() {
		System.out.println("That position would go out of bounds or over another ship");
	}
	
	/**
	 * Tells a ship can't have that orientation
	 */
	public void tellInvalidOrientation() {
		System.out.println("That orientation is not horizontal or vertical.");
	}
	
	/**
	 * Tells that the coordinates are invalid
	 */
	public void tellInvalidCoordinate() {
		System.out.println("That coordinate does not lie on the board.  "
				+ "Please re-enter the coordinate.");
	}
	
	/**
	 * Tells computer has begun placing its ships
	 */
	public void tellComputerIsSettingUp() {
		System.out.println("Computer is setting up...");
	}
	
	/**
	 * Tells computer has finished placing its ships
	 */
	public void tellComputerFinishedSettingUp() {
		System.out.println("Computer has finsihed setting up.");
	}
	
	/**
	 * Tells a player missed
	 * @param playerType Human or Computer who shot
	 */
	public void tellMiss(PlayerType playerType) {
		System.out.println(playerType==PlayerType.HUMAN ? 
				"You missed":"The computer player missed");
	}
	
	/**
	 * Tells a player hit
	 * @param playerType Human or computer who shot
	 */
	public void tellHit(PlayerType playerType) {
		System.out.println(playerType==PlayerType.HUMAN ? 
				"You hit":"The computer player hit");
	}
	
	/**
	 * Tells to place ship and tells its length
	 * @param s the sip to place
	 */
	public void tellShipAndLength(Ship s) {
		System.out.println("Please place your "+s.getType().getName()
				+". It has a lenth of "+s.getType().getLength()+".");
	}
	
	/**
	 * print both boards
	 * @param b1 first board
	 * @param b2 second board
	 */
	public void printBoard(Board b1, Board b2) {
		System.out.println(b1);
		System.out.println();
		System.out.println();
		System.out.println(b2);
		
	}
	
	/**
	 * Tells which player lost
	 * @param playerType for determining if human or computer lost
	 */
	public void tellPlayerLost(PlayerType playerType) {
		System.out.println(playerType==PlayerType.HUMAN ? 
				"You lost":"The computer player lost");
	}
}
