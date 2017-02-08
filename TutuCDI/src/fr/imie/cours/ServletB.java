package fr.imie.cours;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletb")
public class ServletB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = (String) request.getAttribute("prenom");
		String nom = (String) request.getAttribute("nom");
		response.getWriter().println("<p>nous sommes dans B</p>");
		response.getWriter().println(prenom + "<br>");
		response.getWriter().println(nom + "<br>");
	}

}
