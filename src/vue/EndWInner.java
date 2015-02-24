package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import modele.Equipe;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndWInner extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public EndWInner(Equipe equipeGagnante) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLeTournoiEst = new JLabel("Le tournoi est termin\u00E9 !");
		lblLeTournoiEst.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLeTournoiEst.setBounds(87, 29, 293, 24);
		contentPanel.add(lblLeTournoiEst);
		
		JLabel lblLeGrandGagnant = new JLabel("Le grand gagnant est ...\r\n");
		lblLeGrandGagnant.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLeGrandGagnant.setBounds(10, 75, 293, 35);
		contentPanel.add(lblLeGrandGagnant);
		
		JPanel pNom = new JPanel();
		pNom.setBounds(10, 156, 414, 62);
		contentPanel.add(pNom);
		pNom.setLayout(new BoxLayout(pNom, BoxLayout.Y_AXIS));
		
		JLabel lNomGagnant = new JLabel(equipeGagnante.getNom());
		lNomGagnant.setFont(new Font("Tahoma", Font.BOLD, 25));
		lNomGagnant.setAlignmentX(Component.CENTER_ALIGNMENT);
		pNom.add(lNomGagnant);
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
