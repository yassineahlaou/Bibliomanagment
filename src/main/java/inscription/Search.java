package inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authentification.ConnectionMySql;

public class Search {
	public boolean search(Sign s)   {
		
		 boolean status = false;
		 Connection cnx1 = null;
		
		 //etablir la conexion a la base de données
		
		PreparedStatement prepered1 = null;
		
		try {
			 cnx1 = ConnectionMySql.getConn();
			 String sql1 = "select * from users where username = ? " ; //la requete
				
			
			
			 prepered1 = cnx1.prepareStatement(sql1);
			prepered1.setString(1, s.getUsername());
			
			
			ResultSet result = prepered1.executeQuery();
	        status = result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

		
		
		

	}
}