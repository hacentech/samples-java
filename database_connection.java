package app.server;

import java.sql.*;

public class Connection {
  
	
	 private static final String dbClassName = "com.mysql.jdbc.Driver";
	 private static final String CONNECTION ="jdbc:mysql://localhost/esi";
	 private static java.sql.Connection connexion;

	 boolean connect() throws ClassNotFoundException,SQLException
	 {
		 
		 try
			{
				Class.forName(dbClassName);	
				connexion=DriverManager.getConnection(CONNECTION,"root","root");
				System.err.println("connexion réussie");
				return true;
			}

			catch (Exception e) 
			{	e.printStackTrace();
				System.err.println("ERROR :"+e.getMessage());
				return false;
			}
	 }
	 
	 
	 ResultSet dbquery(String query)
	 {
		 Statement stm = null;
		try {
			stm = connexion.createStatement();
		} catch (SQLException e) {
			System.out.println("ERROR :"+e.getMessage());
			e.printStackTrace();
		}
			ResultSet res = null;
		
		
			try {
				res = stm.executeQuery(query);
			} catch (SQLException e) {
				System.out.println("ERROR :"+e.getMessage());
				e.printStackTrace();
			}
		return res;
	 }
	 
	 Boolean dbinsert(String query)
	 {
		 Statement stm = null;
		try {
			stm = connexion.createStatement();
		} catch (SQLException e) {
			System.out.println("ERROR :"+e.getMessage());
			e.printStackTrace();
		}
			Boolean rep=false;
			try 
			{
				rep=stm.execute(query);
			} catch (SQLException e) {
				System.out.println("ERROR :"+e.getMessage());
				e.printStackTrace();
			}
		return rep;
	 }
	  
	 
	 void disconnect()
	 {
		 try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
