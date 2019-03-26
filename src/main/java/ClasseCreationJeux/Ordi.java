package main.java.ClasseCreationJeux;

import java.util.ArrayList;
import java.util.Random;

import main.java.ClasseUtiliserRessources.Propriete;

public class Ordi implements Propriete {

	/*
	 * codeAleatoire permet de generer un code aleatoire entre 0 et 6
	 */
	public static ArrayList<Integer> codeAleatoireMastermind() {

		Random r = new Random();

		int nbreChiffresCombi = Integer.parseInt(properties.getProperty("nombreChiffresCombi"));

		ArrayList<Integer> code = new ArrayList<Integer>();
		for (int i = 0; i < nbreChiffresCombi; i++) {
			int nombre;
			do {
				nombre = r.nextInt(7);
			} while (code.contains(nombre));
			code.add(nombre);
		}
		return code;
	}

	/*
	 * codeAleatoire permet de generer un code aleatoire entre 0 et 9
	 */
	public static ArrayList<Integer> codeAleatoireR() {

		Random r = new Random();

		int nbreChiffresCombi = Integer.parseInt(properties.getProperty("nombreChiffresCombi"));

		ArrayList<Integer> code = new ArrayList<Integer>();
		for (int i = 0; i < nbreChiffresCombi; i++) {
			int nombre;
			do {
				nombre = r.nextInt(10);
			} while (code.contains(nombre));
			code.add(nombre);
		}
		return code;
	}

	public static ArrayList<Integer> codeAleatoireRecherche(ArrayList<Integer> codePrecedent, String resultatOrdi) {
		if (codePrecedent == null && resultatOrdi == null) {
			return codeAleatoireR();
		}
		ArrayList<Integer> code = new ArrayList<Integer>();

		int nbreChiffresCombi = Integer.parseInt(properties.getProperty("nombreChiffresCombi"));

		// Converti l'objet String en un tableau de caractere
		char[] tabResultatOrdi = resultatOrdi.toCharArray();

		for (int i = 0; i < nbreChiffresCombi; i++) {
			if (tabResultatOrdi[i] == '=') {
				code.add(codePrecedent.get(i));
			} else if (tabResultatOrdi[i] == '+') {
				// ajout 1 au code precedent
				int nombre = codePrecedent.get(i);
				nombre++;
				code.add(nombre++);
			} else if (tabResultatOrdi[i] == '-') {
				// enleve 1 au code precedent
				int nombre = codePrecedent.get(i);
				nombre--;
				code.add(nombre);
			}
		}
		return code;
	}
}
