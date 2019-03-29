package main.java.Recherche;

import java.util.ArrayList;
import java.util.Properties;

import main.java.ClasseCreationJeux.Humain;
import main.java.ClasseCreationJeux.Ordi;
import main.java.ClasseCreationJeux.Utilitaire;
import main.java.ClasseUtiliserRessources.EcrireJournal;
import main.java.ClasseUtiliserRessources.Propriete;

public class DuelRecherche extends EcrireJournal implements Propriete {

	public void run(Properties properties) {

		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des proprietes : " + "nombre d'essais : " + essaiMax);

		ArrayList<Integer> propositionOrdi = null;
		String resultatJoueur = null;
		String resultatOrdi = null;

		ArrayList<Integer> codeJoueurCherche = Ordi.codeAleatoireR();
		logger.info("L'ordi a saisi la combinaison que le joueur doit trouver.");

		System.out.println("\nSaisir une combinaison entre 0 et 9 a 4 chiffres e faire deviner a l'ordinateur. ");
		ArrayList<Integer> codeOrdiCherche = Humain.codeJoueur();
		logger.info("Le joueur a saisi la combinaison que l'ordi doit trouver.");

		System.out.print("Votre combinaison : ");
		for (int i = 0; i < codeOrdiCherche.size(); i++) {
			System.out.print(codeOrdiCherche.get(i));
		}
		System.out.println();

		if (properties.get("developerMode").equals("true")) {
			System.out.print("La combinaison de l'ordi est : ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(codeJoueurCherche.get(i));
			}
		}

		while (essaiMax > 0) {

			System.out.println("\nSaisir une combinaison entre 0 et 9 a 4 chiffres");
			ArrayList<Integer> propositionJoueur = Humain.codeJoueur();
			if (essaiMax == 10) {
				logger.info("Le joueur a saisi une proposition.");
			} else {
				logger.info("Le joueur a saisi une nouvelle proposition.");
			}

			System.out.print("\nProposition du joueur : ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(propositionJoueur.get(i));
			}
			System.out.print("\nReponse : ");

			// comparer propositionJoueur avec codeJoueurCherche pour donner un resultat
			resultatJoueur = Utilitaire.getResultatRechercher(codeJoueurCherche, propositionJoueur);

			// Affiche le resultat de la proposition du joueur
			System.out.println(resultatJoueur);
			logger.info("Le resultat du joueur est afficher");

			propositionOrdi = Ordi.codeAleatoireRecherche(propositionOrdi, resultatOrdi);
			if (propositionOrdi == null) {
				logger.info("L'ordi a saisi une proposition.");
			} else {
				logger.info("L'ordi a saisi une nouvelle proposition.");
			}

			// Afficher la proposition de l'ordinateur
			System.out.print("\nProposition de l'ordinateur : ");
			for (int i = 0; i < codeOrdiCherche.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
			System.out.print("\nReponse : ");

			// comparer propositionOrdi avec codeOrdiCherche pour donner un resultat (+, -
			// ou =)
			resultatOrdi = Utilitaire.getResultatRechercher(codeOrdiCherche, propositionOrdi);

			// Affiche le resultat
			System.out.println(resultatOrdi);
			logger.info("Le resultat de l'ordi est afficher.");

			// le joueur qui trouve la combinaison de l'autre alors le jeu l'affiche
			if (resultatOrdi.equals("====")) {
				System.out.println("Bravo ordinateur, vous avez gagne.");
				logger.info("L'ordi a gagne.");
				essaiMax = 0;
			} else if (resultatJoueur.equals("====")) {
				System.out.println("Bravo joueur, vous avez gagne.");
				logger.info("Le joueur a gagne.");
				essaiMax = 0;
			}
			essaiMax--;

			// Si aucun des 2 joueurs trouve la combinaison de l'autre avant le nombre
			// d'essai maximum le jeu affiche les 2 combinaison en indiquant perdu
			if (essaiMax == 0) {
				System.out.println("\nVous avez tout les 2 perdu.");
				logger.info("Les 2 joueur ont perdu.");
				System.out.println("La combinaison du joueur etait : ");
				logger.info("Affichage de la combinaison du joueur.");
				for (int i = 0; i < codeOrdiCherche.size(); i++) {
					System.out.print(codeOrdiCherche.get(i));
				}
				System.out.println(".");
				System.out.println("La combinaison de l'ordinateur etait : ");
				logger.info("Affichage de la combinaison de l'ordi.");
				for (int i = 0; i < codeJoueurCherche.size(); i++) {
					System.out.print(codeJoueurCherche.get(i));
				}
			}
		}
	}
}