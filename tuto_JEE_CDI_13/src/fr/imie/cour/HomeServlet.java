package fr.imie.cour;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet/*")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath() + "</br>")

		/*
		 * request.getRequestDispatcher(path).incl
		 * 
		 * response.setAttribute("dd", "dd"); // Pas de set parameter
		 * response.sendRedirect(request.getContextPath());
		 * response.sendRedirect(location); response.sendRedirect(location);
		 */
		/*
		 * .append("prenom :") .append(request.getParameter("prenom") + "</br>")
		 * .append("nom :") .append(request.getParameter("nom") + "</br>")
		 */;
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String val = names.nextElement();
			response.getWriter().append(val);
			val = request.getParameter(val);
			response.getWriter().append(" :" + val + "</br>");
		}
		HttpSession session = request.getSession();
		session.setAttribute("toto", "test");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPut(request, response);

		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		writer.append((String) session.getAttribute("toto") + "</br>");
	}

}
