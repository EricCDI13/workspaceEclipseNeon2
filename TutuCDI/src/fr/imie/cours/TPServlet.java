package fr.imie.cours;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/tpservlet")
public class TPServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// TP servlet 1 ex 2
		out //
		.append("prot : " + request.getProtocol() + "<br/>") //
		.append("addr : " + request.getRemoteAddr() + "<br/>") //
		.append("host : " + request.getRemoteHost() + "<br/>") //
		.append("user : " + request.getRemoteUser() + "<br/>") //
		.append("port : " + request.getRemotePort() + "<br/>") //
		.append("addr : " + request.getLocalAddr() + "<br/>") //
		.append("name : " + request.getLocalName() + "<br/>") //
		.append("port : " + request.getLocalPort() + "<br/>") //
		.append("schm : " + request.getScheme() + "<br/>") //
		;

		// TP servlet 1 ex 3
		// .append("pren : "+request.getParameter("prenom")+"<br/>")
		// .append("nom : "+request.getParameter("nom")+"<br/>")
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			out.append(name + " : " + value + "<br/>");
		}

		// TP servlet 2 ex 1
		HttpSession session = request.getSession();

		//
		Integer nbVisite = (Integer) session.getAttribute("nbVisite");
		if (nbVisite == null) {
			nbVisite = 1;
		} else {
			nbVisite++;
		}
		session.setAttribute("nbVisite", nbVisite);

		out.append("est nouvelle : " + session.isNew() + "<br/>");
		out.append("identifiant : " + session.getId() + "<br/>");
		out.append("date création : " + session.getCreationTime() + "<br/>");
		out.append("date modification : " + session.getLastAccessedTime() + "<br/>");
		out.append("nombre de visite : " + nbVisite + "<br/>");
	}

}
