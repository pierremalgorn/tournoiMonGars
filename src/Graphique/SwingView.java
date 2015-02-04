package Graphique;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class SwingView extends JFrame{

	Integer counter;
	JButton plus;
	JButton minus;
	JButton reset;
	JLabel counterLabel;
	ButtonListener bl;
	
	public SwingView(){
		counter = 0;
		bl = new ButtonListener();
		this.setTitle("compteur");
		this.setSize(new Dimension(400,400));
		
		counterLabel = new JLabel();
		plus = new JButton("+");
		minus = new JButton("-");
		reset = new JButton("Reset");
		
		plus.addActionListener(bl);
		minus.addActionListener(bl);
		reset.addActionListener(bl);
		
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		
		panel.add(counterLabel);
		panel.add(plus);
		panel.add(minus);
		panel.add(reset);
		
		this.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == plus){
				counter ++;
			} else if(e.getSource() == minus){
				counter --;
			} else if(e.getSource() == reset){
				counter = 0;
			}
			counterLabel.setText(counter.toString());
		}
	}

}
