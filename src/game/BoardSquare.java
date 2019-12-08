package game;


/**
 * Has a PlayerType, a ship which can be null, and a boolean for whether or not it has been shot
 * @author zohair
 *
 */
public class BoardSquare    {
	private PlayerType playerType=null;
	private Ship ship=null;
	private boolean shotOrNot=false;
	public static final char WATER='W';
	public static final char SHIP='S';
	public static final char HIT='X';
	public static final char MISS='O';

	/**
	 * Default constructor
	 */
    public BoardSquare() {
        
    }
    
    /**
     * Creates a board square
     * @param playerType Human or Computer
     * @param ship The ship or null if none is there
     * @param shotOrNot If the BoardSuqare has already been hit
     */
    public BoardSquare(PlayerType playerType, Ship ship, boolean shotOrNot) {
        this.ship=ship;
        this.playerType=playerType;
        this.ship=ship;
        this.shotOrNot=shotOrNot;
    }
        
        
	/**
	 * 
	 * @return If Human, returns S if not hit and is  a ship.  Otherwise returns W for water if not hit, O if a miss, and X if a hit
	 */
	public char getDisplayCharacter() {
		if (playerType==PlayerType.HUMAN&&ship!=null&&shotOrNot==false) {
			return SHIP;
		} else if (playerType==PlayerType.COMPUTER&&ship!=null&&shotOrNot==false){
			return WATER;
		} else {
			if (shotOrNot==false) {
				return WATER;
			} else {
				if (ship==null) {
					return MISS;
				} else {
					return HIT;
				}
			}
		}
	}

	/**
	 * 
	 * @return Human or Computer
	 */
    public PlayerType getPlayer() {
        return playerType;
    }

    /**
     * 
     * @param playerType Human or Computer
     */
    public void setPlayer(PlayerType playerType) {
        this.playerType = playerType;
    }

    /**
     * 
     * @return the Ship or null if none is there
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * 
     * @param ship The Ship object to set it as (or null)
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * 
     * @return true if never has been shot at
     */
    public boolean isShotOrNot() {
        return shotOrNot;
    }

    /**
     * 
     * @param shotOrNot Set true if it is shot and set false if it is has not been shot
     */
    public void setShotOrNot(boolean shotOrNot) {
        this.shotOrNot = shotOrNot;
    }
        
        
}
