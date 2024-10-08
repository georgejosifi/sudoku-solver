package sudokView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import sudok.Sudoku;

public class SundokuFrame extends JFrame {
	private JButton button;
	private Sudoku sudoku;
	private JTextField [][] squares;
	
	
	

	public SundokuFrame () {
		super("Sudoku Solver");
		sudoku =  new Sudoku();
	    //text field font
		Font f = new Font("Verdana",Font.BOLD,19);
		
	    Buttonpanel buttons = new Buttonpanel(this);
		
		setLayout(new BorderLayout());
		//krijo fushen e sudokut
		JPanel board = new JPanel (new GridLayout(3,3));
		board.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		add(board,BorderLayout.CENTER);
		 //krijo  81 text fielde
		squares = new JTextField[9][9];
		
		for (int row = 0; row <9; row++) {
		
			for(int col = 0; col<9; col++) {
         	squares[row][col] =  new JTextField("0");
         	JTextField textCell = squares[row][col];
         	textCell.setFont(f);
         //	 Te pranoj vetem digit nga  0  te 9.
         	textCell.addKeyListener(new KeyAdapter( ) {
         		public void keyTyped(KeyEvent e) {
         			char c = e.getKeyChar();
         			if(textCell.getText().length() > 0 || (c < '0') || (c > '9')) {
         				e.consume();
         			}
         			
         		}
         	});
        
         	
         	
			}
	
		}
		
		//sistemo textfieldat ne boxet e duhura.
		for (int k = 0; k<9; k++) {
			BoxPanel box = new BoxPanel();
			for(int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					if (k<3 ) {
					box.add(squares[i][3*k+j]);
					}else if (k>=3 && k <=5) {
						box.add(squares[3 + i][3*(k-3) + j]);
					}else {
						box.add(squares[6 + i][3*(k-6) + j]);
					}
				}
			}
			board.add(box);
		}
		
		add(buttons,BorderLayout.SOUTH);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	public JButton getButton() {
		return button;
	}


	public Sudoku getSudoku() {
		return sudoku;
	}


	public JTextField getSquares(int i , int j ) {
		return squares[i][j];
	}


}
