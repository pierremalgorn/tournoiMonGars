package main;

import controleur.TournoiEliminationControleur;
import controleur.TournoiPoulesControleur;
import vue.Salut;

public class main {
	
	public static void main(String[] args) {
		Salut salut = new Salut();
		int reponse = salut.salut();
			
		if(reponse == 1) {
			new TournoiEliminationControleur();
		} else if (reponse == 2) {
			new TournoiPoulesControleur();
		}

	}

}
