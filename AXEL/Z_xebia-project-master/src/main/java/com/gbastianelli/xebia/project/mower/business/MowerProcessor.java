package com.gbastianelli.xebia.project.mower.business;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Motion;
import com.gbastianelli.xebia.project.mower.model.Mower;
import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * MowerProcessor: Business class used to process a mower.
 * <p>
 * Créé le 18 oct. 2015
 * 
 * @author guillaumebastianelli
 */
public class MowerProcessor implements Runnable {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(MowerProcessor.class);

	/** Limit of the field (the upper right corner) */
	private final Position fieldLimit;

	/** Sequence of motions to be processed */
	private final List<Motion> motions;

	/** Mower to process */
	private final Mower mower;

	/** Listeners which listen the processor */
	private final Set<IMowerProcessorListener> mowerProcessorListeners = new HashSet<IMowerProcessorListener>();

	/**
	 * Constructor of {@MowerProcessor}.
	 * 
	 * @param fieldLimit the position of the upper right corner of the field to mower
	 * @param motions the motion to process
	 * @param mower the mower to process
	 */
	public MowerProcessor(Position fieldLimit, List<Motion> motions, Mower mower) {
		super();
		this.fieldLimit = fieldLimit;
		this.motions = motions;
		this.mower = mower;
	}

	/**
	 * Add a {@link IMowerProcessorListener} to the processor.
	 * 
	 * @param listener the listener to add
	 */
	public void addMowerProcessorListener(IMowerProcessorListener listener) {
		mowerProcessorListeners.add(listener);
	}

	/**
	 * Getter of {@link MowerProcessor#fieldLimit}.
	 *
	 * @return value of {@link MowerProcessor#fieldLimit}
	 */
	public Position getFieldLimit() {
		return fieldLimit;
	}

	/**
	 * Getter of {@link MowerProcessor#motions}.
	 *
	 * @return value of {@link MowerProcessor#motions}
	 */
	public List<Motion> getMotions() {
		return motions;
	}

	/**
	 * Getter of {@link MowerProcessor#mower}.
	 *
	 * @return value of {@link MowerProcessor#mower}
	 */
	public Mower getMower() {
		return mower;
	}

	/**
	 * Getter of {@link MowerProcessor#mowerProcessorListeners}.
	 *
	 * @return value of {@link MowerProcessor#mowerProcessorListeners}
	 */
	public Set<IMowerProcessorListener> getMowerProcessorListeners() {
		return Collections.unmodifiableSet(mowerProcessorListeners);
	}

	/**
	 * Remove a {@link IMowerProcessorListener} to the processor.
	 * 
	 * @param listener the listener to remove
	 */
	public void removeMowerProcessorListener(IMowerProcessorListener listener) {
		mowerProcessorListeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		LOGGER.info("The mower {} starts its job!", mower.getName());
		for (final Motion motion : motions) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("The mower {} is moving -> {}", mower.getName(), motion);
			}
			moveMower(motion);
		}
		fireMowingFinished();
	}

	/**
	 * Notify the listener that the mower finished its job.
	 */
	private void fireMowingFinished() {
		for (final IMowerProcessorListener listener : mowerProcessorListeners) {
			listener.mowingFinished(mower.getName(), mower.getPosition(), mower.getDirection());
		}
	}

	/**
	 * Check if a {@link Position} is in the {@link Field}.
	 * 
	 * @param position the {@link Position} to check
	 * @return <code>true</code> if the {@link Position} is in the field else <code>false</code>
	 */
	private boolean isInField(Position position) {
		return (0 <= position.getX()) && (position.getX() <= fieldLimit.getX()) && (0 <= position.getY()) && (position.getY() <= fieldLimit.getY());
	}

	/**
	 * Change the position of the mower according to its current direction.
	 * <ul>
	 * <li>East -> x+1</li>
	 * <li>North -> y+1</li>
	 * <li>South -> y-1</li>
	 * <li>West -> x-1</li>
	 * </ul>
	 */
	private void moveForward() {
		Position newPosition = null;
		switch (mower.getDirection()) {
		case E:
			newPosition = new Position(mower.getPosition().getX() + 1, mower.getPosition().getY());
			break;
		case N:
			newPosition = new Position(mower.getPosition().getX(), mower.getPosition().getY() + 1);
			break;
		case S:
			newPosition = new Position(mower.getPosition().getX(), mower.getPosition().getY() - 1);
			break;
		case W:
			newPosition = new Position(mower.getPosition().getX() - 1, mower.getPosition().getY());
			break;
		default:
			break;
		}
		if (isInField(newPosition)) {
			mower.setPosition(newPosition);
		} else {
			LOGGER.error("The mower cannot move with order {} because it is beyond the field");
		}
	}

	/**
	 * Move a mower with a motion "order"
	 * 
	 * @param motion the motion
	 */
	private void moveMower(Motion motion) {
		switch (motion) {
		case A:
			moveForward();
			break;
		case D:
			turnRight();
			break;
		case G:
			turnLeft();
			break;
		default:
			break;
		}
	}

	/**
	 * Change the direction of the mower with i's current left direction.
	 * <ul>
	 * <li>East -> North</li>
	 * <li>North -> West</li>
	 * <li>South -> East</li>
	 * <li>West -> South</li>
	 * </ul>
	 */
	private void turnLeft() {
		switch (mower.getDirection()) {
		case E:
			mower.setDirection(Direction.N);
			break;
		case N:
			mower.setDirection(Direction.W);
			break;
		case S:
			mower.setDirection(Direction.E);
			break;
		case W:
			mower.setDirection(Direction.S);
			break;
		default:
			break;
		}
	}

	/**
	 * Change the direction of the mower with i's current right direction.
	 * <ul>
	 * <li>East -> South</li>
	 * <li>North -> East</li>
	 * <li>South -> West</li>
	 * <li>West -> North</li>
	 * </ul>
	 */
	private void turnRight() {
		switch (mower.getDirection()) {
		case E:
			mower.setDirection(Direction.S);
			break;
		case N:
			mower.setDirection(Direction.E);
			break;
		case S:
			mower.setDirection(Direction.W);
			break;
		case W:
			mower.setDirection(Direction.N);
			break;
		default:
			break;
		}
	}

}
