package com.projet3.UtiliserRessources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LireFichierConfig {

	public Properties getProperties() {

		Properties properties = new Properties();

		try {
			String fichierConfig = System.getProperty("user.dir") + "/" + "src/main/ressources/config.properties";
			// Cree un FileInputStreamen ouvrant une connexion e un fichier reel, le fichier
			// nomme par le nom du chemin d'acces name dans le systeme de fichiers.
			FileInputStream in = new FileInputStream(fichierConfig);
			// Lit une liste de proprietes a partir du flux d'octets en entree.
			properties.load(in);
			// Ferme ce flux d'entree de fichier et libere toutes les ressources systeme
			// associees au flux.
			in.close();
		} catch (IOException e) {
			System.out.println("Erreur de chargement du fichier de configuration !");
			System.out.println(e.getMessage());
		}
		return properties;
	}

}
