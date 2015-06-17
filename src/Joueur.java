import java.util.*;
import java.awt.*;

/**
 * Classe abstraite traduisant le concept abstrait de joueur. 
 * */
public abstract class Joueur {

	protected String pseudo;
	protected int armeesDispo;
	protected Color couleur;
	protected LinkedList<Carte> main;
	protected LinkedList<Continent> continent;
	protected LinkedList<Pays> pays;
	public static int colorIndex = 0;
	protected static Color colorList[] = {Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange, Color.pink};
	protected Plateau plateau;
	/**
	 * Permet de distribuer les pions entre les pays du joueur.
	 * @param p le pays dans lequel il faut ajouter des pions. (Pays)
	 * @param nbPions le nombre de pions à donner au pays désigné. (int)
	 * */
	public void distribuer(Pays p,int nbPions){
		if(this.armeesDispo>nbPions){
		p.ajouterPions(nbPions);
		this.armeesDispo-=nbPions;
		}
	}
	
	/**
	 * Méthode d'instance permettant de vérifier les différentes combinaisons possibles entre les cartes indiquées
	 * @param c1 la carte 1. (Carte)
	 * @param c2 la carte 2. (Carte)
	 * @param c3 la carte 3. (Carte)
	 * @return  le nombre de pions que l'on obtiens avec cette combinaison de cartes. (int)
	 * */
	public int combinaison(Carte c1,Carte c2,Carte c3)
	{
		int res=0;
		if(c1.getType()==TypeCarte.Canon && c2.getType()==TypeCarte.Canon && c3.getType()==TypeCarte.Canon)res=8;
		else if(c1.getType()==TypeCarte.Soldat && c2.getType()==TypeCarte.Soldat && c3.getType()==TypeCarte.Soldat)res=3;
		else if(c1.getType()==TypeCarte.Cavalier && c2.getType()==TypeCarte.Cavalier && c3.getType()==TypeCarte.Cavalier)res=5;
		else if((c1.getType()==TypeCarte.Soldat && c2.getType()==TypeCarte.Cavalier && c3.getType()==TypeCarte.Canon) ||
				(c1.getType()==TypeCarte.Cavalier && c2.getType()==TypeCarte.Soldat && c3.getType()==TypeCarte.Canon) ||
				(c1.getType()==TypeCarte.Canon && c2.getType()==TypeCarte.Cavalier && c3.getType()==TypeCarte.Soldat) ||
				(c1.getType()==TypeCarte.Soldat && c2.getType()==TypeCarte.Canon && c3.getType()==TypeCarte.Cavalier) ||
				(c1.getType()==TypeCarte.Cavalier && c2.getType()==TypeCarte.Canon && c3.getType()==TypeCarte.Soldat) ||
				(c1.getType()==TypeCarte.Canon && c2.getType()==TypeCarte.Soldat && c3.getType()==TypeCarte.Cavalier))res=10;
		return res;
	}
	
	/**
	 * Méthode d'instance de type getter permettant de récupérer le nombre d'armées d'un joueur.
	 * @return le nombre d'armées auquelles le joueur a accès. (int) 
	 * */
	public int getArmeesDispo(){
		return this.armeesDispo;
	}
	
	/**
	 * Ajoute un nombre d'armées indiqué.
	 * @param nb le nombre d'armées à ajouter au joueur. (int) 
	 * */	
	public void ajouterArmeesDispo(int nb){
		this.armeesDispo+=nb;
	}
	
	/**
	 * Soustrait un nombre d'armées indiqué.
	 * @param nb le nombre d'armées à retirer au joueur. (int) 
	 * */
	public void enleverArmeesDispo(int nb){
		this.armeesDispo-=nb;
	}
	
	/**
	 * Enlève un pays de la liste des pays de ce joueur
	 * @param p le pays perdu
	 */
	public void perdrePays(Pays p)
	{
		this.pays.remove(p);
	}
	
	/**
	 * Rajoute unpays à la liste des pays de ce joueur
	 * @param p le pays acquis
	 */
	public void acquerirPays(Pays p)
	{
		this.pays.add(p);
	}
	
	/**
	 * ajoute 1 unite sur tout les pays du joueur et enleve 1 unite a l'armee dispo
	 * @param pays
	 */
	public void mettre1ArmePays(LinkedList<Pays> pays){
		for(Pays p : pays){
			p.ajouterPions(1);
			this.armeesDispo=this.armeesDispo-1;
		}
	}
	
	/**
	 * ajout un continent a un joueur
	 * @param c
	 */
	public void ajoutContinent(Continent c){
		this.continent.add(c);
	}
	
	/**
	 * ajoute le nb de bonus d'un continent
	 */
	public void ajNbUniteContinent(){
		for(int i =0; i<this.continent.size();i++){
			this.ajouterArmeesDispo(this.continent.get(i).getBonusPion());
		}
	}
}
