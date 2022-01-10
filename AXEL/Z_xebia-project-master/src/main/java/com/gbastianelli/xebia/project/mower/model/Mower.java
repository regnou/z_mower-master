package com.gbastianelli.xebia.project.mower.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>
 * Mower: Represent a mower.
 * <p>
 * Créé le 18 oct. 2015
 *
 * @author guillaumebastianelli
 */
public class Mower {

	/** Direction of the mower */
	private Direction direction;

	/** Name of the mower */
	private String name;

	/** Position of the mower */
	private Position position;

	/**
	 * Constructor of {@Mower}.
	 * 
	 * @param direction the default direction of the mower
	 * @param name the default name of the mower
	 * @param position the default position of the mower
	 */
	public Mower(Direction direction, String name, Position position) {
		super();
		this.direction = direction;
		this.name = name;
		this.position = position;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Getter of {@link Mower#direction}.
	 *
	 * @return value of {@link Mower#direction}
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Getter of {@link Mower#name}.
	 *
	 * @return value of {@link Mower#name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of {@link Mower#position}.
	 *
	 * @return value of {@link Mower#position}
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * Setter of {@link Mower#direction}.
	 *
	 * @param direction value of {@link Mower#direction} à "setter".
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Setter of {@link Mower#name}.
	 *
	 * @param name value of {@link Mower#name} à "setter".
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter of {@link Mower#position}.
	 *
	 * @param position value of {@link Mower#position} à "setter".
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
