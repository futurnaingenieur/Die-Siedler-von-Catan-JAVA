import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CardVictoireListener implements MouseListener {
	private Menu menu;
	private SeeCardMenu seeCardMenu;
	
	public CardVictoireListener(Menu menu, SeeCardMenu seeCardMenu){
		this.menu = menu;
		this.seeCardMenu = seeCardMenu;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Victoire!");
		menu.getCurrentPlayer().addPoint(1);
		menu.getCurrentPlayer().removeCard(5);
		seeCardMenu.setVisible(false);
		menu.modifyInfoPanel("<html> 1 point de victoire a été ajouté à votre total! </html>");
		
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
