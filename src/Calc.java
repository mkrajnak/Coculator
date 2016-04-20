import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc implements ActionListener {

	private JFrame frame;
	
	private JPanel panel;
	private JTextField textField;
	
	private JButton buttonZero;
	private JButton buttonOne;
	private JButton buttonTwo;
	private JButton buttonTree;
	private JButton buttonFour;
	private JButton buttonFive;
	private JButton buttonSix;
	private JButton buttonSeven;
	private JButton buttonEight;
	private JButton buttonNine;
	
	private JButton buttonEquals;
	private JButton buttonMultiply;
	private JButton buttonAdd;
	private JButton buttonSubtract;
	private JButton buttonDivide;
	private JButton buttonClear;
	

	/**
	 * Launch the application.
	 */
	/*
	 * added comment
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470,  300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[456.00,grow]", "[49.00][193.00,grow]"));
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 0 0,grow");
		textField.setColumns(10);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[100.00,grow][100.00,grow][100.00,grow][100.00,grow]", "[40.00,grow][40.00,grow][40.00,grow][40.00,grow]"));
		
		buttonSeven = new JButton("7");
		panel.add(buttonSeven, "cell 0 0,grow");
		
		buttonEight = new JButton("8");
		panel.add(buttonEight, "cell 1 0,grow");
		
		buttonNine = new JButton("9");
		panel.add(buttonNine, "cell 2 0,grow");
		
		buttonDivide = new JButton("/");
		panel.add(buttonDivide, "cell 3 0,grow");
		
		buttonFour = new JButton("4");
		panel.add(buttonFour, "cell 0 1,grow");
		
		buttonFive = new JButton("5");
		panel.add(buttonFive, "cell 1 1,grow");
		
		buttonSix = new JButton("6");
		panel.add(buttonSix, "cell 2 1,grow");
		
		buttonMultiply = new JButton("*");
		panel.add(buttonMultiply, "cell 3 1,grow");
		
		buttonOne = new JButton("1");
		panel.add(buttonOne, "cell 0 2,grow");
		
		buttonTwo = new JButton("2");
		panel.add(buttonTwo, "cell 1 2,grow");
		
		buttonTree = new JButton("3");
		panel.add(buttonTree, "cell 2 2,grow");
		
		buttonSubtract = new JButton("-");
		panel.add(buttonSubtract, "cell 3 2,grow");
		buttonSubtract.addActionListener(this);
		
		buttonZero = new JButton("0");
		panel.add(buttonZero, "cell 0 3,grow");
		
		buttonClear = new JButton("C");
		panel.add(buttonClear, "cell 1 3,grow");
		
		buttonEquals = new JButton("=");
		panel.add(buttonEquals, "cell 2 3,grow");
		
		buttonAdd = new JButton("+");
		panel.add(buttonAdd, "cell 3 3,grow");
		buttonAdd.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == buttonAdd){
			textField.setText(textField.getText() + "+");
		}
	}
	
	

}
