import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class main {
 
	public static void main(String[] argv) {
 
		Database bd = new Database();
		bd.sql();
	}
}
