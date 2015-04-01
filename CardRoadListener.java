import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CardRoadListener implements MouseListener {

	private Road road;
	private Menu menu;
	
	public CardRoadListener(Menu menu){
		this.menu = menu;
	}
	
	public void setCardRoad(){
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {

		road = (Road)e.getSource();
		road.setBuildableMode(true);
		if(road.isCardRoadBuildable(menu.getCurrentPlayer())){
			menu.getMap().setRoadToPlayer(road);
			menu.getMap().getScreen().repaint();
			menu.getMap().getScreen().getMenu().modifyInfoPanel("Contrôle Continu construit");
			menu.getMap().RemoveCardRoadListener();
		} 
		road.setBuildableMode(false);
		
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
