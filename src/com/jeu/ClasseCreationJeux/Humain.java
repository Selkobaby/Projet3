package com.jeu;

import java.util.ArrayList;

import java.util.Scanner;

public class Humain {
	
	/*
	 * codeJoueur permet de recuperer le code e  4 chiffres que va saisir le Joueur
	 */
	public static ArrayList<Integer> codeJoueur() {

		int nbreChiffresCombi = 4;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		ArrayList<Integer> code = new ArrayList<Integer>();
		String str = null;
		do {
			str = sc.nextLine();
			//Converti l'objet String en un tableau de caractere
			char[] tab = str.toCharArray();
			code.clear();
			for (int i = 0; i < str.length(); i++) {
					//Converti le tableau de caractere en un nombre entier
					code.add(Integer.parseInt(Character.toString(tab[i])));
			}
		} while (str.length() != nbreChiffresCombi);
		return code;
	}
}