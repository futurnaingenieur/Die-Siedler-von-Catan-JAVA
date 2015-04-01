import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BuildUvListener implements MouseListener{

	private Map map;
	private BuildMenu b;
	
	public BuildUvListener(Map map, BuildMenu bm){
		
		this.map = map;
		b=bm;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		
		map.createUvListener();
		b.setVisible(false);
		map.getScreen().getMenu().modifyInfoPanel("<html>Cliquez sur l'UV que vous souhaitez construire</html>");
		
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
