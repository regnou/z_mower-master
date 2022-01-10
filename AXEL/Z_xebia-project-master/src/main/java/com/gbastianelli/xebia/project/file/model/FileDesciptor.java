package com.gbastianelli.xebia.project.file.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * FileDesciptor: Descriptor of the instruction file.
 * <p>
 * Créé le 21 oct. 2015
 * 
 * @author guillaumebastianelli
 */
public class FileDesciptor {

	/** The size of the field (coordinate of the upper right corner) */
	private final Position field;

	/** The list of mowers and how they have to be processed */
	private final List<MowingDescriptor> mowingDescriptors;

	/**
	 * Constructor of {@FileDesciptor}.
	 * 
	 * @param field Lize of the field (coordinate of the upper right corner)
	 * @param mowingDescriptors List of mowers and how they have to be processed
	 */
	public FileDesciptor(Position field, List<MowingDescriptor> mowingDescriptors) {
		super();
		this.field = field;
		this.mowingDescriptors = mowingDescriptors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Getter of {@link FileDesciptor#field}.
	 *
	 * @return value of {@link FileDesciptor#field}
	 */
	public Position getField() {
		return field;
	}

	/**
	 * Getter of {@link FileDesciptor#mowingDescriptors}.
	 *
	 * @return value of {@link FileDesciptor#mowingDescriptors}
	 */
	public List<MowingDescriptor> getMowingDescriptors() {
		return mowingDescriptors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
