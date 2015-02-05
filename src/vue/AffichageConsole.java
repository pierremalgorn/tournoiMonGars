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
	Scanner sc;
	
	public AffichageConsole() {
		System.out.println("Bonjour, je suis gentil.");	
		initialisationTournoi();
		
		while(true) {
			menuPrincipal();
		}
		
	}
	
	public void modifierEquipes() {
		System.out.println("Il y a actuellement "+tournoi.getNbEquipes()+" équipes dans le tournoi :");
		List<Equipe> equipes = tournoi.getEquipes();
		int choix;
		int nbJoueurs;
		
		for (int i = 0 ; i < equipes.size() ; i++) {
			System.out.println("Equipe "+(i+1)+" : "+equipes.get(i).getNom());
			System.out.println("           "+equipes.get(i).getNbJoueurs()+ " joueurs");
			System.out.println("           "+equipes.get(i).getNomEntraineur()+" est l'entraîneur de cette équipe");			
		}
		do {
			System.out.println("\nVeuillez choisir l'équipe que vous souhaitez modifier : ");
			choix = getPosIntTyped();
		} while (choix == -1 );
		
		System.out.println("Vous modifiez l'équipe "+choix+", veuillez taper : ");
		System.out.println("   Le nom de l'équipe : ");
		String nom = getStringTyped();
		
		do {	
			System.out.println("   Le nombre de joueurs dans l'équipe : ");
			nbJoueurs = getPosIntTyped();
		} while (nbJoueurs == -1 );
		
		System.out.println("   Le nom de l'entraîneur : ");
		String nomEntraineur = getStringTyped();
		
		controleur.modifierEquipe();
	}
	
	public void clearScreen() {
		for(int i = 0 ; i < 50 ; i++) {
			System.out.println();
		}
	}
	
	public int getPosIntTyped(){
		sc = new Scanner(System.in);
		try {
			return sc.nextInt();
		} catch (Exception e){
			return -1;
		}
	}
	
	public String getStringTyped() {
		sc = new Scanner(System.in);
		return sc.next();
	}
	
	public void menuPrincipal() {
		int choix;
		
		do {
			clearScreen();
			
			System.out.println("\nBienvenue dans le menu principal, voici les options disponibles :");
			System.out.println("   1. Modifier les paramètres du tournoi");
			System.out.println("   2. Modifier les équipes");
			System.out.println("   3. Lancer le tournoi");
			System.out.println("   4. Quitter le jeu");
			System.out.println("\n\nFaites votre choix : ");
			choix = getPosIntTyped();
		} while (choix  < 1 || choix > 4);
		
		switch(choix) {
		case 1 : 
			initialisationTournoi();
			break;
		
		case 2 :
			modifierEquipes();
			break;
			
		case 3 :
			start();
			break;
			
		case 4 :
			System.exit(0);
		}
		
	}
	
	public void start() {
		int tour = (int) (Math.log(tournoi.getNbEquipes()) / Math.log(2));
		int j;
		
		for(j = 0 ; j < tour ; j++){
			controleur.creerTour();
			afficherTour();
			demandeScores();
		}
		System.out.println("And the winner isssss : "+tournoi.getWinnerName());
	}

	public void initialisationTournoi() {

		int typeTournoi;
		
		//Demande du mode de jeu
		do {
			System.out.println("\nChoisissez votre mode de jeu !\n\nTapez :\n 1. Pour un tournoi à élimination directe\n 2. Pour un tournoi à coqs\nFaites votre choix : ");
			typeTournoi = getPosIntTyped();
		} while (typeTournoi < 1 || typeTournoi > 2);
		
		System.out.println("Tapez le nom du tournoi : ");
		String nomTournoi = getStringTyped();
		
		int temps;
		do {
			System.out.println("\n\nEntrez le temps de match en minutes (mini 1 min, maxi 120 min) : ");
			temps = getPosIntTyped();
		} while (temps < 1 || temps > 120);
		
		int nbEquipes;
		do {
			System.out.println("\n\nEntrez le nombre d'équipes pair désirées (mini 2, maxi 8) : ");
			nbEquipes = getPosIntTyped();
		} while (nbEquipes < 1 || nbEquipes > 120 || (nbEquipes % 2) != 0);
		

		
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
		int score1, score2;
		
		for(Match match : tour){
			System.out.println("Quels est le résultat du match "+match.getEq1().getNom()+" - "+match.getEq2().getNom()+" ?");
			do {
				System.out.println(match.getEq1().getNom()+" : ");
				score1 = getPosIntTyped();
			} while (choix == -1 );
			
			do {
				System.out.println(match.getEq2().getNom()+" : ");
				score2 = getPosIntTyped();
			} while (choix == -1 );
			
			controleur.setScore(match, score1, score2);
		}
		
	}
	
	public void afficherTour() {
		List<Match> tour = tournoi.getTour();
		clearScreen();
		System.out.println("Voici les équipes qui vont s'affronter au prochain tour :\n");
		for(Match match : tour) {
			System.out.println(match.getNomEq1()+" vs "+match.getNomEq2()+"      ");
		}
	}
}
