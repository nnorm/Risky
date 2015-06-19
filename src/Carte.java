/**
 * Classe décrivant le concept de carte de jeu. 
 * */
public class Carte{
	
	private TypeCarte type;
	
	/**
	 * Constructeur avec argument.
	 * @param type le type de la carte à instancier. (TypeCarte) 
	 * */
	public Carte(TypeCarte type)
	{
		this.type = type;
	}
	
	/**
	 * Méthode d'instance de type getter permettant de récupérer le type de la carte.
	 * @return type de la carte. (TypeCarte) 
	 * */
	public TypeCarte getType()
	{
		return this.type;
	}
}