import java.sql.*;

public class Database {
	private String[] champs;
	private String[] table;
	private String[] valeur;
	private String condition;
	
	public Database(String[] champs, String[] table, String[] valeur, String condition){
		this.champs = champs;
		this.table = table;
		this.valeur = valeur;
		this.condition = condition;
	}
	
	public void requeteSlt(boolean where){
		String res = "";
		String ch = "";
		String tab = "";
		String conca = "";
		for(int i = 0; i<= this.champs.length-2; i++){
			ch += this.champs[i] + ", "; 
		}
		ch += this.champs[this.champs.length-1];
		for(int i = 0; i<= this.table.length-2; i++){
			tab += this.table[i] + ", "; 
		}
		tab += this.table[this.table.length-1];
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
			conca = "SELECT " + ch + " FROM " + tab;
			if(where == true){
				conca = conca + " WHERE " + this.condition;
				vRs = vSt.executeQuery(conca);
			}else{
				vRs = vSt.executeQuery(conca);
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
	
	public void requeteInsert(){
		String ch = "";
		String val = "";
		String conca = "";
		String tab = "";
		for(int i = 0; i<= this.champs.length-2; i++){
			ch += this.champs[i] + ", "; 
		}
		ch += this.champs[this.champs.length-1];
		
		for(int i = 0; i<= this.valeur.length-2; i++){
			try{
				val += "" + Integer.parseInt(this.valeur[i]) + ", "; 
			}catch(Exception e){
				val += "'" + this.valeur[i] + "'" + ", "; 
			}
		}
		try{
			val += "" + Integer.parseInt(this.valeur[this.valeur.length-1]);
		}catch(Exception e){
			val += "'" + this.valeur[this.valeur.length-1] + "'";
		}
	
		for(int i = 0; i<= this.table.length-2; i++){
			tab += this.table[i] + ", "; 
		}
		tab += this.table[this.table.length-1];
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		
		try{
			Connection vCon = DriverManager.getConnection("jdbc:oracle:thin:@bd11:1521:bd11", "infs2_prj06","azerty01");
			Statement vSt = vCon.createStatement();
			conca = "INSERT INTO " + tab + "(" + ch + ") VALUES (" + val + ")";
			System.out.println(conca);
			vSt.executeUpdate(conca);
			System.out.println("Insertion reussi");
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
	
	public void requeteDelete(){
		String tab = "";
		String conca = "";

		for(int i = 0; i<= this.table.length-2; i++){
			tab += this.table[i] + ", "; 
		}
		tab += this.table[this.table.length-1];
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		
		try{
			Connection vCon = DriverManager.getConnection("jdbc:oracle:thin:@bd11:1521:bd11", "infs2_prj06","azerty01");
			Statement vSt = vCon.createStatement();
			conca = "DELETE FROM " + tab + " WHERE " + this.condition;
			System.out.println(conca);
			vSt.executeUpdate(conca);
			System.out.println("Delete reussi");
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
}
