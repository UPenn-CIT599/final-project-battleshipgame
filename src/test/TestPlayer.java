package test;

import game.Computer;
import game.Human;
import game.Player;
import game.PlayerType;
import game.Ship;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * For tests for the Player
 * @author zohair
 */

public class TestPlayer {
	
	/**
	 * Tests if a Player can be found to have lost
	 */
	@Test
	public void testCheckIfLost() {
		Player human=new Human();
		Ship [] ships=human.getShips();
		ships[0].setNumHit(5);
		ships[1].setNumHit(4);
		ships[2].setNumHit(3);
		ships[3].setNumHit(3);
		ships[4].setNumHit(2);
		assertTrue(human.checkIfLost());
	}
	
	/**
	 * Tests if a Player can be found to have not lost
	 */
	@Test
	public void testCheckIfNotLost() {
		Player human=new Human();
		Ship [] ships=human.getShips();
		ships[0].setNumHit(5);
		ships[1].setNumHit(4);
		ships[2].setNumHit(3);
		ships[3].setNumHit(3);
		assertTrue(!human.checkIfLost());
	}
	
}

