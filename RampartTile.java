/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe BarTile
 * implémentant une Tile de bordure sans rôle particulier
 */


// imports
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// classe
public class RampartTile extends Tile {
	
	// attributs
	private static final long serialVersionUID = 1L;
	
	// constructeur
	public RampartTile(){
		type=99;
	}
	
	// méthode dessinant sur la fenêtre la tuile
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Image img = null;
		try {
			img = ImageIO.read(new File("resources/Forest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
	}
}
