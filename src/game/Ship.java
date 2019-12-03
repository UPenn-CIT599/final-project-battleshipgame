package game;

/**
 * Has a type, an orientation, an x coordinate, a y coordinate, and a number of hits
 * @author zohair
 *
 */
public class Ship {
	private ShipType type=null;
	private ShipOrientation orientation=null;
	private int x=-1;
	private int y=-1;
	private int numHit=0;
    
    /**
     * Creates a ship of a certain type
     * @param type the ship's type
     */
    public Ship(ShipType type) {
    	this.type=type;
    }
	
    /**
     * 
     * @return the ship's length
     */
	public int getShipLength() {
		return type.getLength();
	}
	
	/**
	 * 
	 * @return the length minus the number of hits
	 */
	public int getNumNotHit() {
		return type.getLength()-numHit;
	}

	/**
	 * 
	 * @return the type of the ship
	 */
    public ShipType getType() {
        return type;
    }

    /**
     * 
     * @return the orientation of the ship
     */
    public ShipOrientation getOrientation() {
        return orientation;
    }

    /**
     * 
     * @return the starting x coordinate of the ship
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @return the starting y coordinate of the ship
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @return the number of hits the ship has had (duplicates do not count)
     */
    public int getNumHit() {
        return numHit;
    }

    /**
     * Sets the type of the ship
     * @param type any valid ShipType
     */
    public void setType(ShipType type) {
        this.type = type;
    }

    /**
     * Sets the orientation of the ship
     * @param orientation Horizontal or Vertical
     */
    public void setOrientation(ShipOrientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Sets the starting x coordinate of the ship
     * @param x the x value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the starting y coordinate of the ship
     * @param y the y value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the numHits of the ship
     * @param numHit the new number of hits
     */
    public void setNumHit(int numHit) {
        this.numHit = numHit;
    }
    
    /**
     * Increments the number of hits
     */
    public void incrementNumHit() {
    	numHit++;
    }
    
    /**
     * Gets number not hit (length minus number of hits)
     * @return number not hit
     */
    public int numNotHit() {
    	return type.getLength()-numHit;
    }
    
    /**
     * if number not hit is 0, return true
     * @return true if sunk
     */
    public boolean isSunk() {
    	return numNotHit()<1;
    }
    
    /**
     * if their are still un-hit ships squares
     * @return true if not sunk
     */
    public boolean isNotSunk() {
    	return numNotHit()>0;
    }
        
}
