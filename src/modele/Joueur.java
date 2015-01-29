package modele;

public class Joueur {

	private String nom;
	private int age;
	
	public Joueur(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	
	
	//Getters and setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
