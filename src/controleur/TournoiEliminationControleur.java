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
	
	public Match MatchParTour() {
		Match match = new Match();
		return match;
	}
	
}
