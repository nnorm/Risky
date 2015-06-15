import java.util.*;

public class Continent {
	private ArrayList<Pays> pays;
	private int bonusPion;
	private String nom;
	
	public Continent(String nom, int bonus)
	{
		this.nom = nom;
		this.bonusPion = bonus;
		this.pays = new ArrayList<Pays>();
	}
	
	public void addPays(Pays p) throws IllegalArgumentException
	{
		for(Pays ps : this.pays)
			if(ps == p)
				throw new IllegalArgumentException("Ce pays est déjà dans le continent !");
		
		this.pays.add(p);
	}
}