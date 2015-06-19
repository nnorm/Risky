import java.sql.*;
 /**
  * Classe main de test 
  * */
public class main {
 
	public static void main(String[] args) {

	    /*String[] champs = {"id_joueur", "pseudo"};
		String[] table = {"JOUEUR"};
		String[] val = {"J001", "test"};
		Database bd = new Database(champs,table,val,"");
		bd.requeteInsert() 
		FONCTIONNE FAIRE ATTENTION A LA CONTRAINTE D'INTEGRITER
		bd.requeteSlt(false);*/
		/* Tests de l'interface */
		Interface ihm = new Interface("Risky", 800, 600);
		ihm.display();
	}
}
