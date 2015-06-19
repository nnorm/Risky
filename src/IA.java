import java.util.*;

/**
 * Classe fille de Joueur jouant le rôle d'IA. 
 * */
public class IA extends Joueur
{	
	/*	lvlDifficulte=1 ---> niveau (tres) facile
					 =2 ---> niveau moyen 
 	*/
	private int lvlDifficulte;   
	public static int nbIA = 0;
	
	/**
	 * Constructeur avec arguments.
	 * @param nbArmeesInit le nombre d'armées disponible à l'initialisation du jeu. (int) 
	 * */	
	public IA(int nbArmeesInit, int lvlDifficulte)
	{
		if(lvlDifficulte < 1 || lvlDifficulte > 2)
		{
			throw new IllegalArgumentException("Ce niveau de difficulté n'existe pas (1 ou 2)");
		}
		this.armeesDispo = nbArmeesInit;
		this.pseudo = "Ordinateur " + IA.nbIA;
		this.main = new LinkedList<Carte>();
		this.pays = new LinkedList<Pays>();
		this.continent = new LinkedList<Continent>();
		this.couleur = Humain.colorList[Humain.colorIndex];
		this.idJ += 1;
		this.score = 0;
		this.lvlDifficulte = lvlDifficulte;
		Humain.colorIndex++;
		IA.nbIA++;
	}
	
	/**
	 * Méthode d'instance de type setteur sur l'attribut lvlDifficulte.
	 * @param le niveau de difficulté de l'IA. (Int, 1 ou 2)
	 */
	public void setlvlDiff(int lvl){
		this.lvlDifficulte=lvl;
	}
	
	/**
	 * Trie les continents par ordre décroissant du nombre de pays possédés par ce joueur
	 * @return tableau contenant les indices des continents dans la liste de Plateau
	 */
	public int[] paysParContinent()
	{
		
		int[] paysParContinent = new int[this.plateau.getContinentLength()];
		int[] indicesContinents = new int[this.plateau.getContinentLength()];
		for(int i = 0; i < indicesContinents.length; i++) indicesContinents[i] = i;
		for(int i = 0; i < paysParContinent.length; i++)
		{
			for(int j = 0; i < this.plateau.getContinent(i).getlistPays().size(); j++)
			{
				if(this.plateau.getContinent(i).getlistPays().get(j).getOwner().equals(this))
				{
					paysParContinent[i] ++;
				}
			}
		}
		int max = -1;
		int indMax = -1;
		int temp = -1;
		for(int i = 0; i < paysParContinent.length; i++)
		{
			max = -1;
			indMax = -1;
			for(int j = i; j < paysParContinent.length; j++)
			{
				if(paysParContinent[j] > max)
					{
					max = paysParContinent[j];
					indMax = j;
					}
			}
			temp = paysParContinent[indMax];
			paysParContinent[indMax] = paysParContinent[i];
			paysParContinent[i] = temp;
			temp = indicesContinents[indMax];
			indicesContinents[indMax] = indicesContinents[i];
			indicesContinents[i] = temp;
		}
		return indicesContinents;
	}
	
