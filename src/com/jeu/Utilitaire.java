package com.jeu;

import java.util.ArrayList;

public class Utilitaire {
	/* comparaison entre le code proposé et le code cherché pour 
	indiqué les bien placé*/
	public static int getBienPlace(ArrayList<Integer> codeChercher ,ArrayList<Integer> codeProposer) {
		
		int bienPlace = 0; 
		
		for (int i = 0; i < codeChercher.size(); i++) {
			int nombre = codeProposer.get(i);
			if (codeChercher.get(i) == nombre) {
				bienPlace++;
			}
		}
		return bienPlace;
	}
	
	/* comparaison entre le code proposé et le code cherché pour 
	indiqué les mal placé*/
	public static int getMalPlace(ArrayList<Integer> codeChercher ,ArrayList<Integer> codeProposer) {
		
		int malPlace = 0; 
		
		for (int i = 0; i < codeChercher.size(); i++) {
			int nombre = codeProposer.get(i);
			if (codeChercher.contains(nombre)) {
				malPlace++;
			}
		}
		return malPlace;
	}
	
	// Comparer les 2 code pour avoir un resultat +, - ou =
	public static String getResultatRechercher(ArrayList<Integer> codeChercher ,ArrayList<Integer> codeProposer) {
		String resultat = "";

		for (int i = 0; i < codeChercher.size(); i++) {
			if (codeChercher.get(i) == codeProposer.get(i)) {
				resultat += "=";
			} else if (codeChercher.get(i) < codeProposer.get(i)) {
				resultat += "-";
			} else
				resultat += "+";
		}
		return resultat;
	}
}