import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SeeCardMenu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Menu menu;
	private ArrayList<JButton> buttonList;
	
	public SeeCardMenu(Menu menu){
		this.menu=menu;
		buttonList = new ArrayList<JButton>();
		setFrame();
		setComponents();
		setVisible(true);
		
	}
	
	public void setFrame(){
		
		setSize(350,170);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); 
		setAlwaysOnTop(true);
		setTitle("Menu Carte");
		setLayout(new FlowLayout());
	}
	
	public void setComponents(){
		
		for(Card temp : menu.getCurrentPlayer().getCardList()){
			JButton button = new JButton(temp.getNom());
			button.setName(Integer.toString(temp.getType()));
			buttonList.add(button);
		}
		for(JButton temp : buttonList){
			switch(temp.getName()){
				case "1":
					temp.addMouseListener(new CardAncienListener(menu,this));
					break;
				case "2":
					temp.addMouseListener(new CardCcListener(menu,this));
					break;
				case "3":
					temp.addMouseListener(new CardDecouverteListener(menu,this));
					break;
				case "4":
					temp.addMouseListener(new CardMonopoleListener(menu,this));
					break;
				case "5":
					temp.addMouseListener(new CardVictoireListener(menu,this));
					break;
				case "6":
					temp.addMouseListener(new CardPlusAncienListener(menu,this));
					break;
				default:
					break;
			
			}
			add(temp);
		}
			
		}
}

