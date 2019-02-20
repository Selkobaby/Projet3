package com.jeu.Mastermind;

import java.util.ArrayList;

import com.jeu.ClasseCreationJeux.Humain;
import com.jeu.ClasseCreationJeux.Ordi;
import com.jeu.ClasseCreationJeux.Utilitaire;
import com.jeu.ClasseUtiliserRessources.EcrireJournal;
import com.jeu.ClasseUtiliserRessources.Propriete;

public class DefenseurMastermind extends EcrireJournal implements Propriete  {

	public static void DefenseurM () {;
		
		// Saisi d'une combinaison par le joueur
		System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 6 que l'ordinateur devra deviner.");
		ArrayList<Integer> codeJoueur = Humain.codeJoueur();
		logger.info("Le joueur a saisi la combinaison que l'ordi doit trouver.");

		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des propriétés : " + "nombre d'essais : " + essaiMax);
		
		while (essaiMax > 0) {

			//Generation automatique d'une combinaison a chaque tours
			ArrayList<Integer> propositionOrdi = Ordi.codeAleatoireMastermind();
			
			//recherche des bien et mal place de la proposition de l'ordi
			int bienPlace = Utilitaire.getBienPlace(codeJoueur, propositionOrdi);
			int malPlace = Utilitaire.getMalPlace(codeJoueur, propositionOrdi);

			System.out.println("Proposition : ");
			for (int i = 0; i < codeJoueur.size(); i++) {
				System.out.print(propositionOrdi.get(i));
			}
		
			//Le resultat de chaque comparaison
			System.out.println("\nReponse : " + bienPlace + " bien place et " 
					+ malPlace + " mal place ");
			System.out.println();
			logger.info("Affichage du resultat de la combinaison de l'ordi");

			if (bienPlace == codeJoueur.size()) {
				System.out.println("\nBravo, vous avez gagne.");
				logger.info("L'ordi a gagner.");
				essaiMax = 0;
			}
			essaiMax--;
			
			//Si le nombre d'essais max est atteint, le resultat est affcher avec l'indication perdu
			if (essaiMax == 0) {
				logger.info("L'ordi a perdu");
				System.out.println("Perdu, la combinaison du joueur etait ");
				logger.info("Affichage de la combinaison du joueur.");
				for(int i = 0; i < codeJoueur.size(); i++) {
					System.out.print(codeJoueur.get(i));
				}
			}
		}
	}
}