package com.jeu.ClasseCreationJeux;

import com.jeu.ClasseUtiliserRessources.EcrireJournal;
import com.jeu.Mastermind.ChallengerMastermind;
import com.jeu.Mastermind.DefenseurMastermind;
import com.jeu.Mastermind.DuelMastermind;
import com.jeu.Recherche.ChallengerRecherche;
import com.jeu.Recherche.DefenseurRecherche;
import com.jeu.Recherche.DuelRecherche;

public class Choix extends EcrireJournal {

	public static void getMode(char jeu, char modeJeu) {
		
		String choixChallenger = "Mode challenger";
		String choixDefenseur = "Mode defenseur";
		String choixDuel = "Mode duel";

		if (jeu == '1' && modeJeu == '1') {
			System.out.println("Vous avez choisi le " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secrete de l'ordinateur.");
			logger.info("Le joueur a choisi le mode challenger du jeu recherche.");
			ChallengerRecherche.ChallengerR();
		} else if (jeu == '1' && modeJeu == '2') {
			System.out.println("Vous avez choisi le " + choixDefenseur);
			System.out.println("C'est a l'ordinateur de trouver votre combinaison secrete.");
			logger.info("Le joueur a choisi le mode defenseur du jeu recherche.");
			DefenseurRecherche.DefenseurR();
		} else if (jeu == '1' && modeJeu == '3') {
			System.out.println("Vous avez choisi le " + choixDuel);
			System.out.println("L'ordinateur et vous jouez tour a tour, le premier a trouver la combinaison secrete de l'autre a gagne.");
			logger.info("Le joueur a choisi le mode duel du jeu recherche.");
			DuelRecherche.DuelR();
		} else if (jeu == '2' && modeJeu == '1') {
			System.out.println("Vous avez choisi le " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secrete de l'ordinateur.");
			logger.info("Le joueur a choisi le mode challenger du jeu mastermind.");
			ChallengerMastermind.ChallengerM();
		} else if (jeu == '2' && modeJeu == '2') {
			System.out.println("Vous avez choisi le " + choixDefenseur);
			System.out.println("C'est a l'ordinateur de trouver votre combinaison secrete.");
			logger.info("Le joueur a choisi le mode defenseur du jeu mastermind.");
			DefenseurMastermind.DefenseurM();
		} else if (jeu == '2' && modeJeu == '3') {
			System.out.println("Vous avez choisi le " + choixDuel);
			System.out.println("L'ordinateur et vous jouez tour a tour, le premier a trouver la combinaison secrete de l'autre a gagne.");
			logger.info("Le joueur a choisi le mode duel du jeu mastermind.");
			DuelMastermind.DuelM();
		} 
	}
}