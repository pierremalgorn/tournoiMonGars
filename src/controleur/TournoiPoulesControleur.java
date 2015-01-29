package controleur;

import modele.ATournoi;
import modele.TournoiPoules;

public class TournoiPoulesControleur extends ATournoiControleur {

	private TournoiPoules tournoi;
	
	public TournoiPoulesControleur(ATournoi tournoi) {
		super();
		this.tournoi = (TournoiPoules)tournoi;
	}

}
