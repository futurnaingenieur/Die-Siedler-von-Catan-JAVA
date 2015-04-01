import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CardAncienListener implements MouseListener {
	private Menu menu;
	private SeeCardMenu seeCardMenu;
	
	public CardAncienListener(Menu menu, SeeCardMenu seeCardMenu){
		this.seeCardMenu=seeCardMenu;
		this.menu=menu;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		menu.getMap().createCardTileListener();
		seeCardMenu.setVisible(false);
		menu.getCurrentPlayer().removeCard(1);
		menu.getCurrentPlayer().addPlusAncien();
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
