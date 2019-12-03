package test;

import game.BoardSquare;
import game.PlayerType;
import game.Ship;
import game.ShipType;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * For testing the BoardSquare class
 * @author zohair
 */

public class TestBoardSquare {

	/**
	 * Test that unhit human square with ship is SHIP
	 */
	@Test
	public void testUnhitHuman() {
		BoardSquare bs=new BoardSquare(PlayerType.HUMAN, new Ship(ShipType.BATTLESHIP), false);
		assertTrue(BoardSquare.SHIP==bs.getDisplayCharacter());
	}
	
	/**
	 * Test that unhit computer square with ship is WATER
	 */
	@Test
	public void testUnhitComputer() {
		BoardSquare bs=new BoardSquare(PlayerType.COMPUTER, new Ship(ShipType.BATTLESHIP), false);
		assertTrue(BoardSquare.WATER==bs.getDisplayCharacter());
	}
	
	/**
	 * Test that unhit water is WATER
	 */
	@Test
	public void testUnhitWater() {
		BoardSquare bs=new BoardSquare(PlayerType.COMPUTER, null, false);
		assertTrue(BoardSquare.WATER==bs.getDisplayCharacter());
	}
	
	/**
	 * Test that hit human is HIT
	 */
	@Test
	public void testHitHuman() {
		BoardSquare bs=new BoardSquare(PlayerType.HUMAN, new Ship(ShipType.BATTLESHIP), true);
		assertTrue(BoardSquare.HIT==bs.getDisplayCharacter());
	}
	
	/**
	 * Test that hit computer is HIT
	 */
	@Test
	public void testHitComputer() {
		BoardSquare bs=new BoardSquare(PlayerType.COMPUTER, new Ship(ShipType.BATTLESHIP), true);
		assertTrue(BoardSquare.HIT==bs.getDisplayCharacter());
	}
	
	/**
	 * Test that missed human is MISS
	 */
	@Test
	public void testMissHuman() {
		BoardSquare bs=new BoardSquare(PlayerType.HUMAN, null, true);
		assertTrue(BoardSquare.MISS==bs.getDisplayCharacter());
	}
	
	/**
	 * Test that missed computer is MISS
	 */
	@Test
	public void testMissComputer() {
		BoardSquare bs=new BoardSquare(PlayerType.COMPUTER, null, true);
		assertTrue(BoardSquare.MISS==bs.getDisplayCharacter());
	}
	
	
	
}
