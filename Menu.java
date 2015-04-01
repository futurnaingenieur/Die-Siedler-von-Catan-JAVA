/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe Menu
 * implémentant un Menu representant la partie droite de la fenêtre principale du jeu.
 * Ce menu contient les fiches de joueurs indiquant leurs ressources ainsi que les les boutons d'actions 
 * permettant de jouer. 
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private int nbPlayers;
	private Character c[];
	private JLabel info;
	private int selectedPlayer;
	private JButton buildButton;
	private JButton cardButton;
	private JButton exchangeButton;
	private JButton nextTurnButton;
	private Map map;
	private int turn1;
	private int turn2;
	
	public Menu(int nb_players, Map map){
		
		this.turn1=0;
		this.nbPlayers=nb_players;
		this.add(new JLabel(new ImageIcon("resources/cadre.png")));
		if(this.nbPlayers<=1){
			this.nbPlayers=2;
		}
		if(this.nbPlayers>4){
			this.nbPlayers=4;
		}
		this.map=map;
		
		setPlayersPanels();
		selectedPlayer=new Random().nextInt(nb_players);
		c[selectedPlayer].setSelected(true);
		setInfoPanel();
		setButtons();
	}
	
	public Map getMap(){
		return map;
	}
	
	public int getTurn1(){
		return turn1;
	}
	
	public int getTurn2(){
		return turn2;
	}
	
	public int getNbPlayers(){
		return nbPlayers;
	}
	
	public void incrementTurn1(){
		turn1++;
	}
	
	public void incrementTurn2(){
		turn2++;
	}
	
	// Méthode initialisant les bouttons d'action.
	public void setButtons(){
		
		buildButton=new JButton("Construire");
		buildButton.setBounds(20,580,210,40);
		add(buildButton);
		buildButton.addMouseListener(new BuildListener(map));
		
		cardButton=new JButton("Carte");
		cardButton.setBounds(270,580,210,40);
		add(cardButton);
		cardButton.addMouseListener(new CardListener(this));
		
		exchangeButton=new JButton("Commercer");
		exchangeButton.setBounds(270,650,210,40);
		add(exchangeButton);
		exchangeButton.addMouseListener(new TradeInfoListener(this));
		
		nextTurnButton=new JButton("Tour Suivant");
		nextTurnButton.setBounds(270,720,210,40);
		add(nextTurnButton);
		nextTurnButton.addMouseListener(new NextTurnListener(this));
	}

	// Méthode initialisant les panels des joueurs en leurs attribuant leurs ressources de base (ici 0) et la couleur de leur frame.
	public void setPlayersPanels(){
		
		c=new Character[nbPlayers];
		setLayout(null);
		int x=0,y=0;
		Color col=null;
		for(int i=0;i<nbPlayers;i++){
			if(i==0){x=20;y=30;col=new Color(58,142,48);}
			if(i==1){x=270;y=30;col=new Color(76,117,179);}
			if(i==2){x=20;y=300;col=new Color(172,38,29);}
			if(i==3){x=270;y=300;col=new Color(230,184,2);}
			c[i]=new Character("Joueur "+(i+1), col,map);
			c[i].setBounds(x,y,210,230);
			c[i].setBiere(0);
			c[i].setSommeil(0);
			c[i].setCafe(0);
			c[i].setCours(0);
			c[i].setNourriture(0);
			add(c[i]);
		}
	}
	
	public String getInfoPanelString(){
		return info.getText();
	}
	
	public void setInfoPanel(){
		info=new JLabel("<html>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " point !</html>");
		info.setBounds(20,650,210,110);
		add(info);
		info.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
	}
	
	// Méthode modifiant le panel d'affichage d'information en y inserant la chaine de charactère entrée en paramètre.
	public void modifyInfoPanel(String str){
		info.setText(str);
	}
	
	public int getSelectedPlayer(){
		return selectedPlayer+1;
	}
	
	public Character getPlayer(int p){
		return c[p];
	}
	
	public Character getCurrentPlayer(){
		return c[selectedPlayer];
	}
	
	// Méthode passant au tour suivant en séléctionant le joueur suivant et modifiant les informations affiché dans la panel info.
	public void nextTurn(){
		
		int de=0;
		if(turn1>=nbPlayers && turn2>nbPlayers){
			de=rollDieResources();
		}
		
		c[selectedPlayer].setSelected(false);
		if(turn1>=nbPlayers && turn2<=nbPlayers){
			if(turn1==nbPlayers){
				selectedPlayer++;
				turn1++;
			}
			if(selectedPlayer>0){
				selectedPlayer--;
			}
			else{
				selectedPlayer=nbPlayers-1;
			}
		}else{
			if(selectedPlayer<(nbPlayers-1)){
				selectedPlayer++;
			}
			else{
				selectedPlayer=0;
			}
		}
		c[selectedPlayer].setSelected(true);
		for(int i=0;i<nbPlayers;i++){
			c[i].repaint();
		}
		if(de==0){
			if(c[selectedPlayer].getPoint()>=2){
				info.setText("<html>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " points !</html>");
			} else {
				info.setText("<html>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " point !</html>");
			}
		}else if(de==7){
			if(c[selectedPlayer].getPoint()>=2){
				info.setText("<html>Les dés ont obtenu " + de + ", donc le binôme glandeur s'est déplacé.<br>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " points !</html>");
			} else {
				info.setText("<html>Les dés ont obtenu " + de + ", donc le binôme glandeur s'est déplacé.<br>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " point !</html>");
			}
		}else{
			if(c[selectedPlayer].getPoint()>=2){
				info.setText("<html>Les dés ont obtenu " + de + ".<br>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " points !</html>");
			} else {
				info.setText("<html>Les dés ont obtenu " + de + ".<br>C'est au tour du joueur "+(selectedPlayer+1)+" !<br>Vous avez " + c[selectedPlayer].getPoint() + " point !</html>");
			}
		}
	}
	
	// Méthode lançant deux dés et renvoyant la somme de ces derniers. Utilisé en Début de chaque tour.
	public int rollDieResources(){
		
		int d1=new Random().nextInt(6)+1;
		int d2=new Random().nextInt(6)+1;
		int d=d1+d2;
		for(Uv uvtemp : map.getUvTab()){
			for(int i : uvtemp.getTileIndex()){
				if(i!=-1 &&map.getTile(i).getCoefficient()==d){
					if(uvtemp.getPlayer()!=null){
						switch (map.getTile(i).getType()){
						case 1:
							uvtemp.getPlayer().setBiere(1);
							break;
						case 2:
							uvtemp.getPlayer().setSommeil(1);
							break;
						case 3:
							uvtemp.getPlayer().setCafe(1);
							break;
						case 4:
							uvtemp.getPlayer().setCours(1);
							break;
						case 5:
							uvtemp.getPlayer().setNourriture(1);
							break;
						default:
							break;
						}
					
					}
				}
			}
		}
		if(d==7){
			map.moveBinomeGlandeur();
		}
		return d;
	}
	
	
	public void paintComponent(Graphics g){
		
		Image img = null;
		
		
			try {
				img = ImageIO.read(new File("resources/menu_background.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img,0,3,this);
	}
}
