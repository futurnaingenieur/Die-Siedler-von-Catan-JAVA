/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe Map
 * implémentant une map aléatoire représentant la partie gauche de l'écran de jeu.
 */



import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Map extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Tile t[];
	private Road r1[];
	private Road r2[];
	private Road r3[];
	private Uv uv[];
	private int[] inventoryTile = {1, 1, 1, 1, 4, 4, 4, 4, 2, 2, 2, 3, 3, 3, 3, 5, 5, 5, 6};
	private int[] coefficientTile = {2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 8, 9, 9, 10, 10, 11, 11, 12};
	private Screen screen;
	private UvListener[] mUvL;
	private UvStarListener[] mUvSL;
	private RoadListener[] mRoadL1;
	private RoadListener[] mRoadL2;
	private RoadListener[] mRoadL3;
	private CardRoadListener[] mCardRoadL1;
	private CardRoadListener[] mCardRoadL2;
	private CardRoadListener[] mCardRoadL3;
	private TileCardListener[] tileCardListener;
	private Stack<Card> cardStack;
	private int binomeGlandeur;
	private boolean t1;
	private boolean t1_r;	
	
	public Map(){
		setWindow();
		t1=true;
		t1_r=true;
	}
	
	public Tile[] getTileTab(){
		return t;
	}
	
	public int getBinome(){
		return binomeGlandeur;
	}
	
	public Tile getTile(int index){
		return t[index];
	}
	
	public void setUvToPlayer(Uv uv){
		uv.setToPlayer(screen.getMenu().getCurrentPlayer());
	}
	
	public void setRoadToPlayer(Road road){
		road.setToPlayer(screen.getMenu().getCurrentPlayer());
	}
	
	public void setUvStarToPlayer(Uv uv){
		uv.setStarUv();
	}
	
	// Méthode permettant de déplacer aléatoirement le binôme glandeur, utile lorsqu'un 7 est tiré en début de tour.
	public void moveBinomeGlandeur(){
		
		t[binomeGlandeur].setBinomeGlandeur(false);
		binomeGlandeur=new Random().nextInt(32);
		while(binomeGlandeur==1 || binomeGlandeur==3 || binomeGlandeur==4 || 
				binomeGlandeur==14 || binomeGlandeur==15 || binomeGlandeur==27 ||
				binomeGlandeur==28 || binomeGlandeur==0 || binomeGlandeur==2 ||
				binomeGlandeur==8 || binomeGlandeur==9 || binomeGlandeur==21 || binomeGlandeur==22){
			binomeGlandeur=new Random().nextInt(32);
		}
		t[binomeGlandeur].setBinomeGlandeur(true);
		screen.repaint();
		t[binomeGlandeur].repaint();
	}
	
	// Méthode permettant de déplacer manuellement le binôme glandeur, utile lors de l'utilisation de la carte Ancien.
	public void setBinomeGlandeur(int index){
		t[binomeGlandeur].setBinomeGlandeur(false);
		binomeGlandeur=index;
		t[binomeGlandeur].setBinomeGlandeur(true);
		screen.repaint();
		t[binomeGlandeur].repaint();
	}
	
	public int getBinomeGlandeur(){
		return binomeGlandeur;
	}
	
	public Stack<Card> getCardStack(){
		return cardStack;
	}
	
	public boolean getT1(){
		return t1;
	}
	
	public void setT1(boolean b){
		t1=b;
	}
	
	public boolean getT1R(){
		return t1_r;
	}
	
	public void setT1R(boolean b){
		t1_r=b;
	}
	
	public Uv getUv(int i){
		return uv[i];
	}

	public Uv[] getUvTab(){
		return uv;
	}
	
	public Road[] getRoadTab(int i){
		
		Road[] r= null;
		switch (i){
			case 1:
				r = r1;
				break;
			case 2:
				r = r2;
				break;
			case 3:
				r = r3;
				break;
			default:
				break;
		}
		return r;
	}
	
	public Screen getScreen(){
		return screen;
	}	
	
	public void define(Screen screen){
		
		JLabel ports = new JLabel(new ImageIcon("resources/exchange_zones.png"));
		ports.setBounds(-150,-130,1000,1000);
		add(ports);
		this.screen=screen;
		setTiles();
		setRoadsType1(); 
		setRoadsType2();
		setRoadsType3();
		setUvs();
		setUvNeighboor();
		setCard();
		
	}
	
	public void setWindow(){
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(1200,842);
		this.setBounds(0, 0, 1200, 842);
	}

	// Méthode initialisant les hexagones de la map en les placant et en affectant leurs types et coefficients.
	public void setTiles(){
		
		t = new Tile[37];		    
		for(int i=0;i<37;i++){
		    if(i==1 || i==3 || i==4 || i==14 || i==15 || i==27 || i==28 || i==34 || i==36){
		    	t[i] = new ExchangeTile();	
		    }
		    else if(i==0 || i==2 || i==8 || i==9 || i==21 || i==22 || i==32 || i==33 || i==35){
		    	t[i] = new RampartTile();
		    }
		    else{
		    	Random r=new Random();
		    	int k;
		    	
		    	do
		    	{
		    		k=r.nextInt(19);
		    	}
		    	while(inventoryTile[k] == -1);
		    		
			    switch(inventoryTile[k]){
			    case 1:
			    	t[i]=new BarTile();
			    	break;
			    case 2:
			    	t[i]=new RestTile();
			    	break;
			    case 3:
			    	t[i]=new CoffeeTile();
			    	break;
			    case 4:
			    	t[i]=new ReproTile();
			    	break;
			    case 5:
			    	t[i]=new RestoTile();
			    	break;
			    case 6:
			    	t[i]=new DesertTile();
			    	t[i].setBinomeGlandeur(true);
			    	binomeGlandeur=i;
			    	break;
			    	default:
			    		break;
			    }
			    inventoryTile[k]=-1;
			    
			    do
			    {
			    	k=r.nextInt(19);
			    }
			    while(coefficientTile[k] == -1);
			    
			    t[i].setCoefficient(coefficientTile[k]);
			    t[i].setIndex(i);
			    
			    coefficientTile[k] = -1;
		    }
	    }
	    for(int i=0;i<4;i++){
	    	t[i].setBounds(30,195+i*107,101,87);
	    	add(t[i]);
	    }
	    for(int i=4;i<9;i++){
	        t[i].setBounds(120,140+(i-4)*107,101,87);
	        add(t[i]);
	        }
	    for(int i=9;i<15;i++){
	        t[i].setBounds(210,88+(i-9)*107,101,87);
	        add(t[i]);
	        }
	    
	    for(int i=15;i<22;i++){
	        t[i].setBounds(300,33+(i-15)*107,101,87);
	        add(t[i]);
	        }
	    for(int i=22;i<28;i++){
	        t[i].setBounds(390,88+(i-22)*107,101,87);
	        add(t[i]);
	        }
	    for(int i=28;i<33;i++){
	        t[i].setBounds(480,140+(i-28)*107,101,87);
	        add(t[i]);
	        }
	    for(int i=33;i<37;i++){
	        t[i].setBounds(570,195+(i-33)*107,101,87);
	        add(t[i]);
	        }
	    
	    for (Tile ttemp : t){
			this.setComponentZOrder(ttemp, 1);
		}
	    
	    t[1].setGivenRessource(1);
		t[3].setGivenRessource(-1);
		t[4].setGivenRessource(-1);
		t[14].setGivenRessource(-1);
		t[15].setGivenRessource(5);
		t[27].setGivenRessource(3);
		t[28].setGivenRessource(-1);
		t[34].setGivenRessource(2);
		t[36].setGivenRessource(4);
		
	    
	}
	
	// Méthode permettant l'initialisation des route de type 1 c'est à  dire les routes diagonales allant de en haut à gauche à en bas à droite.
	// Cette méthode permet également de les placer sur la map.
	public void setRoadsType1(){
		
		r1 = new Road[24];
		for(int i=0;i<24;i++){
	    	r1[i]=new Road(1, screen.getMenu());
	    }
	    
	    for(int i=0;i<3;i++){
	    	r1[i].setBounds(104,291+107*i,41,51);
	    	add(r1[i]);
	    }
	    
	    for(int i=3;i<7;i++){
	    	r1[i].setBounds(194,239+107*(i-3),41,51);
	    	add(r1[i]);
	    }
	    
	    for(int i=7;i<12;i++){
	    	r1[i].setBounds(284,184+107*(i-7),41,51);
	    	add(r1[i]);
	    }
	    
	    for(int i=12;i<17;i++){
	    	r1[i].setBounds(374,132+107*(i-12),41,51);
	    	add(r1[i]);
	    }
	    
	    for(int i=17;i<21;i++){
	    	r1[i].setBounds(464,184+107*(i-17),41,51);
	    	add(r1[i]);
	    }
	    
	    for(int i=21;i<24;i++){
	    	r1[i].setBounds(554,239+107*(i-21),41,51);
	    	add(r1[i]);
	    }
	    
	    for(Road rtemp : r1){
			this.setComponentZOrder(rtemp, 0);
		}		
	}
	
	// Méthode permettant l'initialisation des route de type 2 c'est à  dire les routes diagonales allant de en haut à droite à en bas à gauche.
	// Cette méthode permet également de les placer sur la map.
	public void setRoadsType2(){
		
		r2 = new Road[24];
		for(int i=0;i<24;i++){
	    	r2[i]=new Road(2, screen.getMenu());
	    }
	    
	    for(int i=0;i<3;i++){
	    	r2[i].setBounds(104,239+107*i,41,51);
	    	add(r2[i]);
	    }
	    
	    for(int i=3;i<7;i++){
	    	r2[i].setBounds(194,186+107*(i-3),41,51);
	    	add(r2[i]);
	    }
	    
	    for(int i=7;i<12;i++){
	    	r2[i].setBounds(284,132+107*(i-7),41,51);
	    	add(r2[i]);
	    }
	    
	    for(int i=12;i<17;i++){
	    	r2[i].setBounds(374,186+107*(i-12),41,51);
	    	add(r2[i]);
	    }
	    
	    for(int i=17;i<21;i++){
	    	r2[i].setBounds(464,239+107*(i-17),41,51);
	    	add(r2[i]);
	    }
	    
	    for(int i=21;i<24;i++){
	    	r2[i].setBounds(554,293+107*(i-21),41,51);
	    	add(r2[i]);
	    }
	    
	    for(Road rtemp : r2){
			this.setComponentZOrder(rtemp, 0);
		}
	}
	
	// Méthode permettant l'initialisation des route de type 3 c'est à  dire les routes horizontales .
	// Cette méthode permet également de les placer sur la map.
	public void setRoadsType3(){
		
		r3 = new Road[24];
		for(int i=0;i<24;i++){
	    	r3[i]=new Road(3, screen.getMenu());
	    }
	    
	    for(int i=0;i<4;i++){
	    	r3[i].setBounds(146,227+107*i,50,20);
	    	add(r3[i]);
	    }
	    
	    for(int i=4;i<9;i++){
	    	r3[i].setBounds(236,175+107*(i-4),50,20);
	    	add(r3[i]);
	    }
	    
	    for(int i=9;i<15;i++){
	    	r3[i].setBounds(326,120+107*(i-9),50,20);
	    	add(r3[i]);
	    }
	    
	    for(int i=15;i<20;i++){
	    	r3[i].setBounds(416,175+107*(i-15),50,20);
	    	add(r3[i]);
	    }
	    
	    for(int i=20;i<24;i++){
	    	r3[i].setBounds(506,227+107*(i-20),50,20);
	    	add(r3[i]);
	    }
	    
	    for(Road rtemp : r3){
	    	this.setComponentZOrder(rtemp, 0);
		}
	    
	    
	}
	
	// Méthode d'initialisation des UV's permettant de les placer aux bons endroits de la map.
	public void setUvs(){
		
		uv=new Uv[54];
		for(int i=0;i<54;i++){
			uv[i]=new Uv(this);
		}
		
		for(int i=0;i<3;i++){
			uv[i].setBounds(95,276+107*i,30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=3;i<7;i++){
			uv[i].setBounds(124,221+107*(i-3),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=7;i<11;i++){
			uv[i].setBounds(186,221+107*(i-7),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=11;i<16;i++){
			uv[i].setBounds(212,169+107*(i-11),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=16;i<21;i++){
			uv[i].setBounds(278,169+107*(i-16),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=21;i<27;i++){
			uv[i].setBounds(303,114+107*(i-21),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=27;i<33;i++){
			uv[i].setBounds(366,114+107*(i-27),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=33;i<38;i++){
			uv[i].setBounds(392,169+107*(i-33),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=38;i<43;i++){
			uv[i].setBounds(456,169+107*(i-38),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=43;i<47;i++){
			uv[i].setBounds(483,221+107*(i-43),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=47;i<51;i++){
			uv[i].setBounds(547,221+107*(i-47),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
		
		for(int i=51;i<54;i++){
			uv[i].setBounds(572,276+107*(i-51),30,30);
			add(uv[i]);
			setComponentZOrder(uv[i],0);
		}
	}
	
	// Méthode 	affectant à chaque UV's de la map ses hexagones voisins en stockant leurs index dans tileIndex de l'uv.
	public void setUvNeighboor(){
		
		uv[0].setTileIndex(5,1,-1);
		uv[1].setTileIndex(6,1,-1);
		uv[2].setTileIndex(7,3,-1);
		uv[3].setTileIndex(5,4,-1);
		uv[4].setTileIndex(5,6,1);
		uv[5].setTileIndex(6,7,-1);
		uv[6].setTileIndex(7,3,-1);
		uv[7].setTileIndex(5,10,4);
		uv[8].setTileIndex(5,6,11);
		uv[9].setTileIndex(6,7,12);
		uv[10].setTileIndex(7,13,-1);
		uv[11].setTileIndex(10,-1,-1);
		uv[12].setTileIndex(5,10,11);
		uv[13].setTileIndex(6,11,12);
		uv[14].setTileIndex(7,12,13);
		uv[15].setTileIndex(13,-1,-1);
		uv[16].setTileIndex(10,16,-1);
		uv[17].setTileIndex(10,11,17);
		uv[18].setTileIndex(11,12,18);
		uv[19].setTileIndex(12,13,19);
		uv[20].setTileIndex(13,20,14);
		uv[21].setTileIndex(16,15,-1);
		uv[22].setTileIndex(10,16,17);
		uv[23].setTileIndex(11,17,18);
		uv[24].setTileIndex(12,18,19);
		uv[25].setTileIndex(13,19,20);
		uv[26].setTileIndex(20,-1,-1);
		uv[27].setTileIndex(16,-1,-1);
		uv[28].setTileIndex(16,17,23);
		uv[29].setTileIndex(17,18,24);
		uv[30].setTileIndex(18,19,25);
		uv[31].setTileIndex(19,20,26);
		uv[32].setTileIndex(20,-1,-1);
		uv[33].setTileIndex(16,23,-1);
		uv[34].setTileIndex(17,23,24);
		uv[35].setTileIndex(18,24,25);
		uv[36].setTileIndex(19,25,26);
		uv[37].setTileIndex(20,26,27);
		uv[38].setTileIndex(23,-1,-1);
		uv[39].setTileIndex(23,24,29);
		uv[40].setTileIndex(24,25,30);
		uv[41].setTileIndex(25,26,31);
		uv[42].setTileIndex(26,27,-1);
		uv[43].setTileIndex(23,28,29);
		uv[44].setTileIndex(24,29,30);
		uv[45].setTileIndex(25,30,31);
		uv[46].setTileIndex(26,31,-1);
		uv[47].setTileIndex(29,28,-1);
		uv[48].setTileIndex(29,30,-1);
		uv[49].setTileIndex(30,31,-1);
		uv[50].setTileIndex(31,36,-1);
		uv[51].setTileIndex(29,34,-1);
		uv[52].setTileIndex(30,-1,-1);
		uv[53].setTileIndex(31,36,-1);
		
		uv[0].setRoadIndex(0,0,-1);
		uv[1].setRoadIndex(1,1,-1);
		uv[2].setRoadIndex(2,2,-1);
		uv[3].setRoadIndex(-1,0,0);
		uv[4].setRoadIndex(0,1,1);
		uv[5].setRoadIndex(1,2,2);
		uv[6].setRoadIndex(2,-1,3);
		uv[7].setRoadIndex(3,3,0);
		uv[8].setRoadIndex(4,4,1);
		uv[9].setRoadIndex(5,5,2);
		uv[10].setRoadIndex(6,6,3);
		uv[11].setRoadIndex(-1,3,4);
		uv[12].setRoadIndex(3,4,5);
		uv[13].setRoadIndex(4,5,6);
		uv[14].setRoadIndex(5,6,7);
		uv[15].setRoadIndex(6,-1,8);
		uv[16].setRoadIndex(7,7,4);
		uv[17].setRoadIndex(8,8,5);
		uv[18].setRoadIndex(9,9,6);
		uv[19].setRoadIndex(10,10,7);
		uv[20].setRoadIndex(11,11,8);
		uv[21].setRoadIndex(-1,7,9);
		uv[22].setRoadIndex(7,8,10);
		uv[23].setRoadIndex(8,9,11);
		uv[24].setRoadIndex(9,10,12);
		uv[25].setRoadIndex(10,11,13);
		uv[26].setRoadIndex(11,-1,14);
		uv[27].setRoadIndex(12,-1,9);
		uv[28].setRoadIndex(13,12,10);
		uv[29].setRoadIndex(14,13,11);
		uv[30].setRoadIndex(15,14,12);
		uv[31].setRoadIndex(16,15,13);
		uv[32].setRoadIndex(-1,16,14);
		uv[33].setRoadIndex(12,12,15);
		uv[34].setRoadIndex(13,13,16);
		uv[35].setRoadIndex(14,14,17);
		uv[36].setRoadIndex(15,15,18);
		uv[37].setRoadIndex(16,16,19);
		uv[38].setRoadIndex(17,-1,15);
		uv[39].setRoadIndex(18,17,16);
		uv[40].setRoadIndex(19,18,17);
		uv[41].setRoadIndex(20,19,18);
		uv[42].setRoadIndex(-1,20,19);
		uv[43].setRoadIndex(17,17,20);
		uv[44].setRoadIndex(18,18,21);
		uv[45].setRoadIndex(19,19,22);
		uv[46].setRoadIndex(20,20,23);
		uv[47].setRoadIndex(21,-1,20);
		uv[48].setRoadIndex(22,21,21);
		uv[49].setRoadIndex(23,22,22);
		uv[50].setRoadIndex(-1,23,23);
		uv[51].setRoadIndex(21,21,-1);
		uv[52].setRoadIndex(22,22,-1);
		uv[53].setRoadIndex(23,23,-1);
		
	}
	
	public void createCardRoadListener(){
		mCardRoadL1 = new CardRoadListener[23];
		mCardRoadL2 = new CardRoadListener[23];
		mCardRoadL3 = new CardRoadListener[23];
		for(int i=0;i<23;i++){
			mCardRoadL1[i]=(new CardRoadListener(this.getScreen().getMenu()));
			mCardRoadL2[i]=(new CardRoadListener(this.getScreen().getMenu()));
			mCardRoadL3[i]=(new CardRoadListener(this.getScreen().getMenu()));		
			r1[i].addMouseListener(mCardRoadL1[i]);
			r2[i].addMouseListener(mCardRoadL2[i]);
			r3[i].addMouseListener(mCardRoadL3[i]);
		}
	}
	
	//Méthode initialisant le paquet de carte en le mélangeant.
	public void setCard(){
		Random rand = new Random();
		int intRand;
		cardStack = new Stack<Card>();
		ArrayList<Integer> arrayInt = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
		arrayInt.add(1);
		}
		for(int i=0;i<3;i++){
			arrayInt.add(2);
		}
		for(int i=0;i<4;i++){
			arrayInt.add(3);
		}
		for(int i=0;i<3;i++){
			arrayInt.add(4);
		}
		for(int i=0;i<5;i++){
			arrayInt.add(5);
		}
		while(arrayInt.size()>0){
					
			intRand = rand.nextInt(arrayInt.size());
			cardStack.push(new Card(arrayInt.get(intRand)));
			arrayInt.remove(intRand);
		}
	}
	
	//Méthode tirant une carte de la pile de jeu.
	public void drawCard(Character player){
			if(cardStack.size()>0){
				player.addCard(cardStack.pop());
			}
	}
	
	public void createUvListener(){
		
		mUvL = new UvListener[54];
		for(int i=0;i<54;i++){
				mUvL[i]=(new UvListener(this));
				uv[i].addMouseListener(mUvL[i]);
		}
	}
	
	public void createCardTileListener(){
		tileCardListener = new TileCardListener[19];
		int j=0;
		for(int i=0;i<37;i++){
			if(t[i].getType()!=99 && t[i].getType()!=7){
				tileCardListener[j]=new TileCardListener(this.screen.getMenu());
				t[i].addMouseListener(tileCardListener[j]);
				j++;
			}
		}
	}
	
	public void removeCardTileListener(){
		int j=0;
		for(int i=0;i<37;i++){
			if(t[i].getType()!=99 && t[i].getType()!=7){
				t[i].removeMouseListener(tileCardListener[j]);
				j++;
			}
		}
	}
	
	public void createRoadListener(){
		
		mRoadL1 = new RoadListener[23];
		mRoadL2 = new RoadListener[23];
		mRoadL3 = new RoadListener[23];
		for(int i=0;i<23;i++){
			mRoadL1[i]=(new RoadListener(this));
			mRoadL2[i]=(new RoadListener(this));
			mRoadL3[i]=(new RoadListener(this));		
			r1[i].addMouseListener(mRoadL1[i]);
			r2[i].addMouseListener(mRoadL2[i]);
			r3[i].addMouseListener(mRoadL3[i]);
		}
		
	}
	
	public void RemoveUvListener(){
		for(int i=0;i<54;i++){
				uv[i].removeMouseListener(mUvL[i]);
		}
	}
	
	public void RemoveRoadListener(){
		for(int i=0;i<23;i++){
				r1[i].removeMouseListener(mRoadL1[i]);
				r2[i].removeMouseListener(mRoadL2[i]);
				r3[i].removeMouseListener(mRoadL3[i]);
		}
	}
	
	public void RemoveCardRoadListener(){
		for(int i=0;i<23;i++){
				r1[i].removeMouseListener(mCardRoadL1[i]);
				r2[i].removeMouseListener(mCardRoadL2[i]);
				r3[i].removeMouseListener(mCardRoadL3[i]);
		}
	}
	
	public void createUvStarListener(){
		mUvSL = new UvStarListener[54];
		for(int i=0;i<54;i++){
				mUvSL[i]=(new UvStarListener(this));
				uv[i].addMouseListener(mUvSL[i]);
		}
	}
	
	public void RemoveUvStarListener(){
		for(int i=0;i<54;i++){
				uv[i].removeMouseListener(mUvSL[i]);
		}
	}
	
	// Méthode dessinant le fond de la map
	public void paintComponent(Graphics g){
		
		Image img = null;
		try {
			img = ImageIO.read(new File("resources/cadre.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
		
		
	}
	
}
