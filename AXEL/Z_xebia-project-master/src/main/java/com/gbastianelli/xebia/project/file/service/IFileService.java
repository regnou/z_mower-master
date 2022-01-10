package com.gbastianelli.xebia.project.file.service;

import java.io.File;

import com.gbastianelli.xebia.project.file.FileReadingException;
import com.gbastianelli.xebia.project.file.model.FileDesciptor;
import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * IFileService: Interface which define the behaviour of the service dedicated to read 'mowing descritpion' files.
 * <p>
 * Créé le 21 oct. 2015
 *
 * @author guillaumebastianelli
 */
public interface IFileService {

	/**
	 * Read and parse the 'mowing description' file
	 *
	 * @param file the 'mowing description' file
	 * @return the corresponding descriptor
	 * @throws FileReadingException error during the reading
	 */
	FileDesciptor readFile(File file) throws FileReadingException;

	/**
	 * Write the current date in the output file.
	 *
	 * @param outputFile the output file
	 */
	void writeDate(File outputFile);

	/**
	 * Write the position and the direction of a mower in a file.
	 *
	 * @param positon position of the mower
	 * @param direction direction of the mower
	 * @param outputFile the output file
	 */
	void writePositionInFile(Position position, Direction direction, File outputFile);

}
