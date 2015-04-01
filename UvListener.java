import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class UvListener implements MouseListener{

	private Character currentPlayer;
	private Map map;
	private Uv uv;
	private Screen screen;
	private boolean b;

	public UvListener(Map map){
		
		this.map = map;
		this.screen=map.getScreen();
		this.currentPlayer=screen.getMenu().getCurrentPlayer();
		
		uv = new Uv(map);
		b=true;
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		uv = (Uv)e.getSource();
		if(map.getT1()){
			uv.setBuildableMode(true);
			uv.setToPlayer(currentPlayer);
			map.setT1(false);
			screen.repaint();
			uv.setBuildableMode(false);
			screen.getMenu().modifyInfoPanel("<html>Placez votre premier contrôle continu</html>");
			map.RemoveUvListener();
		}else{
			uv.setBuildableMode(true);
			if (uv.isUvBuildable(currentPlayer, uv)==true){
				map.setUvToPlayer(uv);
				screen.repaint();
				uv.buyUv(currentPlayer);
				screen.getMenu().modifyInfoPanel("UV construite.");
				map.RemoveUvListener();
				b=false;
			} else if(b) {
				if (screen.getMenu().getInfoPanelString()!="<html>Vous n'avez pas assez de ressources</html>"){
					screen.getMenu().modifyInfoPanel("<html>La construction de cette UV n'est pas possible ici !</html>");
				}
			}
			uv.setBuildableMode(false);
		}
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
