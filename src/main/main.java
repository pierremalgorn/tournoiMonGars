package main;

import java.util.Scanner;

import vue.AffichageConsole;
import vue.AffichageGraphique;

public class main {
	
	static AffichageConsole console;
	static AffichageGraphique graphique;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int reponse;
		System.out.println("Bonjour, je suis gentil.\nChoisissez quelle interface vous voulez utiliser :");
		
		do {
			System.out.println("\n\nTapez :\n 1. Pour la version console\n 2. Pour la version graphique\nFaites votre choix : ");
			reponse = sc.nextInt();
		} while (reponse < 1 || reponse > 2);
			
		if(reponse == 1) {
			console = new AffichageConsole();
		} else if (reponse == 2) {
			try {
				AffichageGraphique frame = new AffichageGraphique();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	

}
