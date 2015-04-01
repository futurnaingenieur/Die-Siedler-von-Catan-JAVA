/*
 * LO43 BRUN-MERAT-PRIMAS
 * classe Card
 * implémentant une Carte de dévellopement.
 */

public class Card {
	private String nom;
	private int type;
	
	
	public Card(int type){
		this.type=type;
		switch(type){
			case 1:
				nom="Ancien";
				break;
			case 2:
				nom="Contrôles continus";
				break;
			case 3:
				nom="Découvertes";
				break;
			case 4:
				nom="Monopôle";
				break;
			case 5:
				nom="Point de victoire";
				break;
			case 6:
				nom="Le plus ancien";
				break;
			default:
				break;
		}
	}
	
	public int getType(){
		return type;
	}
	
	public String getNom(){
		return nom;
	}
}
