import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calendar extends JPanel{
	int date,year;
	String month,day;
	DateStamp ds;
	//JTable jt;
	//JScrollPane sp;
	JLabel mlabel,ylabel,jl;
	JButton prev,next;
	Icon im;
	String[] days= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	String[] months= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	int [] monthValue= {-1,-1,4,0,2,5,0,3,6,1,4,6}, dayValue= {1,2,3,4,5,6,0}, centuryValue= {0,6,4,2}, monthMaxDays= {31,-1,31,30,31,30,31,31,30,31,30,31};
	int monthNum;
	//String[][] dates= new String[5][7];
	JLabel[] dayslabels= new JLabel[7];
	JLabel[][] datelabels= new JLabel[5][7];
	Calendar(){
		/*ds=new DateStamp();
		ds.cl=this;
		ds.start();
		*/
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch(ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e){
			System.out.println(e);
		}
		im= new ImageIcon("CalendarWall.jpg");
		jl=new JLabel(im);
		add(jl);
		jl.setBounds(0,0,350,350);
		Color col= Color.BLACK;
		String fontString="Comic Sans MS";
		Font font= new Font(fontString,Font.PLAIN,20),fontSmall= new Font(fontString,Font.PLAIN,20);
		mlabel=new JLabel("",JLabel.CENTER);
		mlabel.setFont(font);
		mlabel.setForeground(col);
		mlabel.setBounds(87,0,88,50);
		jl.add(mlabel);
		ylabel=new JLabel("",JLabel.CENTER);
		ylabel.setFont(font);
		ylabel.setForeground(col);
		ylabel.setBounds(175,0,88,50);
		jl.add(ylabel);
		prev=new JButton("<");
		prev.setFont(font);
		prev.setForeground(col);
		prev.setBounds(10,10,67,30);
		jl.add(prev);
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(mlabel.getText().equals("Jan")){
					monthNum=11;
					mlabel.setText(months[monthNum]);
					ylabel.setText(String.valueOf(--year));
				}
				else{
					mlabel.setText(months[--monthNum]);
				}
				setPlace();
			}
		});
		next=new JButton(">");
		next.setFont(font);
		next.setForeground(col);
		next.setBounds(273,10,67,30);
		jl.add(next);
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(mlabel.getText().equals("Dec")){
					monthNum=0;
					mlabel.setText(months[monthNum]);
					ylabel.setText(String.valueOf(++year));
				}
				else{
					mlabel.setText(months[++monthNum]);
				}
				setPlace();
			}
		});
		for(int i=0;i<7;i++){
			dayslabels[i]= new JLabel(days[i],JLabel.CENTER);
			dayslabels[i].setBounds(i*50,50,50,50);
			jl.add(dayslabels[i]);
			dayslabels[i].setFont(font);
			dayslabels[i].setForeground(col);
			//dayslabels[i].setOpaque(true);
			//dayslabels[i].setBackground(Color.red);
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<7;j++){
				datelabels[i][j]= new JLabel("",JLabel.CENTER);
				datelabels[i][j].setBounds(j*50,100+i*50,50,50);
				//datelabels[i][j].setFocusPainted(false);
				jl.add(datelabels[i][j]);
				datelabels[i][j].setFont(fontSmall);
				datelabels[i][j].setForeground(col);
			}
		}
		prev.setFocusPainted(false);
		next.setFocusPainted(false);
		setLayout(null);
		//jt= new JTable(dates,days);
		//sp= new JScrollPane(jt);
		//add(sp);
	}
	
	/*public void paint(Graphics g){
		g.drawImage(im,0,0,this);
		g.drawString(String.valueOf(date),50,50);
	}*/
	
	int findPlace(int thisYear){
		int place=0;
		place= (1+monthValue[monthNum]+(thisYear%100)+((thisYear%100)/4)+(centuryValue[((thisYear/100)+1)%4]))%7;
		for(int i=0;i<7;i++){
			if(dayValue[i]==place)
				return i;
		}
		return -1;
	}
	
	void setPlace(){
		for(int i=0;i<5;i++){
			for(int j=0;j<7;j++){
				datelabels[i][j].setText("");
			}
		}
		monthMaxDays[1]=(year%4==0)?29:28;
		monthValue[0]=(year%4==0)?0:1;
		monthValue[1]=(year%4==0)?3:4;
		int h=findPlace(year),dateVal=1;
		datelabels[0][h++].setText(String.valueOf(dateVal++));
		for(int i=h;i<7;i++){
			datelabels[0][h++].setText(String.valueOf(dateVal++));
		}
		for(int i=1;i<5;i++){
			for(int j=0;j<7;j++){
				if(dateVal<=monthMaxDays[monthNum])
				datelabels[i][j].setText(String.valueOf(dateVal++));
			}
		}
		for(int i=0;i<5;i++)
		if(dateVal<=monthMaxDays[monthNum])
				datelabels[0][i].setText(String.valueOf(dateVal++));
	}
	
	void refresh(){
		this.date=ds.date;
		this.month=ds.month;
		this.year=ds.year;
		this.day=ds.day;
		for(int i=0;i<12;i++){
			if(month.equals(months[i]))
				monthNum=i;
		}
		mlabel.setText(month);
		ylabel.setText(String.valueOf(year));
		setPlace();
		//repaint();
	}
}