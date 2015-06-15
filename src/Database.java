import java.sql.*;

public class Database {
	private String requete;
	public void sql(){
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		
		try{
			Connection vCon = DriverManager.getConnection("jdbc:oracle:thin:@bd11:1521:bd11", "infs2_prj06","azerty01");
			Statement vSt = vCon.createStatement();
			ResultSet vRs = vSt.executeQuery("SELECT id_joueur, pseudo, couleur FROM JOUEUR");
			while(vRs.next())
			{
				String id = vRs.getString(1);
				String pseudo = vRs.getString(2);
				String couleur = vRs.getString(3);
				System.out.println(id + pseudo + couleur);
			}
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
}
