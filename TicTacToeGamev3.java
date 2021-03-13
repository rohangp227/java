import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Game implements ActionListener{
	JFrame main;
	JLabel message;
	JButton start,numOfPlayer,tile[][]= new JButton[3][3];
	int i,j;//,k;
	boolean turn,mode=false;
	int playedTile[][]= new int[3][3];
	int totalTurns,turnInt=-1,turnIntOpp=-1;
	//int [] o= new int[9],x= new int[9];
	
	Game(){
		main= new JFrame("Tic Tac Toe");
		//k=0;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				tile[i][j]= new JButton();
				main.add(tile[i][j]);
				tile[i][j].addActionListener(this);
				tile[i][j].setBounds(j*75,i*75,75,75);
				playedTile[i][j]=-1;
				//k++;
			}
		}
		turnInt=(turn)?0:1;
		turnIntOpp=(turn)?1:0;
		//System.out.print(turnInt);
		message= new JLabel("X player turn");
		main.add(message);
		message.setBounds(0,225,225,50);
		
		start= new JButton("Reset");
		main.add(start);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(i=0;i<3;i++){
				for(j=0;j<3;j++){
					tile[i][j].setBackground(null);
					tile[i][j].setText("");
					tile[i][j].setEnabled(true);
					//o[t]=0;
					//x[t]=0;
					playedTile[i][j]=-1;
				}}
				message.setText("X player turn");
				turn=false;//false for X as first and true for O as second player
				turnInt=(turn)?0:1;
				turnIntOpp=(turn)?1:0;
				totalTurns=0;
			}
		});
		start.setBounds(0,275,225,50);
		
		numOfPlayer= new JButton("Change to Single Player");
		main.add(numOfPlayer);
		numOfPlayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!mode){
				numOfPlayer.setText("Change to Two Player");
				mode=true;
				}
				else{
				numOfPlayer.setText("Change to Single Player");
				mode=false;
				}
				for(i=0;i<3;i++){
				for(j=0;j<3;j++){
					tile[i][j].setBackground(null);
					tile[i][j].setText("");
					tile[i][j].setEnabled(true);
					//o[t]=0;
					//x[t]=0;
					playedTile[i][j]=-1;
				}}
				message.setText("X player turn");
				turn=false;//false for X as player and true for O as CPU
				turnInt=(turn)?0:1;
				turnIntOpp=(turn)?1:0;
				totalTurns=0;
			}
		});
		numOfPlayer.setBounds(0,325,225,50);
		
		main.setLayout(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setResizable(false);
		main.setBounds(50,50,240,410);
		main.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int x=0,y=0;
		if((++totalTurns)<=9){
		for(x=0;x<3;x++){
		for(y=0;y<3;y++){
		if(e.getSource()==tile[x][y]){
		if(turn){
			tile[x][y].setText("O");
			tile[x][y].setEnabled(false);
			//o[r]=1;
			playedTile[x][y]=1;
			message.setText("X player turn");
			turn=false;
			turnInt=(turn)?0:1;
			turnIntOpp=(turn)?1:0;
		}
		else{
			tile[x][y].setText("X");
			tile[x][y].setEnabled(false);
			//x[r]=1;
			playedTile[x][y]=0;
			message.setText("O player turn");
			turn=true;
			turnInt=(turn)?0:1;
			turnIntOpp=(turn)?1:0;
		}
		break;
		}}}
		if(!winner()){}
			if(mode)
				cpuPlayer();
		}
	}
		
	boolean winner(){
		int t=0,u=0,w=0,e=0;
		for(w=0;w<3;w++){
		//for(e=0;e<3;e++){
		if(playedTile[w][0]==0 && playedTile[w][1]==0 && playedTile[w][2]==0){
			message.setText("X is winner");
			tile[w][0].setBackground(Color.red);
			tile[w][1].setBackground(Color.red);
			tile[w][2].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}
		if(playedTile[w][0]==1 && playedTile[w][1]==1 && playedTile[w][2]==1){
			message.setText("O is winner");
			tile[w][0].setBackground(Color.red);
			tile[w][1].setBackground(Color.red);
			tile[w][2].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}
		}//}
		for(w=0;w<3;w++){
		//for(e=0;e<3;e++){
		if(playedTile[0][w]==0 && playedTile[1][w]==0 && playedTile[2][w]==0){
			message.setText("X is winner");
			tile[0][w].setBackground(Color.red);
			tile[1][w].setBackground(Color.red);
			tile[2][w].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}
		if(playedTile[0][w]==1 && playedTile[1][w]==1 && playedTile[2][w]==1){
			message.setText("O is winner");
			tile[0][w].setBackground(Color.red);
			tile[1][w].setBackground(Color.red);
			tile[2][w].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}
		}//}
		//for(w=0;w<3;w++){
		//for(e=0;e<3;e++){
		if(playedTile[0][0]==0 && playedTile[1][1]==0 && playedTile[2][2]==0){
			message.setText("X is winner");
			tile[0][0].setBackground(Color.red);
			tile[1][1].setBackground(Color.red);
			tile[2][2].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}//}//}
		//for(w=0;w<3;w++){
		//for(e=0;e<3;e++){
		if(playedTile[0][0]==1 && playedTile[1][1]==1 && playedTile[2][2]==1){
			message.setText("O is winner");
			tile[0][0].setBackground(Color.red);
			tile[1][1].setBackground(Color.red);
			tile[2][2].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}//}//}
		if(playedTile[0][2]==0 && playedTile[1][1]==0 && playedTile[2][0]==0){
			message.setText("X is winner");
			tile[0][2].setBackground(Color.red);
			tile[1][1].setBackground(Color.red);
			tile[2][0].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}//}//}
		//for(w=0;w<3;w++){
		//for(e=0;e<3;e++){
		if(playedTile[0][2]==1 && playedTile[1][1]==1 && playedTile[2][0]==1){
			message.setText("O is winner");
			tile[0][2].setBackground(Color.red);
			tile[1][1].setBackground(Color.red);
			tile[2][0].setBackground(Color.red);
			for(t=0;t<3;t++)
			for(u=0;u<3;u++)
				tile[t][u].setEnabled(false);
			return true;
		}//}//}
		else if(totalTurns==9){
			message.setText("Draw");
			return true;
		}
		return false;
	}
	
	int r=-1,s=-1,g=0;
	//boolean onCenterChecked=false;
	void cpuPlayer(){
		if((++totalTurns)<=9){
		
		bestMove();
		
		
		if(turn){
			//System.out.print(r+" "+s);
			tile[r][s].setText("O");
			tile[r][s].setEnabled(false);
			//o[r]=1;
			playedTile[r][s]=1;
			message.setText("X player turn");
			turn=false;
			turnInt=(turn)?0:1;
			turnIntOpp=(turn)?1:0;
		}
		else{
			tile[r][s].setText("X");
			tile[r][s].setEnabled(false);
			//x[r]=1;
			playedTile[r][s]=0;
			message.setText("O player turn");
			turn=true;
			turnInt=(turn)?0:1;
			turnIntOpp=(turn)?1:0;
		}
		winner();
		}
	}
	
	void bestMove(){
		//turnInt=(turn)?1:0;//reversed
		//int g=0,h=0;
		for(g=0;g<3;g++){
		if(playedTile[g][0]==turnIntOpp && playedTile[g][1]==turnIntOpp && playedTile[g][2]==-1){
			r=g;s=2;//return tile[g][2];//true;
			return;
		}if(playedTile[g][0]==turnIntOpp && playedTile[g][1]==-1 && playedTile[g][2]==turnIntOpp){
			r=g;s=1;//return tile[g][2];//true;
			return;
		}
		if(playedTile[g][0]==-1 && playedTile[g][1]==turnIntOpp && playedTile[g][2]==turnIntOpp){
			r=g;s=0;//return tile[g][2];//true;
			return;
		}
		
		if(playedTile[0][g]==turnIntOpp && playedTile[1][g]==turnIntOpp && playedTile[2][g]==-1){
			r=2;s=g;//return tile[2][g];//true;
			return;
		}
		if(playedTile[0][g]==turnIntOpp && playedTile[1][g]==-1 && playedTile[2][g]==turnIntOpp){
			r=1;s=g;//return tile[2][g];//true;
			return;
		}
		if(playedTile[0][g]==-1 && playedTile[1][g]==turnIntOpp && playedTile[2][g]==turnIntOpp){
			r=0;s=g;//return tile[2][g];//true;
			return;
		}
		}
		
		if(playedTile[0][0]==turnIntOpp && playedTile[1][1]==turnIntOpp && playedTile[2][2]==-1){
			r=2;s=2;//return tile[2][2];//true;
			return;
		}
		if(playedTile[0][0]==turnIntOpp && playedTile[1][1]==-1 && playedTile[2][2]==turnIntOpp){
			r=1;s=1;//return tile[2][2];//true;
			return;
		}
		if(playedTile[0][0]==-1 && playedTile[1][1]==turnIntOpp && playedTile[2][2]==turnIntOpp){
			r=0;s=0;//return tile[2][2];//true;
			return;
		}
		
		if(playedTile[0][2]==turnIntOpp && playedTile[1][1]==turnIntOpp && playedTile[2][0]==-1){
			r=2;s=0;//return tile[2][0];//true;
			return;
		}
		if(playedTile[0][2]==turnIntOpp && playedTile[1][1]==-1 && playedTile[2][0]==turnIntOpp){
			r=1;s=1;//return tile[2][0];//true;
			return;
		}
		if(playedTile[0][2]==-1 && playedTile[1][1]==turnIntOpp && playedTile[2][0]==turnIntOpp){
			r=0;s=2;//return tile[2][0];//true;
			return;
		}
		//return false;
		//turnInt=(turn)?0:1;//normal
		
		
		//int g=0,h=0;
		for(g=0;g<3;g++){
		if(playedTile[g][0]==turnInt && playedTile[g][1]==turnInt && playedTile[g][2]==-1){
			r=g;s=2;//return tile[g][2];//true;
			return;
		}
		if(playedTile[g][0]==turnInt && playedTile[g][1]==-1 && playedTile[g][2]==turnInt){
			r=g;s=1;//return tile[g][2];//true;
			return;
		}
		if(playedTile[g][0]==-1 && playedTile[g][1]==turnInt && playedTile[g][2]==turnInt){
			r=g;s=0;//return tile[g][2];//true;
			return;
		}
		
		if(playedTile[0][g]==turnInt && playedTile[1][g]==turnInt && playedTile[2][g]==-1){
			r=2;s=g;//return tile[2][g];//true;
			return;
		}
		if(playedTile[0][g]==turnInt && playedTile[1][g]==-1 && playedTile[2][g]==turnInt){
			r=1;s=g;//return tile[2][g];//true;
			return;
		}
		if(playedTile[0][g]==-1 && playedTile[1][g]==turnInt && playedTile[2][g]==turnInt){
			r=0;s=g;//return tile[2][g];//true;
			return;
		}
		}
		
		if(playedTile[0][0]==turnInt && playedTile[1][1]==turnInt && playedTile[2][2]==-1){
			r=2;s=2;//return tile[2][2];//true;
			return;
		}
		if(playedTile[0][0]==turnInt && playedTile[1][1]==-1 && playedTile[2][2]==turnInt){
			r=1;s=1;//return tile[2][2];//true;
			return;
		}
		if(playedTile[0][0]==-1 && playedTile[1][1]==turnInt && playedTile[2][2]==turnInt){
			r=0;s=0;//return tile[2][2];//true;
			return;
		}
		
		if(playedTile[0][2]==turnInt && playedTile[1][1]==turnInt && playedTile[2][0]==-1){
			r=2;s=0;//return tile[2][0];//true;
			return;
		}
		if(playedTile[0][2]==turnInt && playedTile[1][1]==-1 && playedTile[2][0]==turnInt){
			r=1;s=1;//return tile[2][0];//true;
			return;
		}
		if(playedTile[0][2]==-1 && playedTile[1][1]==turnInt && playedTile[2][0]==turnInt){
			r=0;s=2;//return tile[2][0];//true;
			return;
		}
		//return false;
		
		
		/*if(!onCenterChecked && onCenter){
			r=2;s=2;
			onCenterChecked=true;
		}*/
		
		//center
		//System.out.print("innn "+turn+" "+turnInt+" "+playedTile[1][1]+" "+playedTile[2][2]);
		if(playedTile[1][1]==turnInt && playedTile[2][2]==-1){
			
			r=2;s=2;
			return;
		}
		if(playedTile[1][1]==turnInt && playedTile[2][2]==turnIntOpp && playedTile[0][2]==-1){
			r=0;s=2;
			return;
		}
		
		
		//edge
		//first
		if(playedTile[0][1]==turnInt && playedTile[2][1]==-1){
			r=2;s=1;return;
		}
		if(playedTile[1][0]==turnInt && playedTile[1][2]==-1){
			r=1;s=2;return;
		}
		if(playedTile[2][1]==turnInt && playedTile[0][1]==-1){
			r=0;s=1;return;
		}
		if(playedTile[1][2]==turnInt && playedTile[1][0]==-1){
			r=1;s=0;return;
		}
		//second
		if(playedTile[0][1]==turnInt && playedTile[2][1]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[0][2]==-1){
			r=0;s=2;return;
		}
		if(playedTile[1][0]==turnInt && playedTile[1][2]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[0][0]==-1){
			r=0;s=0;return;
		}
		if(playedTile[2][1]==turnInt && playedTile[0][1]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[2][0]==-1){
			r=2;s=0;return;
		}
		if(playedTile[1][2]==turnInt && playedTile[1][0]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[2][2]==-1){
			r=2;s=2;return;
		}
		//third
		if(playedTile[0][1]==turnInt && playedTile[2][1]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[0][2]==turnIntOpp && playedTile[2][0]==turnInt && playedTile[1][0]==-1){
			r=1;s=0;return;
		}
		if(playedTile[1][0]==turnInt && playedTile[1][2]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[0][0]==turnIntOpp && playedTile[2][2]==turnInt && playedTile[2][1]==-1){
			r=2;s=1;return;
		}
		if(playedTile[2][1]==turnInt && playedTile[0][1]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[2][0]==turnIntOpp && playedTile[0][2]==turnInt && playedTile[1][2]==-1){
			r=1;s=2;return;
		}
		if(playedTile[1][2]==turnInt && playedTile[1][0]==turnIntOpp && playedTile[1][1]==turnInt && playedTile[2][2]==turnIntOpp && playedTile[0][0]==turnInt && playedTile[0][1]==-1){
			r=0;s=1;return;
		}
		
		
		//corner
		//first
		if((playedTile[0][0]==turnInt || playedTile[0][2]==turnInt || playedTile[2][2]==turnInt || playedTile[2][0]==turnInt) && playedTile[1][1]==-1){
			r=1;s=1;return;
		}
		//second
		if(((playedTile[0][0]==turnInt && playedTile[1][1]==turnIntOpp && playedTile[2][2]==turnInt) || (playedTile[0][2]==turnInt && playedTile[1][1]==turnIntOpp && playedTile[2][0]==turnInt) || (playedTile[2][2]==turnInt && playedTile[1][1]==turnIntOpp && playedTile[0][0]==turnInt) || (playedTile[2][0]==turnInt && playedTile[1][1]==turnIntOpp && playedTile[0][2]==turnInt)) && playedTile[2][1]==-1){
			r=2;s=1;return;
		}
		//third
		if(playedTile[][]==turnInt && playedTile[1][1]==turnIntOpp && (playedTile[0][2]==turnInt || playedTile[][]==turnInt) && playedTile[][]==-1){
			r=;s=;return;
		}
		if(playedTile[][]==turnInt && playedTile[1][1]==turnIntOpp && (playedTile[0][2]==turnInt || playedTile[][]==turnInt) && playedTile[][]==-1){
			r=;s=;return;
		}
		if(playedTile[][]==turnInt && playedTile[1][1]==turnIntOpp && (playedTile[0][2]==turnInt || playedTile[][]==turnInt) && playedTile[][]==-1){
			r=;s=;return;
		}
		if(playedTile[][]==turnInt && playedTile[1][1]==turnIntOpp && (playedTile[0][2]==turnInt || playedTile[][]==turnInt) && playedTile[][]==-1){
			r=;s=;return;
		}
		
		
		//no move left
		for(int o=0;o<3;o++)
			for(int p=0;p<3;p++)
				if(playedTile[o][p]==-1){
					r=o;s=p;
					return;
				}
	}
	
	/*boolean onCenter(){
		if(playedTile[1][1]==0 && totalTurns==1){
			return true;
		}
		return false;
	}*/
	/*boolean onEdge(){
		if(playedTile[0][1]==0){
			return true;
		}
		if(playedTile[1][2]==0){
			return true;
		}
		if(playedTile[2][1]==0){
			return true;
		}
		if(playedTile[1][0]==0){
			return true;
		}
		return false;
	}*/
	/*boolean onCorner(){
		if(playedTile[0][0]==0){
			return true;
		}
		if(playedTile[0][2]==0){
			return true;
		}
		if(playedTile[2][2]==0){
			return true;
		}
		if(playedTile[2][0]==0){
			return true;
		}
		return false;
	}*/
	/*JButton onLine(){
		int g=0,h=0;
		for(g=0;g<3;g++){
		if(playedTile[g][0]==0 && playedTile[g][1]==0 && playedTile[g][2]==-1){
			return tile[g][2];//true;
		}
		if(playedTile[0][g]==0 && playedTile[1][g]==0 && playedTile[2][g]==-1){
			return tile[2][g];//true;
		}
		}
		if(playedTile[0][0]==0 && playedTile[1][1]==0 && playedTile[2][2]==-1){
			return tile[2][2];//true;
		}if(playedTile[0][2]==0 && playedTile[1][1]==0 && playedTile[2][0]==-1){
			return tile[2][0];//true;
		}
		return false;
	}*/
	
	public static void main(String [] args){
		new Game();
	}
}

/*r=0;s=0;
		if(totalTurns==2){r=0;s=0;}
		if(totalTurns==4){r=1;s=1;}
		if(totalTurns==6){r=2;s=2;}*/
		
		/*if(x[0]==1 && x[1]==1 && x[2]==0 && o[2]==0){
		r=2;
		}
		else if(x[3]==1 && x[4]==1 && x[5]==0 && o[2]==0){
		r=5;
		}
		else if(x[6]==1 && x[7]==1 && x[8]==0 && o[8]==0){
		r=8;
		}
		
		else if(x[0]==1 && x[3]==1 && x[6]==0 && o[6]==0){
		r=6;
		}
		else if(x[1]==1 && x[4]==1 && x[7]==0 && o[7]==0){
		r=7;
		}else if(x[2]==1 && x[5]==1 && x[8]==0 && o[8]==0){
		r=8;
		}*/
		/*
		else if(x[]==1 && x[]==1 && x[]==0 && o[]==0){
		r=;
		}*/