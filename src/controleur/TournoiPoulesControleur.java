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
	public void creerTour() { //appel� par la vue
		int nombreTours = 0;
		
		if(((TournoiPoules) tournoi).getListePoules() == null){ // Si la liste des poules n'existe pas, on la cr�e
			creerPoules();
		};
		jouerMatch();
		
		nombreTours = ((TournoiPoules) tournoi).getNbTours();
		if(nombreTours == 2){ // On change l'attribut nombreTours pour indiquer que la phase de poules est termin�e
			
			tournoi.setTournoiFini(2);
		}
		else{
			((TournoiPoules) tournoi).setNbTours(nombreTours + 1); // On incr�mente le nombre de tours
			tournoi.setTournoiFini(0); //1 : match termin�
		}
		
		
		

	}

	@Override
	public void setScore(Match match, int scoreEq1, int scoreEq2) { // Appel� pour d�terminer les scores et le nombre de points qui en d�coule
		Equipe equipe1; 
		Equipe equipe2; 
		List<Integer> nbPoint = new ArrayList<>();
		List<Integer> nbPointActuel = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;
		
		
		match.setScoreEq1(scoreEq1);
		match.setScoreEq2(scoreEq2);
		match.getEq1().setNbButsMarques(match.getEq1().getNbButsMarques() + scoreEq1); //On affilie � chaque �quipe un nombre de buts marqu�s
		match.getEq1().setNbButsEncaisses(match.getEq1().getNbButsEncaisses() + scoreEq2); //On affilie � chaque �quipe un nombre de buts encaiss�s
		match.getEq2().setNbButsMarques(match.getEq2().getNbButsMarques() + scoreEq2);
		match.getEq2().setNbButsEncaisses(match.getEq2().getNbButsEncaisses() + scoreEq1);
		
		equipe1 = match.getEq1();
		equipe2 = match.getEq2();

		
		while(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j) != equipe1){ // On cherche � quelle poule appartiennent les �quipes qui ont jou� le match
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
				if(count == j){	 // On incr�mente de 3 le nombre de points de l'�quipe1
					int nbPointApres = nbPointActuel.get(count) + 3;
					nbPoint.add(nbPointApres);
				}
				else{ // Le nombre de point des autres �quipes reste inchang�
					nbPoint.add(nbPointActuel.get(count));
				}
				count = count + 1;
			}
		}
		
		else if(scoreEq1 < scoreEq2) {
			int count = 0;
			
			while(count<4){
				if(count == k){ //On incr�mente de 3 le nombre de points de l'�quipe2
					int nbPointApres = nbPointActuel.get(count) + 3;
					nbPoint.add(nbPointApres);
				}
				else{ // Le nombre de point des autres �quipes reste inchang�
					nbPoint.add(nbPointActuel.get(count));
				}
				count = count + 1;
			}
		}
		
		else{ // Dans le cas o� il y a �galit�, on incr�mente de 1 le nombre de points des 2 �quipes qui ont jou� le match
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
	
	public void preparerElimination(){ //Vise � pr�parer la transition des poules � la partie �liminatoire
		List<Integer> pointPoule = new ArrayList<>();
		List<Integer> pointPouleOrdonnee = new ArrayList<>();
		List<Equipe> equipeElim = new ArrayList<>();
		List<Equipe> equipesPoule = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		
		for(i=0 ; i<((TournoiPoules) tournoi).getListePoules().size(); i++){ // Autant de fois qu'il y a de poules
			
			j = 0;
			pointPoule = ((TournoiPoules) tournoi).getListePoules().get(i).getNbPoint(); // On r�cup�re le nombre de point
			
			pointPouleOrdonnee.removeAll(pointPouleOrdonnee);
			
			for(k=0; k<4; k++){	
				pointPouleOrdonnee.add(pointPoule.get(k));
			}
			
			equipesPoule.removeAll(equipesPoule);
			
			for(k=0; k<4; k++){	
				equipesPoule.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(k));
			}
			
			Collections.sort(pointPouleOrdonnee); // On ordonne la liste du nombre de points des �quipes de la poule
			
			
			if(pointPouleOrdonnee.get(1) != pointPouleOrdonnee.get(2)){ // Si le 2� et le 3� n'ont pas le m�me nombre de points
				
				int pointEquipe = pointPouleOrdonnee.get(3);
				
				while(pointEquipe != pointPoule.get(j)){
					j = j + 1;
				}
				
				equipeElim.add(equipesPoule.get(j)); // On ajoute la 1� �quipe
				equipesPoule.remove(equipesPoule.get(j)); // On la supprime de la liste temporaire pour ne pas la saisir � nouveau
				pointPoule.remove(pointPoule.get(j));
				
				j = 0;
				pointEquipe = pointPouleOrdonnee.get(2);

				while(pointEquipe != pointPoule.get(j)){
					j = j + 1;
				}
				equipeElim.add(equipesPoule.get(j)); // On ajoute la deuxi�me �quipe
			}
			
			else if(pointPouleOrdonnee.get(1) == pointPouleOrdonnee.get(2)){ // Si la 2� et la 3� �quipe ont le meme nombre de points
				if(pointPouleOrdonnee.get(1) != pointPouleOrdonnee.get(0)){ // Si toutes les �quipes n'ont pas toutes le meme nombre de points
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
					
					equipeElim.add(equipesPoule.get(j)); // On ajoute la 1� �quipe qui a plus de points

					
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

					if(differenceEq1 < differenceEq2){ // On compare la diff�rence entre le nombre de buts marqu�s et le nombre de buts encaiss�s pour l'�quipe1 et l'�quipe2
						equipeElim.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l+1));
					}
					else{
						equipeElim.add(((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(j));
					}
				
				}
				
				else{ //Dans le cas o� toutes les �quipes ont le meme nombre de points, on s�lectionne les �quipes al�atoirement
					Random random = new Random();
					int aleatoire = random.nextInt(3);
					equipeElim.add(equipesPoule.get(aleatoire));
					equipesPoule.remove(aleatoire);
					int aleatoire2 = random.nextInt(2);
					equipeElim.add(equipesPoule.get(aleatoire2));
				}
			}
				
		}
		
		
		tournoi.setEquipes(equipeElim); // On fait une nouvelle liste d'�quipes pouvant acc�der � la partie � �limination directe
	}

	
	public void creerPoules(){ // Appel�e une unique fois
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
				aleatoire = random.nextInt(equipes.size()); // On s�lectionne les �quipes al�atoirement dans la liste d'�quipes
				
				equipesPoule.add(equipes.get(aleatoire));
				
				equipes.remove(aleatoire); // On supprime ensuite l"�quipe qu'on a ajout�
				nbPoint.add(0); // On initialise le nombre de points associ� � l'�quipe
			}
			
			
			
			poule = new Poule(equipesPoule, nbPoint, tableauRencontres); // On instancie la nouvelle poule
			poules.add(poule);  // On l'ajoute � la liste de poules
			
		}
		
		((TournoiPoules) tournoi).setListePoules(poules);
		for(i=0 ; i<nbPoules ; i++){
			tableauRencontres[0][0] = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(0).getNom();

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
			
			
			l = 0;
			while(equipesPresentes.get(aleatoire) != ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l).getNom()){
				l=l+1;
			}
			equipe2 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l);
			tab[0][nbTours] = equipe2.getNom();
			
			equipesPresentes.add(equipe1.getNom());
			equipesPresentes.add(equipe2.getNom());
			System.out.println(equipesPresentes.get(0));
			System.out.println(equipesPresentes.get(1));
			System.out.println(equipesPresentes.get(2));
			System.out.println(equipesPresentes.get(3));
			System.out.println(equipe1.getNom());
			System.out.println(equipe2.getNom());
			
			
			
			l = 0;
			while(equipe1.getNom() != equipesPresentes.get(l)){
				l = l+1;
			}
			System.out.println(equipesPresentes.get(l));
			equipesPresentes.remove(l);
			

			
			l = 0;
			while(equipe2.getNom() != equipesPresentes.get(l)){
				l = l+1;
			}
			System.out.println(equipesPresentes.get(l));
			equipesPresentes.remove(l);
			
			l=0;
			System.out.println(equipesPresentes.get(0));
			while(equipesPresentes.get(0) != ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l).getNom()){
				l = l+1;
			}
			equipe3 = ((TournoiPoules) tournoi).getListePoules().get(i).getEquipesPoule().get(l);
			
			l=0;
			System.out.println(equipesPresentes.get(1));
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
