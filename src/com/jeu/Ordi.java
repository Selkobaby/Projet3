package com.jeu;

import java.util.ArrayList;
import java.util.Random;

public class Ordi {

	/*
	 * codeAleatoire permet de generer un code aleatoire entre 0 et 6
	 */
	public static ArrayList<Integer> codeAleatoire() {
		
		Random r = new Random();
						
		int nbreChiffresCombi = 4;
						
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

	public static ArrayList<Integer> codeAleatoireRecherche(ArrayList<Integer> codePrecedent, String resultatOrdi) {
		if(codePrecedent == null && resultatOrdi == null) {
			return codeAleatoire();
		}
		ArrayList<Integer> code = new ArrayList<Integer>();
		
		int nbreChiffresCombi = 4;
		//Converti l'objet String en un tableau de caractere
		char[] tabResultatOrdi = resultatOrdi.toCharArray();

		for (int i = 0; i < nbreChiffresCombi; i++) {
			Random rd = new Random();
			if (tabResultatOrdi[i] == '=') {
				code.add(codePrecedent.get(i));
			} else if (tabResultatOrdi[i] == '+') {
				// Entre codePrecedent.get(i) + 1 et 0
				int nombre;
				int min = codePrecedent.get(i) + 1;
				int max = 10;
				nombre = rd.nextInt(max - min) + min;
				code.add(nombre);
			} else if (tabResultatOrdi[i] == '-') {
				// Entre 0 et codePrecedent.get(i) - 1
				int min = 0;
				int max = codePrecedent.get(i);
				int nombre = rd.nextInt(max - min) + min;
				code.add(nombre);
			}
		}
		return code;
	}
}
