import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SeeCardListener implements MouseListener{
	private Menu menu;
	private CardMenu cardMenu;
	public SeeCardListener(Menu menu, CardMenu cardMenu){
		this.menu = menu;
		this.cardMenu = cardMenu;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		new SeeCardMenu(menu);
		cardMenu.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
