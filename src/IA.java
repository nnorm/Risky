import java.util.*;

/**
 * Classe fille de Joueur jouant le rôle d'IA. 
 * */
public class IA extends Joueur
{
	private int lvlDifficulte;
	public static int nbIA = 0;
	/**
	 * Constructeur avec arguments.
	 * @param nbArmeesInit le nombre d'armées disponible à l'initialisation du jeu. (int) 
	 * */	
	public IA(int nbArmeesInit)
	{
		this.armeesDispo = nbArmeesInit;
		this.pseudo = "Ordinateur " + IA.nbIA;
		this.main = new LinkedList<Carte>();
		this.pays = new LinkedList<Pays>();
		this.continent = new LinkedList<Continent>();
		this.couleur = Humain.colorList[Humain.colorIndex];
		Humain.colorIndex++;
		IA.nbIA++;
	}
	
	/**
	 * Méthode d'instance faisant jouer le tour à l'IA courante. 
	 * */
	public void jouerTour()
	{}
	
}
