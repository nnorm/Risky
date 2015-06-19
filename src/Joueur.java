import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	protected Date date	= new Date();
	
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
	
	  public String getDate() {

		    SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");
		    String strTime = sdfTime.format(this.date);
		    return strTime;
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
	 * Ajoute 1'unite sur tout les pays du joueur et enlève 1'unité a l'armée disponible.
	 * @param pays les pays du joueur. (LinkedList<Pays>)
	 */
	public void mettre1ArmePays(LinkedList<Pays> pays){
		for(Pays p : pays){
			p.ajouterPions(1);
			this.armeesDispo=this.armeesDispo-1;
		}
	}
	
	/**
	 * Ajoute un continent à un joueur.
	 * @param c le continent à ajouter au joueur. (Continent)
	 */
	public void ajoutContinent(Continent c){
		this.continent.add(c);
		this.score += 5;
	}
	
	/**
	 * Ajoute le nombre d'unités grâce au bonus d'un continent.
	 */
	public void ajNbUniteContinent(){
		for(int i =0; i<this.continent.size();i++){
			this.ajouterArmeesDispo(this.continent.get(i).getBonusPion());
		}
		this.ajouterArmeesDispo(this.pays.size() /3);
	}
	
	/**
	 * Méthode d'instance de type setter sur l'attribut plateau. Ne doit être utilisé que par le constructeur de Plateau.
	 */
	public void setPlateau(Plateau p)
	{
		this.plateau = p;
	}
	
	/**
	 * Méthode d'instance listant les pays attaquables autour du pays indiqué.
	 * @param pays le pays à traiter. (Pays)
	 * @return la liste des pays attaquables. (ArrayList<Pays>)
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
	 * Méthode qui renvoi le pays avec le plus d'unités.
	 * @param  pays2 la liste des pays à évaluer. (LinkedList<Pays)
	 * @return le pays avec le plus d'armées. (Pays)
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
	 * Méthode qui renvoi les pays voisins alliés.
	 * @param pays le pays à traiter. (Pays)
	 * @return la liste des pays voisins alliés. (ArrayList<Pays>)
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
	
	/**
	 * Méthode d'instance permettant d'obtenir l'id du joueur.
	 * @return l'id du joueur. (String)
	 * */
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
	
	/**
	 * Méthode d'instance retournant l'id du joueur gagnant.
	 * @return joueur gagnant. (String) 
	 * */
	public String Gagnant()
	{
		String res= "";
		if (this.pays.size() == 42){
			res = idJoueur();
			this.idP++; 
		}
		return res;
	}
	
	/**
	 * Méthode retournant le nombre total d'unités à travers tous les pays.
	 * @return le nombre d'unités de tous les pays. (int) 
	 * */
	public int uniteTotal()
	{
		int unite = 0;
		for (int i = 0; i< this.pays.size();i++){
			unite += this.pays.get(i).getNbArmees();
		}
		return unite;
	}
	
	/**
	 * Méthode mettant à jour le score grâce à un combat.
	 * @param pays pays attaquant. (Pays)
	 * @param pays2 pays defenseur. (Pays)
	 * @param nbPionsAtk nombre de pions attaquant. (int)
	 * */
	public void mettreAJourScore(Pays pays, Pays pays2, int nbPionsAtk){
		Combat t = new Combat(pays, pays2, nbPionsAtk);
		this.score += t.getScoreC();
	}
	
	/**
	 * Méthode permettant d'enregistrer le joueur dans la base de données.
	 * */
	public void enregistrerJoueur()
	{
		String[] champs = {"id_joueur","pseudo"};
		String[] joueur = {idJoueur(), this.pseudo};
		String[] table = {"JOUEUR"};
		Database dataJoueur = new Database(champs, table,joueur,"");
		dataJoueur.requeteInsert();
	}
	
	/**
	 * Méthode permettant d'enregistrer la partie dans la base de données.
	 * */	
	public void enregistrerPartie()
	{
		
		String[] champs2 = {"id_partie","id_gagnant","datepartie","nbarmees"};
		String[] table2 = {"PARTIE"};
		String id = "" + this.idP;
		String nbArm = "" + uniteTotal();
		String[] gagnant = {id,Gagnant(),getDate(),nbArm};
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
	
	/**
	 * Méthode permettant de supprimer le joueur de la base de données.
	 * */
	public void supprimer(String[] table, String condition){
		Database bd = new Database(null,table,null,condition);
		bd.requeteDelete();
	}
}
