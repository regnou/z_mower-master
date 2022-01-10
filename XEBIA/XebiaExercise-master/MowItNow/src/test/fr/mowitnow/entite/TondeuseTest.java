package fr.mowitnow.entite;

import static org.junit.Assert.*;

import fr.mowitnow.entite.Coordonee;
import fr.mowitnow.entite.Orientation;
import fr.mowitnow.entite.Tondeuse;

import org.junit.Test;

public class TondeuseTest {
	
	@Test
	public void testAvancer() 
	{
		Coordonee coordonneeTerrain = new Coordonee();
		coordonneeTerrain.setAbscisse(5);
		coordonneeTerrain.setOrdonnee(5);
	    
		Orientation orientation = Orientation.N;

		Tondeuse tondeuse1 = new Tondeuse();
	    Coordonee emplacement1 = new Coordonee();
	    emplacement1.setAbscisse(1);
	    emplacement1.setOrdonnee(2);
		tondeuse1.setEmplacement(emplacement1);
		tondeuse1.setOrientation(orientation);
		tondeuse1.avancer(coordonneeTerrain);
		assertEquals(emplacement1.getAbscisse(),tondeuse1.getEmplacement().getAbscisse());
		
		Tondeuse tondeuse2 = new Tondeuse();
	    Coordonee emplacement2 = new Coordonee();
	    emplacement2.setAbscisse(4);
	    emplacement2.setOrdonnee(5);
	    tondeuse2.setEmplacement(emplacement2);
	    tondeuse2.setOrientation(orientation);
	    tondeuse2.avancer(coordonneeTerrain);
		assertEquals(emplacement2.getAbscisse(),tondeuse2.getEmplacement().getAbscisse());
		
		
	}
	
	@Test
	public void testTournerGauche() 
	{
		Coordonee coordonneeTerrain = new Coordonee();
		coordonneeTerrain.setAbscisse(5);
		coordonneeTerrain.setOrdonnee(5);
	    
		Orientation orientation = Orientation.N;

		Tondeuse tondeuse = new Tondeuse();
	    Coordonee emplacement = new Coordonee();
	    emplacement.setAbscisse(1);
	    emplacement.setOrdonnee(2);
		tondeuse.setEmplacement(emplacement);
		tondeuse.setOrientation(orientation);
		tondeuse.tournerGauche();
		assertEquals(tondeuse.getOrientation(),Orientation.W);
	}
	
	@Test
	public void testTournerDroite() 
	{
		Coordonee coordonneeTerrain = new Coordonee();
		coordonneeTerrain.setAbscisse(5);
		coordonneeTerrain.setOrdonnee(5);
	    
		Orientation orientation = Orientation.N;

		Tondeuse tondeuse = new Tondeuse();
	    Coordonee emplacement = new Coordonee();
	    emplacement.setAbscisse(1);
	    emplacement.setOrdonnee(2);
		tondeuse.setEmplacement(emplacement);
		tondeuse.setOrientation(orientation);
		tondeuse.tournerDroite();
		assertEquals(tondeuse.getOrientation(),Orientation.E);
	}

}
