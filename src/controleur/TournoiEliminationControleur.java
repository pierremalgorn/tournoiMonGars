package controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modele.ATournoi;
import modele.Equipe;
import modele.Match;
import modele.TournoiElimination;

public class TournoiEliminationControleur extends ATournoiControleur {

	public TournoiEliminationControleur(ATournoi tournoi) {
		super(tournoi);
		this.tournoi = (TournoiElimination)tournoi;
	}
	
	public void creerTour(){
				
		int aleatoire;
		int aleatoire2;
		Random random = new Random();
		
		List<Match> tour = new ArrayList<Match>();
		
		List<Equipe> equipes = tournoi.getEquipes();
		List<Equipe> equipesEnJeu = new ArrayList<Equipe>();
		
		for(Equipe equipe : equipes){
			if (equipe.isElimine() == false){
				equipesEnJeu.add(equipe);
			}
		}

		while(equipesEnJeu.size() > 0){
			aleatoire = random.nextInt(equipesEnJeu.size());
			Equipe equipe1 = equipesEnJeu.get(aleatoire);
			equipesEnJeu.remove(aleatoire);
			
			aleatoire2 = random.nextInt(equipesEnJeu.size());
			Equipe equipe2 = equipesEnJeu.get(aleatoire2);
			equipesEnJeu.remove(aleatoire2);
			
			tour.add(new Match(equipe1, equipe2));	
			
		}
		
		tournoi.setTour(tour);
		
	}
	
	public void setScore(Match match, int scoreEq1, int scoreEq2) {		
		match.setScoreEq1(scoreEq1);
		match.setScoreEq2(scoreEq2);
		
		if(scoreEq1 > scoreEq2) {
			match.getEq2().setElimine(true);
		}
		else {
			match.getEq1().setElimine(true);
		}
		
	}
	
}
