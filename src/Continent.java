import java.util.*;
/**
 * Classe décrivant le concept de Continent.
 * */
public class Continent {
	private ArrayList<Pays> pays;
	private int bonusPion;
	private String nom;
	
	/**
	 * Constructeur avec arguments
	 * @param nom le nom du continent. (String)
	 * @param bonus le bonus de pion que ce continent donne.
	 * */
	public Continent(String nom, int bonus)
	{
		this.setNom(nom);
		this.setBonusPion(bonus);
		this.pays = new ArrayList<Pays>();
	}
	
	/**
	 * Methode d'instance pour ajouter des pays au continent
	 * @param p le pays est a ajouté. (Pays) 
	 * */
	public void addPays(Pays p) throws IllegalArgumentException
	{
		for(Pays ps : this.pays)
			if(ps == p)
				throw new IllegalArgumentException("Ce pays est déjà dans le continent !");
		
		this.pays.add(p);
	}

	/**
	 * Methode d'instance type getter sur l'attribut bonusPion.
	 * @return bonusPion le bonus de pion accordé par le continent. (int) 
	 * */
	public int getBonusPion() {
		return bonusPion;
	}

	/**
	 * Methode d'instance type setter sur l'attribut bonusPion.
	 * @param bonusPion le bonus de pion accordé par le continent. (int) 
	 * */
	public void setBonusPion(int bonusPion) {
		this.bonusPion = bonusPion;
	}
	
	/**
	 * Methode d'instance type getter sur l'attribut nom.
	 * @return nom le nom du continent. (String) 
	 * */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Methode d'instance type setter sur l'attribut nom.
	 * @return nom le nom du continent. (String) 
	 * */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * methode d'insatnce qui renvoi si la personne as tout les pays du contient
	 * @param liste pays
	 * @return 
	 */
	public boolean appartient(ArrayList<Pays> pays){
		boolean res=false;
		int i =0;
		int nbPaysDansContinent = this.pays.size();
		int PaysDedant=0;
		while(i<pays.size()){
			if(this.pays.contains(pays.get(i))){
				PaysDedant++;
			}
			i++;
		}
		if(PaysDedant==nbPaysDansContinent)res=true;
		return res;
	}
	
	/**
	 * methode qui renvoi la liste de pays
	 * @return
	 */
	public ArrayList<Pays> getlistPays(){
		return this.pays;
	}
}
