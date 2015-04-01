/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe Character
 * implémentant un joueur.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Character extends JPanel {

	private static final long serialVersionUID = 1L;
	private Map map;
	private String name;
	private Color color;
	private int biere;
	private int sommeil;
	private int cafe;
	private int cours;
	private int nourriture;
	private int point;
	private int ancienPlayed;
	private boolean selected;
	private boolean hasExchangeGeneral;
	private boolean hasExchangeBiere;
	private boolean hasExchangeCours;
	private boolean hasExchangeCafe;
	private boolean hasExchangeNourriture;
	private boolean hasExchangeSommeil;
	private ArrayList <Uv> uvList;
	private ArrayList <Card> cardList;
	
	public Character(String name, Color color, Map map){
		
		this.name=name;
		this.color=color;
		this.map=map;
		this.ancienPlayed=0;
		point=0;
		setBiere(0);
		setSommeil(0);
		setCafe(0);
		setCours(0);
		setNourriture(0);
		setSelected(false);
		uvList=new ArrayList <Uv> ();
		cardList=new ArrayList <Card> ();
		this.hasExchangeGeneral=false;
		this.hasExchangeBiere=false;
		this.hasExchangeCours=false;
		this.hasExchangeCafe=false;
		this.hasExchangeNourriture=false;
		this.hasExchangeSommeil=false;
	}
	
	// méthode ajoutant la carte en paramètre au jeu du joueur.
	public void addCard(Card card){
		cardList.add(card);
	}
	
	// méthode ajoutant la carte plus ancien au jeu du joueur si celui ci à joué 3 cartes ancien.
	public void addPlusAncien(){
		ancienPlayed++;
		if(ancienPlayed==3){
			Card plusAncien = new Card(6);
			this.addCard(plusAncien);
		}
	}
	
	public ArrayList <Uv> getUvList(){
		return uvList;
	}
	
	public ArrayList <Card> getCardList(){
		return cardList;
	}
	
	public int getPoint(){
		return point;
	}
	
	public Color getColor(){
		return color;
	}
	
	public String getName(){
		return name;
	}
	
	public Map getMap(){
		return map;
	}
	
	public boolean getHasExchangeGeneral(){
		return this.hasExchangeGeneral;
	}
	
	public boolean getHasExchangeBiere(){
		return this.hasExchangeBiere;
	}
	
	public boolean getHasExchangeCours(){
		return this.hasExchangeCours;
	}
	
	public boolean getHasExchangeCafe(){
		return this.hasExchangeCafe;
	}
	
	public boolean getHasExchangeNourriture(){
		return this.hasExchangeNourriture;
	}
	
	public boolean getHasExchangeSommeil(){
		return this.hasExchangeSommeil;
	}
	
	public int getInfo(String str){
		
		int result;
		switch (str){
		case "biere":
			result = biere;
			break;
		case "sommeil":
			result = sommeil;
			break;
		case "cafe":
			result = cafe;
			break;
		case "cours":
			result = cours;
			break;
		case "nourriture":
			result = nourriture;
			break;
		default:
			result = -1;
			break;
		
		}
		return result;
	}
	
	// méthode ajoutant une UV au joueur.
	public void addUv(Uv uv){
		uvList.add(uv);
	}
	
	public void setResource(int biere, int cours, int cafe, int nourriture, int sommeil){
		
		setBiere(biere);
		setSommeil(sommeil);
		setCafe(cafe);
		setCours(cours);
		setNourriture(nourriture);
	}
	
	public void setSelected(boolean b){
		selected=b;
		this.setVisible(true);
	}
	
	public void setBiere(int diff){
		if(biere+diff>=0){
			biere+=diff;
		}
	}
	
	public void setSommeil(int diff){
		if(sommeil+diff>=0){
			sommeil+=diff;
		}
	}
	
	public void setCafe(int diff){
		if(cafe+diff>=0){
			cafe+=diff;
		}
	}
	
	public void setCours(int diff){
		if(cours+diff>=0){
			cours+=diff;
		}
	}
	
	public void setNourriture(int diff){
		if(nourriture+diff>=0){
			nourriture+=diff;
		}
	}
	 //Methode permettant l'ajout de point de Victoire.
	public void addPoint(int p){
		point+=p;
		if(point>=10){
			map.setVisible(false);
			map.getScreen().getMenu().setVisible(false);
			map.getScreen().setEndGame(map);
		}
	}
	
	//Enleve une carte du joueur suivant son type
	public void removeCard(int type){
		boolean b=true;
		int i=0;
		int j=0;
		for(Card temp : cardList){
			if(temp.getType() == type && b){
				b=false;
				j=i;
			}
			i++;
		}
		cardList.remove(j);
	}
	
	// méthode vérifiant si le joueur possède une zone de troc et identifie celles-ci en modifiant les bouléens determinants les type de zones de troc que ce joueur possède.
	public boolean hasExchangeTile(){
		boolean b=false;
		Tile tempTile;
		for(Uv temp : uvList){
			for(int tempInt : temp.getTileIndex()){
				if(tempInt!=-1){
				tempTile = map.getTile(tempInt);
					if (tempTile.getType()==7){
						b=true;
						switch(tempTile.givenRessource){
							case -1:
								this.hasExchangeGeneral=true;
								break;
							case 1:
								this.hasExchangeBiere=true;
								break;
							case 2:
								this.hasExchangeCours=true;
								break;
							case 3:
								this.hasExchangeCafe=true;
								break;
							case 4:
								this.hasExchangeNourriture=true;
								break;
							case 5:
								this.hasExchangeSommeil=true;
								break;
						}
					}
				}
			}
		}
		return b;
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(color);
		g.fillRect(0, 0, 210, 230);
		
		String img_str;
		if(selected){
			img_str=new String("resources/cadre_char_selected.png");
			g.setFont(new Font("Arial",Font.BOLD,25));
		}else{
			img_str=new String("resources/cadre_char.png");
			g.setFont(new Font("Arial",0,20));
		}
		
		Image img = null;
		try {
			img = ImageIO.read(new File(img_str));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
		
		g.setColor(Color.BLACK);
		g.drawString(name, 20, 30);
		
		g.setFont(new Font("Arial",0,18));
		g.drawString("BIERE", 20, 80);
		g.drawString(Integer.toString(biere), 170, 80);
		g.drawString("COURS", 20, 110);
		g.drawString(Integer.toString(cours), 170, 110);
		g.drawString("CAFE", 20, 140);
		g.drawString(Integer.toString(cafe), 170, 140);
		g.drawString("NOURRITURE", 20, 170);
		g.drawString(Integer.toString(nourriture), 170, 170);
		g.drawString("SOMMEIL", 20, 200);
		g.drawString(Integer.toString(sommeil), 170, 200);
	}
}
