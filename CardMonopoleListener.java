import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CardMonopoleListener implements MouseListener {
	private Menu menu;
	private SeeCardMenu seeCardMenu;
	
	public CardMonopoleListener(Menu menu, SeeCardMenu seeCardMenu){
		this.menu= menu;
		this.seeCardMenu = seeCardMenu;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int total=0;
		// TODO Auto-generated method stub
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
			for(int i=0;i<menu.getNbPlayers();i++){
				total+= menu.getPlayer(i).getInfo("biere");
				menu.getPlayer(i).setBiere(-menu.getPlayer(i).getInfo("biere"));
			}
			menu.getCurrentPlayer().setBiere(total);
			break;
		case "Cours":
			for(int i=0;i<menu.getNbPlayers();i++){
				total+= menu.getPlayer(i).getInfo("cours");
				menu.getPlayer(i).setCours(-menu.getPlayer(i).getInfo("cours"));
			}
			menu.getCurrentPlayer().setCours(total);
			break;
		case "Café":
			for(int i=0;i<menu.getNbPlayers();i++){
				total+= menu.getPlayer(i).getInfo("cafe");
				menu.getPlayer(i).setCafe(-menu.getPlayer(i).getInfo("cafe"));
			}
			menu.getCurrentPlayer().setCafe(total);
			break;
		case "Nourriture":
			for(int i=0;i<menu.getNbPlayers();i++){
				total+= menu.getPlayer(i).getInfo("nourriture");
				menu.getPlayer(i).setNourriture(-menu.getPlayer(i).getInfo("nourriture"));
			}
			menu.getCurrentPlayer().setNourriture(total);
			break;
		case "Sommeil":
			for(int i=0;i<menu.getNbPlayers();i++){
				total+= menu.getPlayer(i).getInfo("sommeil");
				menu.getPlayer(i).setSommeil(-menu.getPlayer(i).getInfo("sommeil"));
			}
			menu.getCurrentPlayer().setSommeil(total);
			break;
		default:
			break;
		}
		optionFrame.setVisible(false);
		menu.repaint();
		seeCardMenu.setVisible(false);
		menu.getCurrentPlayer().removeCard(4);
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
