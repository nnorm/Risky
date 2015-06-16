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
		int desAt1=rnd.nextInt(6)+1;
		int desAt2=0;
		int desAt3=0;
		int desDef1=rnd.nextInt(6)+1;
		int desDef2=0;
		if(nbDesAttaque>=2){
			desAt2=rnd.nextInt(6)+1;
			if(nbDesAttaque==3)desAt3=rnd.nextInt(6)+1;
		}
		if(nbDesDefense==2){
			this.nbDesDefense=rnd.nextInt(6)+1;
		}
		int[] combat1=new int[2];
		int[] combat2=new int[2];
		if(desAt1>desAt2 && desAt1>desAt3)combat1[0]=desAt1;
		if(desAt2>desAt1 && desAt2>desAt3)combat1[0]=desAt2;
		if(desAt3>desAt1 && desAt3>desAt2)combat1[0]=desAt3;
		if(desDef1>=desDef2)combat1[1]=desDef1;
		if(desDef2>=desDef1)combat1[1]=desDef2;
		if(combat1[0]==desAt1){
			if(desAt2>=desAt3)combat2[0]=desAt2;
			if(desAt3>=desAt2)combat2[0]=desAt3;
		}
		if(combat1[0]==desAt2){
			if(desAt1>=desAt3)combat2[0]=desAt1;
			if(desAt3>=desAt1)combat2[0]=desAt3;
		}
		if(combat1[0]==desAt3){
			if(desAt2>=desAt1)combat2[0]=desAt2;
			if(desAt1>=desAt2)combat2[0]=desAt1;
		}
		if(combat1[1]==desDef1)combat2[1]=desDef2;
		else combat2[1]=desDef1;
	}
}
