import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BuildRoadListener implements MouseListener {
	
	private Map map;
	private BuildMenu b;
	
	public BuildRoadListener(Map map, BuildMenu bm){
		
		this.map=map;
		b=bm;
	}

	public void mouseClicked(MouseEvent e) {
		
		map.createRoadListener();
		b.setVisible(false);
		map.getScreen().getMenu().modifyInfoPanel("<html>Cliquez sur la route que vous souhaitez construire</html>");
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
