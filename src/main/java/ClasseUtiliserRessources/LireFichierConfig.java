package com.jeu.ClasseUtiliserRessources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LireFichierConfig {
	
	public Properties getProperties() {
		
		Properties properties = new Properties();
		
		try {
			String fichierConfig = System.getProperty("user.dir") + "\\" + "ressources\\res\\config.properties";
			//Cr�e un FileInputStreamen ouvrant une connexion � un fichier r�el, le fichier nomm� par le nom du chemin d'acc�s name dans le syst�me de fichiers.
			FileInputStream in = new FileInputStream(fichierConfig);
			//Lit une liste de propri�t�s � partir du flux d'octets en entr�e.
			properties.load(in);
			//Ferme ce flux d'entr�e de fichier et lib�re toutes les ressources syst�me associ�es au flux.
			in.close();
		} catch (IOException e) {
			System.out.println("Erreur de chargement du fichier de configuration !");
			System.out.println(e.getMessage());
		}
		return properties;
	}

}
