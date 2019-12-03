package game;

/**
 * Contains the Human and Computer model classes that contain all model code for the game
 * @author zohair
 *
 */
public class GameModel {
	private Human human=new Human();
	private Computer computer=new Computer();
	
	/**
	 * gets the human player
	 * @return the human player
	 */
	public Human getHuman() {
		return human;
	}
	
	/**
	 * gets the computer player
	 * @return the computer player
	 */
	public Computer getComputer() {
		return computer;
	}
	
	/**
	 * Tells if orientation char is valid
	 * @param orientation the char for the orientation
	 * @return true is the orientation char is valid
	 */
	public static boolean isInvalidOrientation(String orientation) {
		return !orientation.equals("H")&&!orientation.equals("h")&&!orientation.equals("V")&&!orientation.equals("v");
	}
}
