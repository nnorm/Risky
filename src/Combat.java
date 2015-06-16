import java.util.*;
/**
 * Méthode permettant d'utiliser le concept de combat entre deux joueurs. 
 * */
public class Combat {
	private int nbDesAttaque;
	private int nbDesDefense;

	/**
	 * Constructeur avec arguments.
	 * @param attaquant le pays attaquant. (Pays)
	 * @param defenseur le pays défenseur. (Pays)
	 * @param nbPionsAtk le nombre de pions attaquant. (int)
	 * */
	public Combat(Pays attaquant, Pays defenseur, int nbPionsAtk)
	{
		if(nbPionsAtk <1 || attaquant.getNbArmees() < 2 || defenseur.getNbArmees() < 1)
			throw new IllegalArgumentException("requête impossible");
		
		if(defenseur.getNbArmees() > 1 ) this.nbDesDefense = 2;
		else this.nbDesDefense = 1;
		
		if(nbPionsAtk < 3) this.nbDesAttaque = nbPionsAtk;
		else this.nbDesAttaque = 3;
	}
	
	/** 
	 * Méthode d'instance trouvant l'issue du combat.
	 * */
	public void effectuerCombat()
	{
		Random rnd = new Random();
		int[] lancersAtk = new int[this.nbDesAttaque];
		int[] lancersDef = new int[this.nbDesDefense];
		for(int i = 0; i < lancersAtk.length; i++)
		{
			lancersAtk[i] = rnd.nextInt(6) +1;
		}
		
		for(int i = 0; i < lancersDef.length; i++)
		{
			lancersDef[i] = rnd.nextInt(6) +1;
		}
	}
}
