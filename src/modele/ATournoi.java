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
		Random random = new Random();
		List<List<Joueur>> groupesJoueurs = new ArrayList<List<Joueur>>();
		
		for(int i=0 ; i<8 ; i++) { //Boucle de création d'équipes
			List<Joueur> joueurs= new ArrayList<Joueur>();
			for(int j=0 ; j<11 ; j++) { //Boucle de création de joueurs
				joueurs.add(new Joueur("Joueur "+(j+1), (random.nextInt(60 - 18 + 1) + 18)));
			}
			groupesJoueurs.add(joueurs);
		}
		
		List<Equipe> equipes = new ArrayList<Equipe>();
		equipes.add(new Equipe("OM", 11, "Marcelo Bielsa", groupesJoueurs.get(0)));
		equipes.add(new Equipe("OL", 11, "Hubert Fournier", groupesJoueurs.get(1)));
		equipes.add(new Equipe("PSG", 11, "Laurent Blanc", groupesJoueurs.get(2)));
		equipes.add(new Equipe("AS Monaco", 11, "Leonardo Jardim", groupesJoueurs.get(3)));
		equipes.add(new Equipe("AS Saint-Etienne", 11, "Christophe Galtier", groupesJoueurs.get(4)));
		equipes.add(new Equipe("Montpellier SC", 11, "Rolland Courbis", groupesJoueurs.get(5)));
		equipes.add(new Equipe("Girondins de Bordeaux", 11, "Willy Sagnol", groupesJoueurs.get(6)));
		equipes.add(new Equipe("OGC Nice", 11, "Claude Puel", groupesJoueurs.get(7)));
		
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
	
	
		
	
}
