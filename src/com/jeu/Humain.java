package com.jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class Humain {
	
	Scanner sc = new Scanner (System.in);
	
	/*
	 * codeJoueur permet de récupérer le code à  4 chiffres que va saisir le Joueur
	 * pour le mode Mastermind
	 */
	public ArrayList<Integer> codeJoueur() {

		ArrayList<Integer> code = new ArrayList<Integer>();
		String str = null;
		do {
			str = sc.nextLine();
			//Converti l'objet String en un tableau de caractère
			char[] tab = str.toCharArray();
			code.clear();
			for (int i = 0; i < str.length(); i++) {
					//Converti le tableau de caractere en un nombre entier
					code.add(Integer.parseInt(Character.toString(tab[i])));
			}
		} while (str.length() != code.size());
		return code;
	}
}