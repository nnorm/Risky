import java.util.*;

public class Continent {
	private ArrayList<Pays> pays;
	private int bonusPion;
	private String nom;
	
	public Continent(String nom, int bonus)
	{
		this.setNom(nom);
		this.setBonusPion(bonus);
		this.pays = new ArrayList<Pays>();
	}
	
	public void addPays(Pays p) throws IllegalArgumentException
	{
		for(Pays ps : this.pays)
			if(ps == p)
				throw new IllegalArgumentException("Ce pays est déjà dans le continent !");
		
		this.pays.add(p);
	}

	public int getBonusPion() {
		return bonusPion;
	}

	public void setBonusPion(int bonusPion) {
		this.bonusPion = bonusPion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
