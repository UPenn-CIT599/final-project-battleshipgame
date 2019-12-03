package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.GameModel;
/**
 * For tests for the GameModel
 * @author zohair
 *
 */
public class TestGameModel {
	
	/**
	 * Test that isInvalidOrientation detects invalid orientation
	 */
	@Test
	public void testIsInvalidOrientation() {
		assertTrue(GameModel.isInvalidOrientation("F"));
	}
	
	/**
	 * Test that isInvalidOrientation passes horizontal orientation
	 */
	@Test
	public void testIsValidHorizontal() {
		assertTrue(!GameModel.isInvalidOrientation("H"));
	}
	
	/**
	 * Test that isInvalidOrientation passes vertical orientation
	 */
	@Test
	public void testIsValidVerticall() {
		assertTrue(!GameModel.isInvalidOrientation("V"));
	}
}
