package com.gbastianelli.xebia.project.file;

/**
 * <p>
 * FileReadingException: Exception during the reading a the 'mowing description' file.
 * <p>
 * Créé le 21 oct. 2015
 * 
 * @author guillaumebastianelli
 */
public class FileReadingException extends Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -637069624860436L;

	/**
	 * Constructor of {@FileReadingException}.
	 */
	public FileReadingException() {
		super();
	}

	/**
	 * Constructor of {@FileReadingException}.
	 * 
	 * @param message error message
	 */
	public FileReadingException(String message) {
		super(message);
	}

	/**
	 * Constructor of {@FileReadingException}.
	 * 
	 * @param message error message
	 * @param cause the error cause
	 */
	public FileReadingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor of {@FileReadingException}.
	 * 
	 * @param cause error cause
	 */
	public FileReadingException(Throwable cause) {
		super(cause);
	}

}
