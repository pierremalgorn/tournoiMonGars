	package modele;

import java.util.List;

public class Equipe {
	
	private String nom;
	private String nomEntraineur;
	private List<Joueur> joueurs;
	private boolean elimine;
	

	public Equipe(String nom, String nomEntraineur, List<Joueur> joueurs) {
		super();
		this.nom = nom;
		this.nomEntraineur = nomEntraineur;
		this.joueurs = joueurs;
		this.elimine = false;
	}
	
	//Getters and setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbJoueurs() {
		return joueurs.size();
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

	public boolean isElimine() {
		return elimine;
	}

	public void setElimine(boolean elimine) {
		this.elimine = elimine;
	}
	
}
