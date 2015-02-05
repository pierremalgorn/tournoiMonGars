package modele;

import java.util.Random;

public class Joueur {

	private String nom;
	private int age;
	
	public Joueur(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	
	//Age aléatoire
	public Joueur(String nom) {
		super();
		Random random = new Random();
		this.nom = nom;
		this.age = random.nextInt(60 - 18 + 1) + 18;
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