	/**
	 * Méthode d'instance retournant si un pays a un autre pays voisin mais n'appartenant pas au même continent.
	 * @param pays le pays à traiter. (Pays)
	 * @return vrai si le pays à traiter a un voisin n'appartenant pas au même continent, faux sinon. (boolean)
	 */
	public boolean paystouchePAutreContinent(Pays pays){
		ArrayList<Pays> paysvoisin= new ArrayList<Pays> ();
		boolean pC=false;
		for(int i=0;i<this.plateau.getContinentLength();i++){
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
	 * Méthode d'instance qui renvoi le nombre de pays ennemi voisin d'un pays.
	 * @param  le pays à traiter. (Pays)
	 * @return le nombre de pays voisins. (int)
	 */
	public int PplusVoisinEnemy(Pays pays){
		return this.paysvoisinAtt(pays).size();
		
	}
	/**
	 * Méthode d'instance qui distribue les armées en fonction du niveau de difficulté de l'IA.
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
			int[] indicesContinents = this.paysParContinent();
			int temp;
			for(int i = 0; i < indicesContinents.length && this.armeesDispo != 0; i++)
			{
				temp = this.armeesDispo/2;
				temp = temp/this.plateau.getContinent(i).getlistPays().size();
				for(int j = 0; j < this.plateau.getContinent(i).getlistPays().size() && this.armeesDispo >= temp; j++)
				{
					this.distribuer(this.plateau.getContinent(i).getlistPays().get(j), temp);
				}
			}
		}
	}
	
	/**
	 * Méthode d'instance retournant le nombre de pion récupéré par le bonus des cartes.
	 * @return le nombre de pions à récupérer grâces aux cartes bonus. (int)
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
			if(nbMax > 0)
			{
			this.plateau.mettreDsPaquet(this.main.get(posCart1Max));
			this.plateau.mettreDsPaquet(this.main.get(posCart2Max));
			this.plateau.mettreDsPaquet(this.main.get(posCart3Max));
			this.main.remove(posCart1Max);
			this.main.remove(posCart2Max);
			this.main.remove(posCart3Max);
			this.ajouterArmeesDispo(nbMax);
			}
		}
		return nbMax;
	}
	
	
	/**
	 * Méthode d'instance faisant jouer un tour à l'IA en fonction du niveau de difficulté.
	 */
	public void unTour(){
		Random rmd =new Random();
		if(this.lvlDifficulte==1){ // level 1 fini 
			
			int numPaysAtt1 = rmd.nextInt(this.pays.size())+1;
			ArrayList<Pays> paysvoisinAtt1=this.paysvoisinAtt(this.pays.get(numPaysAtt1));
			ArrayList<Pays> paysCopy=this.paysvoisinAtt(this.pays.get(numPaysAtt1));
			paysCopy.remove(numPaysAtt1);
			boolean vic=false;
			int nbArmAt1=0;
			
			this.ajNbUniteContinent();
			this.BonusCarte();
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
				}
				if(paysAt1.getNbArmees()==3){
					 nbArmAt1=2;
				}
				if(paysAt1.getNbArmees()==2){
					 nbArmAt1=1;
				}
				for(int cpt =0;cpt<2 && !vic;cpt++){ // combat
					Combat cb1 =new Combat(paysAt1,paysdef1,nbArmAt1);
					if(cb1.effectuerCombat()){ 
						vic=true;
						this.main.add(this.plateau.piocherCarte());
					}
				}
			}
			Pays paysmax=this.paysPlusArme(this.pays);
			paysmax.deplacerPions(this.listePVoisinAll(paysmax).get(0) ,(paysmax.getNbArmees()/2));
		}
		if(this.lvlDifficulte==2){
			this.ajNbUniteContinent();
			this.BonusCarte();
			ArrayList<Pays> listPays = null;
			int[] indices = this.paysParContinent();
			int temp;
			ArrayList<Pays> ordrePrioAttaque = new ArrayList<Pays>();
			Pays p = null;
			for(int i = 0; i < indices.length; i++)
			{
				listPays = this.plateau.getContinent(i).getlistPays();
				Collections.sort(listPays);
				temp = this.armeesDispo/2;
				temp = temp/this.plateau.getContinent(i).getlistPays().size();
				for(int j = 0; j < this.plateau.getContinent(i).getlistPays().size() && this.armeesDispo >= temp; j++)
				{
					p = this.plateau.getContinent(i).getlistPays().get(j);
					this.distribuer(p, temp);
					ordrePrioAttaque.add(p);
				}
			}
			int nbArmAt1= -1;
			for(Pays pa:ordrePrioAttaque)
			{
				if(pa.getNbArmees() > 1)
				{
					listPays = this.paysvoisinAtt(pa);
					Collections.sort(listPays);
					Collections.reverse(listPays);
				
					if(pa.getNbArmees()>3){
						nbArmAt1=3;
					}
					if(pa.getNbArmees()==3){
						nbArmAt1=2;
					}
					if(pa.getNbArmees()==2){
						nbArmAt1=1;
					}
					boolean vic = false;
					for(int cpt =0;cpt<2 && !vic; cpt++){ // combat
						Combat cb1 =new Combat(pa, listPays.get(1),nbArmAt1);
						if(cb1.effectuerCombat()){ 
							vic=true;
							this.main.add(this.plateau.piocherCarte());
						}
					}
				}
				Pays paysmax=this.paysPlusArme(this.pays);
				paysmax.deplacerPions(this.listePVoisinAll(paysmax).get(0) ,(paysmax.getNbArmees()/2));
			}
		}
	}
}
