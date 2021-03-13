import java.awt.*;
import javax.swing.*;

class CurrentDate extends JLabel{
	int date,year;
	String month,day;
	DateStamp ds;
	//JLabel dlabel,mlabel,ylabel,daylabel;
	Image im;
	String fontString="Comic Sans MS";
	String oneDigit;
	Font font= new Font(fontString,Font.PLAIN,37);
	CurrentDate(){
		/*ds=new DateStamp();
		ds.cl=this;
		ds.start();
		*/
		im= new ImageIcon("CurrentDateWall.png").getImage();
		/*dlabel= new JLabel();
		mlabel= new JLabel();
		ylabel= new JLabel();
		daylabel= new JLabel();
		add(dlabel);*/
	}
	
	public void paint(Graphics g){
		g.drawImage(im,0,0,this);
		g.setFont(font);
		if(date<10)
			oneDigit="0"+date;
		else
			oneDigit=String.valueOf(date);
		g.drawString(day+", "+oneDigit+"/"+month+"/"+String.valueOf(year),10,65);
	}
	
	void refresh(){
		this.date=ds.date;
		this.month=ds.month;
		this.year=ds.year;
		this.day=ds.day;
		repaint();
	}
}