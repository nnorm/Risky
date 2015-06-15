
public class Pays {
	private String nom;
	private int nbArmees;
	//private Continent continent;
	private Joueur owner;
	private Pays[] frontaliers;
	
	public void ajouterPions(int nbPions)
	{
		this.nbArmees += nbPions;
	}
	
	public void enleverPions(int nbPions)
	{
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
	
	public void deplacerPions(Pays p, int nbPions)
	{
		if(!this.isVoisin(p)) throw new RuntimeException("requête impossible");
		
	}
	
	public Joueur getOwner()
	{
		return this.owner;
	}
	
	public int nbArmees()
	{
		return this.nbArmees;
	}
}
