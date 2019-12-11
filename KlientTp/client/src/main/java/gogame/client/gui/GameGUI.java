package gogame.client.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gogame.client.game.pawn.Pawn;
import gogame.client.game.pawn.PawnPanel;
import gogame.client.game.performance.Game;
import gogame.client.transProtocol.TcpClient;

public class GameGUI extends JFrame {
	public static boolean gameStarted=false;
	
     
	
	static JFrame frame;
     JButton buttonConnect,buttonSize9,buttonSize13,
     buttonSize19,buttonGameMulti,buttonGameSingle,
     buttonExit,buttonPass,start;
     
     JLabel labelTurn;
     JPanel panel1;
     PawnPanel pawnPanel;
     
     public static int turn;
     public static boolean pass=false;
     public static boolean connect = false;
     public static boolean exit = false;
     public volatile static boolean singlePlayer =false;
     public volatile static boolean multiPlayer = false;
     public static int size=0;
     public static Color color;
     public String gameType;
     
	public void gameFrame(){
		
	 
	    frame = new JFrame();
		frame.setSize(900,900);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);	
	//	frame.setLayout(new BorderLayout());
		
	     buttonConnect = new JButton("connect ");
	     buttonSize9 = new JButton("9");
	     buttonSize13 = new JButton("13");
	     buttonSize19 = new JButton("19");
	     buttonGameMulti = new JButton("Multiplayer");
	     buttonGameSingle = new JButton("Singleplayer");
	     buttonExit = new JButton("EXIT");
	     buttonPass = new JButton("PASS");
	     labelTurn = new JLabel("TURN");
	    
		panel1= new JPanel();
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0,750,900,150);
		panel1.setLayout(new GridLayout(1,8));
		pawnPanel = new PawnPanel();
		pawnPanel.addMouseListener(new GameMouseListener(pawnPanel));
		frame.add(panel1);
		frame.add(pawnPanel);
		
	
	    panel1.add(buttonConnect);
	    panel1.add(buttonSize9);
	    panel1.add(buttonSize13);
	    panel1.add(buttonSize19);
	    panel1.add(buttonGameMulti);
	    panel1.add(buttonGameSingle);
	    panel1.add(buttonExit);
	    panel1.add(buttonPass);
	  
	    frame.setVisible(true);
	    frame.repaint();
	    
	     final Game game= Game.getInstance();
	    final TcpClient client = new TcpClient();
		
       
         
         buttonPass.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        	 
        	   pass=true;
        	   client.sendMessage("PASS");
         		}
        });
         buttonSize9.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	 
            	 size=9;
            	 client.sendMessage("SIZE 9");
            	 
             		}
            });
         buttonSize13.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	 
            	 size =13;
             		}
            });
         buttonSize19.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	 size =19;
            	 
             		}
            });
         buttonGameSingle.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	 
            	  System.out.println(multiPlayer);
             	 multiPlayer=true;
             	 System.out.println(multiPlayer);
             		}
            });
         buttonGameMulti.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	  System.out.println(multiPlayer);
            	 multiPlayer=true;
            	 System.out.println(multiPlayer);
            	 
            	 
             		}
            });
         buttonConnect.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	   connect =true;
            	 
             		}
            });
       
         buttonExit.addActionListener(new ActionListener() {
             
             public void actionPerformed(ActionEvent e) {
            	 
            	 exit=true;
             	}
            });
         
           
	}
	
//--------------------------------------------------------------------METODY
	public void addPawn(int x, int y,Color color) {
		
		 pawnPanel.addPawn(new Pawn(x,y,24,color));
		 pawnPanel.repaint();
	}
	public void removePawn(int x, int y ,Color color) {
		
		 pawnPanel.addPawn(new Pawn(x,y,24,color));
		 pawnPanel.repaint();
	}
	public boolean gameChosen() {
		if((size!=0)  && ((singlePlayer==true) || (multiPlayer==true))) {return true;}
		else return false;
		
		
	}
	public String getSize(int size)
	{
		return String.valueOf(size);
	}
	
	public String getGameType() {
		return gameType;
		
	}
	public void disabledBeforeConnection() {
		buttonSize9.setEnabled(false);
		buttonSize13.setEnabled(false);
		buttonSize19.setEnabled(false);
		buttonGameMulti.setEnabled(false);
		buttonGameSingle.setEnabled(false);
		buttonExit.setEnabled(false);
		buttonPass.setEnabled(false);
		
	}
	public void enabledAfterConnection() {
		buttonSize9.setEnabled(true);
		buttonSize13.setEnabled(true);
		buttonSize19.setEnabled(true);
		buttonGameMulti.setEnabled(true);
		buttonGameSingle.setEnabled(true);
		buttonConnect.setEnabled(false);
		
	}
	public void disableAfterChoice() {
		buttonSize9.setEnabled(false);
		buttonSize13.setEnabled(false);
		buttonSize19.setEnabled(false);
		buttonGameMulti.setEnabled(false);
		buttonGameSingle.setEnabled(false);
		buttonExit.setEnabled(true);
		buttonPass.setEnabled(true);
		
	
	}
	public void addChosenBoardSize() {
		
	}
	public boolean gameStarted() {
		if(connect==true)return true;
		else return false;
	}
	
	
public static void inicialize() {
	
	  boolean status = false;
	  
      GameGUI gameGUI= new GameGUI();
      gameGUI.gameFrame();
      gameGUI.disabledBeforeConnection();
      Game game = Game.getInstance();
      /*
      while(connect!=true) {
    	if(game.gameReady) {connect = true;}
    	  System.out.println("waiting for connect");
      } connect=true;gameGUI.enabledAfterConnection();
     
      while(status!=true) {
    	  if(gameGUI.gameChosen()==true) {status=true;gameGUI.disableAfterChoice();}
    	 System.out.println("waiting !!! add size and type of a game");
      }
      
   */
    
		
	}
	
}
