import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class InternTradeListener implements MouseListener {

	JButton jbt;
	TradeMenu tm;
	
	public InternTradeListener(TradeMenu tm, JButton jbt){
		this.tm = tm;
		this.jbt=jbt;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (jbt.getText()){
			case "-":
				tm.increment(jbt);
				break;
			case "+":
				tm.increment(jbt);
				break;
			case "Valider":
				tm.checkAndAssign();
				break;
			default:
				break;
		}
		if(jbt.getText()=="Valider"){
			tm.setVisible(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
