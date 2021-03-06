package com.projet3.Recherche;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.projet3.FonctionsJeux.Humain;
import com.projet3.FonctionsJeux.Ordi;
import com.projet3.FonctionsJeux.Utilitaire;
import com.projet3.UtiliserRessources.Propriete;

public class DefenseurRecherche implements Propriete {
	
	private static Logger logger = Logger.getLogger(Logger.class);

	public void run(Properties properties) {

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
			if (propositionOrdi == null) {
				logger.info("L'ordi a saisi une proposition.");
			} else {
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
				System.out.println("Bravo ordi, vous avez gagne");
				essaiMax = 0;
			}
			essaiMax--;

			// si le nombre maximum d'essai est atteint l'ordinateur a perdu
			if (essaiMax == 0) {
				System.out.print("Perdu, la combinaison du joueur etait ");
				for (int i = 0; i < codeJoueur.size(); i++) {
					System.out.print(codeJoueur.get(i));
				}
				System.out.println(".");
			}
		}
	}
}