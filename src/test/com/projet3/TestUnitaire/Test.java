package com.test;


import com.main.java.FonctionsJeux.Ordi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Test {

	@org.junit.jupiter.api.Test
	void testNbreChiffresCombiOrdi() {
		assertEquals(4, Ordi.codeAleatoireMastermind().size());
	}

	@org.junit.jupiter.api.Test
	void testValeurCombiMax() {
		int[] tab = new int[4];
		for (int i = 0; i < Ordi.codeAleatoireMastermind().size(); i++) {
			tab[i] = Ordi.codeAleatoireMastermind().get(i);
		}
		assertTrue(tab[0] <= 6 && tab[1] <= 6 && tab[2] <= 6 && tab[3] <= 6);
	}
}
