/** 
 * Classe permettant d'utiliser le concept de pays dans le context du jeu.
 * */
public class Pays implements Comparable{
	private String nom;
	private int numPays;
	private int nbArmees;
	private Continent continent;
	private Joueur owner;
	private Pays[] frontaliers;
	
	public int compareTo(Object o)
	{
		Pays p = (Pays)o;
		return p.nbArmees - this.nbArmees;
	}
	
	/**
	 * Ajoute des armées
	 * @param nbPions nombre de pions à ajouter au pays
	 */
	public void ajouterPions(int nbPions)
	{
		this.nbArmees += nbPions;
	}
	
	/**
	 * Enlève des armées
	 * @param nbPions nombre de pions à enlever au pays
	 */
	public void enleverPions(int nbPions) throws RuntimeException
	{
		if(nbPions >= this.nbArmees)
		throw new RuntimeException("requête impossible");
		this.nbArmees -= nbPions;
	}
	
	/**
	 * Vérifie si un pays est limitrophe avec ce pays
	 * @param p le pays à vérifier
	 */
	public boolean isVoisin(Pays p)
	{
		return PaysAdjacents.pays[this.numPays][p.getNumPays()];
	}
	
	/**
	 * Déplace des pions de ce pays à un autre
	 * @param p le pays destinataire du déplacement
	 * @param nbPions le nombre de pions à envoyer
	 * @throws RuntimeException si le pas destinataire n'est pas voisin du pays de départ
	 */
	public void deplacerPions(Pays p, int nbPions) throws RuntimeException
	{
		if(!this.isVoisin(p)) throw new RuntimeException("requête impossible");
		p.ajouterPions(nbPions);
		this.enleverPions(nbPions);
	}
	
	/**
	 * Accesseur sur owner
	 * @return le possesseur actuel du pays
	 */
	public Joueur getOwner()
	{
		return this.owner;
	}
	
	/**
	 * Change le propriétaire du pays
	 * @param j le nouveau propriétaire
	 */
	public void setOwner(Joueur j)
	{
		this.owner.perdrePays(this);
		j.acquerirPays(this);
		this.owner = j;
	}
	
	/**
	 * Accesseur sur nbArmees
	 * @return le nombre d'armées actuel du pays
	 */
	public int getNbArmees()
	{
		return this.nbArmees;
	}
	
	public Continent getContinent(){
		return this.continent;
	}
	public int getNumPays()
	{
		return this.numPays;
	}
}

