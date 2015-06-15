import java.lang.system;

public class Joueur {

	protected String pseudo;
	protected int armeesDispo;
	protected Color couleur;
	protected List<Carte> main;
	protected List<Continent> continent;
	protected List<Pays> pays;
	
	public void distribuer(Pays p,int nbPions){
		if(this.armeesDispo>nbPions){
		this.pays.ajouterPions(nbPions);
		this.armeesDispo-=nbPions;
	}
	}
	
	public combinaison(Carte c1,Carte c2,Carte c3)
	{
		int res=0;
		if(c1.type==Canon && c2.type==Canon && c3.type==Canon)res=8;
		else if(c1.type==Soldat && c2.type==Soldat && c3.type==Soldat)res=3;
		else if(c1.type==Cavalier && c2.type==Cavalier && c3.type==Cavalier)res=5;
		else if((c1.type==Soldat && c2.type==Cavalier && c3.type==Canon) ||
				(c1.type==Cavalier && c2.type==Soldat && c3.type==Canon) ||
				(c1.type==Canon && c2.type==Cavalier && c3.type==Soldat) ||
				(c1.type==Soldat && c2.type==Canon && c3.type==Cavalier) ||
				(c1.type==Cavalier && c2.type==Canon && c3.type==Soldat) ||
				(c1.type==Canon && c2.type==Soldat && c3.type==Cavalier))res=10;
		return res;
	}
	
	public int getArmeesDispo(){
		return this.armeesDispo;
	}
	
	public void ajouterArmeesDispo(int nb){
		this.armeesDispo+=nb;
	}
	
	public void enleverArmeesDispo(int nb){
		this.armeesDispo-=nb;
	}
	

}
