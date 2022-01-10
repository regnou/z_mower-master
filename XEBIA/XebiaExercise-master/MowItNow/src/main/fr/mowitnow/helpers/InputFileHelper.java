package fr.mowitnow.helpers;

import java.util.ArrayList;
import java.util.List;

import fr.mowitnow.entite.Coordonee;
import fr.mowitnow.entite.Directive;
import fr.mowitnow.entite.Instruction;
import fr.mowitnow.entite.Tondeuse;

public class InputFileHelper {
	
	public static List<Instruction> getInstructions(List<String> lignesInputFiles) throws IllegalArgumentException {
		List<Instruction> instructions = new ArrayList<Instruction>();
		for (int i=1;i<lignesInputFiles.size();i=i+2) {
			Tondeuse tondeuse = TondeuseHelper.getTondeuse(lignesInputFiles.get(i));
			List<Directive> directives = DirectiveHelper.getDirectives(lignesInputFiles.get(i+1));
			
			Instruction instruction = new Instruction();
			instruction.setTondeuse(tondeuse);
			instruction.setDirectives(directives);
			instructions.add(instruction );
		}
		return instructions;
	}

	/**
	 * @param lignes
	 * @return
	 */
	public static List<String> getLigneTerrainFromInputFile(List<String> lignes) {
		List<String> listeCaracteres = new ArrayList<String>();
		String ligne = lignes.get(0);
		for (String part : ligne.split("\\s+")) {
			listeCaracteres.add(part);
		}
		if (listeCaracteres.size()!=2) {
			throw new IllegalArgumentException("Les coordonnées du terrain doivent contenir deux caractères : abscisse ordonnee");
		}
		return listeCaracteres;
	}

	/**
	 * @param lignesFichierMap
	 * @return
	 */
	public static Coordonee getCoordonneesTerrain(List<String> lignes) {

		List<String> ligneTerrain = getLigneTerrainFromInputFile(lignes);
		Coordonee coordonneeTerrain = new Coordonee();
		String abscisse = ligneTerrain.get(0);
		String ordonnee = ligneTerrain.get(1);
		coordonneeTerrain.setAbscisse(Integer.parseInt(abscisse));
		coordonneeTerrain.setOrdonnee(Integer.parseInt(ordonnee));
		
		return coordonneeTerrain;
	}
	
}
