package com.jeu;

import java.util.ArrayList;

public class DuelMastermind {

	public static void DuelM() {

		int essaiMax = 10;
		ArrayList<Integer> propositionOrdi = null;

		ArrayList<Integer> codeJoueurCherche = Ordi.codeAleatoireMastermind();
		System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 6 que l'ordinateur devra deviner.");
		ArrayList<Integer> codeOrdiCherche = Humain.codeJoueur();

		System.out.print("Votre combinaison : ");
		for (int i = 0; i < codeJoueurCherche.size(); i++) {
			System.out.print(codeOrdiCherche.get(i));
		}
		
		while (essaiMax > 0) {

			// proposition du joueur
			System.out.println("\nQuel est votre proposition ?");
			ArrayList<Integer> propositionJoueur = Humain.codeJoueur();

			int bienPlaceJ = Utilitaire.getBienPlace(codeJoueurCherche, propositionJoueur);
			int malPlaceJ = Utilitaire.getMalPlace(codeJoueurCherche, propositionJoueur);

			System.out.print("Proposition du joueur: ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(propositionJoueur.get(i));
			}
			//Le resultat de chaque comparaison
			System.out.println("\nReponse : " + bienPlaceJ + " bien place et " + malPlaceJ + " mal place ");
			System.out.println();

			propositionOrdi = Ordi.codeAleatoireMastermind();
			int bienPlaceOrdi = Utilitaire.getBienPlace(codeOrdiCherche, propositionOrdi);
			int malPlaceOrdi = Utilitaire.getMalPlace(codeOrdiCherche, propositionOrdi);
			
			System.out.println("Proposition Ordi: ");
			for (int i = 0; i < codeOrdiCherche.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
			//Le resultat de chaque comparaison
			System.out.print("\nReponse : " + bienPlaceOrdi + " bien place et " + malPlaceOrdi + " mal place ");
			System.out.println();
			
			//Affiche le vainqueur de la parti
			if (bienPlaceJ == codeJoueurCherche.size()) {
				System.out.println("\nBravo, vous avez gagne !");
				essaiMax = 0;
			} else if (bienPlaceOrdi == codeOrdiCherche.size()) {
				System.out.println("\nBravo, ordinateur vous avez gagne !");
				essaiMax = 0;
			}
			essaiMax--;
			
			//Affiche la combinaison de chacun si le nombre d'essais maximum est atteint
			if (essaiMax == 0) {
				System.out.print("\nVous avez perdu.");
				System.out.println("\nLa combinaison de l'ordinateur etait ");
				for(int i = 0; i < codeJoueurCherche.size(); i++) {
					System.out.print(codeJoueurCherche.get(i));
				}
				System.out.print(".");
				System.out.println();
				System.out.println("La combinaison du joueur etait ");
				for(int i = 0; i < codeOrdiCherche.size(); i++) {
					System.out.print(codeOrdiCherche.get(i));
				}
				System.out.print(".");
			}
		}
	}
}