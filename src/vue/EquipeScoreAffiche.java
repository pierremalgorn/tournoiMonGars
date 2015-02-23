package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class EquipeScoreAffiche extends JPanel {
	private String nom;
	private int position;
	JTextField tfScore;
	
	public EquipeScoreAffiche(String nom, int position) {
		super(new GridLayout(2, 1, 0, 0));
		this.nom = nom;
		this.position = position;
		tfScore = new JTextField();
		this.setBorder(creerBordure());
		populate();
	}
	
	private void populate() {
		JLabel eq = new JLabel(nom, SwingConstants.CENTER);
		
		JPanel score = new JPanel(new GridLayout(1, 2, 0, 0));
		score.add(new JLabel("Score : ", SwingConstants.RIGHT));
		
		//On crée un noueau Panel pour contenir le TF pour régler la taille
		JPanel textfieldContainer = new JPanel(null);
		tfScore.setBounds(0, 4, 35, 20);
		textfieldContainer.add(tfScore);
		score.add(textfieldContainer);
		
		creerCase(eq, score);
	}
	
	public String getNom() {
		return nom;
	}

	public JTextField getTfScore() {
		return tfScore;
	}

	private void creerCase(JLabel nomEquipe, JPanel score) {	
		this.add(nomEquipe);
		this.add(score);
	}
	
	private Border creerBordure() {
		if(position == 1) {
			return BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK);
		}
		else {
			return BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK);
		}
	}
	
}
