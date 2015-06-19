import java.util.*;
import java.awt.*;


/**
 * Classe abstraite traduisant le concept abstrait de joueur. 
 * */
public abstract class Joueur  {

	protected String pseudo;
	protected int idJ = 0;
	protected int armeesDispo;
	protected Color couleur;
	protected LinkedList<Carte> main;
	protected LinkedList<Continent> continent;
	protected LinkedList<Pays> pays;
	public static int colorIndex = 0;
	protected static Color[] colorList = {Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange, Color.pink};
	protected Plateau plateau;
	protected int idP; 
	protected int score;
	
	/**
	 * Permet de distribuer les pions entre les pays du joueur.
	 * @param p le pays dans lequel il faut ajouter des pions. (Pays)
	 * @param nbPions le nombre de pions à donner au pays désigné. (int)
	 * */
	public void distribuer(Pays p,int nbPions){
		if(this.armeesDispo>nbPions){
		p.ajouterPions(nbPions);
		this.armeesDispo-=nbPions;
		}
	}
	
	public void piocherCarte()
	{
		this.main.add(this.plateau.piocherCarte());
	}
	
	/**
	 * Méthode d'instance permettant de vérifier les différentes combinaisons possibles entre les cartes indiquées
	 * @param c1 la carte 1. (Carte)
	 * @param c2 la carte 2. (Carte)
	 * @param c3 la carte 3. (Carte)
	 * @return  le nombre de pions que l'on obtiens avec cette combinaison de cartes. (int)
	 * */
	public int combinaison(Carte c1,Carte c2,Carte c3)
	{
		int res=0;
		if(c1.getType()==TypeCarte.Canon && c2.getType()==TypeCarte.Canon && c3.getType()==TypeCarte.Canon)res=8;
		else if(c1.getType()==TypeCarte.Soldat && c2.getType()==TypeCarte.Soldat && c3.getType()==TypeCarte.Soldat)res=3;
		else if(c1.getType()==TypeCarte.Cavalier && c2.getType()==TypeCarte.Cavalier && c3.getType()==TypeCarte.Cavalier)res=5;
		else if((c1.getType()==TypeCarte.Soldat && c2.getType()==TypeCarte.Cavalier && c3.getType()==TypeCarte.Canon) ||
				(c1.getType()==TypeCarte.Cavalier && c2.getType()==TypeCarte.Soldat && c3.getType()==TypeCarte.Canon) ||
				(c1.getType()==TypeCarte.Canon && c2.getType()==TypeCarte.Cavalier && c3.getType()==TypeCarte.Soldat) ||
				(c1.getType()==TypeCarte.Soldat && c2.getType()==TypeCarte.Canon && c3.getType()==TypeCarte.Cavalier) ||
				(c1.getType()==TypeCarte.Cavalier && c2.getType()==TypeCarte.Canon && c3.getType()==TypeCarte.Soldat) ||
				(c1.getType()==TypeCarte.Canon && c2.getType()==TypeCarte.Soldat && c3.getType()==TypeCarte.Cavalier))res=10;
		return res;
	}
	
	/**
	 * Méthode d'instance de type getter permettant de récupérer le nombre d'armées d'un joueur.
	 * @return le nombre d'armées auquelles le joueur a accès. (int) 
	 * */
	public int getArmeesDispo(){
		return this.armeesDispo;
	}
	
	/**
	 * Ajoute un nombre d'armées indiqué.
	 * @param nb le nombre d'armées à ajouter au joueur. (int) 
	 * */	
	public void ajouterArmeesDispo(int nb){
		this.armeesDispo+=nb;
	}
	
	/**
	 * Soustrait un nombre d'armées indiqué.
	 * @param nb le nombre d'armées à retirer au joueur. (int) 
	 * */
	public void enleverArmeesDispo(int nb){
		this.armeesDispo-=nb;
	}
	
	/**
	 * Enlève un pays de la liste des pays de ce joueur
	 * @param p le pays perdu
	 */
	public void perdrePays(Pays p)
	{
		p.enleverPions(p.getNbArmees());
		this.pays.remove(p);
	}
	
	/**
	 * Rajoute unpays à la liste des pays de ce joueur
	 * @param p le pays acquis
	 */
	public void acquerirPays(Pays p)
	{
		this.pays.add(p);
		this.score += 2;
	}
	
	/**
	 * ajoute 1 unite sur tout les pays du joueur et enleve 1 unite a l'armee dispo
	 * @param pays
	 */
	public void mettre1ArmePays(LinkedList<Pays> pays){
		for(Pays p : pays){
			p.ajouterPions(1);
			this.armeesDispo=this.armeesDispo-1;
		}
	}
	
