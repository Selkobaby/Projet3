package com.jeu;

import java.util.ArrayList;

public class ChallengerRecherche {
	
	public static void ChallengerR(){
		
		// generer la combinaison aleatoire 
		ArrayList<Integer> codeAleatoire = Ordi.codeAleatoireR();
		
		int nbreEssais = 10;
				
		while (nbreEssais > 0) {

			
			System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 9");
			ArrayList<Integer> proposition = Humain.codeJoueur();

			System.out.print("Proposition : ");
			for (int i = 0; i < codeAleatoire.size() ; i++) {
				System.out.print(proposition.get(i));
			}
			System.out.print("\nReponse : ");

			String resultat = Utilitaire.getResultatRechercher(codeAleatoire, proposition);
					
			System.out.println(resultat);
			
			// Afficher la victoire si la combinaison est ====
			if (resultat.equals("====")) {
				System.out.println("Bravo, vous avez gagne.");
				nbreEssais = 0;
			}
			nbreEssais--;
			
			//Afficher la combinaison avec les bon resultat
			if (nbreEssais == 0) {
				System.out.print("Perdu, la combinaison de l'ordinateur etait : ");
				for (int i = 0; i < codeAleatoire.size(); i++) {
					System.out.print(codeAleatoire.get(i));
				}
			}
		}
	}		
}