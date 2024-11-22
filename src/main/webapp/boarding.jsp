<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sala de Embarque</title>
</head>
<body>
    <header>
        <h1>Sala de Embarque</h1>
    </header>

    <section>
        <h2>Voos em embarque:</h2>
        
        <%
        List<FlightData> flightList = (List<FlightData>) request.getAttribute("embarked");
        if (flightList != null && !flightList.isEmpty()) {
        %>

        <ul>
            <% 
            for (FlightData flight : flightList) {
            %>
                <li>
                    <strong>Número de voo:</strong> <%= flight.getFlightNumber() %><br>
                    <strong>Companhia Aérea:</strong> <%= flight.getCompany() %><br>
                    <strong>Horário:</strong> <%= flight.getTime() %>
                </li>
            <% 
            }
            %>
        </ul>

        <% } else { %>
            <p><strong> Não há voos em processo de embarque. </strong></p>
        <% } %>
    </section>

    <footer>
        <p>&copy; 2024 - Sistema de Embarque</p>
    </footer>
</body>
</html>
