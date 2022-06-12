package authentification;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;



public class ConnectionMySql {
	Connection conn = null;
    public static Connection getConn(){
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
           
            //this line is to introduce our database that we have already created
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/authen", "root", "");
            return conn;

            	//don't do SQLExeption do just Exeption
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }


    }

	

}


