package game;

/**
 * Runs the game.
 * @author zohair
 *
 */
public class GameController {
	
	private GameModel model = new GameModel();
	private GameView view = new GameView();
	
	private boolean keepPlaying=true;

	/**
	 * Show the board, setup, and take turns until someone loses
	 */
	public GameController() {
		model.getHuman().getBoard().askForPlayerName(view);
		view.printBoard(model.getComputer().getBoard(), model.getHuman().getBoard());
		setUp(view);
		takeTurns();
	}

	/**
	 * Plays until someone loses
	 */
	public void takeTurns() {
		do {
			if(keepPlaying) {
				takeTurn(model.getHuman(), model.getComputer(), view);
			}
			if(keepPlaying) {
				takeTurn(model.getComputer(), model.getHuman(), view);
			}
			
		}while(keepPlaying);
		
	}
	
	/**
	 * A player will try to hit the opponent and the view will tell the results
	 * @param p the player whose turn it is
	 * @param opponent the opponent
	 * @param v the view that tells the result
	 */
	public void takeTurn(Player p, Player opponent, GameView v){
		boolean notShotAlready = false;
		Coordinates tmpCoordinate = null;
		do {
			tmpCoordinate = p.getCoordinates(v);
			if (p.hasShotAlready(v, opponent.getBoard(), tmpCoordinate) == false) {
				notShotAlready = true;
			}
			else {
				if (p.getType() == PlayerType.HUMAN) {
					v.tellIsHitAlready();
				}
			}
		} while (!notShotAlready);
		if(p.takeShot(v, opponent.getBoard(), tmpCoordinate)) {
			if (opponent.checkIfLost()) {
				v.printBoard(model.getComputer().getBoard(), model.getHuman().getBoard());
				v.tellPlayerLost(opponent.getType());
				keepPlaying=false;
			}
		}if(keepPlaying) {
		v.printBoard(model.getComputer().getBoard(), model.getHuman().getBoard());
		}
	}
	
	/**
	 * Human sets up and then computer
	 * @param view the view that shows the process
	 */
	public void setUp(GameView view) {
		model.getHuman().setUp(view, model.getComputer().getBoard());
		model.getComputer().setUp(view);
		view.printBoard(model.getComputer().getBoard(), model.getHuman().getBoard());
	}

}
