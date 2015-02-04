package controleur;

import modele.Match;

public abstract class ATournoiControleur {

	public abstract void creerTour();
	public abstract void setScore(Match match, int score1, int score2);

}
