<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: lamha
  Date: 4/1/2026
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

     <h1>Bienvenue <%= ((User)session.getAttribute("currentUser")).getPrenom()%> !</h1>

     <br><br>
     <a href="seDeconnecter">← Se Déconnecter</a>


</body>
</html>
