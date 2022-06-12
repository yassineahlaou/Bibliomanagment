package gestion;

import java.util.List;

public interface ICatalogue {
	public void addBook (Book b);
	public  List<Book> listBooks();
	public  List<Book> bookperkw(String kw);
	public  Book getBook(int id);
	public void updateBook (Book b);
	public void deleteBook (int id);
	

}
