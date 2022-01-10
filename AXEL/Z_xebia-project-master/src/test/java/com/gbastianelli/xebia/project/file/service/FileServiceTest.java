/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gbastianelli.xebia.project.file.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.gbastianelli.xebia.project.file.model.FileDesciptor;
import com.gbastianelli.xebia.project.file.model.MowingDescriptor;
import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Motion;
import com.gbastianelli.xebia.project.mower.model.Mower;
import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * FileServiceTest: Test of {@link IFileService}.
 * <p>
 * Créé le 22 oct. 2015
 * 
 * @author guillaumebastianelli
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FileServiceTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class FileServiceTest {

	private static FileDesciptor expectedResult;
	private static final Direction MOWER_A_DIRECTION = Direction.N;
	private static final Motion[] MOWER_A_MOTION_SEQUENCE = { Motion.G, Motion.A, Motion.G, Motion.A, Motion.G, Motion.A, Motion.G, Motion.A,
			Motion.A };
	private static final String MOWER_A_NAME = "Mower 1";
	private static final Position MOWER_A_POSITION = new Position(1, 2);
	private static final Direction MOWER_B_DIRECTION = Direction.E;
	private static final Motion[] MOWER_B_MOTION_SEQUENCE = { Motion.A, Motion.A, Motion.D, Motion.A, Motion.A, Motion.D, Motion.A, Motion.D,
			Motion.D, Motion.A };
	private static final String MOWER_B_NAME = "Mower 2";
	private static final Position MOWER_B_POSITION = new Position(3, 3);
	@Value("${inputFile}")
	private String fileName;
	@Inject
	private IFileService fileService;

	@BeforeClass
	public static void initResults() {
		final Position field = new Position(5, 5);
		final List<MowingDescriptor> descriptors = new ArrayList<>();
		Mower mower = new Mower(MOWER_A_DIRECTION, MOWER_A_NAME, MOWER_A_POSITION);
		descriptors.add(new MowingDescriptor(mower, Arrays.asList(MOWER_A_MOTION_SEQUENCE)));
		mower = new Mower(MOWER_B_DIRECTION, MOWER_B_NAME, MOWER_B_POSITION);
		descriptors.add(new MowingDescriptor(mower, Arrays.asList(MOWER_B_MOTION_SEQUENCE)));
		expectedResult = new FileDesciptor(field, descriptors);
	}

	@Test
	public void testReadFile() throws Exception {
		final ClassPathResource resource = new ClassPathResource(fileName);
		final FileDesciptor descriptor = fileService.readFile(resource.getFile());
		Assert.assertEquals(expectedResult, descriptor);
	}

}
