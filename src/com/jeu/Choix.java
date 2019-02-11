package com.jeu;

public class Choix {

	public static void getMode(char jeu, char modeJeu) {
		
		String choixChallenger = "Mode challenger";
		String choixDefenseur = "Mode défenseur";
		String choixDuel = "Mode duel";

		if (jeu == '1' && modeJeu == '1') {
			System.out.println("Vous avez choisi " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secrète de l'ordinateur.");
		} else if (jeu == '1' && modeJeu == '2') {
			System.out.println("Vous avez choisi " + choixDefenseur);
			System.out.println("C'est à l'ordinateur de trouver votre combinaison secrète.");
		} else if (jeu == '1' && modeJeu == '3') {
			System.out.println("Vous avez choisi " + choixDuel);
			System.out.println("L'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné.");
		} else if (jeu == '2' && modeJeu == '1') {
			System.out.println("Vous avez choisi " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secrète de l'ordinateur.");
		} else if (jeu == '2' && modeJeu == '2') {
			System.out.println("Vous avez choisi " + choixDefenseur);
			System.out.println("C'est à l'ordinateur de trouver votre combinaison secrète.");
		} else if (jeu == '2' && modeJeu == '3') {
			System.out.println("Vous avez choisi " + choixDuel);
			System.out.println("L'ordinateur et vous jouez tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné.");
		} 
	}
}