package main.java.Mastermind;

import java.util.ArrayList;

import main.java.ClasseCreationJeux.Humain;
import main.java.ClasseCreationJeux.Ordi;
import main.java.ClasseCreationJeux.Utilitaire;
import main.java.ClasseUtiliserRessources.EcrireJournal;
import main.java.ClasseUtiliserRessources.Propriete;

public class ChallengerMastermind extends EcrireJournal implements Propriete  {

	public static void ChallengerM() {

		// generer une combinaison alatoire
		ArrayList<Integer> codeAleatoire = Ordi.codeAleatoireMastermind();
		logger.info("L'ordi a saisi la combinaison que le joueur doit trouver.");
		
		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des proprietes : " + "nombre d'essais : " + essaiMax);
		
		if (properties.get("developerMode").equals("true")) {
			System.out.print("La combinaison de l'ordi est : ");
			for (int i = 0; i < codeAleatoire.size() ; i++) {
				System.out.print(codeAleatoire.get(i));
			}
		}
		
		while (essaiMax > 0) {
			
			//Saisir une combinaison e 4 chiffres.
			System.out.println();
			System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 6.");
			ArrayList<Integer> proposition = Humain.codeJoueur();
			logger.info("Le joueur a saisi une combinaison a 4 chiffres.");
	
			//recherche des bien et mal place de la proposition du joueur
			int bienPlace = Utilitaire.getBienPlace(codeAleatoire, proposition);
			int malPlace = Utilitaire.getMalPlace(codeAleatoire, proposition);
			
			// Affichage de la combinaison propose
			System.out.print("Proposition du Joueur : ");
			for (int i = 0; i < codeAleatoire.size(); i++) {
				System.out.print(proposition.get(i));
			}
			System.out.print("\nReponse : ");

			//Le resultat de chaque comparaison
			System.out.print(bienPlace + " bien place et " + malPlace + " mal place ");
			logger.info("Affichage du resultat de la combinaison du joueur.");
			
			if (bienPlace == codeAleatoire.size()) {
				System.out.println("\nBravo vous avez gagne !");
				logger.info("Le joueur a gagner");
				essaiMax = 0;
			}
			essaiMax--;

			/* Si le nombre d'essai atteint 0, le jeu affiche 
			la bonne combinaison qui indique que le joueur a perdu */
			if (essaiMax == 0) {
				logger.info("Le joueur a perdu");
				System.out.println("Perdu, la combinaison de l'ordinateur etait : ");
				logger.info("Affichage de la combinaison de l'ordi");
				for (int i = 0; i < codeAleatoire.size(); i++) {
					System.out.print(codeAleatoire.get(i));
				}
			}
		}
	}
}