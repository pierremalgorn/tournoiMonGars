package modele;

import java.util.List;

public class TournoiPoules extends ATournoi {

	private List<Poule> listePoules;
	private int nbTours;
	

	public TournoiPoules(String nom, int tpsMatchEnM, int nbEquipes,
			List<Poule> listePoules, int nbTours) {
		super(nom, tpsMatchEnM, nbEquipes);
		this.listePoules = listePoules;
		this.nbTours = nbTours;
	}


	public int getNbTours() {
		return nbTours;
	}


	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}


	public List<Poule> getListePoules() {
		return listePoules;
	}


	public void setListePoules(List<Poule> listePoules) {
		this.listePoules = listePoules;
	}


	public TournoiPoules(String nom, int tpsMatchEnS, int nbEquipes) {
		super(nom, tpsMatchEnS, nbEquipes);
	}

}
