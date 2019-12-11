package gogame.client.game.pawn;


import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import gogame.client.game.board.BoardGui;
import gogame.client.gui.ClickAreaSquare;


public class PawnPanel extends JPanel{
	
	
public List<Pawn> pawns = new LinkedList<Pawn>();
public List<ClickAreaSquare> squares = new LinkedList<ClickAreaSquare>();
public static int type;
public static int boardSize;

//metoda przechodzi po liscie obiektow pawn i sprawdza czy taki pawn juz zostal dodany do listy
	public boolean checkIfPawnExists(int x,int y) {
		for(Pawn p  : pawns) {
			
		  if((p.getX()==x)&&(p.getY()==y))return true;		
		}
	 return false;
	}
	
	public void addPawn(Pawn pawn) {
		pawns.add(pawn);
		this.repaint();
	}
	public void removePawn(Pawn pawn) {
		pawns.remove(pawn);
		this.repaint();
	}
	
	public void addSquare(ClickAreaSquare square) {
		squares.add(square);
		this.repaint();
	}
	
	
	
	public void paint(Graphics g) {
		
		
		// przypisanie danych z pierwszego frame co do typuy rogrywki
		
		
		BoardGui board = new BoardGui(boardSize);
		int size= board.size;   
		int y= board.stepHeight;
		int x= board.stepWidth;
		
		
		
		
		for(int i=0; i<= size ; i++) {
			g.drawLine(boardCor(size,x,y)[i][0]+7, boardCor(size,x,y)[i][1]+30, boardCor(size,x,y)[(size+1)*(size+1)-size-1 +i][0]+7,boardCor(size,x,y)[(size+1)*(size+1)-size-1 +i][1]+30);
		}
		
		for(int i=0; i<= size ; i++) {
			g.drawLine(boardCor(size,x,y)[(size+1)*i][0]+7,boardCor(size,x,y)[(size+1)*i][1]+30,boardCor(size,x,y)[(size+1)*i+size][0]+7,boardCor(size,x,y)[(size+1)*i][1]+30);
		}
		
		//square width i height na 24 na sztywniaka  
		for(int i=0 ; i<(size+1)*(size+1); i++) {	
			 squares.add(new ClickAreaSquare(boardCor(size,x,y)[i][0]-12+7,boardCor(size,x,y)[i][1]-12+30,24,24));
			}
		
		
		
		for(Pawn p  : pawns) {
			
			p.draw(g);
			
				
		}
		for(ClickAreaSquare s  : squares) {
			
			s.draw(g);
			
				
		}	
		
	}
	
	public int[][] boardCor(int size,int widthStep,int heightStep) {
		int[][] boardCoordinates= new int[(size+1)*(size+1)][2];
		//coordinates of upper left corner  (0,heighStep)
		int iterator =0;
		for(int i=1 ; i<=size+1;i++)
		{
			
			for(int j=0 ; j<=size; j++)
			{
				boardCoordinates[iterator][0]=j*widthStep+100;
				boardCoordinates[iterator][1]=heightStep*i;
			//	System.out.print(" ["+boardCoordinates[iterator][0]+" , "+boardCoordinates[iterator][1]+" ]" );
				iterator ++;
			}
		//	System.out.println("\n");
				
		}
		//System.out.println(boardCoordinates);
		return boardCoordinates;
	}
	
	public int[] coordinatesScaleConverter(int x, int y, int size) {
		int[] output = new int [2];
		int orientX=0,orientY = 0;
		if(size == 1) {orientX=100 ; orientY=65;}
		else if(size == 2) {orientX= 100; orientY=47;}
		else if(size == 3) {orientX= 100; orientY=33;}
		int tempX=0,tempY=0;
		while(x!=orientX) {
		x-=orientY;	    // odejmuje Y bo jest bez szifta i jest i tak rowny orientX (kwadratowa siatka)
		tempX++;	
		}
		while(y!=orientY) {
			y-=orientY;	   
			tempY++;	
		}
		output[0]=tempX;
		output[1]=tempY;
		return output;	
	}
	public int[] coordinatesFromBoardToPawnCovnerter(int x, int y) {
		int[] output = new int [2];
		output[0] = x+7-12;
		output[1]=y+30-12;
		return output;
	}
	public int[] coordinatesFromPawnToBoardCovnerter(int x, int y) {
		int[] output = new int [2];
		output[0] = x-7+12;
		output[1]=y-30+12;
		return output;
	}
	
	
	
	
}