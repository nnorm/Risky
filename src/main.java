import java.sql.*;
 /**
  * Classe main de test 
  * */
public class main {
 
	public static void main(String[] argv) {

	/*	String[] champs = {"id_joueur","id_partie", "couleur", "score"};
		String[] table = {"PARTICIPER"};
		String[] val = {"J001","P001","blue", "3000"};
		Database bd = new Database(champs,table,val,"");
		bd.requeteInsert(); /* LANCE UNE EXCEPTION 
		bd.requeteSlt(false);  */
		/* Tests de l'interface */
		Interface ihm = new Interface("Risky", 800, 600);
		ihm.display();
	}
}
