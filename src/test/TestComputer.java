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
 * For testing the Computer class
 * @author zohair
 */
public class TestComputer {
	
	/**
	 * Test that a Computer has type Computer
	 */
	@Test
	public void testIsComputer() {
		Player computer=new Computer();
		assertTrue(computer.getType().equals(PlayerType.COMPUTER));
	}
	
	/**
	 * Tests that random coordinates fall within Human Board
	 */
	@Test
	public void testGetRandomCoordinates(){
		Board b=new Board(PlayerType.HUMAN);
		Computer c=new Computer();
		Coordinates coordinates=c.getCoordinates(new GameView());
		assertTrue(coordinates.getX()>-1&&coordinates.getX()<b.getWIDTH());
		assertTrue(coordinates.getY()>-1&&coordinates.getY()<b.getHEIGHT());
	}
	
	/**
	 * Tests that Computer can hit the Human
	 */
	@Test
	public void testIsHit() {
		Player computer=new Computer();
		Board b=new Board(PlayerType.HUMAN);
		Ship s=new Ship(ShipType.CARRIER);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		Coordinates c=new Coordinates(5,2);
		b.placeShip(c, s);
		assertTrue(computer.takeShot(new GameView(), b, c));
	}
	
	/**
	 * Tests that Computer can miss the Human
	 */
	@Test
	public void testIsMissed() {
		Player computer=new Computer();
		Board b=new Board(PlayerType.HUMAN);
		Ship s=new Ship(ShipType.CARRIER);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		Coordinates c=new Coordinates(5,2);
		b.placeShip(c, s);
		Coordinates miss=new Coordinates(4,2);
		assertTrue(!computer.takeShot(new GameView(), b, miss));
	}
	
}

