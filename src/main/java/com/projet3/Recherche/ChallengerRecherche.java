package com.projet3.Recherche;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.projet3.FonctionsJeux.Humain;
import com.projet3.FonctionsJeux.Ordi;
import com.projet3.FonctionsJeux.Utilitaire;
import com.projet3.UtiliserRessources.Propriete;

public class ChallengerRecherche implements Propriete {
	
	private static Logger logger = Logger.getLogger(Logger.class);

	public void run(Properties properties) {

		// generer la combinaison aleatoire
		ArrayList<Integer> codeAleatoire = Ordi.codeAleatoireR();
		logger.info("L'ordi a saisi la combinaison que le joueur doit trouver.");

		int essaiMax = Integer.parseInt(properties.getProperty("essaiMax"));
		logger.info("Chargement des proprietes : " + "nombre d'essais : " + essaiMax);

		if (properties.get("modeDeveloppeur").equals("true")) {
			System.out.println("La combinaison de l'ordi est : ");
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