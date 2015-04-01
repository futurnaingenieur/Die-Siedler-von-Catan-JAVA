import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CardPlusAncienListener implements MouseListener {
	private Menu menu;
	private SeeCardMenu seeCardMenu;
	
	public CardPlusAncienListener(Menu menu, SeeCardMenu seeCardMenu){
		this.menu=menu;
		this.seeCardMenu=seeCardMenu;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		menu.getCurrentPlayer().addPoint(2);
		seeCardMenu.setVisible(false);
		menu.getCurrentPlayer().removeCard(6);
		menu.modifyInfoPanel("<html> 2 points de victoire ont été ajoutés! </html>");
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
