package vue;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import modele.Equipe;


public class EquipesRenderer extends JLabel implements ListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		
		Equipe equipe = (Equipe) value;
		if(equipe != null) {
			setText(equipe.getNom());
		}
		
		return this;
	}

	public EquipesRenderer() {
		
	}

}
