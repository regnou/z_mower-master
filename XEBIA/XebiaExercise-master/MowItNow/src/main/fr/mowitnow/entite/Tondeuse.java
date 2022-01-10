package fr.mowitnow.entite;

public class Tondeuse {
	
	Coordonee emplacement;
	
	Orientation orientation;
	
	public Coordonee getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Coordonee emplacement) {
		this.emplacement = emplacement;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void avancer(Coordonee coordonneeTerrain) {
		switch (orientation.name()) {
		case "N":
			int avancementOrdonnee = emplacement.getOrdonnee()+1;
			if (coordonneeTerrain.getOrdonnee()>=avancementOrdonnee) {
				emplacement.setOrdonnee(avancementOrdonnee);
			}
			break;
		case "S":
			int reculOrdonnee = emplacement.getOrdonnee()-1;
			if (reculOrdonnee>=0) {
				emplacement.setOrdonnee(reculOrdonnee);
			}
			break;
		case "E":
			int avancementAbscisse = emplacement.getAbscisse()+1;
			if (coordonneeTerrain.getAbscisse()>=avancementAbscisse) {
				emplacement.setAbscisse(avancementAbscisse);
			}
			break;
		case "W":
			int reculAbscisse = emplacement.getAbscisse()-1;
			if (reculAbscisse>=0) {
				emplacement.setAbscisse(reculAbscisse);
			}
			break;
		default:
			break;
		}
		
	}

	public void tournerDroite() {
		switch (orientation.name()) {
		case "N":
			orientation = Orientation.E;
			break;
		case "S":
			orientation = Orientation.W;
			break;
		case "E":
			orientation = Orientation.S;
			break;
		case "W":
			orientation = Orientation.N;
			break;
		default:
			break;
		}
		
	}

	public void tournerGauche() {
		switch (orientation.name()) {
		case "N":
			orientation = Orientation.W;
			break;
		case "S":
			orientation = Orientation.E;
			break;
		case "E":
			orientation = Orientation.N;
			break;
		case "W":
			orientation = Orientation.S;
			break;
		default:
			break;
		}
		
	}

}
