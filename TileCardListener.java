import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TileCardListener implements MouseListener {
	private Menu menu;
	
	public TileCardListener(Menu menu){
		this.menu=menu;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Tile t=(Tile)e.getSource();
		System.out.println(menu.getMap().getBinome());
		menu.getMap().setBinomeGlandeur(t.getIndex());
		menu.getMap().removeCardTileListener();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
