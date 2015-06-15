
public class Pays {
	private String nom;
	private int nbArmees;
	//private Continent continent;
	private Joueur owner;
	private Pays[] frontaliers;
	
	public void ajouterPions(int nbPions)
	{
		if(nbPions < this.owner.getArmeesDispo())
			throw new RuntimeException("requête impossible");
		
		this.nbArmees += nbPions;
		this.owner.enleverArmeesDispo(nbPions);
	}
	
}
