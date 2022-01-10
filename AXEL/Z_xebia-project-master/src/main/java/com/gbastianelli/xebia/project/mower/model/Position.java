package com.gbastianelli.xebia.project.mower.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>
 * Position: Combination of a position on the West/East axe and North/South axe.
 * <p>
 * Créé le 18 oct. 2015
 *
 * @author guillaumebastianelli
 */
public class Position {

	/** Postion on the West/East axe */
	private final int x;

	/** Postion on the North/South axe */
	private final int y;

	/**
	 * Constructor of {@Position}.
	 *
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Getter of {@link Position#x}.
	 *
	 * @return value of {@link Position#x}
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter of {@link Position#y}.
	 *
	 * @return value of {@link Position#y}
	 */
	public int getY() {
		return y;
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
