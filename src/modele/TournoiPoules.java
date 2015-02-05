package modele;

import java.util.List;

public class TournoiPoules extends ATournoi {

	private List<Poule> listePoules;
	
	public TournoiPoules(String nom, int tpsMatchEnM, int nbEquipes,
			List<Poule> listePoules) {
		super(nom, tpsMatchEnM, nbEquipes);
		this.listePoules = listePoules;
	}

	public TournoiPoules(String nom, int tpsMatchEnS, int nbEquipes) {
		super(nom, tpsMatchEnS, nbEquipes);
	}

}
