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
		System.out.println("Bonjour, je suis gentil.");	
		
		initialisationTournoi();
		
		this.start();
	}
	
	public void start() {
		
	}

	public void initialisationTournoi() {
		
		Scanner sc;
		int typeTournoi;
		
		//Demande du mode de jeu
		do {
			System.out.println("\nChoisissez votre mode de jeu !\n\nTapez :\n 1. Pour un tournoi à élimination directe\n 2. Pour un tournoi à coqs\nFaites votre choix : ");
			sc = new Scanner(System.in);
			typeTournoi = sc.nextInt();
		} while (typeTournoi < 1 || typeTournoi > 2);
		
		sc = new Scanner(System.in);
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
			tournoi = new TournoiElimination(nomTournoi, temps, nbEquipes);
			controleur = new TournoiEliminationControleur(tournoi);
		}
		else {
			tournoi = new TournoiPoules(nomTournoi, temps, nbEquipes);
			controleur = new TournoiPoulesControleur(tournoi);
		}
		
		controleur.afficherTour();
		
	}
	
	public void affichageTours(int nbTour){
		System.out.println("Quels sont les résultats des matchs du tour "+ nbTour+" ?");
		
	}
	
	public void clearScreen() {
		System.out.println("\f");
	}
}
