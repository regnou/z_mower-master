package fr.mowitnow;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import fr.mowitnow.entite.Coordonee;
import fr.mowitnow.entite.Instruction;
import fr.mowitnow.entite.Tondeuse;
import fr.mowitnow.helpers.InputFileHelper;

public class CommandExecuteurJob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String inPutFile;
			String outPutFile;
			if (args.length>=1 && args[0]!=null && !args[0].isEmpty()) {
				inPutFile = args[0];
			} else {
				throw new IOException("Merci de saisir un fichier d'entrée en premier argument");
			}
			Path path = Paths.get(inPutFile);

			List<String> lignes = Files.readAllLines(path, Charset.defaultCharset());

			Coordonee coordonneesTerrain = InputFileHelper.getCoordonneesTerrain(lignes);

			List<Instruction> instructions = InputFileHelper.getInstructions(lignes);

			if (args.length==2 && args[1]!=null && !args[1].isEmpty()) {
				outPutFile = args[1];
			} else {
				throw new IOException("Merci de saisir un fichier de sortie en deuxième argument");
			}
			PrintWriter pw = new PrintWriter(new File(outPutFile));

			for (Instruction instruction : instructions) {
				
				instruction.executer(coordonneesTerrain);
				Tondeuse tondeuseBougee = instruction.getTondeuse();
				
		        StringBuilder sb = new StringBuilder();
		        sb.append(tondeuseBougee.getEmplacement().getAbscisse());
		        sb.append(" ");
		        sb.append(tondeuseBougee.getEmplacement().getOrdonnee());
		        sb.append(" ");
		        sb.append(tondeuseBougee.getOrientation().toString());
		        sb.append('\n');

		        pw.write(sb.toString());
			}
			pw.close();
			
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
