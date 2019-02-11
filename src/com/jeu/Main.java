package com.jeu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
				
		String jeuRecherche = "Recherche+/-";
		String jeuMastermind = "Mastermind";

		char resultatChoix = ' ', jeu = ' ', modeJeu = ' ';

		System.out.println();

		do {
			do {
				jeu = Message.messageJeu();			

				if (jeu != '1' && jeu != '2' && jeu != '3')
					System.out.println("Vous devez choisir entre 1, 2, ou 3");

				if (jeu == '1') {
					System.out.print("Vous avez choisi le jeu " + jeuRecherche + "\n");
					System.out.println();
				} else if (jeu == '2') {
					System.out.println("Vous avez choisi le jeu " + jeuMastermind + "\n");
					System.out.println();
				} else if (jeu == '3') {
					System.out.println("Fin du jeu");
					System.out.println();
				}

			} while (jeu != '1' && jeu != '2' && jeu != '3');

			if (jeu == '1' || jeu == '2') {
				do {
					do {
						modeJeu = Message.messageMode();

						if (modeJeu != '1' && modeJeu != '2' && modeJeu != '3')
							System.out.println("Vous devez choisir entre 1, 2 ou 3");

					} while (modeJeu != '1' && modeJeu != '2' && modeJeu != '3');

					Choix.getMode(jeu, modeJeu);
					
					do {
						resultatChoix = Message.messageFin();
						
					} while (resultatChoix != 'o' && resultatChoix != 'n');

				} while (resultatChoix == 'o');
			}
		} while (jeu != '3');

		System.out.println("A bientôt !");
	}
}