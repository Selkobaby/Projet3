package com.jeu;

import java.util.ArrayList;

public class DefenseurMastermind {

	public static void DefenseurM () {;
		
		// Saisi d'une combinaison par le joueur
		System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 6 que l'ordinateur devra deviner.");
		ArrayList<Integer> codeJoueur = Humain.codeJoueur();

		int essaisMax = 10;

		while (essaisMax > 0) {

			//Generation automatique d'une combinaison a chaque tours
			ArrayList<Integer> propositionOrdi = Ordi.codeAleatoireMastermind();
			
			int bienPlace = Utilitaire.getBienPlace(codeJoueur, propositionOrdi);
			int malPlace = Utilitaire.getMalPlace(codeJoueur, propositionOrdi);

			System.out.println("Proposition : ");
			for (int i = 0; i < codeJoueur.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
		
			//Le resultat de chaque comparaison
			System.out.println("\nReponse : " + bienPlace + " bien place et " 
					+ malPlace + " mal place ");
			System.out.println();

			if (bienPlace == codeJoueur.size()) {
				System.out.println("\nBravo, vous avez gagne.");
				
				essaisMax = 0;
			}
			essaisMax--;
			
			//Si le nombre d'essais max est atteint, le resultat est affcher avec l'indication perdu
			if (essaisMax == 0) {
				System.out.println("Perdu, la combinaison du joueur etait ");
				for(int i = 0; i < codeJoueur.size(); i++) {
					System.out.print(codeJoueur.get(i));
				}
			}
		}
	}
}