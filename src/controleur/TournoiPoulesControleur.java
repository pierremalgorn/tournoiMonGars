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
		
		if(((TournoiPoules) tournoi).getListePoules() == null){
			creerPoules();
		};
		jouerMatch();
		
		return 0; //1 : match terminé
	}

	@Override
	public void setScore(Match match, int scoreEq1, int scoreEq2) {
		Equipe equipe1; 
		Equipe equipe2; 
		int i = 0;
		int j = 0;
		int k = 0;
		
		
		match.setScoreEq1(scoreEq1);
		match.setScoreEq2(scoreEq2);
		
		equipe1 = match.getEq1();
		equipe2 = match.getEq2();

		
		while(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j) != equipe1){
			j = j + 1;
			if(j == 4){
				i = i + 1;
				j = 0;
			}
		}
		
	
		while(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(k) != equipe2){
			k = k + 1;
		}
		System.out.println("---------");
		List<Integer> nbPointActuel = ((TournoiPoules) tournoi).getListePoules().get(i).getNbPoint();
		
		if(scoreEq1 > scoreEq2) {
			int count = 0;
			List<Integer> nbPoint = new ArrayList<>();
			
			while(count<4){
				if(count == j){	
					int nbPointApres = nbPointActuel.get(count) + 3;
					nbPoint.add(nbPointApres);
				}
				else{
					nbPoint.add(nbPointActuel.get(count));
				}
				count = count + 1;
			}
			
			
			((TournoiPoules) tournoi).getListePoules().get(i).setNbPoint(nbPoint);
		}
		
		else if(scoreEq1 < scoreEq2) {
			int count = 0;
			List<Integer> nbPoint = new ArrayList<>();
			
			while(count<4){
				if(count == k){
					int nbPointApres = nbPointActuel.get(count) + 3;
					nbPoint.add(nbPointApres);
				}
				else{
					nbPoint.add(nbPointActuel.get(count));
				}
				count = count + 1;
			}
			
			
			((TournoiPoules) tournoi).getListePoules().get(i).setNbPoint(nbPoint);
		}
		
		else{
			int count = 0;
			List<Integer> nbPoint = new ArrayList<>();
			
			while(count < 4){
				if(count == k){
					int nbPointApres = nbPointActuel.get(count) + 1;
					nbPoint.add(nbPointApres);
				}
				else if(count == j){
					int nbPointApres = nbPointActuel.get(count) + 1;
					nbPoint.add(nbPointApres);
				}
				else{
					nbPoint.add(0);
				}
				count = count + 1;
			}

			((TournoiPoules) tournoi).getListePoules().get(i).setNbPoint(nbPoint);
		}
		
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
		List<Integer> nbPoint = new ArrayList<Integer>();
		
		
		for(i=0 ; i<nbPoules ; i++){
			equipesPoule = new ArrayList<Equipe>();
			for(j = 0 ; j < 4 ; j++){
				aleatoire = random.nextInt(equipes.size());		
				
				equipesPoule.add(equipes.get(aleatoire));
				
				equipes.remove(aleatoire);
				nbPoint.add(0);
			}
			
			
			
			poule = new Poule(equipesPoule, nbPoint);
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
			Equipe equipe2 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(1);
			Equipe equipe3 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(2);
			Equipe equipe4 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(3);
			
			tour.add(new Match(equipe1, equipe2));
			tour.add(new Match(equipe3, equipe4));
			
		}
		tournoi.setTour(tour);
	}

}
