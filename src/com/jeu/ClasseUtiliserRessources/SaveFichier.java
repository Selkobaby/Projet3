package com.jeu.ClasseUtiliserRessources;

import org.apache.log4j.xml.DOMConfigurator;

public class SaveFichier {
	
	public void fichierJournal() {
		
		//r�cup�re le r�pertoire ou le chemin de l'espace de travail pour le projet en cours
		String sauvegarde = System.getProperty("user.dir") + "\\" + "Projet3\\ressources\\res\\journal.txt";
		//configure sauvegarde tel que d�fini dans le journal log4j.dtd.
		DOMConfigurator.configure(sauvegarde);
		
	}

}
