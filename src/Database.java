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
	
	public void requeteSlt(boolean where){
		String res = "";
		String ch = "";
		for(int i = 0; i< this.champs.length-1; i++){
			ch += this.champs[i] + ", "; 
		}
		ch += this.champs[this.champs.length];
		String tab = "";
		for(int i = 0; i< this.table.length-1; i++){
			tab += this.table[i] + ", "; 
		}
		tab += this.table[this.table.length];
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		
		try{
			Connection vCon = DriverManager.getConnection("jdbc:oracle:thin:@bd11:1521:bd11", "infs2_prj06","azerty01");
			Statement vSt = vCon.createStatement();
			ResultSet vRs = null;
			if(where){
				vRs = vSt.executeQuery("SELECT " + ch + " FROM " + tab + " WHERE " + this.condition);
			}else{
				vRs = vSt.executeQuery("SELECT " + ch + " FROM " + tab);
			}
			while(vRs.next())
			{	
				for(int i = 0; i < this.champs.length; i++){
					res += vRs.getString(this.champs[i]) + " ";
				}
				System.out.println(res);
			}
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
	
	public void requeteInsert(String[] champs, String[] table, String condition){
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
			ResultSet vRs = vSt.executeQuery("INSERT INTO " +  + champs + " VALUES " + table);
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
