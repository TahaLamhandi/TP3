<%--
  Created by IntelliJ IDEA.
  User: lamha
  Date: 4/1/2026
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div class="container">

    <h1>Inscription</h1>

    <% if (request.getAttribute("errorSignup")!=null){%>
    <p style="color: red;">
        <%= request.getAttribute("errorSignup")%>
    </p>
    <%}%>

    <form action="register" method="post">
        <label for="nom">Nom</label>
        <input type="text" id="nom" name="nom" required>

        <label for="prenom">Prénom</label>
        <input type="text" id="prenom" name="prenom" required>

        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit" class="btn">Ajouter Client</button>
    </form>

    <br><br>
    <a href="login.jsp">← J'ai déjà un compte</a>
</div>

</body>
</html>
