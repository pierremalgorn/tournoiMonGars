package main;

import vue.AffichageConsole;
import vue.AffichageGraphique;
import vue.Salut;

public class main {
	
	static AffichageConsole console;
	static AffichageGraphique graphique;
	
	public static void main(String[] args) {
		Salut salut = new Salut();
		int reponse = salut.salut();
			
		if(reponse == 1) {
			console = new AffichageConsole();
		} else if (reponse == 2) {
			graphique = new AffichageGraphique();
		}

	}

}
