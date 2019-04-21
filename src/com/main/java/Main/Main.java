package com.main.java.Main;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.main.java.FonctionsJeux.Choix;
import com.main.java.FonctionsJeux.Message;
import com.main.java.UtiliserRessources.LireFichierConfig;
import com.main.java.UtiliserRessources.Propriete;
import com.main.java.UtiliserRessources.SaveFichier;

public class Main {
	
	private static Logger logger = Logger.getLogger(Logger.class);

	public static void main(String[] args) {

		String fichierLog4j = System.getProperty("user.dir") + "/" + "src/com/main/ressources/log4j.xml";
		DOMConfigurator.configure(fichierLog4j);

		new SaveFichier();
		LireFichierConfig lireFichier = new LireFichierConfig();
		Properties properties = lireFichier.getProperties();

		if (args.length > 0) {
			if (args[0].equals("true")) {
				properties.setProperty("modeDeveloppeur", "true");
			}
		}
		
		String jeuRecherche = "Recherche+/-";
		String jeuMastermind = "Mastermind";

		char resultatChoix = ' ', jeu = ' ', modeJeu = ' ';

		System.out.println();

		do {
			do {
				jeu = Message.messageJeu();

				if (jeu != '1' && jeu != '2' && jeu != '3') {
					System.out.println("Vous devez choisir entre 1, 2, ou 3");
					logger.info("Le joueur n'a pas choisi 1,2 ou 3 pour le jeu.");
				}
				if (jeu == '1') {
					System.out.print("Vous avez choisi le jeu " + jeuRecherche + "\n");
					logger.info("Le joueur a choisi le jeu de recherche.");
					System.out.println();
				} else if (jeu == '2') {
					System.out.println("Vous avez choisi le jeu " + jeuMastermind + "\n");
					logger.info("Le joueur a choisi le jeu de recherche.");
					System.out.println();
				} else if (jeu == '3') {
					System.out.println("Fin du jeu");
					logger.info("Le joueur a quitte le jeu.");
					System.out.println();
				}

			} while (jeu != '1' && jeu != '2' && jeu != '3');

			if (jeu == '1' || jeu == '2') {
				do {
					do {
						modeJeu = Message.messageMode();

						if (modeJeu != '1' && modeJeu != '2' && modeJeu != '3') {
							System.out.println("Vous devez choisir entre 1, 2 ou 3");
						logger.info("Le joueur n'a pas choisi 1,2 ou 3 pour le mode de jeu.");
						}
					} while (modeJeu != '1' && modeJeu != '2' && modeJeu != '3');

					Propriete modeGame = Choix.get(jeu, modeJeu);
					modeGame.run(properties);

					do {
						resultatChoix = Message.messageFin();

					} while (resultatChoix != 'o' && resultatChoix != 'n');

				} while (resultatChoix == 'o');
			}
		} while (jeu != '3');

		System.out.println("A bientot !");
	}
}