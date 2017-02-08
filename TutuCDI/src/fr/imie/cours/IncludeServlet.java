package fr.imie.cours;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<p>avant include</p>");
		request.setAttribute("prenom", "tony");
		request.setAttribute("nom", "parker");
		request.getRequestDispatcher("/servletb").include(request, response);
		out.println("<p>après include</p>");
	}

}
