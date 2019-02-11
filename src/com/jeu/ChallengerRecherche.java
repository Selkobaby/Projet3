package com.jeu;

import java.util.ArrayList;

public class ChallengerRecherche {
	
	public static void ChallengerR(){
				
		Humain humain = new Humain();
		Ordi ordi = new Ordi();
		
		// g�n�rer la combinaison al�atoire 
		ArrayList<Integer> codeAleatoire = ordi.codeAleatoire();
		
		int nbreEssais = 10;
				
		while (nbreEssais > 0) {

			System.out.println("\nSaisir une combinaison � 4 chiffres entre 0 et 6");
			ArrayList<Integer> proposition = humain.codeJoueur();

			System.out.print("Proposition : ");
			for (int i = 0; i < codeAleatoire.size() ; i++) {
				System.out.print(proposition.get(i));
			}
			System.out.print("\nR�ponse : ");

			String resultat = Utilitaire.getResultatRechercher(codeAleatoire, proposition);
					
			System.out.println(resultat);
			
			// Afficher la victoire si la combinaison est ====
			if (resultat.equals("====")) {
				System.out.println("Bravo, vous avez gagn�.");
				nbreEssais = 0;
			}
			nbreEssais--;
			
			//Afficher la combinaison avec les bon resultat
			if (nbreEssais == 0) {
				System.out.print("Perdu, la combinaison de l'ordinateur �tait : ");
				for (int i = 0; i < codeAleatoire.size(); i++) {
					System.out.print(codeAleatoire.get(i));
				}
			}
		}
	}		
}