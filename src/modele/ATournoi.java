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
	private int tournoiFini;
	
	public int getTournoiFini() {
		return tournoiFini;
	}



	public ATournoi(String nom, int tpsMatchEnM, int nbEquipes) {
		super();
		this.nom = nom;
		this.tpsMatchEnM = tpsMatchEnM;
		this.nbEquipes = nbEquipes;
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
	
	public Equipe getWinner() {
		if(tour.size() == 1) {
			Equipe winner = tour.get(0).getWinner();
			if (winner != null ) {
				return winner;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}


	public void setTournoiFini(int tournoiFini) {
		this.tournoiFini = tournoiFini;
	}
	
}
