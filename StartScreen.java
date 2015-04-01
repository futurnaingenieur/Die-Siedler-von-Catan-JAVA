import javax.swing.JOptionPane;


public class StartScreen {
	
	private Screen screen;
	private int nbPlayers;
	private String choixNbJoueurs[];

	public StartScreen(){
		
		screen=new Screen();
		new JOptionPane();
		choixNbJoueurs = new String[3];
		choixNbJoueurs[0]= "<html>2</html>";
		choixNbJoueurs[1]= "3";
		choixNbJoueurs[2]= "4";
		nbPlayers = JOptionPane.showOptionDialog(null, "A combien de joueurs désirez-vous jouer ?", "Les colons de l'UTBohèMe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choixNbJoueurs, choixNbJoueurs[2]);
		if(nbPlayers!=-1)
			launch();
	}
	
	public void launch(){
		screen.createAndDisplay(nbPlayers+2);
	}
}
