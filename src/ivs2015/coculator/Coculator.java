package ivs2015.coculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Coculator extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container content ; 
	private JTextField display ;
	private JPanel buttonPanel = new JPanel();
	private JButton buttons[] = new JButton[16];
	private String buttonString[] = {"0","1","2","3","4","5","6","7","8","9","+","-","/","*","=","C"};
	
	private double prevResult;
	private String prevOperation = null;
	private String DisplayResult = "";
	private int STATE = 0; 
	
	public Coculator(){
		super("Couclator 9.0");
		this.content = getContentPane();
		
		
		this.display = new JTextField();
		this.display.setEditable(false);
		this.display.setSize(this.WIDTH, 100);
		this.display.setText("0");
		//this.display.setBackground(Color.cyan);
		
		buttonPanel.setLayout(new GridLayout(4,4));
		for (int i=0;i< 16;i++){
			buttons[i] = new JButton(buttonString[i]);
			buttons[i].addActionListener(this);
			buttonPanel.add(buttons[i]);
		}
		
		this.add(this.display, BorderLayout.NORTH);
		this.add(this.buttonPanel);
		
		this.setVisible(true);
		this.setSize(450, 500);
		this.setResizable(false);
	
	}
	
	public static void main (String[] args) {
		new Coculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i <= 9; i ++){
			if(e.getSource()==this.buttons[i]){
				if(this.STATE != 0){
					this.DisplayResult = "";
					this.STATE = 0;
				}
				
				this.DisplayResult += i;
				this.display.setText(this.DisplayResult);
			}
		}
		
		for(int i = 10; i <= 13; i++  ){
			if(e.getSource() == this.buttons[i]){
				if(this.prevOperation == null && this.DisplayResult == ""){
					this.prevOperation = buttons[i].getText();
					this.prevResult =  0;
					this.DisplayResult += "0 "+buttons[i].getText();
					this.display.setText(this.DisplayResult);
					this.STATE = 1;
				}
				if(this.prevOperation == null && this.DisplayResult != ""){
					this.prevOperation = buttons[i].getText();
					this.prevResult = Double.parseDouble(this.DisplayResult);
					this.DisplayResult += " "+buttons[i].getText();
					this.display.setText(this.DisplayResult);
					this.STATE = 1;
				}
				else if(this.prevOperation != null && this.STATE != 1){
					double result = 0;
					if(this.prevOperation == "+" )
						result = this.prevResult + Double.parseDouble(this.DisplayResult);
					if(this.prevOperation == "-")
						result = this.prevResult - Double.parseDouble(this.DisplayResult);
					if(this.prevOperation == "*")
						result = this.prevResult * Double.parseDouble(this.DisplayResult);
					if(this.prevOperation == "/")
						result = this.prevResult / Double.parseDouble(this.DisplayResult);
					
					this.prevOperation = buttons[i].getText();
					this.prevResult = result;
					this.display.setText(result + " " + buttons[i].getText());
					this.STATE = 1;
				}
				else if(this.prevOperation != null && this.STATE == 1){
					String newText = this.display.getText().substring(0, this.display.getText().length()-1) + buttons[i].getText();
					this.prevOperation = buttons[i].getText();
					this.display.setText(newText);
					this.STATE = 1;
				}
			}
		}
	}
}
