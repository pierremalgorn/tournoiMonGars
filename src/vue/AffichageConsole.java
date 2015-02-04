package vue;

import java.util.List;
import java.util.Scanner;

import modele.ATournoi;
import modele.Equipe;
import modele.Match;
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
		int tour = (int) (Math.log(tournoi.getNbEquipes()) / Math.log(2));
		int j;
		
		for(j = 0 ; j < tour ; j++){
			controleur.creerTour();
		}
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
		
		
	}
	
	public void demandeScores(){
		
		List<Match> tour = tournoi.getTour();
		Scanner sc = new Scanner(System.in);
		int score1, score2;
		
		for(Match match : tour){
			System.out.println("Quels est le résultat du match "+match.getEq1().getNom()+" - "+match.getEq2().getNom()+" ?");
			System.out.println(match.getEq1().getNom()+" : ");
			score1 = sc.nextInt();			
			System.out.println(match.getEq2().getNom()+" : ");
			score2 = sc.nextInt();
			
			tournoi.setScore(match, score1, score2);
		}
		
	}
	
	public void afficherTour() {
		List<Match> tour = tournoi.getTour();
		System.out.println("Voici les équipes qui vont s'affronter au prochain tour :\n");
		for(Match match : tour) {
			System.out.println(match.getNomEq1()+" vs "+match.getNomEq2()+"      ");
		}
	}
	
	public void clearScreen() {
		System.out.println("\f");
	}
}
