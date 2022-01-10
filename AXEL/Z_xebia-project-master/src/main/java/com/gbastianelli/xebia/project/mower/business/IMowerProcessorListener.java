package com.gbastianelli.xebia.project.mower.business;

import com.gbastianelli.xebia.project.mower.model.Direction;
import com.gbastianelli.xebia.project.mower.model.Position;

/**
 * <p>
 * IMowerProcessorListener: Defined a mower processor listener.
 * <p>
 * Créé le 18 oct. 2015
 *
 * @author guillaumebastianelli
 */
public interface IMowerProcessorListener {

	/**
	 * Tell when a mower has finished his mowing.
	 *
	 * @param mowerName the mower name
	 * @param finalPosition the final position of the mower
	 * @param finalDirection the final direction of the mower
	 */
	void mowingFinished(String mowerName, Position finalPosition, Direction finalDirection);

}
