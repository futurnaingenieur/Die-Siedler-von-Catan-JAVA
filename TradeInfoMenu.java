import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;


public class TradeInfoMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton bbanque,bJ1,bJ2,bJ3,bJ4;
	private Menu menu;
	
	public TradeInfoMenu(Menu menu){
		
		this.menu=menu;
		setFrame();
		setComponents();
		setVisible(true);
	}
	
	public void setFrame(){
		
		setSize(400,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); 
		setAlwaysOnTop(true);
		setTitle("Menu Commerce");
		setLayout(null);
	}
	
	public void setComponents(){
		
		bbanque = new JButton("Banque");
		bbanque.setBackground(new Color(151,140,210));
		bbanque.addMouseListener(new TradeListener(menu,-1,this));
		bJ1 = new JButton("J1");
		bJ1.setBackground(new Color(58,142,48));
		bJ1.addMouseListener(new TradeListener(menu,1,this));
		bJ2 = new JButton("J2");
		bJ2.setBackground(new Color(76,117,179));
		bJ2.addMouseListener(new TradeListener(menu,2,this));
		bJ3 = new JButton("J3");
		bJ3.setBackground(new Color(172,38,29));
		bJ3.addMouseListener(new TradeListener(menu,3,this));
		bJ4 = new JButton("J4");
		bJ4.setBackground(new Color(230,184,2));
		bJ4.addMouseListener(new TradeListener(menu,4,this));
		
		bbanque.setBounds(5,5,385,95);
		bJ1.setBounds(5,105,94,62);
		bJ2.setBounds(104,105,94,62);
		bJ3.setBounds(203,105,94,62);
		bJ4.setBounds(302,105,88,62);
		
		add(bbanque);
		add(bJ1);
		add(bJ2);
		if(menu.getNbPlayers()==3){add(bJ3);}
		if(menu.getNbPlayers()==4){add(bJ3);add(bJ4);}
		
		switch (menu.getSelectedPlayer()){
		case 1:
			bJ1.setVisible(false);
			break;
		case 2:
			bJ2.setVisible(false);
			break;
		case 3:
			bJ3.setVisible(false);
			break;
		case 4:
			bJ4.setVisible(false);
			break;
		default:
			break;
		}
	}
}
