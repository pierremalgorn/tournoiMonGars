package vue;

import java.util.Scanner;

public class Salut {
	
	public Salut() {
		
	}
	
	public int salut(){
		Scanner sc;
		int reponse;
		
		do {
			System.out.println("Bonjour, je suis gentil.\nChoisissez votre mode de jeu !\n\nTapez :\n 1. Pour un tournoi à élimination directe\n 2. Pour un tournoi à coqs\nFaites votre choix : ");
			sc = new Scanner(System.in);
			reponse = sc.nextInt();
		} while (reponse < 1 || reponse > 2);
		sc.close();
		
		return reponse;	
		
	}
}
