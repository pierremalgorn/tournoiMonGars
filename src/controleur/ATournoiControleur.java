package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Joueur;
import modele.Match;

public abstract class ATournoiControleur {

	public abstract void creerTour();
	public abstract void setScore(Match match, int score1, int score2);
	
	public void genererJoueurs() {
		List<Joueur> joueurs= new ArrayList<Joueur>();
		for(int j=0 ; j<11 ; j++) { //Boucle de création de joueurs
			joueurs.add(new Joueur("Joueur "+(j+1)));
		}
	}
	
	public void modifierEquipe() {
		
	}

}
