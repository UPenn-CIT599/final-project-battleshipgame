package game;

import java.util.Scanner;

/**
 * Has a PlayerType, Width, Height, and array of board squares
 * @author zohair
 *
 */
public class Board {
	private PlayerType player=null;
	private final int WIDTH=10;
	private final int HEIGHT=10;
	private BoardSquare[][] squares=null;
	private String humanPlayerName;
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Creates a board of board square with a type of player
	 * @param player the type of player
	 */
	public Board(PlayerType player) {
		squares=new BoardSquare[WIDTH][HEIGHT];
		this.player=player;
		for (int r=0; r<HEIGHT; r++) {
    		for (int c=0; c<WIDTH; c++) {
    			squares[r][c]=new BoardSquare(player, null, false);
        	}
    	}
	}
	
	/**
	 * Get the player's name for personalized board
	 * @param view
	 */
	public void askForPlayerName(GameView view) {
		view.askForHumanPlayerName();
		humanPlayerName = scanner.nextLine();
	}

	/**
	 * 
	 * @return The boards width
	 */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * 
     * @return The boards height
     */
    public int getHEIGHT() {
        return HEIGHT;
    }
        
    /**
     * 
     * @return Human or Computer PlayerType
     */
    public PlayerType getPlayer() {
        return player;
    }

    /**
     * Set to Human or Computer
     * @param player the PlayerType
     */
    public void setPlayer(PlayerType player) {
        this.player = player;
    }
	
    /**
     * Get a BoardSquare by indices
     * @param indexX x coordinate
     * @param indexY y coordinate
     * @return the board square at x, y
     */
    public BoardSquare getBoardSquare(int indexX, int indexY){
        return squares[indexX][indexY];
    }
    
    /**
     * Set a board square by indices
     * @param indexX x coordinate
     * @param indexY y coordinate
     * @param square the board square to replace the old one with
     */
    public void setBoardSquare(int indexX, int indexY, BoardSquare square){
        squares[indexX][indexY]=square;
    }
    
    /**
     * Sets a Ship object starting at x, y
     * @param ship The Ship to position
     * @param orientation Horizontal or vertical
     * @param c the coordinates for the top-left corner
     * @throws Exception if the coordinates were invalid
     */
    public void setShipPosition(Ship ship,
    		Coordinates c) throws Exception{
    	validateCoordinate(c);
    	validateShip(c, ship);
    	placeShip(c, ship);
    }
    
    /**
     * Makes sure coordinates are on board
     * @param c the x and y Coordinates object
     * @throws Exception thrown if coordinates are invalid
     */
    public void validateCoordinate(Coordinates c) throws Exception{
    	if (c.getX()<0||c.getY()<0||c.getX()>WIDTH-1||c.getY()>HEIGHT-1) {
    		throw new Exception("Invalid coordinate");
    	}
    }
    
    /**
     * Throws an exception if an x coordinate would be out of bounds
     * @param x the horizontal coordinate
     * @throws Exception thrown if coordinate is out of bounds
     */
    public void validateXCoordinate(int x) throws Exception{
    	if (x<0||x>WIDTH) {
    		throw new Exception("Invalid coordinate");
    	}
    }
    
    /**
     * Throws an exception if a y coordinate would be out of bounds
     * @param y the vertical coordinate
     * @throws Exception thrown if coordinate is out of bounds
     * */
    public void validateYCoordinate(int y) throws Exception{
    	if (y<0||y>HEIGHT) {
    		throw new Exception("Invalid coordinate");
    	}
    }
        
    
    /**
     * Throws an exception if a ship would be out of bounds or over another ship
     * @param c the coordinates of the top left corner of the ship
     * @param s the ship that would be placed
     * @throws Exception thrown if the ship's position would be invalid
     */
    public void validateShip(Coordinates c, Ship s) throws Exception{
    	if(s.getOrientation()==ShipOrientation.HORIZONTAL) {
    		if (c.getX()+s.getShipLength()-1>WIDTH-1) {
    			throw new Exception("Ship would be out of bounds");
    		}
    		for(int i=c.getX(); i<c.getX()+s.getShipLength()-1; i++) {
    			if (squares[c.getY()][i].getShip()!=null) {
    				throw new Exception("Would intersect existing ship");
    			}
			}
    	}
    	else if (s.getOrientation()==ShipOrientation.VERTICAL) {
    		if (c.getY()+s.getShipLength()-1>HEIGHT-1) {
    			throw new Exception("Ship would be out of bounds");
    		}
    		for(int i=c.getY(); i<c.getY()+s.getShipLength()-1; i++) {
    			if (squares[i][c.getX()].getShip()!=null) {
    				throw new Exception("Would intersect existing ship");
    			}
			}
    	}
    }
    
    /**
     * Places a ship
     * @param c the coordinates of the top left corner of the ship
     * @param s the ship that is to be placed
     */
    public void placeShip(Coordinates c, Ship s) {
    	if(s.getOrientation()==ShipOrientation.HORIZONTAL) {
    		for(int i=c.getX (); i<c.getX()+s.getShipLength(); i++) {
    			squares[c.getY()][i].setShip(s);
    		}
    	}
    	else if (s.getOrientation()==ShipOrientation.VERTICAL) {
    		for(int i=c.getY(); i<c.getY()+s.getShipLength(); i++) {
    			squares[i][c.getX()].setShip(s);
    		}
    	} else {
    		System.out.println("No ship orientation was given.");
    	}
    }
    
    /**
     * Board model receives a hit
     * @param c x, y coordinates
     * @return the ship hit or null if it was a miss
     * @throws Exception thrown if the coordinates were invalid
     */
    public boolean takeHit(Coordinates c){
    	BoardSquare square=squares[c.getY()][c.getX()];
    	Ship s=square.getShip();
    	
    	if(s==null) {
    		square.setShotOrNot(true);
    		return false;
    	} else {
    		if (!square.isShotOrNot()) {
    			s.incrementNumHit();
    			square.setShotOrNot(true);
    		} 
    		return true;
    	}
    }
    
    /**
     * Returns a String which tell which P_layer's board it is and print out rows of the character generated by BoardSquare's getDisplayCharacter
     */
    @Override()
    public String toString() {
    	String boardString="";
    	if (player==PlayerType.COMPUTER) {
    		boardString+="Computer Board\n";
    	} else if (player==PlayerType.HUMAN) {
    		boardString+="Human Board\n";
    	}
    	boardString += "  ";
    	for (int c=0; c<WIDTH; c++) {
    		boardString += c + " ";
    	}
    	boardString += "\n";
    	for (int r=0; r<HEIGHT; r++) {
    		boardString += r + " ";
    		for (int c=0; c<WIDTH; c++) {
    			boardString+=squares[r][c].getDisplayCharacter()+" ";
        	}
    		boardString+="\n";
    	}
    	return boardString;
    
    }
    
}


