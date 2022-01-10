package com.gbastianelli.xebia.project.file.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Motion;
import com.gbastianelli.xebia.project.mower.model.Mower;
import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * FileDescriptorTest: Test of {@link FileDesciptor}
 * <p>
 * Créé le 21 oct. 2015
 * 
 * @author guillaumebastianelli
 */
public class FileDescriptorTest {

	private static final Position FIELD_SIZE = new Position(23, 76);
	private static final Motion[] MOTION_A = { Motion.A, Motion.A, Motion.G };
	private static final Motion[] MOTION_B = { Motion.A, Motion.A, Motion.D };
	private static final Mower MOWER_A = new Mower(Direction.N, "Mower A", new Position(2, 9));
	private static final Mower MOWER_B = new Mower(Direction.E, "Mower B", new Position(3, 11));
	private FileDesciptor fileDesciptor;
	private MowingDescriptor mowingDescriptorA;

	private MowingDescriptor mowingDescriptorB;
	private ArrayList<MowingDescriptor> mowingDescriptors;

	@Before
	public void initFileDescriptor() {
		mowingDescriptorA = new MowingDescriptor(MOWER_A, Arrays.asList(MOTION_A));
		mowingDescriptorB = new MowingDescriptor(MOWER_B, Arrays.asList(MOTION_B));
		mowingDescriptors = new ArrayList<MowingDescriptor>();
		mowingDescriptors.add(mowingDescriptorA);
		mowingDescriptors.add(mowingDescriptorB);
		fileDesciptor = new FileDesciptor(FIELD_SIZE, mowingDescriptors);
	}

	@Test
	public void testGetField() {
		Assert.assertEquals(FIELD_SIZE, fileDesciptor.getField());
	}

	@Test
	public void testGetMowingDescriptors() {
		Assert.assertEquals(mowingDescriptors, fileDesciptor.getMowingDescriptors());
	}

}
