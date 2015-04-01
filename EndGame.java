
import javax.swing.JLabel;
import javax.swing.JPanel;


public class EndGame extends JPanel{

	private static final long serialVersionUID = 1L;
	private Map map;
	private JLabel info;
	
	public EndGame(Map map){
		this.map=map;
		setWindow();
		setInfoPanel();
	}
	
	public void setWindow(){
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(1200,812);
		this.setBounds(0, 0, 1200, 812);
	}
	
	public void setInfoPanel(){
		info=new JLabel("Le " + map.getScreen().getMenu().getCurrentPlayer().getName() + " a gagné !");
		info.setBounds(20,20,210,110);
		add(info);
	}
}
