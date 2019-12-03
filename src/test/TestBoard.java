package test;

import game.Board;
import game.BoardSquare;
import game.Coordinates;
import game.GameView;
import game.Human;
import game.Player;
import game.PlayerType;
import game.Ship;
import game.ShipOrientation;
import game.ShipType;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * For testing the Board class
 * @author zohair
 */

public class TestBoard {
	
	/**
	 * For invalid x coordinate (too small)
	 */
	@Test
	public void invalidXCoordinate() {
		Board board=new Board(PlayerType.HUMAN);
		assertThrows(Exception.class, () -> {
	        board.validateCoordinate(new Coordinates(-1, 5) );
	    });
	}
	
	/**
	 * Another invalid  x coordinate (too big)
	 */
	@Test
	public void invalidXCoordinate2() {
		Board board=new Board(PlayerType.HUMAN);
		assertThrows(Exception.class, () -> {
	        board.validateCoordinate(new Coordinates(11, 5) );
	    });
	}
	
	/**
	 * For invalid y coordinate (too small)
	 */
	@Test
	public void invalidYCoordinate() {
		Board board=new Board(PlayerType.HUMAN);
		assertThrows(Exception.class, () -> {
	        board.validateCoordinate(new Coordinates(0, -1) );
	    });
	}
	
	/**
	 * For invalid x coordinate (too big)
	 */
	@Test
	public void invalidYCoordinate2() {
		Board board=new Board(PlayerType.HUMAN);
		assertThrows(Exception.class, () -> {
	        board.validateCoordinate(new Coordinates(0, 10) );
	    });
	}
	
	/**
	 * Tests board toString of human with one ship
	 */
	@Test
	public void humanToString() {
		Board b=new Board(PlayerType.HUMAN);
		Ship s=new Ship(ShipType.BATTLESHIP);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		b.placeShip(new Coordinates(2, 3), s);
		String expected=
				"Human Board\n"+
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W S S S S W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n";
		assertTrue(expected.equals(b.toString()) );
	}
	
	/**
	 * Tests board toString of computer board that has one hit square
	 */
	@Test
	public void computerHitToString() {
		Board b=new Board(PlayerType.COMPUTER);
		Ship s=new Ship(ShipType.BATTLESHIP);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		b.placeShip(new Coordinates(2, 3), s);
		Player p=new Human();
		p.takeShot(new GameView(), b, new Coordinates(3,3));
		String expected=
				"Computer Board\n"+
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W X W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n" + 
				"W W W W W W W W W W \n";
		System.out.println(expected);
		System.out.println(b.toString());
		assertTrue(expected.equals(b.toString()) );
	}
	
}
