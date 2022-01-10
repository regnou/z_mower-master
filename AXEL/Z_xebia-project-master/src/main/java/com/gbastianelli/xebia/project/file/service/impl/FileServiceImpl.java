package com.gbastianelli.xebia.project.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gbastianelli.xebia.project.file.FileReadingException;
import com.gbastianelli.xebia.project.file.model.FileDesciptor;
import com.gbastianelli.xebia.project.file.model.MowingDescriptor;
import com.gbastianelli.xebia.project.file.service.IFileService;
import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Motion;
import com.gbastianelli.xebia.project.mower.model.Mower;
import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * FileServiceImpl: Default implementation of {@link IFileService}.
 * <p>
 * Créé le 21 oct. 2015
 * 
 * @author guillaumebastianelli
 */
@Service
public class FileServiceImpl implements IFileService {

	/** Pattern of the line which describe the field to mow */
	private static final Pattern FIELD_LINE_PATTERN = Pattern.compile("^(\\d+)( )(\\d+)$");
	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
	/** Pattern of the line which describe the motions of the mower */
	private static final Pattern MOTIONS_LINE_PATTERN = Pattern.compile("^(A|G|D)*$");
	/** Pattern of the line which describe the mower */
	private static final Pattern MOWER_LINE_PATTERN = Pattern.compile("^(\\d+)( )(\\d+)( )(N|E|S|W)$");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileDesciptor readFile(File file) throws FileReadingException {
		LOGGER.info("Try to read the file : {}", file.getAbsoluteFile());
		try {
			// Line which discribe the field
			final List<String> lines = FileUtils.readLines(file);
			final Position field = parseFieldLine(lines.get(0));
			lines.remove(0);
			// Iterate aver mower
			final Iterator<String> lineIterator = lines.iterator();
			final List<MowingDescriptor> mowingDescriptors = new ArrayList<>();
			while (lineIterator.hasNext()) {
				String line = lineIterator.next();
				final int mowerNumber = mowingDescriptors.size() + 1;
				// Mower
				final Mower mower = parseMowerLine(mowerNumber, line);
				// Motions
				if (lineIterator.hasNext()) {
					line = lineIterator.next();
					final List<Motion> motions = parseMotions(mowerNumber, line);
					mowingDescriptors.add(new MowingDescriptor(mower, motions));
				} else {
					throw new FileReadingException(String.format("The line which describe the motions of the mower %s is not present.", mowerNumber));
				}
			}

			final FileDesciptor result = new FileDesciptor(field, mowingDescriptors);
			LOGGER.info("The reading of the file is successful. There is {} mower(s) to process in a field of {}x{} square(s).",
					result.getMowingDescriptors().size(), result.getField().getX(), result.getField().getY());
			return result;
		} catch (final IOException exception) {
			final String errorMessage = String.format("Cannot read the file : %s.", file.getAbsolutePath());
			LOGGER.error(errorMessage, exception);
			throw new FileReadingException(errorMessage, exception);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeDate(File outputFile) {
		LOGGER.info("Write the current date in the file {}.", outputFile.getAbsolutePath());
		final StringBuilder builder = new StringBuilder().append("Mowing at ")
				.append(DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())).append(System.getProperty("line.separator"));
		try {
			FileUtils.writeStringToFile(outputFile, builder.toString(), true);
		} catch (final IOException exception) {
			LOGGER.error(String.format("Cannot write the current date to the file %s.", builder.toString(), outputFile.getAbsolutePath()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writePositionInFile(Position position, Direction direction, File outputFile) {
		LOGGER.info("Write the positon {} and the direction {} in the file {}.", position, direction, outputFile.getAbsolutePath());
		final StringBuilder builder = new StringBuilder().append(position.getX()).append(" ").append(position.getY()).append(" ").append(direction)
				.append(System.getProperty("line.separator"));
		try {
			FileUtils.writeStringToFile(outputFile, builder.toString(), true);
		} catch (final IOException exception) {
			LOGGER.error(String.format("Cannot write the line %s to the file %s.", builder.toString(), outputFile.getAbsolutePath()));
		}
	}

	/**
	 * Parse the line of the file which describe the field to mow.
	 * 
	 * @param fieldLine line to parse
	 * @return the size of the field (upper right corner)
	 * @throws FileReadingException the line is not correct (wrong format)
	 */
	private Position parseFieldLine(String fieldLine) throws FileReadingException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Try the read the line which describe the field to mow : {}.", fieldLine);
		}
		final Matcher fieldMatcher = FIELD_LINE_PATTERN.matcher(fieldLine);
		if (fieldMatcher.matches()) {
			return new Position(Integer.parseInt(fieldMatcher.group(1)), Integer.parseInt(fieldMatcher.group(3)));
		} else {
			throw new FileReadingException("The first line of the file is incorrect.");
		}
	}

	/**
	 * Parse the lines of the file which describe motions of a mower.
	 * 
	 * @param mowerNumber number of the mower
	 * @param line the line to parse
	 * @return list of motions
	 * @throws FileReadingException the line is not correct (wrong format)
	 */
	private List<Motion> parseMotions(int mowerNumber, String line) throws FileReadingException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Try the read the line '{}' which describe a the motions of the mower {}.", line, mowerNumber);
		}
		final Matcher motionsMatcher = MOTIONS_LINE_PATTERN.matcher(line);
		if (motionsMatcher.matches()) {
			final List<Motion> motions = new ArrayList<>();
			for (int i = 0; i < line.length(); i++) {
				motions.add(Motion.valueOf(String.valueOf(line.charAt(i))));
			}
			return motions;
		} else {
			throw new FileReadingException(
					String.format("The line '%s' which describe the motions of the mower %s is incorrect.", line, mowerNumber));
		}
	}

	/**
	 * Parse the lines of the file which describe mowers.
	 * 
	 * @param mowerNumber number of the mower
	 * @param line the line to parse
	 * @return a mower
	 * @throws FileReadingException the line is not correct (wrong format)
	 */
	private Mower parseMowerLine(int mowerNumber, String line) throws FileReadingException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Try the read the line '{}' which describe a mower {}.", line, mowerNumber);
		}
		final Matcher mowerLineMatcher = MOWER_LINE_PATTERN.matcher(line);
		if (mowerLineMatcher.matches()) {
			final Direction mowerDirection = Direction.valueOf(mowerLineMatcher.group(5));
			final String mowerName = new StringBuilder("Mower ").append(mowerNumber).toString();
			final Position mowerPosition = new Position(Integer.parseInt(mowerLineMatcher.group(1)), Integer.parseInt(mowerLineMatcher.group(3)));
			return new Mower(mowerDirection, mowerName, mowerPosition);
		} else {
			throw new FileReadingException(String.format("The line '%s' which describe the mower %s is incorrect.", line, mowerNumber));
		}
	}

}
