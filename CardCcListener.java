import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CardCcListener implements MouseListener {

	private Menu menu;
	private SeeCardMenu seeCardMenu;
	
	public CardCcListener(Menu menu, SeeCardMenu seeCardMenu){
		this.menu= menu;
		this.seeCardMenu = seeCardMenu;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		menu.getMap().createCardRoadListener();
		seeCardMenu.setVisible(false);
		menu.getCurrentPlayer().removeCard(2);
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
