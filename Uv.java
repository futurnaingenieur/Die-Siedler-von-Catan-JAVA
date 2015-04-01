import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe Uv
 * Implemente une UV qui sera constructible par les joueurs lors de la partie.
 */

public class Uv extends JPanel {

	private static final long serialVersionUID = 1L;
	private Character player;
	private Map map;
	private int type;
	private int tileIndex[];
	private int roadIndex[];
	private boolean buildableMode;
	
	public Uv(Map map){
		
		player=null;
		type=0;
		buildableMode=false;
		this.map=map;
		tileIndex=new int[3];
		roadIndex=new int[3];
	}
	
	public Map getMap(){
		return map;
	}
	
	public void setNearResources(int a, int b, int c){
		tileIndex[0]=a;
		tileIndex[1]=b;
		tileIndex[2]=c;
	}
	
	public void setNearRoads(int a, int b, int c){
		roadIndex[0]=a;
		roadIndex[1]=b;
		roadIndex[2]=c;
	}
	
	public void setToPlayer(Character c){
		player=c;
		type=1;
		c.addUv(this);
		player.addPoint(1);
	}
	
	public void setStarUv(){
		type=2;
		player.addPoint(1);
	}
	
	public void setBuildableMode(boolean b){
		buildableMode=b;
	}
	
	public int getType(){
		return type;
	}
	
	public boolean isUvBuildable(Character buildPlayer, Uv _uv){
		
		boolean bool = false;
		boolean pb = false;
		if (_uv.type==0 && buildableMode==true){
			int a = _uv.roadIndex[0];
			int b = _uv.roadIndex[1];
			int c = _uv.roadIndex[2];
			if(a==-1){
				if (buildPlayer.getInfo("biere")>=1 && buildPlayer.getInfo("nourriture")>=1 && buildPlayer.getInfo("cours")>=1 && buildPlayer.getInfo("cafe")>=1){
					if (map.getRoadTab(2)[_uv.roadIndex[1]].getPlayer()==buildPlayer || map.getRoadTab(3)[_uv.roadIndex[2]].getPlayer()==buildPlayer){
						bool = true;
					}
				} else {
					pb = true;
				}
			}
			else if(b==-1){
				if (buildPlayer.getInfo("biere")>=1 && buildPlayer.getInfo("nourriture")>=1 && buildPlayer.getInfo("cours")>=1 && buildPlayer.getInfo("cafe")>=1){
					if (map.getRoadTab(1)[_uv.roadIndex[0]].getPlayer()==buildPlayer || map.getRoadTab(3)[_uv.roadIndex[2]].getPlayer()==buildPlayer){
						System.out.println(b);
						bool = true;
					}
				}else {
					pb = true;
				}
			}
			else if(c==-1){
				if (buildPlayer.getInfo("biere")>=1 && buildPlayer.getInfo("nourriture")>=1 && buildPlayer.getInfo("cours")>=1 && buildPlayer.getInfo("cafe")>=1){
					if (map.getRoadTab(1)[_uv.roadIndex[0]].getPlayer()==buildPlayer || map.getRoadTab(2)[_uv.roadIndex[1]].getPlayer()==buildPlayer){
						bool = true;
					}
				}else {
					pb = true;
				}
			}
			else{
				if (buildPlayer.getInfo("biere")>=1 && buildPlayer.getInfo("nourriture")>=1 && buildPlayer.getInfo("cours")>=1 && buildPlayer.getInfo("cafe")>=1){
					if (map.getRoadTab(1)[_uv.roadIndex[0]].getPlayer()==buildPlayer || map.getRoadTab(2)[_uv.roadIndex[1]].getPlayer()==buildPlayer || map.getRoadTab(3)[_uv.roadIndex[2]].getPlayer()==buildPlayer){
						bool = true;
					}
				}else {
					pb = true;
				}
			}
			if(pb){
				map.getScreen().getMenu().modifyInfoPanel("<html>Vous n'avez pas assez de ressources</html>");
			}
		}
		return bool;
	}
	
	public void buyUv(Character buildPlayer){
		
		buildPlayer.setCours(-1);
		buildPlayer.setNourriture(-1);
		buildPlayer.setBiere(-1);
		buildPlayer.setCafe(-1);
	}
	
	public boolean isUvStarBuildable(Character buildPlayer, Uv _uv){
		
		boolean b = false;
		boolean pb = false;
		if (_uv.type==1 && buildableMode==true){
			if (buildPlayer.getInfo("sommeil")>=3 &&  buildPlayer.getInfo("cours")>=2 && player == buildPlayer){
				return true;
			}else {
				pb = true;
			}
		}
		if(pb){
			map.getScreen().getMenu().modifyInfoPanel("<html>Vous n'avez pas assez de ressources</html>");
		}
		return b;
	}
	
	public void buyUvStar(Character buildPlayer){
		buildPlayer.setCours(-2);
		buildPlayer.setSommeil(-3);
	}
	
	public String getStringFilename(){
		String str;
		if(type>0 && player.getColor().equals(new Color(58,142,48)))
			str="resources/uv_p1.png";
		else if(type>0 && player.getColor().equals(new Color(76,117,179)))
			str="resources/uv_p2.png";
		else if(type>0 && player.getColor().equals(new Color(172,38,29)))
			str="resources/uv_p3.png";
		else if(type>0 && player.getColor().equals(new Color(230,184,2)))
			str="resources/uv_p4.png";
		else
			str="resources/uv.png";
		return str;
	}
	
	
	public int[] getRoadIndex(){
		return roadIndex;
	}
	
	
	public int[] getTileIndex(){
		return tileIndex;
	}
	
	
	public Character getPlayer(){
		return player;	
	}

	
	public void setTileIndex(int a, int b, int c){
		tileIndex[0] = a;
		tileIndex[1] = b;
		tileIndex[2] = c;
	}
	
	public void setRoadIndex(int a, int b, int c){
		roadIndex[0] = a;
		roadIndex[1] = b;
		roadIndex[2] = c;
	}
	
	public void paintComponent(Graphics g){
		
		Image img = null;
		try {
			img = ImageIO.read(new File(getStringFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, this);
		
		if(type==2){
			try {
				img = ImageIO.read(new File("resources/star_uv.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img,0,0,this);
		}
		
	}
	
}
