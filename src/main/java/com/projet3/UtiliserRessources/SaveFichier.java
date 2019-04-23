package com.main.java.UtiliserRessources;

import org.apache.log4j.xml.DOMConfigurator;

public class SaveFichier {

	public void fichierJournal() {

		// recupere le repertoire ou le chemin de l'espace de travail pour le projet en
		// cours
		String sauvegarde = System.getProperty("user.dir") + "\\" + "main\ressources\\journal.txt";
		// configure sauvegarde tel que defini dans le journal log4j.dtd.
		DOMConfigurator.configure(sauvegarde);

	}

}
