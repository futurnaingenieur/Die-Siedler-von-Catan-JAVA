import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CardDecouverteListener implements MouseListener {

	private Menu menu;
	private SeeCardMenu seeCardMenu;
	
	public CardDecouverteListener(Menu menu, SeeCardMenu seeCardMenu){
		this.menu= menu;
		this.seeCardMenu = seeCardMenu;
	}
	
	public void choixRessource(){
		Object[] choix = {"Bière","Cours","Café","Nourriture","Sommeil"};
		JFrame optionFrame = new JFrame("Choix ressource");
		optionFrame.setLocationRelativeTo(null);
		optionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		optionFrame.setResizable(false); 
		optionFrame.setAlwaysOnTop(true);
		optionFrame.setVisible(true);
		String s = (String)JOptionPane.showInputDialog(optionFrame,"Choisir une ressource","Choix ressource",JOptionPane.QUESTION_MESSAGE,null,choix,choix[0]);
		switch(s){
		case "Bière":
			menu.getCurrentPlayer().setBiere(1);
			break;
		case "Cours":
			menu.getCurrentPlayer().setCours(1);
			break;
		case "Café":
			menu.getCurrentPlayer().setCafe(1);
			break;
		case "Nourriture":
			menu.getCurrentPlayer().setNourriture(1);
			break;
		case "Sommeil":
			menu.getCurrentPlayer().setSommeil(1);
			break;
		default:
			break;
		}
		optionFrame.setVisible(false);
		menu.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		choixRessource();
		choixRessource();
		seeCardMenu.setVisible(false);
		menu.getCurrentPlayer().removeCard(3);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
