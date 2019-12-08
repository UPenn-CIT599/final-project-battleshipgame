package game;

/**
 * Has a PlayerType, a Board, and an array of Ships: Carrier, Battleship, Cruiser, Submarine, or Destroyer
 * @author zohair
 *
 */
public abstract class Player {
    
    private PlayerType type=null;
    private Board board=null;
    private Ship [] ships= {new Ship(ShipType.CARRIER), 
    		new Ship(ShipType.BATTLESHIP),
    		new Ship(ShipType.CRUISER),
    		new Ship(ShipType.SUBMARINE),
    		new Ship(ShipType.DESTROYER)};
        
    /**
     * Takes a PlayerType and creates a board with that type
     * @param playerType the type of the player for the board
     */
    Player(PlayerType playerType){
    	type=playerType;
    	board=new Board(playerType);
    }

    /**
     * Gets the player type
     * @return Human or Computer
     */
    public PlayerType getType() {
        return type;
    }

    /**
     * sets the player type
     * @param type  Human or Computer
     */
    public void setType(PlayerType type) {
        this.type = type;
    }
    
    /**
     * Sets the array of ships
     * @param ships The new array of ships
     */
    public void setShips(Ship [] ships) {
        this.ships = ships;
    }
    
    /**
     * Gets the Player's ships
     * @return The Player's array of ships
     */
    public Ship[] getShips() {
        return ships;
    }
    
    /**
     * Sets the Player's Board
     * @param board The new board
     */
    public void setBoard(Board board) {
        this.board = board;
    }
    
    /**
     * 
     * @return The Player's board
     */
    public Board getBoard() {
        return board;
    }
    
    /**
     * Checks if all ships were sunk
     * @return true if all ships have been sunk
     */
    public boolean checkIfLost() {
    	for(Ship s : ships) {
    		if (s.isNotSunk()) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Abstract method for getting coordinates
     * @param view A view for reporting what coordiantes were gotten
     * @return the coordinates
     */
    public abstract Coordinates getCoordinates(GameView view);
    
    /**
     * Takes a shot at the opponent's board.  The view tell what happened
     * @param view the view
     * @param opponentBoard the opponent's Board
     * @param c the coordinates
     * @return true if it was a hit and false if it wasn't
     */
    
    public boolean hasShotAlready(GameView view, Board opponentBoard, Coordinates c) {
    	BoardSquare boardSquare = (opponentBoard.getBoardSquare(c.getY(), c.getX()));
    	//System.out.println("this one "+boardSquare.getDisplayCharacter()+"\n");
    	if ((boardSquare.getDisplayCharacter() == 'X') || (boardSquare.getDisplayCharacter() == 'O')) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean takeShot(GameView view, Board opponentBoard, Coordinates c){
    	if(opponentBoard.takeHit(c)) {
			view.tellHit(type);
			return true;
		} else {
			view.tellMiss(type);
			return false;
		}
	}

}
