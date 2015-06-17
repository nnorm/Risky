import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class main {
 
	public static void main(String[] argv) {

		String[] champs = {"id_joueur","id_partie", "couleur", "score"};
		String[] table = {"PARTICIPER"};
		String[] val = {"J001","P001","blue", "3000"};
		Database bd = new Database(champs,table,val,"");
		bd.requeteInsert();
	}
}
