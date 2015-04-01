import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class UvStarListener implements MouseListener {

	private Character currentPlayer;
	private Map map;
	private Uv uv;
	private Screen screen;
	private boolean b;

	public UvStarListener(Map map){
		
		this.map = map;
		this.screen=map.getScreen();
		this.currentPlayer=screen.getMenu().getCurrentPlayer();
		
		uv = new Uv(map);
		b=true;
	}
	
	public void mouseClicked(MouseEvent e) {
		uv = (Uv)e.getSource();
		uv.setBuildableMode(true);
		if (uv.isUvStarBuildable(currentPlayer, uv)==true){
			map.setUvStarToPlayer(uv);
			screen.repaint();
			uv.buyUvStar(currentPlayer);
			screen.getMenu().modifyInfoPanel("UV étoilée construite.");
			map.RemoveUvStarListener();
			b=false;
		} else if(b) {
			if (screen.getMenu().getInfoPanelString()!="<html>Vous n'avez pas assez de ressources</html>"){
				screen.getMenu().modifyInfoPanel("<html>La construction de cette UV n'est pas possible ici !</html>");
			}
		}
		uv.setBuildableMode(false);
		screen.repaint();
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
