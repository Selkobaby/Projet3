package main.java.Recherche;

import java.util.ArrayList;

import main.java.ClasseCreationJeux.Humain;
import main.java.ClasseCreationJeux.Ordi;
import main.java.ClasseCreationJeux.Utilitaire;
import main.java.ClasseUtiliserRessources.EcrireJournal;
import main.java.ClasseUtiliserRessources.Propriete;

public class DefenseurRecherche extends EcrireJournal implements Propriete {

	public static void DefenseurR() {

		// Saisir la combinaison que l'ordinateur doit deviner
		System.out.println("\nSaisir une combinaison a 4 chiffres entre 0 et 9 ");
		ArrayList<Integer> codeJoueur = Humain.codeJoueur();
		logger.info("Le joueur a saisi la combinaison que l'ordi doit trouver.");
		
		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des proprietes : " + "nombre d'essais : " + essaiMax);
		
		ArrayList<Integer> propositionOrdi = null;
		String resultat = null;

		while (essaiMax > 0) {

			// Faire une proposition
			propositionOrdi = Ordi.codeAleatoireRecherche(propositionOrdi, resultat);
			if(propositionOrdi == null) {
				logger.info("L'ordi a saisi une proposition.");
			}else {
				logger.info("L'ordi a saisi une nouvelle proposition.");
			}
		
			// Compare les 2 combinaisons 
			resultat = Utilitaire.getResultatRechercher(codeJoueur, propositionOrdi);
			
			System.out.print("Proposition : ");
			for (int j = 0; j < codeJoueur.size(); j++) {
				System.out.print(propositionOrdi.get(j));
			}
			
			System.out.print(" -> reponse : ");
			System.out.println(resultat);
			
			// Afficher la victoire si la combinaison est ====
			if (resultat.equals("====")) {
				System.out.println("Bravo, vous avez gagne");
				essaiMax = 0;
			}
			essaiMax--;
			
			//si le nombre maximum d'essai est atteint l'ordinateur a perdu
			if (essaiMax == 0) {
				System.out.print("Perdu, la combinaison du joueur etait ");
				for (int i = 0; i <codeJoueur.size() ; i++) {
					System.out.print(codeJoueur.get(i));
				}
				System.out.println(".");
			}
		}
	}
}