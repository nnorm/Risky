import java.util.*;
/**
 * Méthode permettant d'utiliser le concept de combat entre deux joueurs. 
 * */
public class Combat {
	private int nbDesAttaque;
	private int nbDesDefense;
	private Pays paysAtt;
	private Pays paysDef;
	private int scoreCombat = 0;
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
		
		this.paysAtt=attaquant;
		this.paysDef=defenseur;
		
		
		if(defenseur.getNbArmees() > 1 ) this.nbDesDefense = 2;
		else this.nbDesDefense = 1;
		
		if(nbPionsAtk < 3) this.nbDesAttaque = nbPionsAtk;
		else this.nbDesAttaque = 3;
		
	}
	/**
	 * methode tri a bulle
	 * @param t
	 */
	private static void tribulles(int[] t)
     {
		for (int i=0 ;i<=(t.length-2);i++)
			for (int j=(t.length-1);i < j;j--)
				if (t[j] > t[j-1])
                {
					int x=t[j-1];
                    t[j-1]=t[j];
                    t[j]=x;
                }
     } 
   
	/** 
	 * Méthode d'instance faisant se dérouler un combat entre deux pays
	 * Retire à chaque pays les pions perdus
	 * @return true si le pays défenseur a été perdu à l'issue du combat
	 * */
	public boolean effectuerCombat()
	{
		int defDep = this.nbDesDefense;
		Random rnd = new Random();
		boolean res=false;
		
		this.paysAtt.enleverPions(this.nbDesAttaque);
		
		int resultatNbDef=this.paysDef.getNbArmees();//troupe qui reste sur territoire
		int resultatNbAtt=this.nbDesAttaque;//troupe encore en vie apres combat
		int[] tabAt =new int[this.nbDesAttaque];
		int[] tabDef =new int[this.nbDesDefense];
	
		//génération des résultats du jeté de dés des attaquants
		for(int i=0;i<=tabAt.length;i++){
			tabAt[i]=rnd.nextInt(6)+1;
		}
		
		//génération des résultats du jeté de dés des défenseurs
		for(int j=0;j<=tabDef.length;j++){
			tabDef[j]=rnd.nextInt(6)+1;
		}
		
		//triage des dés
		tribulles(tabDef);
		tribulles(tabAt);
		
		for(int k=0;k<=tabDef.length && resultatNbDef==0 && resultatNbAtt==0 ;k++){
			if(tabDef[k]>=tabAt[k]){
				resultatNbAtt=resultatNbAtt-1;
				
			}
			else resultatNbDef=resultatNbDef-1;
		}
		
		if(resultatNbDef==0){
			this.paysDef.setOwner(this.paysAtt.getOwner());
			this.paysDef.ajouterPions(resultatNbAtt);
			res=true;
		}
		else {
			this.paysAtt.ajouterPions(resultatNbAtt);
			this.paysDef.enleverPions(this.paysDef.getNbArmees()-resultatNbDef);
	
		}
		this.scoreCombat = this.nbDesDefense - defDep;
		return res;
	}
	
	/**
	 * Méthode d'instance de type getter sur l'attribut paysAtt.
	 * @return le pays attaquant. (Pays) 
	 * */
	public Pays getAtt(){
		return this.paysAtt;
	}

	/**
	 * Méthode d'instance de type getter sur l'attribut paysDef.
	 * @return le pays défenseur. (Pays) 
	 * */	
	public Pays getDef(){
		return this.paysDef;
	}

	/**
	 * Méthode d'instance de type getter sur l'attribut scoreCombat.
	 * @return le score du combat. (Pays) 
	 * */	
	public int getScoreC(){
		return this.scoreCombat;
	}
}
