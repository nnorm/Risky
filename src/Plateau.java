import java.util.*;

public class Plateau {
	
	private int longueur;
	private int largeur;
	private Continent[] continent;
	private LinkedList<Carte> carte;
	/**
	 * Constructeur du plateau ; à compléter avec la création des continents
	 * */
	public Plateau(int largeur, int longueur ){
		
		this.largeur=largeur;
		this.longueur=longueur;
		this.carte = new LinkedList<Carte>();
		for( int i=0; i<42; i++){ // créer les 42 cartes
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

	public void shuffleCards(){
		Collections.shuffle(carte);
	}
	
	public Carte piocherCarte() {
		Carte c =this.carte.removeFirst();
		return c;
	}

	public void mettreDsPaquet(Carte c){
		this.carte.add(c);
		this.shuffleCards();
	}
	
}
