package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ATournoi {

	private String nom;
	private int tpsMatchEnM;
	private int nbEquipes;
	private List<Equipe> equipes;
	private List<Match> tour;
	
	public ATournoi(String nom, int tpsMatchEnM, int nbEquipes) {
		super();
		this.nom = nom;
		this.tpsMatchEnM = tpsMatchEnM;
		this.nbEquipes = nbEquipes;
		equipes = this.constructionEquipes();
	}
	
	
	private List<Equipe> constructionEquipes(){
		int aleatoire;
		
		List<List<Joueur>> groupesJoueurs = new ArrayList<List<Joueur>>();
		
		for(int i=0 ; i<8 ; i++) { //Boucle de création d'équipes
			
			groupesJoueurs.add(joueurs);
		}
		
		List<Equipe> equipes = new ArrayList<Equipe>();
		equipes.add(new Equipe("OM", "Marcelo Bielsa", groupesJoueurs.get(0)));
		equipes.add(new Equipe("OL", "Hubert Fournier", groupesJoueurs.get(1)));
		equipes.add(new Equipe("PSG", "Laurent Blanc", groupesJoueurs.get(2)));
		equipes.add(new Equipe("AS Monaco", "Leonardo Jardim", groupesJoueurs.get(3)));
		equipes.add(new Equipe("AS Saint-Etienne", "Christophe Galtier", groupesJoueurs.get(4)));
		equipes.add(new Equipe("Montpellier SC", "Rolland Courbis", groupesJoueurs.get(5)));
		equipes.add(new Equipe("Girondins de Bordeaux", "Willy Sagnol", groupesJoueurs.get(6)));
		equipes.add(new Equipe("OGC Nice", "Claude Puel", groupesJoueurs.get(7)));
		
		//Boucle de suppression des equipes en fonction du choix de l'utilisateur (nombre d'équipes)
		for(int i = 0 ; i < (8 - nbEquipes) ; i++){
			aleatoire = random.nextInt(equipes.size());
			equipes.remove(aleatoire);			
		}
		
		return equipes;
		
	}

	
	//Getters and setters
	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}


	public int getNbEquipes() {
		return nbEquipes;
	}


	public void setNbEquipes(int nbEquipes) {
		this.nbEquipes = nbEquipes;
	}


	public List<Match> getTour() {
		return tour;
	}


	public void setTour(List<Match> tour) {
		this.tour = tour;
	}
	
	public String getWinnerName() {
		Equipe winner = tour.get(0).getWinner();
		if (winner != null ) {
			return winner.getNom();
		}
		else {
			return "Erreur";
		}
	}
	
}
