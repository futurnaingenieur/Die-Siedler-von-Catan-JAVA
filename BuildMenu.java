
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BuildMenu extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton bUv;
	private JButton bUvStar;
	private JButton bRoad;
	private JLabel imgPrice;
	private JLabel uvPrice;
	private JLabel uvsPrice;
	private JLabel roadPrice;
	private Map map;
	
	public BuildMenu(Map map){
		
		this.map=map;
		setFrame();
		setComponents();
		setVisible(true);
	}
	
	public void setFrame(){
		
		setSize(410,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Menu Construction");
		setLayout(null);
	}
	
	public void setComponents(){
		
		bUv=new JButton("UV");
		bUvStar=new JButton ("UV étoilée");
		bRoad=new JButton("Contrôle continu");
		imgPrice=new JLabel(new ImageIcon("resources/menu_build.png"));
		
		bUv.setBounds(20,20,130,30);
		add(bUv);
		bUv.addMouseListener(new BuildUvListener(map, this));
		
		bUvStar.setBounds(20,70,130,30);
		add(bUvStar);
		bUvStar.addMouseListener(new BuildUvStarListener(map, this));
		
		bRoad.setBounds(20,120,130,30);
		add(bRoad);
		bRoad.addMouseListener(new BuildRoadListener(map, this));
		
		imgPrice=new JLabel(new ImageIcon("resources/img_construct_panel.png"));
		imgPrice.setBounds(170,17,43,134);
		add(imgPrice);
		
		uvPrice=new JLabel("<html>BIERE x1 NOURRITURE x1<br>COURS x1 CAFE x1</html>");
		uvPrice.setBounds(229,9,180,50);
		add(uvPrice);
		
		uvsPrice=new JLabel("<html>COURS x2<br>SOMMEIL x3</html>");
		uvsPrice.setBounds(229,59,100,50);
		add(uvsPrice);
		
		roadPrice=new JLabel("<html>BIERE x1<br>NOURRITURE x1</html>");
		roadPrice.setBounds(229,109,100,50);
		add(roadPrice);
	}
}
