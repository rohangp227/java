import java.util.Date;

class DateStamp extends Thread{
	/*
	day month date hour:minute:second IST year
	0-day
	1-month
	2-date
	3-hour
	4-minute
	5-second
	6-IST
	7-year
	*/
	Date d;
	int date,year,hour,hour24,minute,second;
	String day,month,meridiem;
	boolean pm;
	String dateString,dateComponent[]=new String[8];
	AnalogClock ac;//attach an analog clock here
	DigitalClock dc;//attach a digital clock here
	Calendar cl;//attach a calendar here
	CurrentDate cd;//attach a current date here
	DateStamp(AnalogClock ac, DigitalClock dc, Calendar cl, CurrentDate cd){
		this.ac=ac;
		ac.ds=this;
		this.dc=dc;
		dc.ds=this;
		this.cl=cl;
		cl.ds=this;
		this.cd=cd;
		cd.ds=this;
	}
	public void run(){
		d= new Date();
		decodeDate();
		cl.refresh();
		cd.refresh();
		while(true){
			d= new Date();
			decodeDate();
			SleepThread.sleeper(1000);
		}
	}
	void decodeDate(){
		String dateString=d.toString();
		//System.out.print(dateString+" ");
		dateComponent=dateString.split(" |:");
		day=dateComponent[0];
		month=dateComponent[1];
		date=Integer.parseInt(dateComponent[2]);
		hour24=Integer.parseInt(dateComponent[3]);
		hour=(hour24<12)?hour24:(hour24-12);
		minute=Integer.parseInt(dateComponent[4]);
		second=Integer.parseInt(dateComponent[5]);
		year=Integer.parseInt(dateComponent[7]);
		if(hour24>=12)
			pm=true;
		else
			pm=false;
		meridiem=(pm)?"PM":"AM";
		/*for(int i=0;i<8;i++){
			System.out.print(dateComponent[i]+" ");
		}
		System.out.println(hour);
		System.out.println(meridiem);
		*/
		ac.refresh();
		dc.refresh();
		if(hour24==0 && minute==0 && second== 0){
			cl.refresh();
			cd.refresh();
		}
	}
}