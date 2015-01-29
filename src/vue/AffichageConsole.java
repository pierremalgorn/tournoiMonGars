package vue;

import java.util.Scanner;

import modele.ATournoi;
import modele.TournoiElimination;
import modele.TournoiPoules;
import controleur.ATournoiControleur;
import controleur.TournoiEliminationControleur;
import controleur.TournoiPoulesControleur;

public class AffichageConsole {
	
	ATournoi tournoi;
	ATournoiControleur controleur;
	
	public AffichageConsole() {
		Scanner sc;
		int reponse;
		System.out.println("Bonjour, je suis gentil.");		
		
		//Demande du mode de jeu
		do {
			System.out.println("\nChoisissez votre mode de jeu !\n\nTapez :\n 1. Pour un tournoi à élimination directe\n 2. Pour un tournoi à coqs\nFaites votre choix : ");
			sc = new Scanner(System.in);
			reponse = sc.nextInt();
		} while (reponse < 1 || reponse > 2);
		
		if(reponse == 1) {
			tournoi = initialisationTournoi(reponse); //Set les caractéristiques du tournoi
			controleur = (ATournoiControleur) new TournoiEliminationControleur(tournoi);
		} else if (reponse == 2) {
			tournoi = initialisationTournoi(reponse); //Set les caractéristiques du tournoi
			controleur = (ATournoiControleur) new TournoiPoulesControleur(tournoi);
		}
		
		
		
		this.start();
	}
	
	public void start() {
		
	}

	public ATournoi initialisationTournoi(int typeTournoi) {
		
		Scanner sc = new Scanner(System.in);
		clearScreen();
		System.out.println("Tapez le nom du tournoi : ");
		String nomTournoi = sc.nextLine();
		
		int temps;
		do {
			System.out.println("\n\nEntrez le temps de match en minutes (mini 1 min, maxi 120 min) : ");
			temps = sc.nextInt();
		} while (temps < 1 || temps > 120);
		
		int nbEquipes;
		do {
			System.out.println("\n\nEntrez le nombre d'équipes pair désirées (mini 2, maxi 8) : ");
			nbEquipes = sc.nextInt();
		} while (nbEquipes < 1 || nbEquipes > 120 || (nbEquipes % 2) != 0);
		
		sc.close();
		
		if(typeTournoi == 1) {
			return new TournoiElimination(nomTournoi, temps, nbEquipes);
		}
		else {
			return new TournoiPoules(nomTournoi, temps, nbEquipes);
		}
		
	}
	
	public void clearScreen() {
		System.out.println("\f");
	}
}