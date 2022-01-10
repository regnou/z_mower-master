package com.gbastianelli.xebia.project.mower.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * MowerTest: Test of {@link Mower}
 * <p>
 * Créé le 18 oct. 2015
 * 
 * @author guillaumebastianelli
 */
public class MowerTest {

	private static final Direction DEFAULT_DIRECTION = Direction.N;
	private static final String DEFAULT_NAME = "default name";
	private static final Position DEFAULT_POSITION = new Position(2, 2);
	private static final Direction NEW_DIRECTION = Direction.S;
	private static final String NEW_NAME = "new name";
	private static final Position NEW_POSITION = new Position(6, 4);
	private Mower mower;

	@Before
	public void initMower() {
		mower = new Mower(DEFAULT_DIRECTION, DEFAULT_NAME, DEFAULT_POSITION);
	}

	// @Test
	// public void moveEast() {
	// mower.setDirection(Direction.E);
	// mower.move(Motion.A);
	// Assert.assertEquals(DEFAULT_POSITION.getX()+1, mower.getPosition().getX());
	// }
	//
	// @Test
	// public void moveNorth() {
	// mower.move(Motion.A);
	// Assert.assertEquals(DEFAULT_POSITION.getY()+1, mower.getPosition().getY());
	// }
	//
	// @Test
	// public void moveSouth() {
	// mower.setDirection(Direction.S);
	// mower.move(Motion.A);
	// Assert.assertEquals(DEFAULT_POSITION.getY()-1, mower.getPosition().getY());
	// }
	//
	// @Test
	// public void moveWest() {
	// mower.setDirection(Direction.W);
	// mower.move(Motion.A);
	// Assert.assertEquals(DEFAULT_POSITION.getX()-1, mower.getPosition().getX());
	// }

	@Test
	public void testGetDirection() {
		Assert.assertEquals(DEFAULT_DIRECTION, mower.getDirection());
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(DEFAULT_NAME, mower.getName());
	}

	@Test
	public void testGetPosition() {
		Assert.assertEquals(DEFAULT_POSITION, mower.getPosition());
	}

	@Test
	public void testSetDirection() {
		mower.setDirection(NEW_DIRECTION);
		Assert.assertEquals(NEW_DIRECTION, mower.getDirection());
	}

	@Test
	public void testSetName() {
		mower.setName(NEW_NAME);
		Assert.assertEquals(NEW_NAME, mower.getName());
	}

	@Test
	public void testSetPosition() {
		mower.setPosition(NEW_POSITION);
		Assert.assertEquals(NEW_POSITION, mower.getPosition());
	}

	// @Test
	// public void testTurnLeft() {
	// mower.move(Motion.G);
	// Assert.assertEquals(Direction.W, mower.getDirection());
	// mower.move(Motion.G);
	// Assert.assertEquals(Direction.S, mower.getDirection());
	// mower.move(Motion.G);
	// Assert.assertEquals(Direction.E, mower.getDirection());
	// mower.move(Motion.G);
	// Assert.assertEquals(Direction.N, mower.getDirection());
	// }
	//
	// @Test
	// public void testTurnRight() {
	// mower.move(Motion.D);
	// Assert.assertEquals(Direction.E, mower.getDirection());
	// mower.move(Motion.D);
	// Assert.assertEquals(Direction.S, mower.getDirection());
	// mower.move(Motion.D);
	// Assert.assertEquals(Direction.W, mower.getDirection());
	// mower.move(Motion.D);
	// Assert.assertEquals(Direction.N, mower.getDirection());
	// }

}
