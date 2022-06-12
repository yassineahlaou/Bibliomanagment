package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import inscription.Search;
import inscription.Sign;
import inscription.SignSql;


@WebServlet("/inscription")
public class SignServlet extends HttpServlet  {
	
	private SignSql ss;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ss = new SignSql();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("inscription.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Sign si = new Sign();
        si.setEmail(email);
        si.setUsername(username);
        si.setPassword(password);
        Search sh = new Search();
        if (sh.search(si)) {
        	response.sendRedirect("errorsign.jsp");
        	
        }
        else {
        	ss.sign(si);
        	response.sendRedirect("loginn.jsp");
        	
        }
	}
	

}
