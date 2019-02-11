package com.jeu;

import java.util.ArrayList;

public class ChallengerMastermind{

	public static void ChallengerM() {

		Humain humain = new Humain();
		Ordi ordi = new Ordi();

		// gnrer une combinaison alatoire
		ArrayList<Integer> codeAleatoire = ordi.codeAleatoire();

		int essaiMax = 10;
		
		while (essaiMax > 0) {
			
			//Saisir une combinaison � 4 chiffres.
			System.out.println();
			System.out.println("\nSaisir une combinaison � 4 chiffres entre 0 et 6.");
			ArrayList<Integer> proposition = humain.codeJoueur();
	
			int bienPlace = Utilitaire.getBienPlace(codeAleatoire, proposition);
			int malPlace = Utilitaire.getMalPlace(codeAleatoire, proposition);
			
			// Affichage de la combinaison propos�
			System.out.print("Proposition du Joueur : ");
			for (int i = 0; i < codeAleatoire.size(); i++) {
				System.out.print(proposition.get(i));
			}
			System.out.print("\nR�ponse : ");

			//Le resultat de chaque comparaison
			System.out.print(bienPlace + " bien plac� et " + malPlace + " mal plac� ");
		
			if (bienPlace == codeAleatoire.size()) {
				System.out.println("\nBravo vous avez gagn� !");
				essaiMax = 0;
			}
			essaiMax--;

			/* Si le nombre d'essai atteint 0, le jeu affiche 
			la bonne combinaison qui indique que le joueur a perdu */
			if (essaiMax == 0) {
				System.out.println("Perdu, la combinaison de l'ordinateur �tait : ");
				for (int i = 0; i < codeAleatoire.size(); i++) {
					System.out.println(codeAleatoire.get(i));
				}
			}
		}
	}
}