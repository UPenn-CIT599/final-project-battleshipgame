package test;

import game.Board;
import game.Computer;
import game.Coordinates;
import game.GameView;
import game.Human;
import game.Player;
import game.PlayerType;
import game.Ship;
import game.ShipOrientation;
import game.ShipType;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * For tests for the Human
 * @author zohair
 */
public class TestHuman {
	
	/**
	 * Test that a Human has type Human
	 */
	@Test
	public void testIsHuman() {
		Player human=new Human();
		assertTrue(human.getType().equals(PlayerType.HUMAN));
	}
	
	/**
	 * Tests that Human can hit the Computer
	 */
	@Test
	public void testMakeHit() {
		Player human=new Human();
		Board b=new Board(PlayerType.COMPUTER);
		Ship s=new Ship(ShipType.CARRIER);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		Coordinates c=new Coordinates(5,2);
		b.placeShip(c, s);
		assertTrue(human.takeShot(new GameView(), b, c));
	}
	
	/**
	 * Tests that Human can miss the Computer
	 */
	@Test
	public void testMiss() {
		Player human=new Human();
		Board b=new Board(PlayerType.COMPUTER);
		Ship s=new Ship(ShipType.CARRIER);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		Coordinates c=new Coordinates(5,2);
		b.placeShip(c, s);
		Coordinates miss=new Coordinates(4,2);
		assertTrue(!human.takeShot(new GameView(), b, miss));
	}
	
}

