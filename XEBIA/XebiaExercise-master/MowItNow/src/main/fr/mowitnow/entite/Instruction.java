package fr.mowitnow.entite;

import java.util.List;

public class Instruction {
	
	Tondeuse tondeuse;
	
	List<Directive> directives;

	public Tondeuse getTondeuse() {
		return tondeuse;
	}

	public void setTondeuse(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}

	public List<Directive> getDirectives() {
		return directives;
	}

	public void setDirectives(List<Directive> directives) {
		this.directives = directives;
	}
	
	public void executer(Coordonee coordonneeTerrain) {
		for (final Directive directive : directives) {
			switch (directive.name()) {
			case "A":
				tondeuse.avancer(coordonneeTerrain);
				break;
			case "D":
				tondeuse.tournerDroite();
				break;
			case "G":
				tondeuse.tournerGauche();
				break;
			default:
				break;
			}
		}
	}
	
}
