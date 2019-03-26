package Main;

import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import ClasseCreationJeux.Choix;
import ClasseCreationJeux.Message;
import ClasseUtiliserRessources.EcrireJournal;
import ClasseUtiliserRessources.LireFichierConfig;
import ClasseUtiliserRessources.Propriete;
import ClasseUtiliserRessources.SaveFichier;

public class Main extends EcrireJournal implements Propriete {

	public static void main(String[] args) {

		String fichierLog4j = System.getProperty("user.dir") + "\\" + "Projet3\\src\\main\\ressources\\log4j.xml";
		DOMConfigurator.configure(fichierLog4j);

		new SaveFichier();
		LireFichierConfig lireFichier = new LireFichierConfig();
		Properties properties = lireFichier.getProperties();

		if (args.length > 0) {
			if (args[0].equals("true")) {
				properties.setProperty("developerMode", "true");
			}
		}

		String jeuRecherche = "Recherche+/-";
		String jeuMastermind = "Mastermind";

		char resultatChoix = ' ', jeu = ' ', modeJeu = ' ';

		System.out.println();

		do {
			do {
				jeu = Message.messageJeu();

				if (jeu != '1' && jeu != '2' && jeu != '3')
					System.out.println("Vous devez choisir entre 1, 2, ou 3");
				logger.info("Le joueur n'a pas choisi 1,2 ou 3 pour le jeu.");

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

						if (modeJeu != '1' && modeJeu != '2' && modeJeu != '3')
							System.out.println("Vous devez choisir entre 1, 2 ou 3");
						logger.info("Le joueur n'a pas choisi 1,2 ou 3 pour le mode de jeu.");

					} while (modeJeu != '1' && modeJeu != '2' && modeJeu != '3');

					Choix.getMode(jeu, modeJeu);

					do {
						resultatChoix = Message.messageFin();

					} while (resultatChoix != 'o' && resultatChoix != 'n');

				} while (resultatChoix == 'o');
			}
		} while (jeu != '3');

		System.out.println("A bientot !");
	}
}