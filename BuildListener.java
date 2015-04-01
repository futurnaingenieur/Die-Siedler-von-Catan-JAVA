/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe BuildListener
 * active le menu de construction par la souris
 */


// imports
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


// classe
public class BuildListener implements MouseListener {
	
	// attributs
	private Map map;
	
	// constructeur
	public BuildListener(Map map){
		
		this.map = map;
	}
	
	// méthode détectant un clic de souris
	public void mouseClicked(MouseEvent arg0) {
		
		new BuildMenu(map);
	}

	// méthode détectant le passage de la souris
	public void mouseEntered(MouseEvent arg0) {
		
	}

	// méthode détectant la sortie de la souris
	public void mouseExited(MouseEvent arg0) {
		
	}

	// méthode détectant l'appui de la souris
	public void mousePressed(MouseEvent arg0) {
		
	}

	// méthode détectant le relâchement de la souris
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
