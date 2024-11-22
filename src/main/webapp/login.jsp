<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title> Login - Administrador </title>
</head>
<body>

    <header>
        <h1> Login de Administrador </h1>
        <hr>
    </header>

    <main>
        <form action="admin.do?action=login" method="post">
            <div>
                <label for="username"> Username: </label>
                <input type="text" id="username" name="username" required>
            </div>
            <br>

            <div>
                <label for="password"> Senha: </label>
                <input type="password" id="password" name="password" required>
            </div>
            <br>

            <div>
                <button type="submit"> Enviar </button>
            </div>
        </form>
    </main>

    <footer>
        <p><a href="index.jsp"> Menu inicial </a></p>
    </footer>

</body>
</html>
