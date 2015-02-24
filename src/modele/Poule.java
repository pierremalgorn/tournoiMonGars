package modele;

import java.util.List;

public class Poule {
	
	private List<Equipe> equipesPoule;
	private List<Integer> nbPoint;
	
	public Poule(List<Equipe> equipesPoule,List<Integer> nbPoint) {
		super();
		this.equipesPoule = equipesPoule;
		this.nbPoint = nbPoint;
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
