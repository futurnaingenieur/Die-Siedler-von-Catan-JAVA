import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BuyCardListener implements MouseListener {
	
	private Menu menu;
	private CardMenu cardMenu;
	private Character currentPlayer;
	
	public BuyCardListener(Menu menu, CardMenu cardMenu){
		this.cardMenu = cardMenu;
		this.menu = menu;
		this.currentPlayer = menu.getCurrentPlayer();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(currentPlayer.getInfo("cours")>=1 && currentPlayer.getInfo("cafe")>=1 && currentPlayer.getInfo("sommeil")>=1 && menu.getMap().getCardStack().size()>0){
			currentPlayer.getMap().drawCard(currentPlayer);
			currentPlayer.setCours(-1);
			currentPlayer.setCafe(-1);
			currentPlayer.setSommeil(-1);
			currentPlayer.getMap().getScreen().getMenu().getCurrentPlayer().getMap().getScreen().getMenu().modifyInfoPanel("Achat effectué");
		}
		else{
			if(menu.getMap().getCardStack().size()==0){
				currentPlayer.getMap().getScreen().getMenu().getCurrentPlayer().getMap().getScreen().getMenu().modifyInfoPanel("<html>Achat échoué. Plus de cartes!</html>");
			}
			else{
				currentPlayer.getMap().getScreen().getMenu().getCurrentPlayer().getMap().getScreen().getMenu().modifyInfoPanel("<html>Achat échoué. Pas assez de ressources!</html>");
			}
		}
		currentPlayer.getMap().getScreen().getMenu().repaint();
		cardMenu.setVisible(false);
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
