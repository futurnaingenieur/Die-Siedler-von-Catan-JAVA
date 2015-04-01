import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;


public class CardMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	private Menu menu;
	private JButton bBuy;
	private JButton bSee;
	
	public CardMenu(Menu menu){
		this.menu = menu;
		setFrame();
		setComponents();		
		setVisible(true);
	}
	
	public void setFrame(){
		
		setSize(400,224);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Menu Carte");
		setLayout(null);
	}
	
	public void setComponents(){
		bBuy = new JButton("<html>Acheter (1 cours + 1 café + 1 sommeil)</html>");
		bSee = new JButton("Voir cartes");
		bBuy.setBounds(5,5,383,90);
		bSee.setBounds(5,100,383,90);
		bBuy.setFont(new Font("arial",Font.BOLD,15));
		bSee.setFont(new Font("arial",Font.BOLD,15));
		bBuy.setBackground(new Color(255,255,255));
		bSee.setBackground(new Color(170,170,170));
		bBuy.addMouseListener(new BuyCardListener(menu,this));
		bSee.addMouseListener(new SeeCardListener(menu,this));
		this.add(bBuy);
		this.add(bSee);
		
	}
}
