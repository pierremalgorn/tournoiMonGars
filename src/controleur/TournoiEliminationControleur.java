package controleur;

import java.util.List;

import modele.ATournoi;
import modele.Equipe;
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
	
	public void setScore(Match match, int scoreEq1, int scoreEq2) {		
		match.setScoreEq1(scoreEq1);
		match.setScoreEq2(scoreEq2);
		
		if(scoreEq1 > scoreEq2) {
			match.getEq1().setElimine(true);
		}
		else {
			match.getEq2().setElimine(true);
		}
		
	}
	
}
