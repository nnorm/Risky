import java.lang.system;

public class Joueur {

	private String pseudo;
	private int armeesDispo;
	private Color couleur;
	private List<Carte> main;
	private List<Continent> continent;
	private List<Pays> pays;
	
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
				(c1.type==Soldat && c2.type==Canon && c3.type==Cavalier) ||))
	}

}
