package game;


/**
 * ShipType enum has name and length associated.  Can be Carrier, Battleship, Cruiser, Submarine, or Destroyer
 * @author zohair
 *
 */
public enum ShipType {
	CARRIER("Carrier", 5), BATTLESHIP("Battleship", 4), 
	CRUISER("Cruiser", 3), SUBMARINE("Submarine", 3),
	DESTROYER("Destroyer", 2);
	
	private final int length;
	private final String name;
	
	/**
	 * Creates a ship with name and length
	 * @param name the name
	 * @param length the length of squares
	 */
	ShipType(String name, int length) {
		this.name=name;
		this.length=length;
	}
	
	/**
	 * gets the length
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * gets the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
