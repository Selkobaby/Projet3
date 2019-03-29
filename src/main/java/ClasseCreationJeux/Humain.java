package main.java.ClasseCreationJeux;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import main.java.ClasseUtiliserRessources.EcrireJournal;
import main.java.ClasseUtiliserRessources.LireFichierConfig;

public class Humain extends EcrireJournal{

	/*
	 * codeJoueur permet de recuperer le code e 4 chiffres que va saisir le Joueur
	 */
	public static ArrayList<Integer> codeJoueur() {
		
		LireFichierConfig lire = new LireFichierConfig();
		Properties properties = lire.getProperties();

		int nbreChiffresCombi = Integer.parseInt(properties.getProperty("nombreChiffresCombi"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> code = new ArrayList<Integer>();
		String str = null;
		do {
			str = sc.nextLine();
			if (str.length() != 4) {
				logger.error("Le joueur n'a pas saisi 4 chiffres pour la combinaison.");
			}
			// Converti l'objet String en un tableau de caractere
			char[] tab = str.toCharArray();
			code.clear();
			for (int i = 0; i < str.length(); i++) {
				// Converti le tableau de caractere en un nombre entier
				code.add(Integer.parseInt(Character.toString(tab[i])));
			}
		} while (str.length() != nbreChiffresCombi);
		return code;
	}
}