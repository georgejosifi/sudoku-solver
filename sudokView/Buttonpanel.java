package sudokView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttonpanel extends JPanel {
private JButton solveButton;
private JButton resetButton;


public Buttonpanel(SundokuFrame frame) {
//	setLayout(new BorderLayout());
	
	solveButton = new JButton ("Solve");
	solveButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i <9; i++) {
				for (int j = 0; j<9; j++) {
					// merr numrat nga jtextfield dhe ja jep klases Sudoku 
					int inputNumber = Integer.parseInt(frame.getSquares(i,j).getText());
					frame.getSudoku().addNumber(i, j, inputNumber);
				}
			}
			
			frame.getSudoku().solveSudoku();
			
			for(int i = 0; i <9; i++) {
				for (int j = 0; j<9; j++) {
					//tregon vlerat e zgjidhjes se sudokut
					frame.getSquares(i,j).setText(String.valueOf(frame.getSudoku().getValue(i, j)));
				}
			}
			
			
		}
		
	});
	
    add(solveButton);
    
    resetButton = new JButton("Reset");
    resetButton.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i <9; i++) {
				for (int j = 0; j<9; j++) {
					//tregon vlerat e zgjidhjes se sudokut
					frame.getSquares(i,j).setText("0");
				}
			}
			
		}
    	
    });
	
    add(resetButton);
	
}





}
