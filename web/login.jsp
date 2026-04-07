<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="container">

    <h1>Connexion</h1>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <form action="login" method="post">
        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit" class="btn">Se Connecter</button>
    </form>

    <br><br>
    <a href="register.jsp">← Creer un compte !!</a>

</div>

</body>
</html>
