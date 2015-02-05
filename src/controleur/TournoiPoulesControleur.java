package controleur;

import modele.ATournoi;
import modele.Match;
import modele.TournoiPoules;

public class TournoiPoulesControleur extends ATournoiControleur {

	private TournoiPoules tournoi;
	
	public TournoiPoulesControleur(ATournoi tournoi) {
		super();
		this.tournoi = (TournoiPoules)tournoi;
	}

	@Override
	public void creerTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScore(Match match, int score1, int score2) {
		// TODO Auto-generated method stub
		
	}

}
