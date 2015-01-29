package modele;

import java.util.List;

public class Equipe {
	
	private String nom;
	private int nbJoueurs;
	private String nomEntraineur;
	private List<Joueur> joueurs;
	
	public Equipe(String nom, int nbJoueurs, String nomEntraineur, List<Joueur> joueurs) {
		super();
		this.nom = nom;
		this.nbJoueurs = nbJoueurs;
		this.nomEntraineur = nomEntraineur;
		this.joueurs = joueurs;
	}
	
	//Getters and setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
	public String getNomEntraineur() {
		return nomEntraineur;
	}
	public void setNomEntraineur(String nomEntraineur) {
		this.nomEntraineur = nomEntraineur;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	

	

}
