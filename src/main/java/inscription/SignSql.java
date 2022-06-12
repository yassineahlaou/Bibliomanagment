package inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authentification.ConnectionMySql;



public class SignSql {
	
		
	
	public void sign(Sign s) {
		Connection cnx = null;//etablir la conexion a la base de données
		
		cnx = ConnectionMySql.getConn();
		
		ResultSet result = null;// afficher le resultat
		PreparedStatement prepered = null;//Execution de la requete
		
		String sql = "INSERT INTO  users (username, password) values (? , ?) "; //la requete
	   
		try {
			
			
			prepered = cnx.prepareStatement(sql);
			prepered.setString(1, s.getUsername() );
			
			prepered.setString(2, s.getPassword() );
			
			prepered.executeUpdate();
			prepered.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
