package controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modele.ATournoi;
import modele.Equipe;
import modele.Joueur;
import modele.Match;

public abstract class ATournoiControleur {
	
	protected ATournoi tournoi;
	
	public ATournoiControleur(ATournoi tournoi) {
		super();
		this.tournoi = tournoi;
		tournoi.setEquipes(constructionEquipes());
	}
	
	public abstract int creerTour();
	public abstract void setScore(Match match, int score1, int score2);
	
	private List<Equipe> constructionEquipes(){
		int aleatoire;
		Random random = new Random();
		
		List<List<Joueur>> groupesJoueurs = new ArrayList<List<Joueur>>();
		
		for(int i=0 ; i<8 ; i++) { //Boucle de création d'équipes
			groupesJoueurs.add(genererJoueurs(11));
		}
		
		List<Equipe> equipes = new ArrayList<Equipe>();
		equipes.add(new Equipe("OM", "Marcelo Bielsa", groupesJoueurs.get(0)));
		equipes.add(new Equipe("OL", "Hubert Fournier", groupesJoueurs.get(1)));
		equipes.add(new Equipe("PSG", "Laurent Blanc", groupesJoueurs.get(2)));
		equipes.add(new Equipe("AS Monaco", "Leonardo Jardim", groupesJoueurs.get(3)));
		equipes.add(new Equipe("AS Saint-Etienne", "Christophe Galtier", groupesJoueurs.get(4)));
		equipes.add(new Equipe("Montpellier SC", "Rolland Courbis", groupesJoueurs.get(5)));
		equipes.add(new Equipe("Girondins de Bordeaux", "Willy Sagnol", groupesJoueurs.get(6)));
		equipes.add(new Equipe("OGC Nice", "Claude Puel", groupesJoueurs.get(7)));
		
		//Boucle de suppression des equipes en fonction du choix de l'utilisateur (nombre d'équipes)
		for(int i = 0 ; i < (8 - tournoi.getNbEquipes()) ; i++){
			aleatoire = random.nextInt(equipes.size());
			equipes.remove(aleatoire);			
		}
		
		return equipes;
		
	}
	
	//Générer des joueurs à partir d'un nombre
	public List<Joueur> genererJoueurs(int nbJoueurs) {
		List<Joueur> joueurs= new ArrayList<Joueur>();
		for(int j=0 ; j<nbJoueurs ; j++) { //Boucle de création de joueurs
			joueurs.add(new Joueur("Joueur "+(j+1)));
		}
		return joueurs;
	}
	
	//Générer des joueurs à partir d'une liste de noms
	public List<Joueur> genererJoueurs(List<String> nomsJoueurs) {
		List<Joueur> joueurs= new ArrayList<Joueur>();
		for(int i=0 ; i < nomsJoueurs.size() ; i++) { //Boucle de création de joueurs
			joueurs.add(new Joueur(nomsJoueurs.get(i)));
		}
		return joueurs;
	}
	
	
	public abstract int compterNombreTours();
		
	//Modifier la liste de joueurs à partir d'un nombre
	public void modifierEquipe(Equipe equipe, String nom, int nbJoueurs, String nomEntraineur) {
		equipe.setNomEntraineur(nomEntraineur);
		equipe.setNom(nom);
		List<Joueur> nouveauxJoueurs = genererJoueurs(nbJoueurs);
		equipe.setJoueurs(nouveauxJoueurs);
	}
	
	//Modifier la liste de joueurs à partir d'une liste de noms
	public void modifierEquipe(Equipe equipe, String nom, List<String> nomsJoueurs, String nomEntraineur) {
		equipe.setNomEntraineur(nomEntraineur);
		equipe.setNom(nom);
		List<Joueur> nouveauxJoueurs = genererJoueurs(nomsJoueurs);
		equipe.setJoueurs(nouveauxJoueurs);
	}

}
