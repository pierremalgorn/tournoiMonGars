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
	public Match afficherTour() {
		// TODO Auto-generated method stub
		return null;
	}

}
