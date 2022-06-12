package authentification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginSql {
	
	public boolean connect(Login lp)   {
		
		 boolean status = false;
		 Connection cnx = null;
		
		 //etablir la conexion a la base de données
		
		PreparedStatement prepered = null;
		
		try {
			 cnx = ConnectionMySql.getConn();
			 String sql = "select * from users where username = ? and password = ?" ; //la requete
				
			
			
			 prepered = cnx.prepareStatement(sql);
			prepered.setString(1, lp.getUsername());
			prepered.setString(2, lp.getPassword());
			
			ResultSet result = prepered.executeQuery();
	        status = result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

		
		
		
		
	}
	 
}
