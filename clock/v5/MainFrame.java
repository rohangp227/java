import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MainFrame{
	JFrame j;
	static JLabel jf;
	AnalogClock clockWall;
	DigitalClock digiclock;
	Calendar caln;
	CurrentDate today;
	DateStamp ds;
	static Icon sr,dl,ss,dn,wood;
	MainFrame(){
		j= new JFrame("Date and Time");
		wood=new ImageIcon("wooden.jpg");
		sr=new ImageIcon("sunrise.gif");
		dl=new ImageIcon("daylight.gif");
		ss=new ImageIcon("sunset.gif");
		dn=new ImageIcon("darknight.gif");
		jf= new JLabel(wood);
		jf.setBounds(0,0,800,550);
		clockWall=new AnalogClock();
		jf.add(clockWall);
		clockWall.setBounds(50,50,300,300);
		digiclock=new DigitalClock();
		jf.add(digiclock);
		digiclock.setBounds(50,420,300,100);
		caln=new Calendar();
		jf.add(caln);
		caln.setBounds(400,50,350,350);
		today=new CurrentDate();
		jf.add(today);
		today.setBounds(400,420,350,100);
		ds= new DateStamp(clockWall,digiclock,caln,today);
		ds.start();	
		j.add(jf);
		j.setDefaultCloseOperation(3);
		j.setLayout(null);
		j.setBounds(50,50,800,570);
		j.setResizable(false);
		j.setVisible(true);
	}
}