<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sala de Desembarque</title>
</head>
<body>
    <header>
        <h1>Sala de Desembarque</h1>
    </header>

    <section>
        <p>Lista de voos chegando ao aeroporto:</p>

        <table border="1">
            <thead>
                <tr>
                    <th>Número do voo:</th>
                    <th>Companhia Aérea:</th>
                    <th>Horário:</th>
                    <th>Status:</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<FlightData> arrivingFlights = (List<FlightData>) request.getAttribute("disembarked");
                if (arrivingFlights != null && !arrivingFlights.isEmpty()) {
                    for (FlightData flight : arrivingFlights) {
                %>
                <tr>
                    <td><%= flight.getFlightNumber() %></td>
                    <td><%= flight.getCompany() %></td>
                    <td><%= flight.getTime() %></td>
                    <td><%= flight.getState().getClass().getSimpleName() %></td>
                </tr>
                <% 
                    }
                } else {
                %>
                <tr>
                    <td colspan="4">Nenhum voo em desembarque!</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </section>

    <footer>
        <p><a href="index.jsp">Voltar</a></p>
    </footer>
</body>
</html>
