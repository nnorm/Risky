import java.util.*;

public class Plateau {
	
	private int longueur;
	private int largeur;
	private Continent[] continent;
	private ArrayList<Carte> carte;
	
	public Plateau(int largeur, int longueur ){
		
		this.largeur=largeur;
		this.longueur=longueur;
		
		for( int i=0; i<42; i++){ // créer les 42 carte
			if(i>14){
				this.carte.add(new Carte(Soldat));
			}
			if(i<=14 && i<28){
				this.carte.add(new Carte(Cavalier));
			}
			if(i>=28){
				this.carte.add(new Carte(Canon));
			}
		}
	}

	public void shuffleCarts(){
		Collections.shuffle(carte);
	}
	
	//public void 
}
