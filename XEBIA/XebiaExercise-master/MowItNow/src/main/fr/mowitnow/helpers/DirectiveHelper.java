package fr.mowitnow.helpers;

import java.util.ArrayList;
import java.util.List;

import fr.mowitnow.entite.Directive;

public class DirectiveHelper {

	public static List<Directive> getDirectives(String ligne) throws IllegalArgumentException {
		List<Directive> directives = new ArrayList<Directive>();
		for (int i=0; i<ligne.length(); i++) {
			String directiveName = String.valueOf(ligne.charAt(i));
			if (directiveName.equals("A") || directiveName.equals("G") || directiveName.equals("D")) {
				directives.add(Directive.valueOf(directiveName));
			} else {
				throw new IllegalArgumentException("Une ligne des directives comporte un caractere inderdit : "+directiveName);
			}
		}
		
		return directives;
	}

}
