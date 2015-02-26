package controleur;

import java.util.ArrayList;
import java.util.Collections;
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
	public void creerTour() {
		int nombreTours = 0;
		
		if(((TournoiPoules) tournoi).getListePoules() == null){
			creerPoules();
		};
		jouerMatch();
		
		nombreTours = ((TournoiPoules) tournoi).getNbTours();
		if(nombreTours == 2){
			
			tournoi.setTournoiFini(2);
		}
		else{
			((TournoiPoules) tournoi).setNbTours(nombreTours + 1);
			tournoi.setTournoiFini(0); //1 : match terminé
		}
		
		
		

	}

	@Override
	public void setScore(Match match, int scoreEq1, int scoreEq2) {
		Equipe equipe1; 
		Equipe equipe2; 
		List<Integer> nbPoint = new ArrayList<>();
		List<Integer> nbPointActuel = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;
		
		
		match.setScoreEq1(scoreEq1);
		match.setScoreEq2(scoreEq2);
		match.getEq1().setNbButsMarques(match.getEq1().getNbButsMarques() + scoreEq1);
		match.getEq1().setNbButsEncaisses(match.getEq1().getNbButsEncaisses() + scoreEq2);
		match.getEq2().setNbButsMarques(match.getEq2().getNbButsMarques() + scoreEq2);
		match.getEq2().setNbButsEncaisses(match.getEq2().getNbButsEncaisses() + scoreEq1);
		
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

		nbPointActuel = ((TournoiPoules) tournoi).getListePoules().get(i).getNbPoint();
		
		if(scoreEq1 > scoreEq2) {
			int count = 0;
			
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
		}
		
		else if(scoreEq1 < scoreEq2) {
			int count = 0;
			
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
		}
		
		else{
			int count = 0;
			
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
					nbPoint.add(nbPointActuel.get(count));
				}
				count = count + 1;
			}

			
		}
		((TournoiPoules) tournoi).getListePoules().get(i).setNbPoint(nbPoint);
	}
	
	public void preparerElimination(){
		List<Integer> pointPoule = new ArrayList<>();
		List<Integer> pointPouleOrdonnee = new ArrayList<>();
		List<Equipe> equipeElim = new ArrayList<>();
		List<Equipe> equipesPoule = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		
		for(i=0 ; i<((TournoiPoules) tournoi).getListePoules().size(); i++){
			
			j = 0;
			pointPoule = ((TournoiPoules) tournoi).getListePoules().get(i).getNbPoint();
			
			pointPouleOrdonnee.removeAll(pointPouleOrdonnee);
			
			for(k=0; k<4; k++){	
				pointPouleOrdonnee.add(pointPoule.get(k));
			}
			
			equipesPoule.removeAll(equipesPoule);
			
			for(k=0; k<4; k++){	
				equipesPoule.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(k));
			}
			
			Collections.sort(pointPouleOrdonnee);
			
			
			if(pointPouleOrdonnee.get(1) != pointPouleOrdonnee.get(2)){
				
				int pointEquipe = pointPouleOrdonnee.get(3);
				
				while(pointEquipe != pointPoule.get(j)){
					j = j + 1;
				}
				
				equipeElim.add(equipesPoule.get(j));
				equipesPoule.remove(equipesPoule.get(j));
				pointPoule.remove(pointPoule.get(j));
				
				j = 0;
				pointEquipe = pointPouleOrdonnee.get(2);

				while(pointEquipe != pointPoule.get(j)){
					j = j + 1;
				}
				equipeElim.add(equipesPoule.get(j));
			}
			
			else if(pointPouleOrdonnee.get(1) == pointPouleOrdonnee.get(2)){
				if(pointPouleOrdonnee.get(1) != pointPouleOrdonnee.get(0)){
					int nbButsMarquesEq1;
					int nbButsMarquesEq2;
					int nbButsEncaissesEq1;
					int nbButsEncaissesEq2;
					int differenceEq1;
					int differenceEq2;
					
				
					int pointEquipe = pointPouleOrdonnee.get(3);
					
					j = 0;
					while(pointEquipe != pointPoule.get(j)){
						j = j + 1;
					}
					
					equipeElim.add(equipesPoule.get(j));

					
					j = 0;
					pointEquipe = pointPouleOrdonnee.get(2);

					while(pointEquipe != pointPoule.get(j)){
						j = j + 1;
					}
					nbButsMarquesEq1 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j).getNbButsMarques();
					nbButsEncaissesEq1 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j).getNbButsEncaisses();
					differenceEq1 = nbButsMarquesEq1 - nbButsEncaissesEq1;

					equipesPoule.remove(j);
					pointPoule.remove(j);
					
					l = 0;
					while(pointEquipe != pointPoule.get(l)){
						l = l + 1;
					}
					nbButsMarquesEq2 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l+1).getNbButsMarques();
					nbButsEncaissesEq2 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l+1).getNbButsEncaisses();
					differenceEq2 = nbButsMarquesEq2 - nbButsEncaissesEq2;

					if(differenceEq1 < differenceEq2){
						equipeElim.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l+1));
					}
					else{
						equipeElim.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j));
					}
				
				}
				
				else{
					Random random = new Random();
					int aleatoire = random.nextInt(3);
					equipeElim.add(equipesPoule.get(aleatoire));
					equipesPoule.remove(aleatoire);
					int aleatoire2 = random.nextInt(2);
					equipeElim.add(equipesPoule.get(aleatoire2));
				}
			}
				
		}
		
		
		tournoi.setEquipes(equipeElim);
	}

	
	public void creerPoules(){
		int aleatoire;
		int nbPoules = (tournoi.getNbEquipes())/4;
		int i, j;
		Random random = new Random();
		Poule poule;
		List<Equipe> equipesPoule;
		List<Equipe> equipes = new ArrayList<Equipe>(); /*= tournoi.getEquipes()*/;
		equipes.addAll(tournoi.getEquipes());
		List<Poule> poules = new ArrayList<Poule>();
		List<Integer> nbPoint = new ArrayList<Integer>();
		String[][] tableauRencontres = new String[3][4];
		
		
		
		
		for(i=0 ; i<nbPoules ; i++){
			equipesPoule = new ArrayList<Equipe>();
			for(j = 0 ; j < 4 ; j++){
				aleatoire = random.nextInt(equipes.size());		
				
				equipesPoule.add(equipes.get(aleatoire));
				
				equipes.remove(aleatoire);
				nbPoint.add(0);
			}
			
			
			
			poule = new Poule(equipesPoule, nbPoint, tableauRencontres);
			poules.add(poule);
			
		}
		
		((TournoiPoules) tournoi).setListePoules(poules);
		for(i=0 ; i<nbPoules ; i++){
			tableauRencontres[0][0] = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(0).getNom();
			tableauRencontres[1][0] = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(1).getNom();
			tableauRencontres[2][0] = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(2).getNom();
			((TournoiPoules) tournoi).getListePoules().get(i).setTableauRencontres(tableauRencontres);
		}
		
		
	}
	
	public void jouerMatch(){
		List<String> equipesPresentes = new ArrayList<>();
		List<Match> tour = new ArrayList<Match>();
		Equipe equipe1, equipe2, equipe3, equipe4;
		int nbPoules = ((TournoiPoules) tournoi).getListePoules().size();
		int i, j , k, l, nbTours;
		Random random = new Random();
		
		
		
		for(i=0 ; i<nbPoules; i++){
			for(j=0; j<4; j++){
				equipesPresentes.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j).getNom());
			}
			
			equipe1 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(0);
			equipesPresentes.remove(0);
			
			String[][] tab = ((TournoiPoules) tournoi).getListePoules().get(i).getTableauRencontres();
			
			nbTours=1;
			while(tab[0][nbTours] != null){
				nbTours = nbTours+1;
			}
			
			l=0;
			for(k=1; k<nbTours; k++){
				while(tab[0][k] != equipesPresentes.get(l)){
					l = l+1;
				}
				equipesPresentes.remove(l);
			}
			
			int aleatoire = random.nextInt(equipesPresentes.size());
			equipe2 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(aleatoire);
			tab[0][nbTours] = equipe2.getNom();
			
			for(j=0; j<4; j++){
				equipesPresentes.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j).getNom());
			}
			
			l = 0;
			while(equipe1.getNom() != equipesPresentes.get(l)){
				l = l+1;
			}
			equipesPresentes.remove(l);
			
			l = 0;
			while(equipe2.getNom() != equipesPresentes.get(l)){
				l = l+1;
			}
			equipesPresentes.remove(l);
			
			l=0;
			while(equipesPresentes.get(0) != ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l).getNom()){
				l = l+1;
			}
			equipe3 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l);
			
			l=0;
			while(equipesPresentes.get(1) != ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l).getNom()){
				l = l+1;
			}
			equipe4 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l);
			
			
			tour.add(new Match(equipe1, equipe2));
			tour.add(new Match(equipe3, equipe4));
			
		}
		tournoi.setTour(tour);
	}

}
