package vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modele.ATournoi;
import modele.Equipe;
import modele.Joueur;
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
	
	public void afficherEquipes() {
		System.out.println("Il y a actuellement "+tournoi.getNbEquipes()+" équipes dans le tournoi :");
		List<Equipe> equipes = tournoi.getEquipes();
		
		for (int i = 0 ; i < equipes.size() ; i++) {
			System.out.println("Equipe "+(i+1)+" : "+equipes.get(i).getNom());
			System.out.println("           "+equipes.get(i).getNbJoueurs()+ " joueurs");
			System.out.println("           "+equipes.get(i).getNomEntraineur()+" est l'entraîneur de cette équipe");			
		}
	}
	
	public void afficherDetailsEquipe() {
		int numeroEquipe;
		afficherEquipes();
		
		do {
			System.out.println("\nVeuillez choisir l'équipe que vous souhaitez voir en détails (Joueurs) : ");
			numeroEquipe = getPosIntTyped();
		} while (numeroEquipe == -1 );
		
		Equipe equipe = tournoi.getEquipes().get(numeroEquipe-1);
		
		System.out.println("Equipe : "+equipe.getNom());
		System.out.println("           "+equipe.getNbJoueurs()+ " joueurs");
		System.out.println("           "+equipe.getNomEntraineur()+" est l'entraîneur de cette équipe");
		System.out.println("\nComposition de l'équipe :");
		
		List<Joueur> joueurs = equipe.getJoueurs();
		
		int index = 1;
		for(Joueur joueur : joueurs) {
			System.out.println("Joueur "+index+" : "+joueur.getNom()+", "+joueur.getAge()+" ans");
			index++;
		}
		
	}
	
	public void modifierEquipes() {
		List<Equipe> equipes = tournoi.getEquipes();
		int numeroEquipe;
		int nbJoueurs;
		int choix;
		
		//On affiche les différentes équipes
		afficherEquipes();
		
		do {
			System.out.println("\nVeuillez choisir l'équipe que vous souhaitez modifier : ");
			numeroEquipe = getPosIntTyped();
		} while (numeroEquipe == -1 );
		
		System.out.println("Vous modifiez l'équipe "+numeroEquipe+", veuillez taper : ");
		System.out.println("   Le nom de l'équipe : ");
		String nom = getStringTyped();
		
		do {	
			System.out.println("   Le nombre de joueurs dans l'équipe : ");
			nbJoueurs = getPosIntTyped();
		} while (nbJoueurs == -1 );
		
		System.out.println("   Le nom de l'entraîneur : ");
		String nomEntraineur = getStringTyped();
		
		do {	
			System.out.println("\nVoulez-vous modifier le nom des joueurs ? (1 pour oui, 0 pour non)");
			choix = getPosIntTyped();
		} while (choix  < 0 || choix > 1);
		
		switch (choix) {
		case 1 : //Génération de joueurs avec noms définis par l'utilisateur
			List<String> nomsJoueurs = new ArrayList<String>();
			System.out.println("Veuillez entrer le nom des joueurs :");
			for (int i = 0 ; i < nbJoueurs ; i++) {
				System.out.println("Joueur "+(i+1)+" : ");
				nomsJoueurs.add(getStringTyped());				
			}
			controleur.modifierEquipe(equipes.get(numeroEquipe-1), nom, nomsJoueurs, nomEntraineur);
			break;
			
		case 0 : //Génération de joueurs avec noms aléatoires
			controleur.modifierEquipe(equipes.get(numeroEquipe-1), nom, nbJoueurs, nomEntraineur);
			break;
		}
		
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
		return sc.nextLine();
	}
	
	public void menuPrincipal() {
		int choix;
		
		do {
			clearScreen();
			
			System.out.println("\nBienvenue dans le menu principal, voici les options disponibles :");
			System.out.println("   1. Modifier les paramètres du tournoi");
			System.out.println("   2. Modifier les équipes");
			System.out.println("   3. Afficher les équipes et leurs joueurs");
			System.out.println("   4. Lancer le tournoi");
			System.out.println("   5. Quitter le jeu");
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
			afficherDetailsEquipe();
			break;
			
		case 4 :
			start();
			break;
			
		case 5 :
			System.exit(0);
		}
		
	}
	
	public void start() {		
		//int tour = (int) (Math.log(tournoi.getNbEquipes()) / Math.log(2));
		
		while(controleur.creerTour() == 0){
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
			} while (score1 == -1 );
			
			do {
				System.out.println(match.getEq2().getNom()+" : ");
				score2 = getPosIntTyped();
			} while (score2 == -1 );
			
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
