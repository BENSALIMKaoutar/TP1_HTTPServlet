<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to this amazing web application</title>
</head>
<body >
<div align=center>
<H1> Tenter votre chance a cette lotterie virtuelle!</H1>
<FORM ACTION = "./hello" METHOD="post">
 Votre nom svp: <INPUT TYPE = "TEXT" NAME = "nom"><BR>
 <BR>
 Votre rôle: <INPUT TYPE = "TEXT" NAME = "role">
<br><br>
Voulez vous supprimer ce nom de la base de données?
<br>
Oui <input type="radio" id="Oui" name="delete" value="1">
<br>
Non <input type="radio" id="Non" name="delete" value="0">
<br>
 <INPUT TYPE = "SUBMIT" NAME = "Submit Query">
</FORM>


</div>
</body>
</html>
