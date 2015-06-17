import java.util.*;

/**
 * Classe fille de Joueur jouant le rôle d'IA. 
 * */
public class IA extends Joueur
{	/*	lvlDifficulte=1 ---> niveau (tres) facile
					 =2 ---> niveau moyen 
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
	 * methode qui retourne si un pays a un autre p voisin mais n appartenant pas au mem continent
	 * @param pays  p1
	 * @return un boolean si un pays p1 a un voisin sur un autre continent
	 */
	public boolean paystouchePAutreContinent(Pays pays){
		ArrayList<Pays> paysvoisin= new ArrayList<Pays> ();
		boolean pC=false;
		for(int i=0;i<5;i++){
			Continent continent2p= this.plateau.getContinent(i);
			ArrayList<Pays> paysContinent= continent2p.getlistPays();
			for(Pays p:paysContinent){
				if(p.isVoisin(pays)){
					paysvoisin.add(p);
				}
			}
		}
	
		for(Pays p :paysvoisin  ){
			if(p.getContinent().equals(pays.getContinent())){
				pC=true;
			}
		}
		return pC;
	}
	
	/**
	 * methode qui renvoi le nb de pays enemi voisin d'un pays
	 */
	public int PplusVoisinEnemy(Pays pays){
		return this.paysvoisinAtt(pays).size();
		
	}
	/**
	 * methode qui distribue les armees en fonction du lvl
	 */
	public void jouerDeb(){
		this.mettre1ArmePays(this.pays);
		Random rwm =new Random();
		if(this.lvlDifficulte==1){      // distribution 1 unite au premier pays lvl 1
		
			while(this.armeesDispo !=0){
				int i=rwm.nextInt(this.pays.size());
				for(  ;i<=this.pays.size();i++){ 
					this.pays.get(i).ajouterPions(1);
					this.armeesDispo=this.armeesDispo-1;
				}
			}
		}
		
		if(this.lvlDifficulte==2){ // distribution point strategique lvl 2
			
				
			
		}
	}
	
	/**
	 * retourn le nb arme dispo par le bonus
	 */
	public int BonusCarte(){
		int posCart1Max=0;
		int posCart2Max=0;
		int posCart3Max=0;
		int nbMax=0;
		while(this.main.size()>=3){
			for(int i =0;i<=this.main.size();i++){  
				for(int j=0;j<=this.main.size();j++){
					for(int p=0;p<=this.main.size();i++){
						if(this.combinaison(this.main.get(i), this.main.get(j),this.main.get(p)) !=0){
							if(nbMax<this.combinaison(this.main.get(i), this.main.get(j),this.main.get(p))){
								posCart1Max=i;
								posCart2Max=j;
								posCart3Max=p;
								nbMax=this.combinaison(this.main.get(i), this.main.get(j),this.main.get(p));
							}
						}
					}
				}
				
			}
			this.plateau.mettreDsPaquet(this.main.get(posCart1Max));
			this.plateau.mettreDsPaquet(this.main.get(posCart2Max));
			this.plateau.mettreDsPaquet(this.main.get(posCart3Max));
			this.main.remove(posCart1Max);
			this.main.remove(posCart2Max);
			this.main.remove(posCart3Max);
		}
		return nbMax;
	}
	
	
	/**
	 *  joue un tour en fonction de lvl
	 *  
	 */
	public void unTour(){
		if(this.lvlDifficulte==1){ // level 1 fini 
			
			Random rmd =new Random();
			
			int numPaysAtt1 = rmd.nextInt(this.pays.size())+1;
			ArrayList<Pays> paysvoisinAtt1=this.paysvoisinAtt(this.pays.get(numPaysAtt1));
			ArrayList<Pays> paysCopy=this.paysvoisinAtt(this.pays.get(numPaysAtt1));
			paysCopy.remove(numPaysAtt1);
			boolean vic=false;
			int nbArmAt1=0;
			
			this.ajNbUniteContinent();
			this.armeesDispo+=this.BonusCarte();
			while(this.armeesDispo !=0){
				int i=0;
				for(  ;i<=this.pays.size();i++){ 
					this.pays.get(i).ajouterPions(1);
					this.armeesDispo=this.armeesDispo-1;
				}
			}
			
			if(paysCopy.size()!=0){
				while(paysvoisinAtt1.size()==0 || this.pays.get(numPaysAtt1).getNbArmees()==1){ //cherche a voir des pays attaquable
					numPaysAtt1 = rmd.nextInt(this.pays.size())+1;
					paysvoisinAtt1=this.paysvoisinAtt(this.pays.get(numPaysAtt1));
					paysCopy.remove(numPaysAtt1);
				}

				Pays paysdef1 =paysvoisinAtt1.get(rmd.nextInt(paysvoisinAtt1.size()+1));
				Pays paysAt1 =this.pays.get(numPaysAtt1); 
				// condition
				if(paysAt1.getNbArmees()>3){
					 nbArmAt1=3;
					paysAt1.enleverPions(nbArmAt1);
				}
				if(paysAt1.getNbArmees()==3){
					 nbArmAt1=2;
					paysAt1.enleverPions(nbArmAt1);
				}
				if(paysAt1.getNbArmees()==2){
					 nbArmAt1=1;
					paysAt1.enleverPions(nbArmAt1);
				}
				for(int cpt =0;cpt<2 && vic==false;cpt++){ // combat
					Combat cb1 =new Combat(paysAt1,paysdef1,nbArmAt1);
					if(cb1.effectuerCombat()) vic=true;
				}
			}
			Pays paysmax=this.paysPlusArme(this.pays);
			paysmax.deplacerPions(this.paysvoisinAtt(paysmax).get(0) ,(paysmax.getNbArmees()/2));
		}
		if(this.lvlDifficulte==2){
			
		}
		
	}
}
