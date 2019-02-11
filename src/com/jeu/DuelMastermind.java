package com.jeu;

import java.util.ArrayList;

public class DuelMastermind {

	public static void DuelM() {

		Humain humain = new Humain();
		Ordi ordi = new Ordi();

		int essaiMax = 10;
		ArrayList<Integer> propositionOrdi = null;

		ArrayList<Integer> codeJoueurCherche = ordi.codeAleatoire();
		System.out.println("\nSaisir une combinaison à 4 chiffres entre 0 et 6 que l'ordinateur devra deviner.");
		ArrayList<Integer> codeOrdiCherche = humain.codeJoueur();

		System.out.print("Votre combinaison : ");
		for (int i = 0; i < codeJoueurCherche.size(); i++) {
			System.out.print(codeOrdiCherche.get(i));
		}
		
		while (essaiMax > 0) {

			// proposition du joueur
			System.out.println("\nQuel est votre proposition ?");
			ArrayList<Integer> propositionJoueur = humain.codeJoueur();

			int bienPlaceJ = Utilitaire.getBienPlace(codeJoueurCherche, propositionJoueur);
			int malPlaceJ = Utilitaire.getMalPlace(codeJoueurCherche, propositionJoueur);

			System.out.print("Proposition du joueur: ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(propositionJoueur.get(i));
			}
			//Le resultat de chaque comparaison
			System.out.println("\nRéponse : " + bienPlaceJ + " bien placé et " + malPlaceJ + " mal placé ");
			System.out.println();

			propositionOrdi = ordi.codeAleatoire();
			int bienPlaceOrdi = Utilitaire.getBienPlace(codeOrdiCherche, propositionOrdi);
			int malPlaceOrdi = Utilitaire.getMalPlace(codeOrdiCherche, propositionOrdi);
			
			System.out.println("Proposition Ordi: ");
			for (int i = 0; i < codeOrdiCherche.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
			//Le resultat de chaque comparaison
			System.out.print("\nRéponse : " + bienPlaceOrdi + " bien placé et " + malPlaceOrdi + " mal placé ");
			System.out.println();
			
			//Affiche le vainqueur de la parti
			if (bienPlaceJ == codeJoueurCherche.size()) {
				System.out.println("\nBravo, vous avez gagné !");
				essaiMax = 0;
			} else if (bienPlaceOrdi == codeOrdiCherche.size()) {
				System.out.println("\nBravo, ordinateur vous avez gagné !");
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