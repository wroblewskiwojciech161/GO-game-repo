package gogame.client.gui;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gogame.client.game.pawn.Pawn;
import gogame.client.game.pawn.PawnPanel;
import gogame.client.game.performance.Game;
import gogame.client.transProtocol.TcpClient;


public class GameMouseListener extends MouseAdapter{
	
	private PawnPanel panel;
	TcpClient client = new TcpClient();
	
	public GameMouseListener (PawnPanel panel) {
		super();
		this.panel=panel;
	}
	
	
	int x,y;
	public void mouseClicked(MouseEvent e)
	{
		System.out.println(e.getX()+" "+e.getY());
		 x=e.getX();y=e.getY();
		 
		 for(ClickAreaSquare s  : panel.squares) {
				
				if(s.isInsideSquare(e.getX(), e.getY())){
					
					
					//panel.addPawn(new Pawn(s.getX(),s.getY(),30,Color.black));
					//Game game= Game.getInstance();
					//game.xMoved=s.getX(); game.yMoved=s.getY();
					//game.sendMove();
					String tempx=String.valueOf(s.getX());
					String tempy=String.valueOf(s.getY());
					
					client.sendMessage("MOVE "+tempx+" "+tempy);
					
				}
				
					
			}System.out.println(panel.pawns.size());
		
	}
	public  int getX () {return x;}
	public  int getY () {return y;}
	
	
	
	
	
	
	
	

}
