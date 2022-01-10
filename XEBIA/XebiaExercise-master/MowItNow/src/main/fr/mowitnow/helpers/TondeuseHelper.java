package fr.mowitnow.helpers;

import java.util.ArrayList;
import java.util.List;

import fr.mowitnow.entite.Coordonee;
import fr.mowitnow.entite.Orientation;
import fr.mowitnow.entite.Tondeuse;

public class TondeuseHelper {

	public static Tondeuse getTondeuse(String ligne) throws IllegalArgumentException {
		List<String> caracteristiquesTondeuse = new ArrayList<String>();
		for (String part : ligne.split("\\s+")) {
			caracteristiquesTondeuse.add(part);
		}
		Tondeuse tondeuse = new Tondeuse();
		Coordonee emplacement = new Coordonee();
		if (caracteristiquesTondeuse.size() == 3 && (caracteristiquesTondeuse.get(2).equals("N") || caracteristiquesTondeuse.get(2).equals("S")
				|| caracteristiquesTondeuse.get(2).equals("E") || caracteristiquesTondeuse.get(2).equals("W"))) {
			emplacement.setAbscisse(Integer.parseInt(caracteristiquesTondeuse.get(0)));
			emplacement.setOrdonnee(Integer.parseInt(caracteristiquesTondeuse.get(1)));
			tondeuse.setEmplacement(emplacement);
			tondeuse.setOrientation(Orientation.valueOf(caracteristiquesTondeuse.get(2)));
		} else {
			throw new IllegalArgumentException("Les donnees de la tondeuse doivent contenir 3 carateres : abscisse ordonnee orientation");
		}
		return tondeuse;
	}

}
