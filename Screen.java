import java.awt.Toolkit;

import javax.swing.JFrame;


public class Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private Map mainMap;
	private Menu menu;
	private EndGame endGame;
	private int nbPlayers;
	
	public Screen(){
		nbPlayers=2;
	}
	
	public void createAndDisplay(int nbPlayers){
		this.nbPlayers=nbPlayers;
		setWindow();
		setComponents();
	}
	
	public Map getMap(){
		return mainMap;
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public EndGame getEndGame(){
		return endGame;
	}
	
	public void setWindow(){
		
		setSize(1200,812);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setAlwaysOnTop(false);  
		setTitle("Les Colons de l'UTBohèMe");
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources/icon.png"));
	}
	
	public void setComponents(){
		
		getContentPane().setLayout(null);
		
		mainMap = new Map();
		
		mainMap.setBounds(0,0,697,812);
		add(mainMap);
		
		menu = new Menu(nbPlayers,mainMap);
		menu.setBounds(694,-5,500,812);
		add(menu);
		
		mainMap.define(this);

		setVisible(true);
	}
	
	public void setEndGame(Map map){
		endGame = new EndGame(map);
		endGame.setBounds(0,0,1200,812);
		add(endGame);
	}
}
