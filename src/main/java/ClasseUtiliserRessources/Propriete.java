package main.java.ClasseUtiliserRessources;

import java.util.Properties;

public interface Propriete {

	static LireFichierConfig lireFichier = new LireFichierConfig();
	static Properties properties = lireFichier.getProperties();

}
