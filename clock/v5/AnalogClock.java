import java.awt.*;
import javax.swing.*;

class AnalogClock extends JLabel{
	Image cl=new ImageIcon("clock.gif").getImage();
	int hx=150,hy=10,mx=150,my=10,sx=150,sy=10;
	double pi= Math.PI;
	int hrad=80,mrad=110,srad= 140,center=150;
	int hour,minute,second;
	//String meridiem;
	DateStamp ds;
	/*AnalogClock(){
		ds=new DateStamp();
		ds.c=this;
		ds.start();
	}*/
	public void paint(Graphics g){
		g.drawImage(cl,0,0,this);
		g.setColor(Color.RED);
		g.drawLine(150,150,sx,sy);
		g.setColor(Color.BLACK);
		g.drawLine(150,150,mx,my);
		g.drawLine(150,150,hx,hy);
	}
	void refresh(){
		this.hour=ds.hour;
		this.minute=ds.minute;
		this.second=ds.second;
		if(second<=15){
			sx=(int)(center+(srad*Math.sin(second*pi/30)));
			sy=(int)(center-(srad*Math.cos(second*pi/30)));
		}
		else if(second<=30){
			sx=(int)(center+(srad*Math.cos((second-15)*pi/30)));
			sy=(int)(center+(srad*Math.sin((second-15)*pi/30)));
		}
		else if(second<=45){
			sx=(int)(center-(srad*Math.sin((second-30)*pi/30)));
			sy=(int)(center+(srad*Math.cos((second-30)*pi/30)));
		}
		else if(second<=60){
			sx=(int)(center-(srad*Math.cos((second-45)*pi/30)));
			sy=(int)(center-(srad*Math.sin((second-45)*pi/30)));
		}
		
		if(minute<=15){
			mx=(int)(center+(mrad*Math.sin(minute*pi/30)));
			my=(int)(center-(mrad*Math.cos(minute*pi/30)));
		}
		else if(minute<=30){
			mx=(int)(center+(mrad*Math.cos((minute-15)*pi/30)));
			my=(int)(center+(mrad*Math.sin((minute-15)*pi/30)));
		}
		else if(minute<=45){
			mx=(int)(center-(mrad*Math.sin((minute-30)*pi/30)));
			my=(int)(center+(mrad*Math.cos((minute-30)*pi/30)));
		}
		else if(minute<=60){
			mx=(int)(center-(mrad*Math.cos((minute-45)*pi/30)));
			my=(int)(center-(mrad*Math.sin((minute-45)*pi/30)));
		}
		
		if(hour<=3){
			hx=(int)(center+(hrad*Math.sin(hour*pi/6+(minute/12)*(pi/30))));
			hy=(int)(center-(hrad*Math.cos(hour*pi/6+(minute/12)*(pi/30))));
		}
		else if(hour<=6){
			hx=(int)(center+(hrad*Math.cos((hour-3)*pi/6+(minute/12)*(pi/30))));
			hy=(int)(center+(hrad*Math.sin((hour-3)*pi/6+(minute/12)*(pi/30))));
		}
		else if(hour<=9){
			hx=(int)(center-(hrad*Math.sin((hour-6)*pi/6+(minute/12)*(pi/30))));
			hy=(int)(center+(hrad*Math.cos((hour-6)*pi/6+(minute/12)*(pi/30))));
		}
		else if(hour<12){
			hx=(int)(center-(hrad*Math.cos((hour-9)*pi/6+(minute/12)*(pi/30))));
			hy=(int)(center-(hrad*Math.sin((hour-9)*pi/6+(minute/12)*(pi/30))));
		}
		
		repaint();
	}
}