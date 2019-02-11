package com.jeu;

import java.util.ArrayList;
import java.util.Properties;

public class DefenseurRecherche {

	public static void DefenseurR() {

		Humain humain = new Humain();
		Ordi ordi = new Ordi();

		// Saisir la combinaison que l'ordinateur doit deviner
		System.out.println("\nSaisir une combinaison à 4 chiffres entre 0 et 6 ");
		ArrayList<Integer> codeJoueur = humain.codeJoueur();

		int nbreEssaiMax = 10;
		ArrayList<Integer> propositionOrdi = null;
		String resultat = null;

		while (nbreEssaiMax > 0) {

			// Faire une proposition
			propositionOrdi = ordi.codeAleatoireRecherche(propositionOrdi, resultat);

			// Compare les 2 combinaisons 
			resultat = Utilitaire.getResultatRechercher(codeJoueur, propositionOrdi);
			
			System.out.print("Proposition : ");
			for (int j = 0; j < codeJoueur.size(); j++) {
				System.out.print(propositionOrdi.get(j));
			}
			
			System.out.print(" -> réponse : ");
			System.out.println(resultat);
			
			// Afficher la victoire si la combinaison est ====
			if (resultat.equals("====")) {
				System.out.println("Bravo, vous avez gagné");
				nbreEssaiMax = 0;
			}
			nbreEssaiMax--;
			
			//si le nombre maximum d'essai est atteint l'ordinateur a perdu
			if (nbreEssaiMax == 0) {
				System.out.print("Perdu, la combinaison du joueur était ");
				for (int i = 0; i <codeJoueur.size() ; i++) {
					System.out.print(codeJoueur.get(i));
				}
				System.out.println(".");
			}
		}
	}
}