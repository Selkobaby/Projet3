package com.jeu.ClasseUtiliserRessources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LireFichierConfig {
	
	public Properties getProperties() {
		
		Properties properties = new Properties();
		
		try {
			String fichierConfig = System.getProperty("user.dir") + "\\" + "ressources\\res\\config.properties";
			//Crée un FileInputStreamen ouvrant une connexion à un fichier réel, le fichier nommé par le nom du chemin d'accès name dans le système de fichiers.
			FileInputStream in = new FileInputStream(fichierConfig);
			//Lit une liste de propriétés à partir du flux d'octets en entrée.
			properties.load(in);
			//Ferme ce flux d'entrée de fichier et libère toutes les ressources système associées au flux.
			in.close();
		} catch (IOException e) {
			System.out.println("Erreur de chargement du fichier de configuration !");
			System.out.println(e.getMessage());
		}
		return properties;
	}

}
