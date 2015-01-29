package vue;

import java.util.Scanner;

public class Salut {
	
	public Salut() {
		
	}
	
	public int salut(){
		Scanner sc;
		int reponse;
		System.out.println("Bonjour, je suis gentil.\nChoisissez quelle interface vous voulez utiliser :");
		
		do {
			System.out.println("\n\nTapez :\n 1. Pour la version console\n 2. Pour la version graphique\nFaites votre choix : ");
			sc = new Scanner(System.in);
			reponse = sc.nextInt();
		} while (reponse < 1 || reponse > 2);
		sc.close();
		
		
		return reponse;	
		
	}
}