	/**
	 * ajout un continent a un joueur
	 * @param c
	 */
	public void ajoutContinent(Continent c){
		this.continent.add(c);
		this.score += 5;
	}
	
	/**
	 * ajoute le nb de bonus d'un continent
	 */
	public void ajNbUniteContinent(){
		for(int i =0; i<this.continent.size();i++){
			this.ajouterArmeesDispo(this.continent.get(i).getBonusPion());
		}
		this.ajouterArmeesDispo(this.pays.size() /3);
	}
	
	/**
	 * Affecte un plateau de jeu à ce joueur. Ne doit être utilisé que par le constructeur de Plateau
	 */
	public void setPlateau(Plateau p)
	{
		this.plateau = p;
	}
	
	/**
	 * methode liste de pays attaquable
	 */
	public ArrayList<Pays> paysvoisinAtt(Pays pays){
		ArrayList<Pays> paysvoisinAtt=new ArrayList<Pays> ();
		
		for(int i=0;i<5;i++){
			Continent continent2p= this.plateau.getContinent(i);
			ArrayList<Pays> paysContinent= continent2p.getlistPays();
			for(Pays p:paysContinent){
				if(p.isVoisin(pays) && !p.getOwner().equals(this.pseudo)){
					paysvoisinAtt.add(p);
				}
			}
		}
		return paysvoisinAtt;
	}
	
	/**
	 * methode qui renvoi le pays avec le plus d unite
	 * @liste de pays
	 * @return le pays avec le plus d armee
	 */
	public Pays paysPlusArme(LinkedList<Pays> pays2){
		int pMax=pays2.get(0).getNbArmees();
		Pays paysMax =pays2.get(0);
		for(Pays p:pays2){
			if(pMax<p.getNbArmees())
				pMax=p.getNbArmees();
				paysMax =p;
		}
		return paysMax;
	}
	
	/**
	 * methode qui renvoi les pays voisins allier
	 * @param pays
	 * @return
	 */
	public ArrayList<Pays> listePVoisinAll(Pays pays){
		ArrayList<Pays> paysvoisinAl= new ArrayList<Pays> ();
		for(int i=0;i<5;i++){
			Continent continent2p= this.plateau.getContinent(i);
			ArrayList<Pays> paysContinent= continent2p.getlistPays();
			for(Pays p:paysContinent){
				if(p.isVoisin(pays) && p.getOwner().equals(this.pseudo) ){
					paysvoisinAl.add(p);
				}
			}
		}
		return paysvoisinAl;
	}
	
	public String idJoueur()
	{
		String res= "";
		if(this.idJ < 10){
			res = "J00" + "" + this.idJ;
		}
		else if(this.idJ<100){
			res = "J0" + "" + this.idJ;
		}
		else{
			res = "J" + "" + this.idJ;
		}
		return res;
		
	}
	public String Gagnant()
	{
		String res= "";
		if (this.pays.size() == 42){
			res = idJoueur();
			this.idP++; 
		}
		return res;
	}
	
	public int uniteTotal()
	{
		int unite = 0;
		for (int i = 0; i< this.pays.size();i++){
			unite += this.pays.get(i).getNbArmees();
		}
		return unite;
	}
	
	public void mettreAJourScore(Pays pays, Pays pays2, int nbPionsAtk){
		Combat t = new Combat(pays, pays2, nbPionsAtk);
		this.score += t.getScoreC();
	}
	
	
	
	public void enregistrer()
	{
		String[] champs = {"id_joueur","pseudo"};
		String[] joueur = {idJoueur(), this.pseudo};
		String[] table = {"JOUEUR"};
		Database dataJoueur = new Database(champs, table,joueur,"");
		dataJoueur.requeteInsert();
		
		String[] champs2 = {"id_partie","id_gagnant","datepartie","nbarmees"};
		String[] table2 = {"PARTIE"};
		String id = "" + this.idP;
		String nbArm = "" + uniteTotal();
		String[] gagnant = {id,Gagnant(),null,nbArm};
		Database dataGagnant = new Database(champs2, table2,gagnant,"");
		dataGagnant.requeteInsert();
		
		String couleur = "" + this.couleur;
		String scoreJ = "" +this.score;
		String[] table3 = {"PARTICIPER"};
		String[] champs3 = {"id_partie","id_joueur","couleur","score"};
		String[] participe = {id,idJoueur(),couleur,scoreJ};
		Database dataParticiper = new Database(champs3, table3,participe,"");
		dataParticiper.requeteInsert();
	
	}
	
	public void supprimer(String[] table, String condition){
		Database bd = new Database(null,table,null,condition);
		bd.requeteDelete();
	}
	
	
}
