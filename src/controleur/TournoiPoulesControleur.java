package controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modele.ATournoi;
import modele.Equipe;
import modele.Match;
import modele.Poule;
import modele.TournoiPoules;

public class TournoiPoulesControleur extends ATournoiControleur {
	
	public TournoiPoulesControleur(ATournoi tournoi) {
		super(tournoi);
		this.tournoi = (TournoiPoules)tournoi;
	}

	
	@Override
	public int creerTour() {
		
		creerPoules();
		jouerMatch();
		
		return 0; //1 : match terminé
	}

	@Override
	public void setScore(Match match, int score1, int score2) {
		// TODO Auto-generated method stub
		
	}
	
	public int compterNombreTours(){
		int tour = (int) ((Math.log(tournoi.getNbEquipes()) / Math.log(2)) + 3);
		return tour;
	}
	
	public void creerPoules(){
		int aleatoire;
		int nbPoules = (tournoi.getNbEquipes())/4;
		int i, j;
		Random random = new Random();
		Poule poule;
		List<Equipe> equipesPoule;
		List<Equipe> equipes = tournoi.getEquipes();
		List<Poule> poules = new ArrayList<Poule>();
		
		
		for(i=0 ; i<nbPoules ; i++){
			equipesPoule = new ArrayList<Equipe>();
			for(j = 0 ; j < 4 ; j++){
				aleatoire = random.nextInt(equipes.size());
				
				
				equipesPoule.add(equipes.get(aleatoire));
				
				equipes.remove(aleatoire);
			}
			poule = new Poule(equipesPoule);
			poules.add(poule);
		}
		((TournoiPoules) tournoi).setListePoules(poules);
	}
	
	public void jouerMatch(){
		
		int nbPoules = ((TournoiPoules) tournoi).getListePoules().size();
		int i;
		List<Match> tour = new ArrayList<Match>();
		
		for(i=0 ; i<nbPoules; i++){
			Equipe equipe1 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(0);
			Equipe equipe2 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(2);
			Equipe equipe3 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(1);
			Equipe equipe4 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(3);
			
			tour.add(new Match(equipe1, equipe2));
			tour.add(new Match(equipe3, equipe4));
			tournoi.setTour(tour);
		}
		
	}

}
