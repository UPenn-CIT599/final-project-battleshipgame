package test;

import game.Ship;
import game.ShipOrientation;
import game.ShipType;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * For tests for class Ship
 * @author zohair
 */
public class TestShip {
	
	/**
	 * Tests the length of a Ship (Carrier)
	 */
	@Test
	public void testCarrierLength() {
		Ship s=new Ship(ShipType.CARRIER);
		assertEquals(5, s.getShipLength());
	}
	
	/**
	 * Tests the name of a Ship (Carrier)
	 */
	@Test
	public void testCarrierName() {
		Ship s=new Ship(ShipType.CARRIER);
		assertTrue("Carrier".equals(s.getType().getName()));
	}
	
	/**
	 * Tests that a Ship can be found to have no hits
	 */
	@Test
	public void testCarrierNotHit() {
		Ship s=new Ship(ShipType.CARRIER);
		assertEquals(5, s.getNumNotHit());
		assertEquals(0, s.getNumHit());
	}
	
	/**
	 * Tests that a Ship can be found to have a hit
	 */
	@Test
	public void testCarrierHit() {
		Ship s=new Ship(ShipType.CARRIER);
		s.incrementNumHit();
		assertEquals(4, s.getNumNotHit());
		assertEquals(1, s.getNumHit());
	}
	
	/**
	 * Tests that a Ship's orientation can be set
	 */
	@Test
	public void testOrientation() {
		Ship s=new Ship(ShipType.CARRIER);
		s.setOrientation(ShipOrientation.HORIZONTAL);
		assertTrue(ShipOrientation.HORIZONTAL==s.getOrientation());
	}
	
	/**
	 * Tests that a Ship's x coordinate can be set
	 */
	@Test
	public void testXCoordinate() {
		Ship s=new Ship(ShipType.CARRIER);
		s.setX(8);
		assertEquals(8, s.getX());
	}
	
	/**
	 * Tests that a Ship's y coordinate can be set
	 */
	@Test
	public void testYCoordinate() {
		Ship s=new Ship(ShipType.CARRIER);
		s.setY(2);
		assertEquals(2, s.getY());
	}
	
	/**
	 * Tests that a Ship's num hit can be set
	 */
	@Test
	public void testSetNumHit() {
		Ship s=new Ship(ShipType.CARRIER);
		s.setNumHit(5);
		assertEquals(5, s.getNumHit());
	}
	
	/**
	 * Tests that a Ship can be found to be sunk
	 */
	@Test
	public void testSunk() {
		Ship s=new Ship(ShipType.CARRIER);
		s.setNumHit(5);
		assertTrue(s.isSunk());
	}
	
	/**
	 * Tests that a Ship can be found to be not sunk
	 */
	@Test
	public void testIsNotSunk() {
		Ship s=new Ship(ShipType.CARRIER);
		s.setNumHit(4);
		assertTrue(s.isNotSunk());
	}
}
