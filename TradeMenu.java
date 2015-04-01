import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TradeMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Character currentPlayer;
	private JButton mBiere,pBiere,mCours,pCours,mCafe,pCafe,mNourriture,pNourriture,mSommeil,pSommeil,validation ;
	private JLabel 	lmBiere,lpBiere,lmCours,lpCours,lmCafe,lpCafe,lmNourriture,lpNourriture,lmSommeil,lpSommeil;
	public JLabel[] tabLabel;
	private JLabel imgTrade;
	private Menu menu;
	private int customer;
	private int neededRessource;
	private InternTradeListener[] tabListener;
	
	public TradeMenu(Menu menu, int customer){
		
		this.currentPlayer = menu.getCurrentPlayer();
		this.menu=menu;
		this.customer = customer;
		this.tabListener = new InternTradeListener[10];
		this.tabLabel = new JLabel[10];
		this.neededRessource=-1;
		setFrame();
		setComponents();		
		setVisible(true);
	}
	
	public void setFrame(){
		
		setSize(750,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Menu Commerce");
		setLayout(null);
	}
	
	public void setComponents(){
		
		imgTrade=new JLabel(new ImageIcon("resources/trade_img.png"));
		imgTrade.setBounds(23,123,701,53);
		add(imgTrade);
		
		mBiere= new JButton("-");
		mBiere.setBounds(30,70,45,30);
		mBiere.setFont(new Font("arial",Font.BOLD,15));
		mBiere.setBackground(new Color(255,255,255));
		mBiere.setName("mBiere");
		tabListener[0]=new InternTradeListener(this,mBiere);
		mBiere.addMouseListener(tabListener[0]);
		add(mBiere);
		
		pBiere= new JButton("+");
		pBiere.setBounds(30,200,45,30);
		pBiere.setFont(new Font("arial",Font.BOLD,15));
		pBiere.setBackground(new Color(255,255,255));
		pBiere.setName("pBiere");
		tabListener[1]=new InternTradeListener(this,pBiere);
		pBiere.addMouseListener(tabListener[1]);
		add(pBiere);
		
		mCours= new JButton("-");
		mCours.setBounds(190,70,45,30);
		mCours.setFont(new Font("arial",Font.BOLD,15));
		mCours.setBackground(new Color(255,255,255));
		mCours.setName("mCours");
		tabListener[2]=new InternTradeListener(this,mCours);
		mCours.addMouseListener(tabListener[2]);
		add(mCours);
		
		pCours= new JButton("+");
		pCours.setBounds(190,200,45,30);
		pCours.setFont(new Font("arial",Font.BOLD,15));
		pCours.setBackground(new Color(255,255,255));
		pCours.setName("pCours");
		tabListener[3]=new InternTradeListener(this,pCours);
		pCours.addMouseListener(tabListener[3]);
		add(pCours);
		
		mCafe= new JButton("-");
		mCafe.setBounds(350,70,45,30);
		mCafe.setFont(new Font("arial",Font.BOLD,15));
		mCafe.setBackground(new Color(255,255,255));
		mCafe.setName("mCafe");
		tabListener[4]=new InternTradeListener(this,mCafe);
		mCafe.addMouseListener(tabListener[4]);
		add(mCafe);
		
		pCafe= new JButton("+");
		pCafe.setBounds(350,200,45,30);
		pCafe.setFont(new Font("arial",Font.BOLD,15));
		pCafe.setBackground(new Color(255,255,255));
		pCafe.setName("pCafe");
		tabListener[5]=new InternTradeListener(this,pCafe);
		pCafe.addMouseListener(tabListener[5]);
		add(pCafe);
		
		mNourriture= new JButton("-");
		mNourriture.setBounds(510,70,45,30);
		mNourriture.setFont(new Font("arial",Font.BOLD,15));
		mNourriture.setBackground(new Color(255,255,255));
		mNourriture.setName("mNourriture");
		tabListener[6]=new InternTradeListener(this,mNourriture);
		mNourriture.addMouseListener(tabListener[6]);
		add(mNourriture);
		
		pNourriture= new JButton("+");
		pNourriture.setBounds(510,200,45,30);
		pNourriture.setFont(new Font("arial",Font.BOLD,15));
		pNourriture.setBackground(new Color(255,255,255));
		pNourriture.setName("pNourriture");
		tabListener[7]=new InternTradeListener(this,pNourriture);
		pNourriture.addMouseListener(tabListener[7]);
		add(pNourriture);
		
		mSommeil= new JButton("-");
		mSommeil.setBounds(670,70,45,30);
		mSommeil.setFont(new Font("arial",Font.BOLD,15));
		mSommeil.setBackground(new Color(255,255,255));
		mSommeil.setName("mSommeil");
		tabListener[8]=new InternTradeListener(this,mSommeil);
		mSommeil.addMouseListener(tabListener[8]);
		add(mSommeil);
		
		pSommeil= new JButton("+");
		pSommeil.setBounds(670,200,45,30);
		pSommeil.setFont(new Font("arial",Font.BOLD,15));
		pSommeil.setBackground(new Color(255,255,255));
		pSommeil.setName("pSommeil");
		tabListener[9]=new InternTradeListener(this,pSommeil);
		pSommeil.addMouseListener(tabListener[9]);
		add(pSommeil);
		
		validation = new JButton("Valider");
		validation.setBounds(615,300,100,50);
		validation.setFont(new Font("arial",Font.BOLD,12));
		validation.setBackground(new Color(255,255,255));
		validation.addMouseListener(new InternTradeListener(this,validation));
		add(validation);
//---------------------------------------------------------------------------------------------		
		lmBiere = new JLabel("0");
		lmBiere.setBounds(48,35,45,30);
		lmBiere.setFont(new Font("arial",Font.BOLD,15));
		lmBiere.setBackground(new Color(255,255,255));
		lmBiere.setName("lmBiere");
		tabLabel[0]=lmBiere;
		add(lmBiere);
	
		lpBiere = new JLabel("0");
		lpBiere.setBounds(48,240,45,30);
		lpBiere.setFont(new Font("arial",Font.BOLD,15));
		lpBiere.setBackground(new Color(255,255,255));
		lpBiere.setName("lpBiere");
		tabLabel[1]=lpBiere;
		add(lpBiere);
		
		lmCours = new JLabel("0");
		lmCours.setBounds(208,35,45,30);
		lmCours.setFont(new Font("arial",Font.BOLD,15));
		lmCours.setBackground(new Color(255,255,255));
		lmCours.setName("lmCours");
		tabLabel[2]=lmCours;
		add(lmCours);
		
		lpCours = new JLabel("0");
		lpCours.setBounds(208,240,45,30);
		lpCours.setFont(new Font("arial",Font.BOLD,15));
		lpCours.setBackground(new Color(255,255,255));
		lpCours.setName("lpCours");
		tabLabel[3]=lpCours;
		add(lpCours);
		
		lmCafe = new JLabel("0");
		lmCafe.setBounds(368,35,45,30);
		lmCafe.setFont(new Font("arial",Font.BOLD,15));
		lmCafe.setBackground(new Color(255,255,255));
		lmCafe.setName("lmCafe");
		tabLabel[4]=lmCafe;
		add(lmCafe);
		
		lpCafe = new JLabel("0");
		lpCafe.setBounds(368,240,45,30);
		lpCafe.setFont(new Font("arial",Font.BOLD,15));
		lpCafe.setBackground(new Color(255,255,255));
		lpCafe.setName("lpCafe");
		tabLabel[5]=lpCafe;
		add(lpCafe);
		
		lmNourriture = new JLabel("0");
		lmNourriture.setBounds(528,35,45,30);
		lmNourriture.setFont(new Font("arial",Font.BOLD,15));
		lmNourriture.setBackground(new Color(255,255,255));
		lmNourriture.setName("lmNourriture");
		tabLabel[6]=lmNourriture;
		add(lmNourriture);
		
		lpNourriture = new JLabel("0");
		lpNourriture.setBounds(528,240,45,30);
		lpNourriture.setFont(new Font("arial",Font.BOLD,15));
		lpNourriture.setBackground(new Color(255,255,255));
		lpNourriture.setName("lpNourriture");
		tabLabel[7]=lpNourriture;
		add(lpNourriture);
		
		lmSommeil = new JLabel("0");
		lmSommeil.setBounds(688,35,45,30);
		lmSommeil.setFont(new Font("arial",Font.BOLD,15));
		lmSommeil.setBackground(new Color(255,255,255));
		lmSommeil.setName("lmSommeil");
		tabLabel[8]=lmSommeil;
		add(lmSommeil);
		
		lpSommeil = new JLabel("0");
		lpSommeil.setBounds(688,240,45,30);
		lpSommeil.setFont(new Font("arial",Font.BOLD,15));
		lpSommeil.setBackground(new Color(255,255,255));
		lpSommeil.setName("lpSommeil");
		tabLabel[9]=lpSommeil;
		add(lpSommeil);
	}

	
	public void increment(JButton jbt){
		String str1,str2;
		int i=0,j=0;
		str1="l"+jbt.getName();
		if(jbt.getName().substring(0,1).equals("m")){
			str2="lp"+jbt.getName().substring(1);
		}
		else{
			str2="lm"+jbt.getName().substring(1);
		}
			for(JLabel temp1 : tabLabel){
				if(str1.equals(temp1.getName())){
					i=Integer.parseInt(temp1.getText());
					for(JLabel temp2 : tabLabel){
						if(str2.equals(temp2.getName())){
							j=Integer.parseInt(temp2.getText());
							if(j>0){
								j--;
							}
							else{
								i++;
							}
						temp1.setText(String.valueOf(i));
						temp2.setText(String.valueOf(j));
						}
					}
					
					
				}
			}
	}
	
	public void checkAndAssign(){
		boolean b=false;
		boolean b1=false;
		String ressource = null;
		int mRessource=-1;
		int[] mR=new int[5]; //le tableau contenant les ressources à enlever au joueur actuel
		int[] pR=new int[5]; //le tableau contenant les ressources à ajouter au joueur actuel
		mR[0]=Integer.parseInt(lmBiere.getText());
		mR[1]=Integer.parseInt(lmCours.getText());
		mR[2]=Integer.parseInt(lmCafe.getText());
		mR[3]=Integer.parseInt(lmNourriture.getText());
		mR[4]=Integer.parseInt(lmSommeil.getText());
		
		pR[0]=Integer.parseInt(lpBiere.getText());
		pR[1]=Integer.parseInt(lpCours.getText());
		pR[2]=Integer.parseInt(lpCafe.getText());
		pR[3]=Integer.parseInt(lpNourriture.getText());
		pR[4]=Integer.parseInt(lpSommeil.getText());
		
		if(customer>-1){ //Echange entre les joueurs CurrentPlayer et customer 
			Character c = menu.getPlayer(customer-1);
			if(mR[0]<=currentPlayer.getInfo("biere")&& mR[1]<=currentPlayer.getInfo("cours") && mR[2]<=currentPlayer.getInfo("cafe") && mR[3]<=currentPlayer.getInfo("nourriture") && mR[4]<=currentPlayer.getInfo("sommeil")){
				if(c.getInfo("biere")>=pR[0] && c.getInfo("cours")>=pR[1] && c.getInfo("cafe")>=pR[2] && c.getInfo("nourriture")>=pR[3] && c.getInfo("sommeil")>=pR[4]){
					currentPlayer.setResource(-mR[0],-mR[1],-mR[2],-mR[3],-mR[4]);//on prend au joueur actuel.
					c.setResource(mR[0],mR[1],mR[2],mR[3],mR[4]);//on donne ses ressources au joueur de l'échange.
					c.setResource(-pR[0],-pR[1],-pR[2],-pR[3],-pR[4]);// a qui on prend les ressource du deal.
					currentPlayer.setResource(pR[0],pR[1],pR[2],pR[3],pR[4]); // et on les donne au joueur actuel.
				}
			}
		}
		else if(customer==-1){ //le joueur actuel a affaire à la banque!
			if(currentPlayer.hasExchangeTile()==false){ //On applique le plein tarif 4:1 puisque le joueur n'a pas de zone de troc
				for(int i=0;i<5;i++){
					if(mR[i]==4 && !b){
						b=true;
						mRessource=i;
					}
					else if(mR[i]!=0 && b){
						b=false;
					}
					if(pR[i]==1 && !b1){
						b1=true;
					}
					else if(pR[i]!=0 && b1){
						b1=false;
					}
				}
				if(b && b1){
					switch (mRessource){
						case 0:
							ressource = "biere";
							break;
						case 1:
							ressource = "cours";
							break;
						case 2:
							ressource = "cafe";
							break;
						case 3:
							ressource = "nourriture";
							break;
						case 4:
							ressource = "sommeil";
							break;
						default:
							break;
					}
					if(currentPlayer.getInfo(ressource)>=mR[mRessource]){
					currentPlayer.setResource(pR[0]-mR[0],pR[1]-mR[1],pR[2]-mR[2],pR[3]-mR[3],pR[4]-mR[4]);
					}
				}
			}
			else{
				// faire avec 3:1 et 2:1 spécifique à une ressource
				for(int i=0;i<5;i++){ // On vérifie la ressource demandée par le joueur (neededRessource)  
					if(pR[i]==1 && !b1){
						b1=true;
						neededRessource=i;
					}
					else if(pR[i]!=0 && b1){
						b1=false;
						neededRessource=-1;
					}
				}
				if(b1){
					switch(neededRessource){ 
					case 0:
						if(currentPlayer.getHasExchangeBiere()){
							for(int i=0;i<5;i++){
								if(mR[i]==2 && !b){
									b=true;
									mRessource=i;
								}
								else if(mR[i]!=0 && b){
									b=false;
								}
							}
						}
						break;
					case 1:
						if(currentPlayer.getHasExchangeCours()){
							for(int i=0;i<5;i++){
								if(mR[i]==2 && !b){
									b=true;
									mRessource=i;
								}
								else if(mR[i]!=0 && b){
									b=false;
								}
							}
						}
						break;
					case 2:
						if(currentPlayer.getHasExchangeCafe()){
							for(int i=0;i<5;i++){
								if(mR[i]==2 && !b){
									b=true;
									mRessource=i;
								}
								else if(mR[i]!=0 && b){
									b=false;
								}
							}
						}
						break;
					case 3:
						if(currentPlayer.getHasExchangeNourriture()){
							for(int i=0;i<5;i++){
								if(mR[i]==2 && !b){
									b=true;
									mRessource=i;
								}
								else if(mR[i]!=0 && b){
									b=false;
								}
							}
						}
						break;
					case 4:
						if(currentPlayer.getHasExchangeSommeil()){
							for(int i=0;i<5;i++){
								if(mR[i]==2 && !b){
									b=true;
									mRessource=i;
								}
								else if(mR[i]!=0 && b){
									b=false;
								}
							}
						}
						break;
					default:
						break;
					}
					if(mRessource==-1){
						if(currentPlayer.getHasExchangeGeneral()){
							for(int i=0;i<5;i++){
								if(mR[i]==3 && !b){
									b=true;
									mRessource=i;
								}
								else if(mR[i]!=0 && b){
									b=false;
								}
							}
						}
					}
					if(b){
						switch (mRessource){
							case 0:
								ressource = "biere";
								break;
							case 1:
								ressource = "cours";
								break;
							case 2:
								ressource = "cafe";
								break;
							case 3:
								ressource = "nourriture";
								break;
							case 4:
								ressource = "sommeil";
								break;
							default:
								break;
						}
						if(currentPlayer.getInfo(ressource)>=mR[mRessource]){
						currentPlayer.setResource(pR[0]-mR[0],pR[1]-mR[1],pR[2]-mR[2],pR[3]-mR[3],pR[4]-mR[4]);
						}
					}
				}
			}
		}
		
		menu.repaint();
		
		
	}
}

