/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe RestTile
 * implémentant une Tile générant la ressource Sommeil
 */


// imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// classe
public class RestTile extends Tile{
	
	// attributs
	private static final long serialVersionUID = 1L;
	
	// constructeur
	public RestTile(){
			type=2;
	}
	
	// méthode dessinant sur la fenêtre la tuile
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Image img = null;
		try {
			img = ImageIO.read(new File("resources/rest.png"));
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
		
		g.setColor(Color.ORANGE);
		g.fillOval(20,0, 25,25);
		g.setColor(Color.BLACK);
		g.drawOval(20, 0, 25, 25);
		Font font=new Font("arial",Font.BOLD,18);
		g.setFont(font);
		if(coefficient<10){
			g.drawString(Integer.toString(coefficient), 28, 19);
		}else{
			g.drawString(Integer.toString(coefficient), 23, 19);
		}
	}
}
	
		

