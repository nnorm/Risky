import java.util.*;
/** 
 * Classe permettant l'utilisation du concept de plateau de jeu.
 * */
public class Plateau {
	
	private int longueur;
	private int largeur;
	private Continent[] continent;
	private LinkedList<Carte> carte;
	private LinkedList<Joueur> joueurs;
	/**
	 * Constructeur du plateau ; à compléter avec la création des continents
	 * */
	public Plateau(int largeur, int longueur, LinkedList<Joueur> joueurs ){
		
		this.joueurs = joueurs;
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
		for(Joueur j:this.joueurs)
		{
			j.setPlateau(this);
		}
	}
	
	/**
	 * Méthode d'instance permettant de mélanger toutes les cartes de la pioche. 
	 * */
	public void shuffleCards(){
		Collections.shuffle(carte);
	}
	
	/**
	 * Méthode d'instance retournant une carte piochée et la retire du tas.
	 * @return la carte piochée. (Carte) 
	 * */
	public Carte piocherCarte() {
		Carte c =this.carte.removeFirst();
		return c;
	}
	
	/**
	 * Méthode d'instance qui permet d'ajouter une carte au paquet et le mélange juste après.
	 * @param c la carte à ajouter. (Carte) 
	 * */
	public void mettreDsPaquet(Carte c){
		this.carte.add(c);
		this.shuffleCards();
	}
	
	/**
	 * Méthode d'instance de type getter sur l'attribut continent à l'indice donnée.
	 * @param  i l'indice du tableau où trouver le continent voulu. (int)
	 * @return le continent à l'indice indiqué. (Continent) 
	 */
	public Continent getContinent(int i) throws IllegalArgumentException
	{
		if(i > this.continent.length-1 || i < 0)
			throw new IllegalArgumentException("Indice invalide!");
		return this.continent[i];
	}
	
	/**
	 * Méthode d'instance de type getter sur la constante length de l'attribut continent.
	 * @return la taille du tableau this.continent. (int) 
	 * */
	public int getContinentLength()
	{
		return this.continent.length;
	}
}
