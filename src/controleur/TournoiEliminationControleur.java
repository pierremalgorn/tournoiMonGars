package controleur;

import modele.ATournoi;
import modele.Match;
import modele.TournoiElimination;

public class TournoiEliminationControleur extends ATournoiControleur {

	private TournoiElimination tournoi;

	public TournoiEliminationControleur(ATournoi tournoi) {
		super();
		this.tournoi = (TournoiElimination)tournoi;
	}
	
	/*public Match MatchParTour() {
		Match match = new Match();
		return match;
	}*/
	
	public Match afficherTour(){
	int nbEquipe = tournoi.getNbEquipes();
	int nbTour = 1;
	
	nbTour = nbTour + 1;
	nbEquipe = nbEquipe/2;
	
	 
	
	Match match = new Match();
	
	return match;

	}
	
}
