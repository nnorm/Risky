import java.util.*;
/**
 * Méthode permettant d'utiliser le concept de combat entre deux joueurs. 
 * */
public class Combat {
	private int nbDesAttaque;
	private int nbDesDefense;
	private Pays PaysAtt;
	private Pays PaysDef;
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
	 * methode tri a bulle
	 * @param t
	 */
	private static void tribulles(int t[])
     {
             for (int i=0 ;i<=(t.length-2);i++)
                     for (int j=(t.length-1);i < j;j--)
                             if (t[j] < t[j-1])
                             {
                                     int x=t[j-1];
                                     t[j-1]=t[j];
                                     t[j]=x;
                             }
     } 
   
	/** 
	 * Méthode d'instance trouvant l'issue du combat.
	 * */
	public void effectuerCombat()
	{
		Random rnd = new Random();
		
		int resultatNbDef=this.nbDesDefense;//troupe qui reste sur territoire
		int resultatNbAtt=this.nbDesAttaque;//troupe encore en vie apres combat
		int[] tabAt =new int[this.nbDesAttaque];
		int[] tabDef =new int[this.nbDesDefense];
	
		for(int i=0;i<=tabAt.length;i++){
			tabAt[i]=rnd.nextInt(6)+1;
		}

		for(int j=0;j<=tabDef.length;j++){
			tabDef[j]=rnd.nextInt(6)+1;
		}
		
		tribulles(tabDef);
		tribulles(tabAt);
		
		for(int k=0;k<=tabDef.length && resultatNbDef==0 && resultatNbAtt==0 ;k++){
			if(tabDef[k]>=tabAt[k]){
				resultatNbAtt=resultatNbAtt-1;
				
			}
			else resultatNbDef=resultatNbDef-1;
		}
		
		if(resultatNbDef==0){
			this.PaysDef.setOwner(this.PaysAtt.getOwner());
			this.PaysDef.ajouterPions(resultatNbAtt);
		}
		else {
			this.PaysAtt.ajouterPions(resultatNbAtt);
			this.PaysDef.enleverPions(this.PaysDef.getNbArmees()-resultatNbDef);
	
		}
	}
}
