<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar voos</title>
</head>
<body>
    <h1>Cadastrar um novo voo:</h1>
    <hr>

    <form action="admin.do?action=register" method="post">
        <div>
            <label for="flightNumber">Número do voo:</label>
            <input type="number" id="flightNumber" name="flightNumber" required><br><br>
        </div>
        
        <div>
            <label for="airline">Companhia aérea:</label>
            <input type="text" id="airline" name="airline" required><br><br>
        </div>
        
        <div>
            <label for="scheduledTime">Horário do voo:</label>
            <input type="text" id="scheduledTime" name="scheduledTime" required><br><br>
        </div>

        <button type="submit">Enviar</button>
    </form>

    <br><hr>
    <p><a href="admin.jsp">Retornar</a></p>
</body>
</html>
