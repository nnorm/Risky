
public class Pays {
	private String nom;
	private int nbArmees;
	//private Continent continent;
	private Joueur owner;
	private Pays[] frontaliers;
	
	/**
	 * 
	 * @param nbPions nombre de pions à ajouter au pays
	 */
	public void ajouterPions(int nbPions)
	{
		this.nbArmees += nbPions;
	}
	
	/**
	 * 
	 * @param nbPions nombre de pions à enlever au pays
	 */
	public void enleverPions(int nbPions) throws RuntimeException
	{
		if(nbPions >= this.nbArmees)
		throw new RuntimeException("requête impossible");
		this.nbArmees -= nbPions;
	}
	
	public boolean isVoisin(Pays p)
	{
		boolean res = false;
		for(int i = 0; i < this.frontaliers.length && !res; i++)
		{
			res = p == frontaliers[i];
		}
		return res;
	}
	
	public void deplacerPions(Pays p, int nbPions) throws RuntimeException
	{
		if(!this.isVoisin(p)) throw new RuntimeException("requête impossible");
		
	}
	
	public Joueur getOwner()
	{
		return this.owner;
	}
	
	public int getNbArmees()
	{
		return this.nbArmees;
	}
}
