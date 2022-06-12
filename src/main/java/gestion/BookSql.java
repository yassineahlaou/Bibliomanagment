package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Mapping objet relationel
//en utilisant --hibernate-- tout cela peur ce faire en 2 3 lignes
public class BookSql implements ICatalogue {

	@Override
	public void addBook(Book b) {
		// TODO Auto-generated method stub
		Connection cnx = ConnectionMySql.getConnection();
		try {
			PreparedStatement prepered = cnx.prepareStatement("INSERT INTO  produits (ref, title, author, price) values (? , ? , ? , ?)");
			prepered.setInt(1, b.getRef());
			prepered.setString(2, b.getTitle());
			prepered.setString(3, b.getAuthor());
			prepered.setDouble(4, b.getPrice());
			prepered.executeUpdate();
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Book> listBooks() {
		List<Book> books = new ArrayList<Book>();
		Connection cnx = ConnectionMySql.getConnection();
		try {
			PreparedStatement prepered = cnx.prepareStatement("select * from produits ");
			ResultSet rs = prepered.executeQuery();
			while (rs.next())
			{
				Book b = new Book();
				b.setRef(rs.getInt("ref"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				books.add(b);
			}
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> bookperkw(String kw) {
		List<Book> books = new ArrayList<Book>();
		Connection cnx = ConnectionMySql.getConnection();
		try {
			PreparedStatement prepered = cnx.prepareStatement("select * from produits where title Like ? ");
			prepered.setString(1, "%"+kw+"%");
			ResultSet rs = prepered.executeQuery();
			while (rs.next())
			{
				Book b = new Book();
				b.setRef(rs.getInt("ref"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				books.add(b);
			}
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book getBook(int reff) {
		Book b = null;
		Connection cnx = ConnectionMySql.getConnection();
		try {
			
			PreparedStatement prepered = cnx.prepareStatement("select * from produits where ref =  ? ");
			prepered.setInt(1, reff);
			ResultSet rs = prepered.executeQuery();
			if (rs.next())
			{
				
				b=new Book();
				b.setRef(rs.getInt("ref"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				
			}
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == null) {
			throw new RuntimeException("Book not found");
		}
		return b;
	}

	@Override
	public void updateBook(Book b) {
		Connection cnx = ConnectionMySql.getConnection();
		try {
			PreparedStatement prepered = cnx.prepareStatement("UPDATE   produits SET title = ? , author = ? ,  price = ?  where ref = ?");
			prepered.setInt(4, b.getRef());
			prepered.setString(1, b.getTitle());
			prepered.setString(2, b.getAuthor());
			prepered.setDouble(3, b.getPrice());
			prepered.executeUpdate();
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBook(int reff) {
		// TODO Auto-generated method stub
		Connection cnx = ConnectionMySql.getConnection();
		try {
			PreparedStatement prepered = cnx.prepareStatement("DELETE from produits where ref = ?");
			prepered.setInt(1, reff);
			
			prepered.executeUpdate();
			prepered.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	
	

}
