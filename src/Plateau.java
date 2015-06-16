import java.util.*;

public class Plateau {
	
	private int longueur;
	private int largeur;
	private Continent[] continent;
	private LinkedList<Carte> carte;
	private ArrayList<Joueur> joueur;
	/**
	 * constructeur manque creation continent
	 * */
	public Plateau(int largeur, int longueur ){
		
		this.largeur=largeur;
		this.longueur=longueur;
		// creation de la liste de carte
		for( int i=0; i<42; i++){ // créer les 42 carte
			if(i>14){
				this.carte.add(new Carte(TypeCarte.Soldat));
			}
			if(i<=14 && i<28){
				this.carte.add(new Carte(TypeCarte.Cavalier));
			}
			if(i>=28){
				this.carte.add(new Carte(TypeCarte.Canon));
			}
		}
	
		
		
		
		
	}

	public void shuffleCarts(){
		Collections.shuffle(carte);
	}
	
	public Carte piocherCarte() {
		Carte c =this.carte.removeFirst();
		return c;
	}

	public void mettreDsPaquet(Carte c){
		this.carte.add(c);
		this.shuffleCarts();
	}
	
}
