package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestion.Book;
import gestion.BookSql;

@WebServlet("/BookView")
public class BookServelet extends HttpServlet {
	private BookSql gest;
	
	@Override
	public void init() throws ServletException {
		gest = new BookSql();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SearchBookModel sb = new SearchBookModel();
		request.setAttribute("sm", sb);
		String action  = request.getParameter("action");
		if (action != null)
		{
			if (action.equals("Search"))
			{
				String key = request.getParameter("keyword");
				sb.setKeyword(key);
				List<Book> books = gest.bookperkw(sb.getKeyword());
				sb.setBooks(books);
				
			}
			else if (action.equals("Delete"))
			{
				
					String reff = request.getParameter("ref");
					gest.deleteBook(Integer.parseInt(reff));
					sb.setBooks(gest.listBooks());
				
			}
			else if (action.equals("Edit")) {
				String reff = request.getParameter("ref");
				Book b = gest.getBook(Integer.parseInt(reff));
				sb.setB(b);
				sb.setMode("edit");
				sb.setBooks(gest.listBooks());
				
				
				
			}
			else if (action.equals("Save"))
			{
				try {
				
					String reff = request.getParameter("ref");
					String titl = request.getParameter("title");
					String auth = request.getParameter("author");
					String pri = request.getParameter("price");
					String mod = request.getParameter("mode");
					
					sb.getB().setRef(Integer.parseInt(reff));
					sb.getB().setTitle(titl);
					sb.getB().setAuthor(auth);
					sb.getB().setPrice(Double.parseDouble(pri));
					sb.setMode(mod);
					if (sb.getMode().equals("add"))
					{
					gest.addBook(sb.getB());
					sb.setBooks(gest.listBooks());
					}
					else if (sb.getMode().equals("edit")) {
						gest.updateBook(sb.getB());
						sb.setBooks(gest.listBooks());
					}
				}
				catch (Exception e)
				{
					sb.setError(e.getMessage());
					
				}
				
			}
			
					
		}
		
		
		request.getRequestDispatcher("BookView.jsp").forward(request, response);
	}
	

}
