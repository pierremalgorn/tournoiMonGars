package controleur;

import modele.ATournoi;
import modele.TournoiElimination;

public class TournoiEliminationControleur extends ATournoiControleur {

	private TournoiElimination tournoi;

	public TournoiEliminationControleur(ATournoi tournoi) {
		super();
		this.tournoi = (TournoiElimination)tournoi;
	}
	
}
