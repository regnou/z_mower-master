package com.gbastianelli.xebia.project.mower.business;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Motion;
import com.gbastianelli.xebia.project.mower.model.Mower;
import com.gbastianelli.xebia.project.mower.model.Position;

public class MowerProcessorTest implements IMowerProcessorListener {

	private static final Position FIELD_LIMIT = new Position(5, 5);
	private static final Logger LOGGER = LoggerFactory.getLogger(MowerProcessorTest.class);
	private static final Direction MOWER_A_DIRECTION = Direction.N;
	private static final Motion[] MOWER_A_MOTION_SEQUENCE = { Motion.G, Motion.A, Motion.G, Motion.A, Motion.G, Motion.A, Motion.G, Motion.A,
			Motion.A };
	private static final String MOWER_A_NAME = "Mower A";
	private static final Position MOWER_A_POSITION = new Position(1, 2);
	private static final Direction MOWER_B_DIRECTION = Direction.E;
	private static final Motion[] MOWER_B_MOTION_SEQUENCE = { Motion.A, Motion.A, Motion.D, Motion.A, Motion.A, Motion.D, Motion.A, Motion.D,
			Motion.D, Motion.A };
	private static final String MOWER_B_NAME = "Mower B";
	private static final Position MOWER_B_POSITION = new Position(3, 3);
	private boolean isRunning = true;
	private Mower mowerA;
	private MowerProcessor processorA;
	private MowerProcessor processorB;

	@After
	public void disposeMowerProcessor() {
		processorA.removeMowerProcessorListener(this);
		processorB.removeMowerProcessorListener(this);
	}

	@Before
	public void initMowerProcessor() {
		isRunning = true;
		mowerA = new Mower(MOWER_A_DIRECTION, MOWER_A_NAME, MOWER_A_POSITION);
		processorA = new MowerProcessor(FIELD_LIMIT, Arrays.asList(MOWER_A_MOTION_SEQUENCE), mowerA);
		processorA.addMowerProcessorListener(this);

		final Mower mower = new Mower(MOWER_B_DIRECTION, MOWER_B_NAME, MOWER_B_POSITION);
		processorB = new MowerProcessor(FIELD_LIMIT, Arrays.asList(MOWER_B_MOTION_SEQUENCE), mower);
		processorB.addMowerProcessorListener(this);
	}

	@Override
	public void mowingFinished(String mowerName, Position finalPosition, Direction finalDirection) {
		LOGGER.info("The mower {} has finished its job! It's final direction and direction are {} {} {}.", mowerName, finalPosition.getX(),
				finalPosition.getY(), finalDirection);
		isRunning = false;
	}

	@Test
	public void testAddMowerProcessorListener() {
		Assert.assertTrue(processorA.getMowerProcessorListeners().contains(this));
	}

	@Test
	public void testGetFieldLimit() {
		Assert.assertEquals(FIELD_LIMIT, processorA.getFieldLimit());
	}

	@Test
	public void testGetMotions() {
		Assert.assertArrayEquals(MOWER_A_MOTION_SEQUENCE, processorA.getMotions().toArray());
	}

	@Test
	public void testGetMower() {
		Assert.assertEquals(mowerA, processorA.getMower());
	}

	@Test
	public void testGetMowerProcessorListeners() {
		Assert.assertEquals(1, processorA.getMowerProcessorListeners().size());
	}

	@Test
	public void testRemoveMowerProcessorListener() {
		processorA.removeMowerProcessorListener(this);
		Assert.assertFalse(processorA.getMowerProcessorListeners().contains(this));
	}

	@Test
	public void testRunA() {
		processorA.run();
		while (isRunning) {

		}
		Assert.assertEquals(new Position(1, 3), processorA.getMower().getPosition());
		Assert.assertEquals(Direction.N, processorA.getMower().getDirection());
	}

	@Test
	public void testRunB() {
		processorB.run();
		while (isRunning) {

		}
		Assert.assertEquals(new Position(5, 1), processorB.getMower().getPosition());
		Assert.assertEquals(Direction.E, processorB.getMower().getDirection());
	}

}
