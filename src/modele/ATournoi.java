package modele;

public abstract class ATournoi {

	private String nom;
	private int tpsMatchEnS;
	private int nbEquipes;
	
	public ATournoi(String nom, int tpsMatchEnS, int nbEquipes) {
		super();
		this.nom = nom;
		this.tpsMatchEnS = tpsMatchEnS;
		this.nbEquipes = nbEquipes;
	}
		
	
}
