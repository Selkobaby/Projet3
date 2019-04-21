package com.main.java.FonctionsJeux;

import org.apache.log4j.Logger;

import com.main.java.Mastermind.ChallengerMastermind;
import com.main.java.Mastermind.DefenseurMastermind;
import com.main.java.Mastermind.DuelMastermind;
import com.main.java.Recherche.ChallengerRecherche;
import com.main.java.Recherche.DefenseurRecherche;
import com.main.java.Recherche.DuelRecherche;
import com.main.java.UtiliserRessources.Propriete;

public class Choix {

	private static Logger logger = Logger.getLogger(Logger.class);
	
	public static Propriete get(char jeu, char modeJeu){

		Propriete propriete = null;
		String choixChallenger = "Mode challenger";
		String choixDefenseur = "Mode defenseur";
		String choixDuel = "Mode duel";

		if (jeu == '1' && modeJeu == '1') {
			System.out.println("Vous avez choisi le " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secrete de l'ordinateur.");
			logger.info("Le joueur a choisi le mode challenger du jeu recherche.");
			propriete = new ChallengerRecherche();
		} else if (jeu == '1' && modeJeu == '2') {
			System.out.println("Vous avez choisi le " + choixDefenseur);
			System.out.println("C'est a l'ordinateur de trouver votre combinaison secrete.");
			logger.info("Le joueur a choisi le mode defenseur du jeu recherche.");
			propriete = new DefenseurRecherche();
		} else if (jeu == '1' && modeJeu == '3') {
			System.out.println("Vous avez choisi le " + choixDuel);
			System.out.println(
					"L'ordinateur et vous jouez tour a tour, le premier a trouver la combinaison secrete de l'autre a gagne.");
			logger.info("Le joueur a choisi le mode duel du jeu recherche.");
			propriete = new DuelRecherche();
		} else if (jeu == '2' && modeJeu == '1') {
			System.out.println("Vous avez choisi le " + choixChallenger);
			System.out.println("Vous devez trouver la combinaison secrete de l'ordinateur.");
			logger.info("Le joueur a choisi le mode challenger du jeu mastermind.");
			propriete = new ChallengerMastermind();
		} else if (jeu == '2' && modeJeu == '2') {
			System.out.println("Vous avez choisi le " + choixDefenseur);
			System.out.println("C'est a l'ordinateur de trouver votre combinaison secrete.");
			logger.info("Le joueur a choisi le mode defenseur du jeu mastermind.");
			propriete = new DefenseurMastermind();
		} else if (jeu == '2' && modeJeu == '3') {
			System.out.println("Vous avez choisi le " + choixDuel);
			System.out.println(
					"L'ordinateur et vous jouez tour a tour, le premier a trouver la combinaison secrete de l'autre a gagne.");
			logger.info("Le joueur a choisi le mode duel du jeu mastermind.");
			propriete = new DuelMastermind();
		}
	return propriete;
	}	
}