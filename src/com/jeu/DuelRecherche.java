package com.jeu;

import java.util.ArrayList;

public class DuelRecherche {

	public static void DuelR() {

		int nbreEssaiMax = 10;
		ArrayList<Integer> propositionOrdi = null;
		String resultatJoueur = null;
		String resultatOrdi = null;

		ArrayList<Integer> codeJoueurCherche = Ordi.codeAleatoire();

		System.out.println("\nSaisir une combinaison entre 0 et 6 a 4 chiffres e faire deviner a l'ordinateur. ");
		ArrayList<Integer> codeOrdiCherche = Humain.codeJoueur();

		System.out.print("Votre combinaison : ");
		for (int i = 0; i < codeOrdiCherche.size(); i++) {
			System.out.print(codeOrdiCherche.get(i));
		}
		System.out.println();

		while (nbreEssaiMax > 0) {

			System.out.println("\nSaisir une combinaison entre 0 et 6 a 4 chiffres");
			ArrayList<Integer> propositionJoueur = Humain.codeJoueur();

			System.out.print("\nProposition du joueur : ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(propositionJoueur.get(i));
			}
			System.out.print("\nReponse : ");

			// comparer propositionJoueur avec codeJoueurCherche pour donner un resultat
			resultatJoueur = Utilitaire.getResultatRechercher(codeJoueurCherche, propositionJoueur);
					
			System.out.println(resultatJoueur);
			
			propositionOrdi = Ordi.codeAleatoireRecherche(propositionOrdi, resultatOrdi);
			
			//Afficher la proposition de l'ordinateur
			System.out.print("\nProposition de l'ordinateur : ");
			for (int i = 0; i < codeOrdiCherche.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
			System.out.print("\nReponse : ");
			
			// comparer propositionOrdi avec codeOrdiCherche pour donner un resultat (+, - ou =)
			resultatOrdi = Utilitaire.getResultatRechercher(codeOrdiCherche, propositionOrdi);
			System.out.println(resultatOrdi);
			
			//le joueur qui trouve la combinaison de l'autre alors le jeu l'affiche
			if (resultatOrdi.equals("====")) {
				System.out.println("Bravo ordinateur, vous avez gagne.");
				nbreEssaiMax = 0;
			} else if (resultatJoueur.equals("====")) {
				System.out.println("Bravo joueur, vous avez gagne.");
				nbreEssaiMax = 0;
			}
			nbreEssaiMax--;
			
			//Si aucun des 2 joueurs trouve la combinaison de l'autre avant le nombre d'essai maximum le jeu affiche les 2 combinaison en indiquant perdu
			if(nbreEssaiMax == 0) {
				System.out.println("\nVous avez tout les 2 perdu.");
				System.out.println("La combinaison du joueur etait : ");
				for (int i = 0 ; i < codeOrdiCherche.size() ; i++) {
					System.out.print(codeOrdiCherche.get(i));
				}
				System.out.println(".");
				System.out.println("La combinaison de l'ordinateur etait : ");
				for (int i = 0 ; i < codeJoueurCherche.size() ; i++) {
					System.out.print(codeJoueurCherche.get(i));
				}
			}
		}
	}	
}