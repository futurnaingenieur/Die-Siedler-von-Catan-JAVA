import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class RoadListener implements MouseListener {

	private Character currentPlayer;
	private Map map;
	private Road road;
	private Screen screen;
	private boolean b;

	public RoadListener(Map map){
		this.map = map;
		this.screen=map.getScreen();
		this.currentPlayer=screen.getMenu().getCurrentPlayer();
		b=true;
	}

	public void mouseClicked(MouseEvent e) {
		
		road = (Road)e.getSource();
		if(map.getT1R()){
			road.setBuildableMode(true);
			map.setRoadToPlayer(road);
			map.setT1R(false);
			screen.repaint();
			road.setBuildableMode(false);
		}else{
			road.setBuildableMode(true);
			if(road.isRoadBuildable(currentPlayer, screen)){
				map.setRoadToPlayer(road);
				screen.repaint();
				road.buyRoad(currentPlayer);
				screen.getMenu().modifyInfoPanel("Contrôle Continu construit");
				map.RemoveRoadListener();
				b=false;
			}else if(b){
				if (screen.getMenu().getInfoPanelString()!="<html>Vous n'avez pas assez de ressources</html>"){
					screen.getMenu().modifyInfoPanel("<html>La construction de ce contrôle continu n'est pas possible ici !</html>");
			
				}
			}
			road.setBuildableMode(false);
		}
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
