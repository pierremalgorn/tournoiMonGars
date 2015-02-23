package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.Color;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Err extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Err(List<String> champsErrones) {
		setBounds(100, 100, 450, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblErreur = new JLabel("ERREUR :");
			lblErreur.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblErreur.setBounds(27, 21, 80, 19);
			contentPanel.add(lblErreur);
		}
		
		JLabel lblVotreSaisieEst = new JLabel("Votre saisie est incorrecte, veuillez corriger le(s) champ(s) suivant(s) :");
		lblVotreSaisieEst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVotreSaisieEst.setBounds(37, 51, 387, 14);
		contentPanel.add(lblVotreSaisieEst);
		
		JTextPane txtpnChampsErrones = new JTextPane();
		txtpnChampsErrones.setForeground(Color.RED);
		txtpnChampsErrones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Concaténation des champs erronés
		String strChampsErrones = new String();
		for(String champ : champsErrones) {
			strChampsErrones = strChampsErrones.concat("\n").concat(champ);
		}
		txtpnChampsErrones.setText(strChampsErrones);
		txtpnChampsErrones.setBackground(SystemColor.control);
		txtpnChampsErrones.setBounds(83, 76, 303, 101);
		contentPanel.add(txtpnChampsErrones);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
