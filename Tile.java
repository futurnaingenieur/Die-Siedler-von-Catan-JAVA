import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Tile extends JPanel {
	
	private static final long serialVersionUID = 1L;
	protected int index;
	protected int type;
	protected int coefficient;
	protected int order;
	protected int givenRessource; // UNIQUEMENT POUR LES PORTS C'est le type de ressource à fournir dans les port 2:1 et =-1 pour les port 3:1
	protected boolean binomeGlandeur;
	
	public Tile(){
		this.order=1;
		this.index=-1;
	}
	
	public void setCoefficient(int coefficient){
		this.coefficient=coefficient;
	}
	
	public void setIndex(int i){
		this.index=i;
	}
	
	public void setBinomeGlandeur(boolean b){
		binomeGlandeur=b;
	}
	
	public void setGivenRessource(int i){
		givenRessource=i;
	}
	
	public int getCoefficient(){
		return coefficient;
	}
	
	public int getIndex(){
		return index;
	}
	
	public int getType(){
		return type;
	}
	
	public int getGivenRessource(){
		return this.givenRessource;
	}
	
	public void paintComponent(Graphics g){
		
		int tabx[]={25,75,100,75,25,0};
		int taby[]={0,0,43,86,86,43};
		g.fillPolygon(tabx,taby,6);
		
		if(coefficient!=0){
			g.setColor(Color.BLACK);
			String s=coefficient+"";
			g.drawString(s, 46,44);
		}
	}
	
}
