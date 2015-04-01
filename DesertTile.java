/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe BarTile
 * implémentant une Tile ne générant aucune ressource
 */


// imports
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// classe
public class DesertTile extends Tile{
	
	// attributs
	private static final long serialVersionUID = 1L;
	
	// constructeur
	public DesertTile(){
		type=6;
	}
	
	// méthode dessinant sur la fenêtre la tuile
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Image img = null;
		try {
			img = ImageIO.read(new File("resources/desert.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
	
		if(binomeGlandeur){
			Image img2 = null;
			try {
				img2 = ImageIO.read(new File("resources/glandeur.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img2, 35, 15, this);
		}
	}
}
