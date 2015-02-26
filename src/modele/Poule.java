package modele;

import java.util.List;

public class Poule {
	
	private List<Equipe> equipesPoule;
	private List<Integer> nbPoint;
	private String[][] tableauRencontres;
	

	public Poule(List<Equipe> equipesPoule,List<Integer> nbPoint, String[][] tableauRencontre) {
		super();
		this.equipesPoule = equipesPoule;
		this.nbPoint = nbPoint;
		this.tableauRencontres = tableauRencontre;
	}
	
	public String[][] getTableauRencontres() {
		return tableauRencontres;
	}

	public void setTableauRencontres(String[][] tableauRencontres) {
		this.tableauRencontres = tableauRencontres;
	}


	public List<Equipe> getEquipesPoule() {
		return equipesPoule;
	}

	public void setEquipesPoule(List<Equipe> equipesPoule) {
		this.equipesPoule = equipesPoule;
	}

	public List<Integer> getNbPoint() {
		return nbPoint;
	}

	public void setNbPoint(List<Integer> nbPoint) {
		this.nbPoint = nbPoint;
	}
	
	
	
}
