import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class NextTurnListener implements MouseListener {
	
	private Menu menu; 
	
	public NextTurnListener(Menu menu){
		this.menu = menu;
	}

	public void mouseClicked(MouseEvent arg0) {
		
		if(menu.getTurn1()<menu.getNbPlayers()-1){
			menu.getMap().setT1(true);
			menu.getMap().setT1R(true);
			menu.incrementTurn1();
		}else if(menu.getTurn2()<menu.getNbPlayers()){
			menu.incrementTurn1();
			menu.getMap().setT1(true);
			menu.getMap().setT1R(true);
			menu.incrementTurn2();
		}else{
			menu.incrementTurn1();
			menu.incrementTurn2();
		}
		menu.nextTurn();
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
