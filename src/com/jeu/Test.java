package com.jeu;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void testNbreChiffresCombiOrdi() {
		assertEquals(4, Ordi.codeAleatoire().size());
	}
	
	@org.junit.jupiter.api.Test
	void testValeurCombiMax() {
		int[] tab = new int [4];
		for(int i = 0 ; i < Ordi.codeAleatoire().size(); i++) {
			tab[i] = Ordi.codeAleatoire().get(i);
		}
		assertTrue(tab[0] <= 6 && tab[1] <= 6 && tab[2] <= 6 && tab[3] <= 6);
	}
	
	@org.junit.jupiter.api.Test
	void testGagneMastermind() {
		int bienPlace = Utilitaire.getBienPlace(Ordi.codeAleatoire(), Humain.codeJoueur());
		assertTrue(bienPlace == 4);
	}
	
	
	
	
	

}
