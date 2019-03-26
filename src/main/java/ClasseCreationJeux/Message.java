package ClasseCreationJeux;

import java.util.Scanner;

public class Message {

	private static Scanner sc = new Scanner(System.in);
	private static Scanner scan = new Scanner(System.in);

	public static char messageJeu() {

		char jeu = ' ';
		System.out.println("CHOIX DU JEU");
		System.out.println("1 - Recherche+/-");
		System.out.println("2 - Mastermind");
		System.out.println("3 - quitter\n");
		jeu = sc.next().charAt(0);

		return jeu;
	}

	public static char messageMode() {

		char modeJeu = ' ';
		System.out.println("CHOIX DU MODE DE JEU");
		System.out.println("1 - Mode challenger");
		System.out.println("2 - Mode defenseur");
		System.out.println("3 - Mode duel");
		modeJeu = sc.next().charAt(0);

		return modeJeu;
	}

	public static char messageFin() {

		char resultatChoix = ' ';
		System.out.println();
		System.out.println("Voulez-vous rejouer au meme jeu ? (o/n)");
		resultatChoix = scan.nextLine().charAt(0);

		return resultatChoix;
	}
}
