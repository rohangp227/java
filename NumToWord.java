import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NumToWord implements ActionListener{
	JFrame jf;
	JButton reset,convert;
	JTextField numField, wordField;
	String numString;
	NumToWord(){
		jf= new JFrame("Number to Word");
		numField= new JTextField();
		jf.add(numField);
		numField.setBounds(300,10,110,50);
		wordField= new JTextField();
		jf.add(wordField);
		wordField.setBounds(10,70,650,50);
		reset= new JButton("Reset");
		jf.add(reset);
		reset.addActionListener(this);
		reset.setBounds(400,120,100,50);
		convert= new JButton("Convert");
		jf.add(convert);
		convert.setBounds(200,120,100,50);
		convert.addActionListener(this);
		
		jf.setBounds(50,50,690,220);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==reset){
			numField.setText("");
			wordField.setText("");
		}
		if(e.getSource()==convert){
			numString=numField.getText();
			if(numString.length()>13){
				JOptionPane.showMessageDialog(jf,"Number of digits should be less than 14");
			}
			else{
			int num[]= new int[numString.length()];
			for(int i=0;i<numString.length();i++){
				num[i]=Integer.parseInt(numString.substring(i,i+1));
			}
			numToWord(num);
			}
		}
	}
	
	void numToWord(int x[]){
		int i,j,l=x.length;
		//int o=l-1,t=l-2,h=l-3,th=l-4;
		String unit_word[]={"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
		String teen_word[]={"ten ","eleven ","twelve ","thirteen ","fourteen ","fifteen ","sixteen ","seventeen ","eighteen ","nineteen "};
		String tens_word[]={"","ten ","twenty ","thirty ","forty ","fifty ","sixty ","seventy ","eighty ","ninety "};
		String place_word[]={"","","","hundred ","thousand ","thousand ","lakh ","lakh ","crore ","crore ","arab ","arab ","kharab ","kharab "};
		String word="";
		
		//single digit number
		if(l==1 && x[0]==0)
			word="zero";
		else if(l==1)
			word=unit_word[x[l-1]]+word;
		
		//2 digit number
		if(l>1 && x[l-2]==1)
			word=teen_word[x[l-1]]+word;
		if(l>1 && x[l-2]!=1){
			word=unit_word[x[l-1]]+word;
			word=tens_word[x[l-2]]+word;
		}
		
		//3 digit number
		if(l>2 && x[l-3]>0){
			word=place_word[3]+word;
			word=unit_word[x[l-3]]+word;
		}
		
		if(l>3)
			for(int n=4;n<=l;n++){
				
				if(l==n){
					word=place_word[n]+word;
					word=unit_word[x[l-n]]+word;
				}
				n++;
				
				if(l>(n-1) && x[l-n]==1){
					word=place_word[n-1]+word;
					word=teen_word[x[l-(n-1)]]+word;
				}
				if(l>(n-1) && x[l-n]!=1){
					word=place_word[(n-1)]+word;
					word=unit_word[x[l-(n-1)]]+word;
					word=tens_word[x[l-n]]+word;
				}
			}
			
		wordField.setText(word);
	}
	
	public static void main(String[] args){
		new NumToWord();
	}
}