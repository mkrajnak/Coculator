package ivs2015.coculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class Coculator extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private JTextField display ;
	private JPanel buttonPanel = new JPanel();
	private JButton buttons[] = new JButton[17];
	
	private double prevResult;
	private String prevOperation = null;
	private String DisplayResult = "";
	private String result = "";
	private int STATE = 0;
	private boolean dotSet = false;
	
	public Coculator(){
		
		this.setTitle("Coculator 9.1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new MigLayout("", "[456.00,grow]", "[49.00][193.00,grow]"));
		this.setBounds(100, 100, 470,  300);
		this.setMinimumSize(new Dimension(300,240));
		
		this.display = new JTextField();
		this.display.setEditable(false);
		this.display.setText("0");
		this.display.setBackground(Color.WHITE);
		this.display.setFont(new java.awt.Font("Century Schoolbook L", 2, 24));
		this.getContentPane().add(this.display, "cell 0 0,grow");
		
		this.buttonPanel.setLayout(new MigLayout("", "[100.00,grow][100.00,grow][100.00,grow][100.00,grow]", "[40.00,grow][40.00,grow][40.00,grow][40.00,grow]"));
		this.getContentPane().add(this.buttonPanel, "cell 0 1,grow");
		
		initButtons();
		
		this.setVisible(true);	
		//this.setResizable(false);
	}
	
	public static void main (String[] args) {
		new Coculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i <= 10; i ++){
			if(e.getSource()==this.buttons[i]){
				if(this.STATE == 1){
					this.result = "";
					this.STATE = 0;
					this.dotSet = false;
				}
				if(this.STATE == 3){
					this.DisplayResult = "";
					this.prevOperation = null;
					this.prevResult = 0;
					this.result = "";
					this.STATE = 0;
					this.dotSet = false;
				}
				
				if(this.result.length() <= 8){
					if(i == 10 && !this.dotSet){
						if(this.result != ""){
							this.DisplayResult += '.';
							this.result += '.';
						}else{
							this.DisplayResult += "0.";
							this.result += "0.";
						}
						this.dotSet = true;
					}
					else if(i != 10){
						this.DisplayResult += i;
						this.result += i;
					}
				}
				this.display.setText(this.DisplayResult);
			}
		}
		
		for(int i = 11; i <= 14; i++  ){
			if(e.getSource() == this.buttons[i]){
				if(this.prevOperation == null && this.result == ""){
					this.prevOperation = buttons[i].getText();
					this.prevResult =  0;
					this.DisplayResult += "0 "+buttons[i].getText() + " ";
					this.display.setText(this.DisplayResult);
					this.STATE = 1;
				}
				else if(this.prevOperation == null && this.result != ""){
					this.prevOperation = buttons[i].getText();
					this.prevResult = Double.parseDouble(this.result);
					this.DisplayResult += " "+buttons[i].getText() + " ";
					this.display.setText(this.DisplayResult);
					this.STATE = 1;
				}
				else if(this.prevOperation != null && this.STATE != 1){
					double result = 0;
					if(this.prevOperation == "+" )
						result = this.prevResult + Double.parseDouble(this.result);
					if(this.prevOperation == "-")
						result = this.prevResult - Double.parseDouble(this.result);
					if(this.prevOperation == "*")
						result = this.prevResult * Double.parseDouble(this.result);
					if(this.prevOperation == "/")
						result = this.prevResult / Double.parseDouble(this.result);
					
					if(this.prevOperation != "="){
						this.prevResult = result;
					}
					
					String tmp = ""+this.prevResult; 
					String[] parts = tmp.split("\\.");
					Pattern p = Pattern.compile("0*");
					Matcher m = p.matcher(parts[1]);
					if(m.matches()){
						this.DisplayResult = parts[0] + " " + buttons[i].getText() + " ";
					}
					else{
						this.DisplayResult = this.prevResult + " " + buttons[i].getText() + " ";
					}
					
					this.display.setText(this.DisplayResult);
					this.prevOperation = buttons[i].getText();
					this.STATE = 1;
				}
				else if(this.prevOperation != null && this.STATE == 1){
					this.DisplayResult = this.display.getText().substring(0, this.display.getText().length()-2) + buttons[i].getText()+" ";
					this.prevOperation = buttons[i].getText();
					this.display.setText(this.DisplayResult);
					this.STATE = 1;
				}
			}
		}
		
		if(e.getSource() == this.buttons[15]){
			if(this.prevOperation == null && this.result == ""){
				this.result = "0";
				this.DisplayResult = "0";
				this.display.setText(this.DisplayResult);
			}
			else if(this.prevOperation == null && this.result != ""){
				this.STATE = 3;
			}
			else if(this.prevOperation != null && this.STATE != 1 && this.STATE != 3){
				double result = 0;
				if(this.prevOperation == "+" )
					result = this.prevResult + Double.parseDouble(this.result);
				if(this.prevOperation == "-")
					result = this.prevResult - Double.parseDouble(this.result);
				if(this.prevOperation == "*")
					result = this.prevResult * Double.parseDouble(this.result);
				if(this.prevOperation == "/")
					result = this.prevResult / Double.parseDouble(this.result);
				
				this.prevResult = result;
				this.prevOperation = "=";
				this.DisplayResult = ""+result;
				
				String[] parts = this.DisplayResult.split("\\.");
				Pattern p = Pattern.compile("0*");
				Matcher m = p.matcher(parts[1]);
				if(m.matches()){
					this.DisplayResult = parts[0];
				}
				if(this.DisplayResult.length() > 16){
					this.DisplayResult = this.DisplayResult.substring(0, 16);
				}
				this.display.setText(this.DisplayResult);
				this.STATE = 3;
			}
			else if(this.prevOperation != null && this.STATE == 1){
				this.prevOperation = "=";
				this.DisplayResult = ""+this.prevResult;
				this.display.setText(this.DisplayResult);
				this.STATE = 3;
			}
			else if(this.STATE == 3){
				this.STATE = 3;
			}
		}
		
		if(e.getSource() == this.buttons[16]){
			this.DisplayResult = "";
			this.prevOperation = null;
			this.prevResult = 0;
			this.result = "";
			this.STATE = 0;
			this.display.setText("0");
			this.dotSet = false;
		}
	}
	
	public void initButtons(){
		this.buttons[0] = new JButton("0");
		this.buttons[0].addActionListener(this);
		this.buttonPanel.add(buttons[0], "cell 0 3, grow");
		
		this.buttons[1] = new JButton("1");
		this.buttons[1].addActionListener(this);
		this.buttonPanel.add(buttons[1], "cell 0 2, grow");
		this.buttons[2] = new JButton("2");
		this.buttons[2].addActionListener(this);
		this.buttonPanel.add(buttons[2], "cell 1 2, grow");
		this.buttons[3] = new JButton("3");
		this.buttons[3].addActionListener(this);
		this.buttonPanel.add(buttons[3], "cell 2 2, grow");
		
		this.buttons[4] = new JButton("4");
		this.buttons[4].addActionListener(this);
		this.buttonPanel.add(buttons[4], "cell 0 1, grow");
		this.buttons[5] = new JButton("5");
		this.buttons[5].addActionListener(this);
		this.buttonPanel.add(buttons[5], "cell 1 1, grow");
		this.buttons[6] = new JButton("6");
		this.buttons[6].addActionListener(this);
		this.buttonPanel.add(buttons[6], "cell 2 1, grow");
		
		this.buttons[7] = new JButton("7");
		this.buttons[7].addActionListener(this);
		this.buttonPanel.add(buttons[7], "cell 0 0, grow");
		this.buttons[8] = new JButton("8");
		this.buttons[8].addActionListener(this);
		this.buttonPanel.add(buttons[8], "cell 1 0, grow");
		this.buttons[9] = new JButton("9");
		this.buttons[9].addActionListener(this);
		this.buttonPanel.add(buttons[9], "cell 2 0, grow");
		
		this.buttons[10] = new JButton(".");
		this.buttons[10].addActionListener(this);
		this.buttonPanel.add(buttons[10], "cell 0 4, grow");
		
		this.buttons[11] = new JButton("+");
		this.buttons[11].addActionListener(this);
		this.buttonPanel.add(buttons[11], "cell 3 3, grow");
		this.buttons[12] = new JButton("-");
		this.buttons[12].addActionListener(this);
		this.buttonPanel.add(buttons[12], "cell 3 2, grow");
		this.buttons[13] = new JButton("/");
		this.buttons[13].addActionListener(this);
		this.buttonPanel.add(buttons[13], "cell 3 0, grow");
		this.buttons[14] = new JButton("*");
		this.buttons[14].addActionListener(this);
		this.buttonPanel.add(buttons[14], "cell 3 1, grow");
		
		this.buttons[15] = new JButton("=");
		this.buttons[15].addActionListener(this);
		this.buttonPanel.add(buttons[15], "cell 2 3, grow");
		this.buttons[16] = new JButton("C");
		this.buttons[16].addActionListener(this);
		this.buttonPanel.add(buttons[16], "cell 1 3, grow");
	}
}
