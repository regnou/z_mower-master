package fr.mowitnow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.mowitnow.entite.Coordonee;
import fr.mowitnow.entite.Instruction;
import fr.mowitnow.entite.Orientation;
import fr.mowitnow.helpers.InputFileHelper;

public class CommandExecutorTest {
	@Test
	public void testExecuterInstructions() throws IllegalArgumentException {
		List<String> inputData = new ArrayList<String>();
		inputData.add(0, "5 5");
		inputData.add(1, "1 2 N");
		inputData.add(2, "GAGAGAGAA");
		inputData.add(3, "3 3 E");
		inputData.add(4, "AADAADADDA");
		Coordonee coordonneesTerrain = InputFileHelper.getCoordonneesTerrain(inputData);

		List<Instruction> instructions = InputFileHelper.getInstructions(inputData);
		instructions.get(0).executer(coordonneesTerrain);
		instructions.get(1).executer(coordonneesTerrain);
		
		assertEquals(instructions.get(0).getTondeuse().getEmplacement().getAbscisse(), 1);
		assertEquals(instructions.get(0).getTondeuse().getEmplacement().getOrdonnee(), 3);
		assertEquals(instructions.get(0).getTondeuse().getOrientation(), Orientation.N);
		
		assertEquals(instructions.get(1).getTondeuse().getEmplacement().getAbscisse(), 5);
		assertEquals(instructions.get(1).getTondeuse().getEmplacement().getOrdonnee(), 1);
		assertEquals(instructions.get(1).getTondeuse().getOrientation(), Orientation.E);
	}
}
