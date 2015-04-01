import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TradeInfoListener implements MouseListener {
	private Menu menu;
	
	public TradeInfoListener(Menu menu){
		this.menu = menu;
	}

	public void mouseClicked(MouseEvent e) {
		new TradeInfoMenu(menu);
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
