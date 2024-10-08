package sudokView;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BoxPanel extends JPanel{
	
	public BoxPanel () {
		setLayout(new GridLayout(3,3));
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
	}

}
