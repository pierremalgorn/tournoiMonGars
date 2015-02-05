package modele;

import java.util.List;

public class TournoiPoules extends ATournoi {

	private List<Poule> listePoules;
	

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
