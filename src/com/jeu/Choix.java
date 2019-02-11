package com.jeu;

public class Choix {

	public static void getMode(char jeu, char modeJeu) {
		
		String choixChallenger = "Mode challenger";
		String choixDefenseur = "Mode d�fenseur";
		String choixDuel = "Mode duel";

		if (jeu == '1' && modeJeu == '1') {
			System.out.println("Vous avez choisi le " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secr�te de l'ordinateur.");
			ChallengerRecherche.ChallengerR();
		} else if (jeu == '1' && modeJeu == '2') {
			System.out.println("Vous avez choisi le " + choixDefenseur);
			System.out.println("C'est � l'ordinateur de trouver votre combinaison secr�te.");
			DefenseurRecherche.DefenseurR();
		} else if (jeu == '1' && modeJeu == '3') {
			System.out.println("Vous avez choisi le " + choixDuel);
			System.out.println("L'ordinateur et vous jouez tour � tour, le premier � trouver la combinaison secr�te de l'autre a gagn�.");
			DuelRecherche.DuelR();
		} else if (jeu == '2' && modeJeu == '1') {
			System.out.println("Vous avez choisi le " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secr�te de l'ordinateur.");
			ChallengerMastermind.ChallengerM();
		} else if (jeu == '2' && modeJeu == '2') {
			System.out.println("Vous avez choisi le " + choixDefenseur);
			System.out.println("C'est � l'ordinateur de trouver votre combinaison secr�te.");
			DefenseurMastermind.DefenseurM();
		} else if (jeu == '2' && modeJeu == '3') {
			System.out.println("Vous avez choisi le " + choixDuel);
			System.out.println("L'ordinateur et vous jouez tour � tour, le premier � trouver la combinaison secr�te de l'autre a gagn�.");
			DuelMastermind.DuelM();
		} 
	}
}