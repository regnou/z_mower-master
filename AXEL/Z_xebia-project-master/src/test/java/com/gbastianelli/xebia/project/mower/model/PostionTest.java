package com.gbastianelli.xebia.project.mower.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * PostionTest: Test of {@link Position}.
 * <p>
 * Créé le 18 oct. 2015
 *
 * @author guillaumebastianelli
 */
public class PostionTest {

	private static final int DEFAULT_X = 2;
	private static final int DEFAULT_Y = 3;
	private Position position;

	@Before
	public void initPosition() {
		position = new Position(DEFAULT_X, DEFAULT_Y);
	}

	@Test
	public void testGetX() {
		Assert.assertEquals(DEFAULT_X, position.getX());
	}

	@Test
	public void testGetY() {
		Assert.assertEquals(DEFAULT_Y, position.getY());
	}

}
