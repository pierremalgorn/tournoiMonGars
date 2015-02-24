package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import modele.ATournoi;
import modele.TournoiElimination;
import modele.TournoiPoules;
import controleur.ATournoiControleur;
import controleur.TournoiEliminationControleur;
import controleur.TournoiPoulesControleur;

public class AffichageGraphique extends JFrame {

	private JPanel contentPane;
	private JTextField tfNom;
	private JComboBox cbDuree;
	private JComboBox cbNbEquipes;

	ATournoi tournoi;
	ATournoiControleur controleur;
	

	public AffichageGraphique() {
		setTitle("Tournoi Mon Gars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillezChoisir = new JLabel("2. Veuillez choisir le mode de jeu :");
		lblVeuillezChoisir.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVeuillezChoisir.setBounds(23, 288, 324, 50);
		contentPane.add(lblVeuillezChoisir);
		
		JLabel lblBonjourJeSuis = new JLabel("Bonjour et bienvenue dans Tournoi Mon Gars !");
		lblBonjourJeSuis.setBounds(10, 0, 313, 23);
		contentPane.add(lblBonjourJeSuis);
		
		JButton btnTournoiParlimination = new JButton("Tournoi par \u00E9limination");
		btnTournoiParlimination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reinitialisationCouleursErreurs();
				if (checkInfosForm() == 0) {
					tournoi = new TournoiElimination(tfNom.getText(), Integer.parseInt((String)cbDuree.getSelectedItem()), Integer.parseInt((String)cbNbEquipes.getSelectedItem()));
					controleur = new TournoiEliminationControleur(tournoi);
				}
				try {
					GameMain frame = new GameMain(tournoi, controleur);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnTournoiParlimination.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTournoiParlimination.setBounds(142, 349, 200, 50);
		contentPane.add(btnTournoiParlimination);
		
		JButton btnTournoiParPoules = new JButton("Tournoi par poules");
		btnTournoiParPoules.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTournoiParPoules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reinitialisationCouleursErreurs();
				if (checkInfosForm() == 0) {	
					tournoi = new TournoiPoules(tfNom.getText(), Integer.parseInt((String)cbDuree.getSelectedItem()), Integer.parseInt((String)cbNbEquipes.getSelectedItem()));
					controleur = new TournoiPoulesControleur(tournoi);
				}
			}
		});
		btnTournoiParPoules.setBounds(142, 410, 200, 50);
		contentPane.add(btnTournoiParPoules);
		
		JLabel lblVeuillezSaisir = new JLabel("1. Veuillez saisir les informations sur le tournoi :");
		lblVeuillezSaisir.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVeuillezSaisir.setBounds(23, 118, 324, 33);
		contentPane.add(lblVeuillezSaisir);
		
		JLabel lblLeNomDu = new JLabel("Nom :");
		lblLeNomDu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeNomDu.setBounds(61, 162, 46, 23);
		contentPane.add(lblLeNomDu);
		
		JLabel lblTempsDeMatch = new JLabel("Temps de match :");
		lblTempsDeMatch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempsDeMatch.setBounds(61, 191, 119, 23);
		contentPane.add(lblTempsDeMatch);
		
		JLabel lblNombreDquipes = new JLabel("Nombre d'\u00E9quipes :");
		lblNombreDquipes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDquipes.setBounds(61, 220, 119, 23);
		contentPane.add(lblNombreDquipes);
		
		JTextPane txtpnVousVousApprtez = new JTextPane();
		txtpnVousVousApprtez.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnVousVousApprtez.setBackground(SystemColor.control);
		txtpnVousVousApprtez.setText("Vous vous appr\u00E9tez \u00E0 cr\u00E9er un tournoi.\r\nVous devrez rensigner le nom de celui-ci, la dur\u00E9e des matchs (en minutes comprises entre 1 et 120 min) ainsi que le nombre d'\u00E9quipes participant \u00E0 ce tournoi (nombre pair)");
		txtpnVousVousApprtez.setBounds(10, 21, 444, 86);
		txtpnVousVousApprtez.setEditable(false);
		contentPane.add(txtpnVousVousApprtez);
		
		tfNom = new JTextField();
		tfNom.setBounds(190, 162, 187, 20);
		contentPane.add(tfNom);
		tfNom.setColumns(10);
		
		//Cr�ation du mod�le de donn�es
		final int TEMPSMAX = 120;
		String[] tempsPossible = new String[TEMPSMAX+1];
		tempsPossible[0] = "";
		for(int i = 0; i < TEMPSMAX; i++) {
			tempsPossible[i+1] = Integer.toString(i + 1);
		}
		cbDuree = new JComboBox(tempsPossible);
		cbDuree.setBounds(190, 193, 54, 20);
		contentPane.add(cbDuree);
		
		//Cr�ation du mod�le de donn�es
		String[] nbEquipes = {"", "2", "4", "6", "8"};
		cbNbEquipes = new JComboBox(nbEquipes);
		cbNbEquipes.setBounds(190, 222, 54, 20);
		contentPane.add(cbNbEquipes);
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
	
	//R�initialise les couleurs par d�faut
	private void reinitialisationCouleursErreurs() {
		tfNom.setBackground(new Color(255,255,255));
		cbDuree.setBackground(new Color(255,255,255));
		cbNbEquipes.setBackground(new Color(255,255,255));
	}
	
	private int checkInfosForm() {
		List<String> champsErrones = new ArrayList<String>();
		if(tfNom.getText().equals("")) {
			tfNom.setBackground(Color.RED);
			champsErrones.add("Nom");
		}
		if(cbDuree.getSelectedItem().equals("")) {
			cbDuree.setBackground(Color.RED);
			champsErrones.add("Temps de match");
		}
		if(cbNbEquipes.getSelectedItem().equals("")) {
			cbNbEquipes.setBackground(Color.RED);
			champsErrones.add("Nombre d'\u00E9quipes");
		}		
		
		if (champsErrones.isEmpty()) {
			return 0; //OK
		}
		else {
			erreurInfos(champsErrones);
			return -1; //NOK
		}
	}
}
