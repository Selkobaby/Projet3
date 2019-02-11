package com.jeu;

import java.util.ArrayList;

public class DefenseurMastermind {

	public static void DefenseurM () {

		Humain humain = new Humain();
		Ordi ordi = new Ordi();
		
		// Saisi d'une combinaison par le joueur
		System.out.println("\nSaisir une combinaison � 4 chiffres entre 0 et 6 que l'ordinateur devra deviner.");
		ArrayList<Integer> codeJoueur = humain.codeJoueur();

		int essaisMax = 10;

		while (essaisMax > 0) {

			//G�n�ration automatique d'une combinaison a chaque tours
			ArrayList<Integer> propositionOrdi = ordi.codeAleatoire();
			
			int bienPlace = Utilitaire.getBienPlace(codeJoueur, propositionOrdi);
			int malPlace = Utilitaire.getMalPlace(codeJoueur, propositionOrdi);

			System.out.println("Proposition : ");
			for (int i = 0; i < codeJoueur.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
		
			//Le resultat de chaque comparaison
			System.out.println("\nR�ponse : " + bienPlace + " bien plac� et " 
					+ malPlace + " mal plac� ");
			System.out.println();

			if (bienPlace == codeJoueur.size()) {
				System.out.println("\nBravo, vous avez gagn�.");
				
				essaisMax = 0;
			}
			essaisMax--;
			
			//Si le nombre d'essais max est atteint, le resultat est affcher avec l'indication perdu
			if (essaisMax == 0) {
				System.out.println("Perdu, la combinaison du joueur �tait ");
				for(int i = 0; i < codeJoueur.size(); i++) {
					System.out.print(codeJoueur.get(i));
				}
			}
		}
	}
}