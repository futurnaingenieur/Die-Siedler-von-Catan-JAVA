/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe ExchangeTile
 * implémentant une Tile représentant un port (ou ici, un bus Optymo)
 */


// imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// classe
public class ExchangeTile extends Tile{
	
	// attributs
	private static final long serialVersionUID = 1L;
	
	// constructeur
	public ExchangeTile(){
		type=7;
	}
	
	
	// méthode dessinant sur la fenêtre la tuile
	public void paintComponent(Graphics g){
		
		Image img = null;
		try {
			img = ImageIO.read(new File("resources/exchange.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
		g.setColor(Color.BLUE);
	}
}
