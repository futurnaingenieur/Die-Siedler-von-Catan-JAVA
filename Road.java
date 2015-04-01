import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Road extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int type;
	private Character player;
    private boolean buildableMode;
	
	public Road(int type, Menu menu){
		this.type=type;
		this.player=null;
		buildableMode = false;
	}
	
	public void setToPlayer(Character player){
		this.player = player;
	}
	
	public void setBuildableMode(boolean b){
		buildableMode=b;
	}
	
	public Character getPlayer(){
		return player;
	}
	
	public boolean isRoadBuildable(Character c, Screen screen){
		
		boolean b=false;
		if(player == null && buildableMode==true){
			for(Uv uvtemp : c.getUvList()){
				if(uvtemp.getRoadIndex()[0]>=0){
					if(uvtemp.getMap().getRoadTab(1)[uvtemp.getRoadIndex()[0]]==this){
						b=true;
					}
				}
				if(uvtemp.getRoadIndex()[1]>=0){
					if(uvtemp.getMap().getRoadTab(2)[uvtemp.getRoadIndex()[1]]==this){
						b=true;
					}
				}
				if(uvtemp.getRoadIndex()[2]>=0){
					if(uvtemp.getMap().getRoadTab(3)[uvtemp.getRoadIndex()[2]]==this){
						b=true;
					}
				}
			}
		}
		if (c.getInfo("biere")<1 ||  c.getInfo("nourriture")<1){
			b=false;
			screen.getMenu().modifyInfoPanel("<html>Vous n'avez pas assez de ressources</html>");
		}
		return b;
	}
	
	public boolean isCardRoadBuildable(Character c){
		boolean b=false;
		if(player == null && buildableMode==true){
			for(Uv uvtemp : c.getUvList()){
				if(uvtemp.getRoadIndex()[0]>=0){
					if(uvtemp.getMap().getRoadTab(1)[uvtemp.getRoadIndex()[0]]==this){
						b=true;
					}
				}
				if(uvtemp.getRoadIndex()[1]>=0){
					if(uvtemp.getMap().getRoadTab(2)[uvtemp.getRoadIndex()[1]]==this){
						b=true;
					}
				}
				if(uvtemp.getRoadIndex()[2]>=0){
					if(uvtemp.getMap().getRoadTab(3)[uvtemp.getRoadIndex()[2]]==this){
						b=true;
					}
				}
			}
		}
		return b;
	}

	public void buyRoad(Character buildPlayer){
		buildPlayer.setNourriture(-1);
		buildPlayer.setBiere(-1);
	}
	
	public boolean isInside(int x, int y){
		
		if(type==1){
			if(y>=-0.5*x+8 && y<=1.72*x+8 && y>=1.72*x-27.52 && y<=-0.5 * x + 63.5)
			{
				repaint();
				return true;
			}
			else{
				return false;
			}
		}
		
		else if(type==3){
			if(y>=0 && y<=20 && x>=0 && x<=50){
				repaint();
				return true;
			}
			else{
				return false;
			}
		}
		
		else if(type==2){
			if(y>=-1.72*x+43 && y<=0.5*x+43 && y>=0.5*x-12.5 && y<=-1.72 * x + 78.52){
				repaint();
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	
	public void paintComponent(Graphics g){
	
		Image img=null;
		String s=null;
		
		switch(type){
		case 1:
			if(player==null)
				s="resources/roadtype1.png";
			else if(player.getColor().equals(new Color(58,142,48)))
				s="resources/roadtype1_p1.png";
			else if(player.getColor().equals(new Color(76,117,179)))
				s="resources/roadtype1_p2.png";
			else if(player.getColor().equals(new Color(172,38,29)))
				s="resources/roadtype1_p3.png";
			else if(player.getColor().equals(new Color(230,184,2)))
				s="resources/roadtype1_p4.png";
			
			try {
				img = ImageIO.read(new File(s));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, this);
			break;
		case 2:
			if(player==null)
				s="resources/roadtype2.png";
			else if(player.getColor().equals(new Color(58,142,48)))
				s="resources/roadtype2_p1.png";
			else if(player.getColor().equals(new Color(76,117,179)))
				s="resources/roadtype2_p2.png";
			else if(player.getColor().equals(new Color(172,38,29)))
				s="resources/roadtype2_p3.png";
			else if(player.getColor().equals(new Color(230,184,2)))
				s="resources/roadtype2_p4.png";
			try {
				img = ImageIO.read(new File(s));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, this);
			break;
		case 3:
			if(player==null)
				s="resources/roadtype3.png";
			else if(player.getColor().equals(new Color(58,142,48)))
				s="resources/roadtype3_p1.png";
			else if(player.getColor().equals(new Color(76,117,179)))
				s="resources/roadtype3_p2.png";
			else if(player.getColor().equals(new Color(172,38,29)))
				s="resources/roadtype3_p3.png";
			else if(player.getColor().equals(new Color(230,184,2)))
				s="resources/roadtype3_p4.png";
			try {
				img = ImageIO.read(new File(s));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, this);
			break;
		default:
			break;
		}
	}
}
