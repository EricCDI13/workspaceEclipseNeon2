<!DOCTYPE html>

<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%-- <%@ %> --%>
<%-- <%@page import="java.text.DateFormatSymbols"%> --%>

<%@taglib prefix="C" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="Alex" uri="/toto/titi"%>

<html>
<head>
<meta charset="UTF-8">
<title>Ma page</title>
</head>
<body>
	<div>
		<!-- 		Commentaire HTML0 -->
		<br /> Commentaire HTML1<br />
		<%
			// Commentaire HTML2
		%><br />
		<%
			/* Commentaire HTML2' */
		%><br />
		<%-- Commentaire HTML3 --%>
		<br />
		<%
			String tst = "Commentaire HTML4";
		%><br />
		<%=tst%><br />
		<jsp:scriptlet>String tst2 = "Commentaire HTML5";</jsp:scriptlet>
		<jsp:expression>tst2</jsp:expression><br />

		<%-- <jsp:usebean>  </jsp:usebean>
		<jsp:getproperty </jsp:getproperty> --%>

		style="background-color: rgb(240, 240, 240); padding: 150px; height:
		200px;">
		<h1 style="text-align: center; color: rgb(200, 200, 200)">Bienvenue
			sur ma futur application</h1>
		<!-- 	<h2 style="text-align: center; color: #F66666">Together App</h2> -->
		<h5 style="color: rgb(100, 100, 100); text-align: center;">
			Developpé by
			<%=System.getProperty("user.name")%>
		</h5>
		<form action="HomeServlet" method="post">
			prenom : <input name="prenom"> <br /> nom : <input
				name="nom"> <br /> <input type="submit"> <br />
		</form>
		<%
			String s = request.getParameter("nom");
			response.getWriter().println(s + "<br/>");
			out.println(s + "<br/>");
		%>
		<%=(request.getParameter("prenom") + "<br/>")%>


		<!-- Afin de renvoyer vers formulaire -->
		<form name="fsaison">

			<!-- Nom du parametre -->
			<select name="saison">

				<%-- <%out.write("<select name='saison'>")%> --%>

				<%
					//List<String> lst = Arrays.asList("hivers", "ete", "Automne", "Printemps");
					List<String> lst = new ArrayList<String>();
					lst.add("hivers");
					lst.add("ete");
					lst.add("Automne");
					lst.add("Printemps");
					for (String saison : lst) {
						out.write("<option>" + saison + "</option>");
					}
				%>
			</select> <input type="submit" value="Submit" id="button-1" />

			<%-- <Alex:Somme></Alex:out> --%>
			<C:out value="Coucou"></C:out>
			
		</form>
		<!-- Ecrire une JSP qui affiche la date de chargement de la page -->
		<div>
			<%
				String txt = (String) session.getAttribute("titi");
					if (txt != null)
						out.write(txt);
					session.setAttribute("titi", session);

					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					Date date = new Date();
					DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM,
							Locale.FRENCH);
					out.write("Date :" + mediumDateFormat.format(date));//formatter.format(aujourdhui));
			%>
		</div>
	</div>

</body>
</html>