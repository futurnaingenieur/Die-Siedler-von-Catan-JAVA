import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TradeListener implements MouseListener{
	
	private Menu menu;
	private int customer;
	private TradeInfoMenu tim;
	
	public TradeListener(Menu menu, int customer, TradeInfoMenu tim){
		
		this.menu = menu;
		this.customer=customer;
		this.tim=tim;
	}

	public void mouseClicked(MouseEvent arg0) {
		tim.setVisible(false);
		new TradeMenu(menu, customer);
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}
