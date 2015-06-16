import java.util.*;

/**
 * Classe abstraite traduisant le concept abstrait de joueur. 
 * */
public abstract class Joueur {

	protected String pseudo;
	protected int armeesDispo;
	//protected Color couleur;
	protected LinkedList<Carte> main;
	protected LinkedList<Continent> continent;
	protected LinkedList<Pays> pays;
	
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
	 * Indique le nombre d'armées données par une combinaison de carte en paramètre
	 * @return le nombre d'armées
	 */
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

}
