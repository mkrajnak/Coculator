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

import ivs2015.math.MathLib;
import net.miginfocom.swing.MigLayout;


public class Coculator extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private JTextField display ;
	private JPanel buttonPanel = new JPanel();
	private JButton buttons[] = new JButton[20];
	
	private double prevResult;
	private String prevOperation = null;
	private String DisplayResult = "";
	private String result = "";
	private int STATE = 0;
	private boolean dotSet = false;
	private String stored = "";
	
	private MathLib math;
	
	public Coculator(){
		this.math = new MathLib();
		
		this.setTitle("Coculator 9.2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new MigLayout("", "[456.00,grow]", "[49.00][193.00,grow]"));
		this.setBounds(100, 100, 470,  300);
		this.setMinimumSize(new Dimension(300,250));
		
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
	
	public void clear(){
		this.DisplayResult = "";
		this.prevOperation = null;
		this.prevResult = 0;
		this.result = "";
		this.STATE = 0;
		this.display.setText("0");
		this.dotSet = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.buttons[19]){
			clear();
		}
		
		if(this.STATE == 7){
			for(int i = 0; i <= 10; i++){
				if(e.getSource()==this.buttons[i]){
					result += i;
					this.DisplayResult += i;
					this.display.setText(this.DisplayResult);
				}
			}
			for(int i = 11; i <= 19; i++){
				if(e.getSource()==this.buttons[i])
				{
					double tmp = math.pow(Double.parseDouble(this.stored), Double.parseDouble(this.result));
					if(Double.isInfinite(tmp)){
						clear();
						this.display.setText("Infinity");
						return;
					}
					this.DisplayResult = this.DisplayResult.substring(0, this.DisplayResult.length() - (this.stored.length() + this.result.length() - 1));
					this.DisplayResult += "" + tmp;
					this.result = "" + tmp;
					this.STATE = 0;
				}
			}
		}
		
		if(this.STATE != 7){
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
				if(this.STATE == 16 || this.STATE == 17){
					this.clear();
					this.STATE = 0;
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
		
		for(int i = 11; i <= 17; i++  ){
			if(e.getSource() == this.buttons[i]){
				/// TODO - spojit fact a sqrt do jedneho ifu
				/// doplnit maetemticku kniznicu
				if(i == 15){
					if(this.STATE == 3){
						int tmp = (int) this.prevResult;
						this.prevResult =  (double) math.fact(tmp);
						this.DisplayResult = ""+this.prevResult;
						this.display.setText(this.DisplayResult);
						break;
					}
					if(this.prevOperation == null && this.result == ""){
						break;
					}
					if(this.prevOperation == null && this.result != ""){
						if(this.result.contains(".") || this.result.contains("-")){
							clear();
							this.display.setText("Math Error");
							break;
						}
						int tmp = Integer.parseInt(this.result);
						this.result = String.valueOf(math.fact(tmp));
						this.DisplayResult = this.result;
						this.display.setText(this.DisplayResult);
						this.prevResult = Double.parseDouble(this.result);
						this.STATE = 16;
						break;
					}
					else if(this.prevOperation != null){
						if(this.result.contains(".") || this.result.contains("-")){
							clear();
							this.display.setText("Math Error");
							break;
						}
						int tmp = Integer.parseInt(this.result);
						
						if(this.STATE != 1){
							this.DisplayResult = this.DisplayResult.substring(0, this.DisplayResult.length() - this.result.length());
							this.result = String.valueOf(math.fact(tmp));
							this.DisplayResult += result;
							this.display.setText(this.DisplayResult);
							break;
						}else{
							this.result = String.valueOf(math.fact(tmp));
							this.DisplayResult = this.result;
							this.display.setText(this.DisplayResult);
							this.prevOperation = null;
							this.STATE = 16;
							break;
						}
					}
				}
				
				if(i == 17){
					if(this.STATE == 3){
						this.prevResult =  math.sqrt(this.prevResult);
						this.DisplayResult = ""+this.prevResult;
						this.display.setText(this.DisplayResult);
						break;
					}
					if(this.prevOperation == null && this.result == ""){
						break;
					}
					if(this.prevOperation == null && this.result != ""){
						this.result =  String.valueOf(math.sqrt(Double.parseDouble(this.result)));
						this.DisplayResult = this.result;
						this.display.setText(this.DisplayResult);
						this.prevResult = Double.parseDouble(this.result);
						this.STATE = 17;
						break;
					}
					else if(this.prevOperation != null){
						if(this.STATE != 1){
							this.DisplayResult = this.DisplayResult.substring(0, this.DisplayResult.length() - this.result.length());
							this.result = String.valueOf(math.sqrt(Double.parseDouble(this.result)));
							this.DisplayResult += this.result;
							this.display.setText(this.DisplayResult);
							break;
						}else{
							this.result = String.valueOf(math.sqrt(Double.parseDouble(this.result)));
							this.DisplayResult = this.result;
							this.display.setText(this.DisplayResult);
							this.prevOperation = null;
							this.STATE = 17;
							break;
						}
					}
				}
				
				if(i == 16){
					if(this.prevOperation == null && this.result == ""){
						break;
					}		
				}
				
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
						result = math.add(this.prevResult, Double.parseDouble(this.result));
					if(this.prevOperation == "-")
						result = math.sub(this.prevResult, Double.parseDouble(this.result));
					if(this.prevOperation == "*")
						result = math.mul(this.prevResult, Double.parseDouble(this.result));
					if(this.prevOperation == "/"){
						result = math.div(this.prevResult, Double.parseDouble(this.result));
						if( Double.isNaN(result) ){						
							clear();
							this.display.setText("Math Error");
							break;
						}
					}
					if(this.prevOperation == "^"){
						result = math.pow(this.prevResult, Double.parseDouble(this.result));
					}
					
					
					if(buttons[i].getText() == "^" && this.prevOperation != "="){
						this.STATE = 7;
						this.stored = this.result;
						this.result = "";
						this.DisplayResult += buttons[i].getText();
						this.display.setText(this.DisplayResult);
						break;
					}
						
					
					if(this.prevOperation != "="){
						this.prevResult = result;
					}
					
					if( Double.isInfinite(this.prevResult) && this.prevOperation != "="){
						clear();
						this.display.setText("Infinity");
						return;
					}
					
					String tmp = ""+this.prevResult; 
					String[] parts = tmp.split("\\.");
					Pattern p = Pattern.compile("0*");
					Matcher m = p.matcher(parts[1]);
					if(m.matches()){
						this.DisplayResult = parts[0] + " " + buttons[i].getText() + " ";
					}
					else{
						String temp = ""+this.prevResult;
						if(temp.contains("E") && temp.length() > 16){
							String ePart = temp.substring(temp.indexOf("E"),temp.length());
							temp = temp.substring(0, 16-ePart.length());
							temp += ePart;
						}
						else if(temp.length() > 16){
							temp = temp.substring(0, 16);
						}
						this.DisplayResult = temp + " " + buttons[i].getText() + " ";
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
		//=
		if(e.getSource() == this.buttons[18]){
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
					result = math.add(this.prevResult, Double.parseDouble(this.result));
				if(this.prevOperation == "-")
					result = math.sub(this.prevResult, Double.parseDouble(this.result));
				if(this.prevOperation == "*")
					result = math.mul(this.prevResult, Double.parseDouble(this.result));
				if(this.prevOperation == "/"){
					result = math.div(this.prevResult, Double.parseDouble(this.result));
					if( Double.isNaN(result) ){						
						clear();
						this.display.setText("Math Error");
						return;
					}
				}
				if(this.prevOperation == "^")
					result = math.pow(this.prevResult, Double.parseDouble(this.result));
				
				this.prevResult = result;
				this.prevOperation = "=";
				this.DisplayResult = ""+result;
				
				if(this.DisplayResult.equals("Infinity")){
					clear();
					this.display.setText("Infinity");
					return;
				}
				
				String[] parts = this.DisplayResult.split("\\.");
				Pattern p = Pattern.compile("0*");
				Matcher m = p.matcher(parts[1]);
				if(m.matches()){
					this.DisplayResult = parts[0];
				}
				if(this.DisplayResult.contains("E") && this.DisplayResult.length() > 16){
					String ePart = this.DisplayResult.substring(this.DisplayResult.indexOf("E"),this.DisplayResult.length());
					this.DisplayResult = this.DisplayResult.substring(0, 16-ePart.length());
					this.DisplayResult += ePart;
				}
				else if(this.DisplayResult.length() > 16){
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
		
		this.buttons[15] = new JButton("!");
		this.buttons[15].addActionListener(this);
		this.buttonPanel.add(buttons[15], "cell 1 4, grow");
		this.buttons[16] = new JButton("^");
		this.buttons[16].addActionListener(this);
		this.buttonPanel.add(buttons[16], "cell 2 4, grow");
		this.buttons[17] = new JButton("sqrt");
		this.buttons[17].addActionListener(this);
		this.buttonPanel.add(buttons[17], "cell 3 4, grow");
		
		this.buttons[18] = new JButton("=");
		this.buttons[18].addActionListener(this);
		this.buttonPanel.add(buttons[18], "cell 2 3, grow");
		this.buttons[19] = new JButton("C");
		this.buttons[19].addActionListener(this);
		this.buttonPanel.add(buttons[19], "cell 1 3, grow");
	}
}
