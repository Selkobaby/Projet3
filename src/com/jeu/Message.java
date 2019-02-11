package com.jeu;

import java.util.Scanner;

public class Message {
	
	public static char messageJeu() {
		
		char jeu = ' ';
		System.out.println("CHOIX DU JEU");
		System.out.println("1 - Recherche+/-");
		System.out.println("2 - Mastermind");
		System.out.println("3 - quitter\n");				
		Scanner sc = new Scanner(System.in);
		jeu = sc.next().charAt(0);
		
		return jeu;
	}
	
	public static char messageMode() {
		
		char modeJeu = ' ';
		System.out.println("CHOIX DU MODE DE JEU");
		System.out.println("1 - Mode challenger");
		System.out.println("2 - Mode défenseur");
		System.out.println("3 - Mode duel");
		Scanner sc = new Scanner(System.in);
		modeJeu = sc.next().charAt(0);
		
		return modeJeu;
	}
	
	public static char messageFin() {
		
		char resultatChoix = ' ';
		System.out.println();
		System.out.println("Voulez-vous rejouer au même jeu ? (o/n)");
		Scanner scan = new Scanner(System.in);
		resultatChoix = scan.nextLine().charAt(0);
		
		return resultatChoix;
	}
}
