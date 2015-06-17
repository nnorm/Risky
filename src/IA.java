import java.util.*;

/**
 * Classe fille de Joueur jouant le rôle d'IA. 
 * */
public class IA extends Joueur
{	/*	lvlDifficulte=1 ---> niveau (tres) facile
		
 	*/
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
	 * setteur du lvl de l ia
	 * @param lvl
	 */
	public void setlvlDiff(int lvl){
		this.lvlDifficulte=lvl;
	}
	
	/**
	 * methode qui distribue les armees en fonction du lvl
	 */
	public void jouerDeb(){
		this.mettre1ArmePays(this.pays);
		if(this.lvlDifficulte==1){      // distribution 1 unite au premier pays lvl 1
			int i=0;
			while(this.armeesDispo !=0){
				this.pays.get(i).ajouterPions(1);
				this.armeesDispo=this.armeesDispo-1;
			}
		}
	}
	
	/**
	 * retourn le nb arme dispo par le bonus
	 */
	public int BonusCarte(){
		int res =0;
		while(this.main.size()>=3){
			for(int i =0;i<=(this.main.size()-2);i++){
				for(int j=1;j<=(this.main.size()-1);j++){
					for(int p=2;p<=this.main.size();i=+3){
						if(this.combinaison(this.main.get(i), this.main.get(j),this.main.get(p)) !=0){
							 res=this.combinaison(this.main.get(i), this.main.get(j),this.main.get(p));
							this.plateau.mettreDsPaquet(this.main.get(i));
							this.plateau.mettreDsPaquet(this.main.get(j));
							this.plateau.mettreDsPaquet(this.main.get(p));
							this.main.remove(i);
							this.main.remove(j);
							this.main.remove(p);
						}
					}
				}
			}
		}
		return res;
	}
	
	
	/**
	 *  joue un tour en fonction de lvl
	 *  
	 */
	public void unTour(){
		if(this.lvlDifficulte==1){
			Random rmd =new Random();
			int paysAtt1= rmd.nextInt(this.pays.size())+1;
			int paysAtt2= rmd.nextInt(this.pays.size())+1;
			this.ajNbUniteContinent();
			this.armeesDispo+=this.BonusCarte();
			for(int i =0;this.armeesDispo !=0;i++){
				this.pays.get(i).ajouterPions(1);
				this.armeesDispo=this.armeesDispo-1;
			}
			int cpt=0;
			boolean arr=false;
			
			for( int j=0;j<=this.plateau.)
		
			
			
			while(cpt<2 && arr==false){
				
				Combat b1=new Combat(paysAtt1,)
			}
			
		}
	}
}
