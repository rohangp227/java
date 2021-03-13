import java.awt.*;
import javax.swing.*;

class DigitalClock extends JLabel{
	int hour,minute,second;
	String meridiem;
	DateStamp ds;
	boolean is24hrFormat;
	//JLabel hlabel,mlabel,slabel,merlabel;
	Image im;
	String fontString="Comic Sans MS";
	String oneDigit;
	Font font= new Font(fontString,Font.PLAIN,40);
	DigitalClock(){
		/*ds=new DateStamp();
		ds.c=this;
		ds.start();
		*/
		im= new ImageIcon("DigiClockWall.png").getImage();
		/*hlabel= new JLabel();
		mlabel= new JLabel();
		slabel= new JLabel();
		add(slabel);*/
		//slabel.setBounds(0,0,100,100);
	}
	
	public void paint(Graphics g){
		g.drawImage(im,0,0,this);
		g.setFont(font);
		if(hour<10)
			oneDigit="0"+hour;
		else
			oneDigit=String.valueOf(hour);
		g.drawString(oneDigit,22,65);
		if(minute<10)
			oneDigit="0"+minute;
		else
			oneDigit=String.valueOf(minute);
		g.drawString(oneDigit,85,65);
		if(second<10)
			oneDigit="0"+second;
		else
			oneDigit=String.valueOf(second);
		g.drawString(oneDigit,150,65);
		g.drawString(meridiem,218,65);
	}
	
	void refresh(){
		if(is24hrFormat)
			this.hour=ds.hour24;
		else
			this.hour=ds.hour;
		this.minute=ds.minute;
		this.second=ds.second;
		this.meridiem=ds.meridiem;
		if(ds.hour24<6)
			MainFrame.jf.setIcon(MainFrame.dn);
		else if(ds.hour24<8)
			MainFrame.jf.setIcon(MainFrame.sr);
		else if(ds.hour24<17)
			MainFrame.jf.setIcon(MainFrame.dl);
		else if(ds.hour24<19)
			MainFrame.jf.setIcon(MainFrame.ss);
		else if(ds.hour24<24)
			MainFrame.jf.setIcon(MainFrame.dn);
		repaint();
	}
}