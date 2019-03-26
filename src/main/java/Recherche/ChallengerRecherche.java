package Recherche;

import java.util.ArrayList;

import ClasseCreationJeux.Humain;
import ClasseCreationJeux.Ordi;
import ClasseCreationJeux.Utilitaire;
import ClasseUtiliserRessources.EcrireJournal;
import ClasseUtiliserRessources.Propriete;

public class ChallengerRecherche extends EcrireJournal implements Propriete {

	public static void ChallengerR() {

		// generer la combinaison aleatoire
		ArrayList<Integer> codeAleatoire = Ordi.codeAleatoireR();
		logger.info("L'ordi a saisi la combinaison que le joueur doit trouver.");

		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des proprietes : " + "nombre d'essais : " + essaiMax);

		if (properties.get("developerMode").equals("true")) {
			System.out.print("La combinaison de l'ordi est : ");
			for (int i = 0; i < codeAleatoire.size(); i++) {
				System.out.print(codeAleatoire.get(i));
			}
		}

		while (essaiMax > 0) {

			System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 9");
			ArrayList<Integer> proposition = Humain.codeJoueur();
			logger.info("Le joueur a saisi une combinaison a 4 chiffres");

			System.out.print("Proposition : ");
			for (int i = 0; i < codeAleatoire.size(); i++) {
				System.out.print(proposition.get(i));
			}
			System.out.print("\nReponse : ");

			// recherche du resultat de la proposition
			String resultat = Utilitaire.getResultatRechercher(codeAleatoire, proposition);

			// affichage du resultat
			System.out.println(resultat);
			logger.info("Affichage du resultat de la combinaison.");

			// Afficher la victoire si la combinaison est ====
			if (resultat.equals("====")) {
				System.out.println("Bravo, vous avez gagne.");
				logger.info("Le joueur a gagne");
				essaiMax = 0;
			}
			essaiMax--;

			// Afficher la combinaison avec les bon resultat
			if (essaiMax == 0) {
				logger.info("Le joueur a perdu.");
				System.out.print("Perdu, la combinaison de l'ordinateur etait : ");
				logger.info("Affichage de la combinaison");
				for (int i = 0; i < codeAleatoire.size(); i++) {
					System.out.print(codeAleatoire.get(i));
				}
			}
		}
	}
}