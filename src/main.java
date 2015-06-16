import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class main {
 
	public static void main(String[] argv) {

		String[] champs = {"id_joueur","pseudo", "couleur"};
		String[] table = {"JOUEUR"};
		String[] val = {"J002","Test2","blue"};
		Database bd = new Database(champs,table,val,"id_joueur = 'J002'");
		bd.requeteDelete();
	}
}
