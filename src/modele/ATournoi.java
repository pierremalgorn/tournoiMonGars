package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ATournoi {

	private String nom;
	private int tpsMatchEnS;
	private int nbEquipes;
	private List<Equipe> equipes;
	
	public ATournoi(String nom, int tpsMatchEnM, int nbEquipes) {
		super();
		this.nom = nom;
		this.tpsMatchEnS = tpsMatchEnM;
		this.nbEquipes = nbEquipes;
		equipes = this.constructionEquipes();
	}
	
	
	////////////////////////////EN COURS
	private List<Equipe> constructionEquipes(){
		Random random = new Random();
		List<Joueur> joueursOM= new ArrayList<Joueur>;
		for(int i=0 ; i<11 ; i++) {
			joueursOM.add(new Joueur("Joueur "+(i+1), (random.nextInt(60 - 18 + 1) + 18)));
		}
		
		Equipe Equipe1 = new Equipe("OM", 11, "Marcelo Bielsa", null);
		List<Equipe> equipes = new ArrayList<Equipe>();
	}

	
	//Getters and setters
	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
		
	
}
