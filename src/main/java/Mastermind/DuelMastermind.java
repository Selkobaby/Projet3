package Mastermind;

import java.util.ArrayList;

import ClasseCreationJeux.Humain;
import ClasseCreationJeux.Ordi;
import ClasseCreationJeux.Utilitaire;
import ClasseUtiliserRessources.EcrireJournal;
import ClasseUtiliserRessources.Propriete;

public class DuelMastermind extends EcrireJournal implements Propriete {

	public static void DuelM() {

		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des proprietes : " + "nombre d'essais : " + essaiMax);

		ArrayList<Integer> propositionOrdi = null;

		// code que le joueur doit trouver
		ArrayList<Integer> codeJoueurCherche = Ordi.codeAleatoireMastermind();
		logger.info("L'ordi a saisi la combinaison que le joueur doit trouver.");

		// code que l'ordi doit trouver
		System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 6 que l'ordinateur devra deviner.");
		ArrayList<Integer> codeOrdiCherche = Humain.codeJoueur();
		logger.info("Le joueur a saisi la combinaison que l'ordi doit trouver.");

		System.out.print("Votre combinaison : ");
		for (int i = 0; i < codeJoueurCherche.size(); i++) {
			System.out.print(codeOrdiCherche.get(i));
		}

		if (properties.get("developerMode").equals("true")) {
			System.out.print("La combinaison de l'ordi est : ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(codeJoueurCherche.get(i));
			}
		}

		while (essaiMax > 0) {

			// proposition du joueur
			System.out.println("\nQuel est votre proposition ?");
			ArrayList<Integer> propositionJoueur = Humain.codeJoueur();
			logger.info("Le joueur a saisie une combinaison.");

			// recherche des bien et mal place de la proposition du joueur
			int bienPlaceJ = Utilitaire.getBienPlace(codeJoueurCherche, propositionJoueur);
			int malPlaceJ = Utilitaire.getMalPlace(codeJoueurCherche, propositionJoueur);

			System.out.print("Proposition du joueur: ");
			for (int i = 0; i < codeJoueurCherche.size(); i++) {
				System.out.print(propositionJoueur.get(i));
			}
			// Le resultat de chaque comparaison
			System.out.println("\nReponse : " + bienPlaceJ + " bien place et " + malPlaceJ + " mal place ");
			System.out.println();
			logger.info("Affichage du resultat de la combinaison du joueur.");

			// proposition de l'ordi
			propositionOrdi = Ordi.codeAleatoireMastermind();
			logger.info("L'ordi a saisie une combinaison.");

			// recherche des bien et mal place de la proposition de l'ordi
			int bienPlaceOrdi = Utilitaire.getBienPlace(codeOrdiCherche, propositionOrdi);
			int malPlaceOrdi = Utilitaire.getMalPlace(codeOrdiCherche, propositionOrdi);

			System.out.println("Proposition Ordi: ");
			for (int i = 0; i < codeOrdiCherche.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
			// Le resultat de chaque comparaison
			System.out.print("\nReponse : " + bienPlaceOrdi + " bien place et " + malPlaceOrdi + " mal place ");
			System.out.println();
			logger.info("Affichage du resultat de la combinaison de l'ordi.");

			// Affiche le vainqueur de la parti
			if (bienPlaceJ == codeJoueurCherche.size()) {
				System.out.println("\nBravo, vous avez gagne !");
				logger.info("Le joueur a gagne");
				essaiMax = 0;
			} else if (bienPlaceOrdi == codeOrdiCherche.size()) {
				System.out.println("\nBravo, ordinateur vous avez gagne !");
				logger.info("L'ordi a gagne");
				essaiMax = 0;
			}
			essaiMax--;

			// Affiche la combinaison de chacun si le nombre d'essais maximum est atteint
			if (essaiMax == 0) {
				System.out.print("\nVous avez perdu.");
				logger.info("Le joueur a perdu.");
				System.out.println("\nLa combinaison de l'ordinateur etait ");
				logger.info("Affichage de la combinaison de l'ordi.");
				for (int i = 0; i < codeJoueurCherche.size(); i++) {
					System.out.print(codeJoueurCherche.get(i));
				}
				System.out.print(".");
				System.out.println();
				logger.info("L'ordi a perdu.");
				System.out.println("La combinaison du joueur etait ");
				logger.info("Affichage de la combinaison du joueur.");
				for (int i = 0; i < codeOrdiCherche.size(); i++) {
					System.out.print(codeOrdiCherche.get(i));
				}
				System.out.print(".");
			}
		}
	}
}