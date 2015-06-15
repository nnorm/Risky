import java.sql.*;
import oracle.jdbc.OracleDriver;

public class Database {
	private String requete;
	try{
	DriverManager.registerDriver (new OracleDriver());
	Connection vCon = DriverManager.getConnection("jdbc:oracle:thin:infs2_prj06/azerty01@bd11:1521:bd11");
	Statement vst = vCon.createStatement();
	ResultSet vRs = vSt.executeQuery("SELECT id_joueur, pseudo, couleur FROM JOUEUR");
	while(vRs.next()){
		String id = vRs.getString(1);
		String pseudo = vRs.getString(2);
		String couleur = vRs.getString(3);
		System.out.println(id + pseudo + couleur);
		
	}
	
	}
	catch(Exception e){
		
	}
}
