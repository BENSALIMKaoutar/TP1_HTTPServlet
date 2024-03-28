import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GreetingServlet extends HttpServlet {
 @Override
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String docType =
 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
 "Transitional//EN\">\n";
 String title = null;
 String votreNom = null;
 String role=null;
 String delete=null;
 String nomPrenom = "Anonymous";
 votreNom = request.getParameter("nom");
 role = request.getParameter("role");
 delete = request.getParameter("delete");
 System.out.println(delete);
 
 if (delete=="Non") {

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","2003KAWTAR");
		PreparedStatement  ps= con.prepareStatement("select * from blacklist where nom=?");
		ps.setString(1,votreNom);
		ResultSet rs= ps.executeQuery();
 
if ( !votreNom.equals(null) & role.equals("tomcat") & !rs.next() ) {
 PreparedStatement  psA= con.prepareStatement("select * from lotterie where nom=?");
 psA.setString(1,votreNom);
 ResultSet rsA= psA.executeQuery();
 if (rsA.next()) doPut(request, response);
 
 else {
	
 Double a = Math.random()*10;
 nomPrenom = votreNom.toUpperCase();
 title = "<H1>Greetings " + nomPrenom + "!</H1>\n";
 out.println(docType +
 "<HTML>\n" +
 "<HEAD><TITLE>Greetings Servlet</TITLE></HEAD>\n" +
 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
 title +
 "</BODY></HTML>");
 
 out.println("Vous avez gagne: "+a);
 out.println(" millions de dollars!");
 
 
    try {
		PreparedStatement  ps1= con.prepareStatement("insert into lotterie values(?,?)");
		ps1.setString(1, votreNom);
		ps1.setDouble(2,a );
		int rs1=ps1.executeUpdate();
		if (rs1>0) out.println("Vos données sont bien stockées.");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
 
 }}

else {out.println(docType +"<HTML>\n"
 	+ " <HEAD><TITLE>Greetings Servlet</TITLE></HEAD>\n"
		+ "<BODY BGCOLOR=\\\"#FDF5E6\\\">\n" +"<h1>Vous n'êtes pas permis à acceder !!!!</h1> </BODY></HTML>");}

	} catch (Exception e) {
		e.printStackTrace();
	}
 }
 else doDelete(request, response);

	}

 
 public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
 }
 
 public void doPut(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	 
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 String docType =
	 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	 "Transitional//EN\">\n";
	 String votreNom = null;
	 String nomPrenom = "Anonymous";
	 String title= null;
	 votreNom= request.getParameter("nom");
	 nomPrenom= votreNom.toUpperCase();
	 
	 
	 Double a = Math.random()*10;
	 nomPrenom = votreNom.toUpperCase();
	 title = "<H1>Greetings " + nomPrenom + "!</H1>\n";
	 out.println(docType +
	 "<HTML>\n" +
	 "<HEAD><TITLE>Greetings Servlet</TITLE></HEAD>\n" +
	 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	 title +
	 "</BODY></HTML>");
	 
	 out.println("Vous avez gagne: "+a);
	 out.println(" millions de dollars!");
	 
	 
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","2003KAWTAR");
			PreparedStatement  ps1= con.prepareStatement("update lotterie set gain=? where nom=?");
			ps1.setString(2, votreNom);
			ps1.setDouble(1,a );
			int rs1=ps1.executeUpdate();
			if (rs1>0) out.println("  Vos données sont bien mises à jour.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	 
 }
 
 public void doDelete(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 String votreNom = null;
	 String nomPrenom = "Anonymous";
	 votreNom= request.getParameter("nom");
	 nomPrenom= votreNom.toUpperCase();
	 
	 try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","2003KAWTAR");
			PreparedStatement  ps1= con.prepareStatement("select * from  lotterie  where nom=?");
			ps1.setString(1, votreNom);
			ResultSet rs1=ps1.executeQuery();
			if (rs1.next()) {
				PreparedStatement  ps2= con.prepareStatement("delete from  lotterie  where nom=?");
				ps2.setString(1, votreNom);
				int rs2=ps2.executeUpdate();
				if (rs2>0) out.println(nomPrenom+" est supprimé de la base de données");
				
			}
			else out.println(nomPrenom + "n'existe pas dans la base de données");
			
		} catch (Exception e) {
			System.out.println("Erreur dans delete "+e );
		}
	 
 }
	 
 }

