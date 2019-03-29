package main.java.ClasseCreationJeux;

import main.java.ClasseUtiliserRessources.EcrireJournal;
import main.java.ClasseUtiliserRessources.Propriete;
import main.java.Mastermind.ChallengerMastermind;
import main.java.Mastermind.DefenseurMastermind;
import main.java.Mastermind.DuelMastermind;
import main.java.Recherche.ChallengerRecherche;
import main.java.Recherche.DefenseurRecherche;
import main.java.Recherche.DuelRecherche;

public class Choix extends EcrireJournal{

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