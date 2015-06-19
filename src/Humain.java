import java.util.*;
/**
 * Classe fille de Joueur jouant le rôle de joueur humain. 
 * */
public class Humain extends Joueur{
	/**
	 * Constructeur avec arguments.
	 * @param pseudo le pseudo du joueur. (String)
	 * @param nbArmeesInit le nombre d'armées disponible à l'initialisation du jeu. (int) 
	 * */
	public Humain(String pseudo, int nbArmeesInit)
	{
		this.pseudo = pseudo;
		this.armeesDispo = nbArmeesInit;
		this.main = new LinkedList<Carte>();
		this.pays = new LinkedList<Pays>();
		this.continent = new LinkedList<Continent>();
		this.couleur = Humain.colorList[Humain.colorIndex];
		Humain.colorIndex++;
		this.idJ += 1 ;
		this.score = 0;
	}
}
