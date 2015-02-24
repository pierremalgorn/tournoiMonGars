package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modele.ATournoi;
import modele.Equipe;
import modele.Joueur;
import modele.Match;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

import controleur.ATournoiControleur;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JSpinner;

public class GameMain extends JFrame {

	private JPanel contentPane;
	private JPanel pTours;
	
	private ATournoi tournoi;
	private ATournoiControleur controleur;
	private JTextField tfNomEquipe;
	private JTextField tfNomEntraineur;
	private JPanel pJoueursEquipe;
	private JComboBox<Equipe> cbEquipes;
	private JSpinner spNbJoueurs;
	private JButton bModifier;
	private JButton bValider;

	/**
	 * Create the frame.
	 */
	public GameMain(ATournoi tournoi, final ATournoiControleur controleur) {
		this.controleur = controleur;
		this.tournoi = tournoi;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pTours = new JPanel();
		pTours.setBounds(32, 90, 418, 269);
		contentPane.add(pTours);
		
		JLabel lblEquipesSaffrontantAu = new JLabel("Equipes s'affrontant au prochain tour :");
		lblEquipesSaffrontantAu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEquipesSaffrontantAu.setBounds(10, 11, 396, 38);
		contentPane.add(lblEquipesSaffrontantAu);
		
		JLabel lblEquipe = new JLabel("Equipe 1");
		lblEquipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEquipe.setBounds(109, 60, 289, 14);
		contentPane.add(lblEquipe);
		
		JLabel lblEquipe2 = new JLabel("Equipe 2");
		lblEquipe2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEquipe2.setBounds(316, 60, 65, 14);
		contentPane.add(lblEquipe2);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVs.setBounds(229, 60, 46, 14);
		contentPane.add(lblVs);
		
		JButton btnValiderLesScores = new JButton("Valider les scores");
		btnValiderLesScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validerScores() == 0) {
					controleur.creerTour();
					afficherProchainsTours();
				}
			}
		});
		btnValiderLesScores.setBounds(268, 414, 169, 23);
		contentPane.add(btnValiderLesScores);
		
		JLabel lblAffichermodifierLesInformations = new JLabel("Afficher/modifier les informations d'une \u00E9quipe :");
		lblAffichermodifierLesInformations.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAffichermodifierLesInformations.setBounds(510, 11, 396, 38);
		contentPane.add(lblAffichermodifierLesInformations);
		
		//On ajoute les �quipes en jeu
		List<Equipe> equipes = tournoi.getEquipes();
		//cbEquipes = new JComboBox<Equipe>();
		cbEquipes = new JComboBox<Equipe>(equipes.toArray(new Equipe[equipes.size()]));
		cbEquipes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				clickOnValidateChanges();
				afficherInfosEquipeSelectionnee();
			}
		});
		EquipesRenderer renderer = new EquipesRenderer();
		cbEquipes.setRenderer(renderer);
		cbEquipes.setBounds(600, 57, 245, 23);
		contentPane.add(cbEquipes);
		
		JLabel lblSelectionnezUnequipe = new JLabel("Equipes :");
		lblSelectionnezUnequipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectionnezUnequipe.setBounds(520, 61, 289, 14);
		contentPane.add(lblSelectionnezUnequipe);
		
		JLabel lblEntraneur = new JLabel("Entra\u00EEneur :");
		lblEntraneur.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEntraneur.setBounds(548, 139, 74, 14);
		contentPane.add(lblEntraneur);
		
		JLabel lblNomDuClub = new JLabel("Nom du club :");
		lblNomDuClub.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomDuClub.setBounds(548, 114, 74, 14);
		contentPane.add(lblNomDuClub);
		
		JLabel lblJoueurs = new JLabel("Joueurs :");
		lblJoueurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJoueurs.setBounds(548, 198, 74, 14);
		contentPane.add(lblJoueurs);
		
		pJoueursEquipe = new JPanel();
		pJoueursEquipe.setBounds(651, 198, 277, 257);
		pJoueursEquipe.setLayout(new BoxLayout(pJoueursEquipe, BoxLayout.Y_AXIS));
		contentPane.add(pJoueursEquipe);
		
		
		tfNomEquipe = new JTextField();
		tfNomEquipe.setBounds(673, 114, 200, 16);
		tfNomEquipe.setEditable(false);
		contentPane.add(tfNomEquipe);
		
		tfNomEntraineur = new JTextField();
		tfNomEntraineur.setBounds(673, 139, 200, 16);
		tfNomEntraineur.setEditable(false);
		contentPane.add(tfNomEntraineur);
		
		spNbJoueurs = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
		spNbJoueurs.setBounds(673, 161, 46, 20);
		contentPane.add(spNbJoueurs);
		
		bValider = new JButton();
		bModifier = new JButton();
		bModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickOnModify();
			}
		});
		bModifier.setIcon(new ImageIcon("src/vue/images/modify.png"));
		bModifier.setContentAreaFilled(false);
		bModifier.setBorder(null);
		bModifier.setBounds(855, 60, 18, 14);
		contentPane.add(bModifier);
		
		bValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickOnValidateChanges();
				controleur.modifierEquipe((Equipe) cbEquipes.getSelectedItem(), tfNomEquipe.getText(), (int) spNbJoueurs.getValue(), tfNomEntraineur.getText());
				afficherInfosEquipeSelectionnee();
			}
		});
		bValider.setIcon(new ImageIcon("src/vue/images/check.png"));
		bValider.setContentAreaFilled(false);
		bValider.setBorder(null);
		bValider.setBounds(888, 60, 18, 14);
		bValider.setVisible(false);
		contentPane.add(bValider);
		
		JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs :");
		lblNombreDeJoueurs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreDeJoueurs.setBounds(548, 164, 118, 14);
		contentPane.add(lblNombreDeJoueurs);
		

		
		afficherInfosEquipeSelectionnee();
		
		
		//int tour = (int) (Math.log(tournoi.getNbEquipes()) / Math.log(2));
		
		//for(int j = 0 ; j < tour ; j++){
			controleur.creerTour();
			afficherProchainsTours();
		//}
		
		
		
	}
	
	private void clickOnValidateChanges() {
		tfNomEntraineur.setEditable(false);
		tfNomEquipe.setEditable(false);
		spNbJoueurs.setEnabled(false);
		bModifier.setVisible(true);
		bValider.setVisible(false);
	}
	
	private void clickOnModify() {
		tfNomEntraineur.setEditable(true);
		tfNomEquipe.setEditable(true);
		spNbJoueurs.setEnabled(true);
		bValider.setVisible(true);
		bModifier.setVisible(false);
	}
	
	private void afficherInfosEquipeSelectionnee() {
		Equipe equipeSelectionnee = (Equipe) cbEquipes.getSelectedItem();
		tfNomEquipe.setText(equipeSelectionnee.getNom());
		tfNomEntraineur.setText(equipeSelectionnee.getNomEntraineur());
		spNbJoueurs.setValue(equipeSelectionnee.getNbJoueurs());
		
		pJoueursEquipe.removeAll();		
		String stringJoueur;
		for (Joueur joueur : equipeSelectionnee.getJoueurs()) {
			stringJoueur = joueur.getNom()+", "+joueur.getAge()+" ans";
			pJoueursEquipe.add(new JLabel(stringJoueur));
		}
		pJoueursEquipe.repaint();
		pJoueursEquipe.validate();
	}

	
	private int validerScores() {
		Component[] tours = pTours.getComponents();
		EquipeScoreAffiche[] tabCases = Arrays.copyOf(tours, tours.length, EquipeScoreAffiche[].class);
		List<Match> tour = tournoi.getTour();
		
		if(checkInputScores(tabCases) == -1) {
			return -1;
		}
		else {
			int j = 0;
			for (int i = 0; i < tour.size(); i++) {
				controleur.setScore(tour.get(i), Integer.valueOf(tabCases[j].getTfScore().getText()), Integer.valueOf(tabCases[j+1].getTfScore().getText()));
				j = j + 2; // 2 cases = 1 match
			}
			return 0;
		}
		
		
	}
	
	private int checkInputScores(EquipeScoreAffiche[] tabCases) {
		final int MAXSCORE = 1000;
		List<String> champsErrones = new ArrayList<String>();
		
		for (EquipeScoreAffiche caseEquipe : tabCases) {
			int err = 0, score = 0;
			try {
				score = Integer.valueOf(caseEquipe.getTfScore().getText());
			} catch (NumberFormatException e) {
				err = -1;
				System.out.println("Erreur de saisie de l'utilisateur sur les r�sultats de match");
			}
			
			if(score < 0 || score > MAXSCORE || err == -1) {
				caseEquipe.getTfScore().setBackground(Color.RED);
				champsErrones.add(caseEquipe.getNom());
			}
			else {
				caseEquipe.getTfScore().setBackground(new Color(255,255,255));
			}
		}
		
		if (champsErrones.isEmpty()) {
			return 0; //OK
		}
		else {
			erreurInfos(champsErrones);
			return -1; //NOK
		}
	}
	
	private void erreurInfos(List champsErrones) {
		try {
			Err dialog = new Err(champsErrones);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void afficherProchainsTours() {
		List<Match> tour = tournoi.getTour();
		pTours.removeAll();
		pTours.setLayout(new GridLayout(tour.size(), 2, 0, 15));
		for(Match match : tour) {
			pTours.add(new EquipeScoreAffiche(match.getNomEq1(), 1));
			pTours.add(new EquipeScoreAffiche(match.getNomEq2(), 2));
		}
		pTours.validate();
	}
}
