import java.sql.*;

public class Database {
	private String[] champs;
	private String[] table;
	private String condition;
	
	public Database(String[] champs, String[] table, String condition){
		this.champs = champs;
		this.table = table;
		this.condition = condition;
	}
	
	public void requeteSlt(String[] champs, String[] table, String condition){
		String ch = "";
		for(int i = 0; i< champs.length-1; i++){
			ch += champs[i] + ", "; 
		}
		ch += champs[champs.length];
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		
		try{
			Connection vCon = DriverManager.getConnection("jdbc:oracle:thin:@bd11:1521:bd11", "infs2_prj06","azerty01");
			Statement vSt = vCon.createStatement();
			ResultSet vRs = vSt.executeQuery("SELECT " + champs + " FROM " + table);
			while(vRs.next())
			{	
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
}
