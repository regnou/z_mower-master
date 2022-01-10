package com.gbastianelli.xebia.project.file.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.gbastianelli.xebia.project.mower.model.Motion;
import com.gbastianelli.xebia.project.mower.model.Mower;

/**
 * <p>
 * MowingDescriptor: Description of the mowing in the instruction file.
 * <p>
 * Créé le 21 oct. 2015
 *
 * @author guillaumebastianelli
 */
public class MowingDescriptor {

	/** Motions of the mower */
	private final List<Motion> motions;

	/** The mower */
	private final Mower mower;

	public MowingDescriptor(Mower mower, List<Motion> motions) {
		super();
		this.mower = mower;
		this.motions = motions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Getter of {@link MowingDescriptor#motions}.
	 *
	 * @return value of {@link MowingDescriptor#motions}
	 */
	public List<Motion> getMotions() {
		return motions;
	}

	/**
	 * Getter of {@link MowingDescriptor#mower}.
	 *
	 * @return value of {@link MowingDescriptor#mower}
	 */
	public Mower getMower() {
		return mower;
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
