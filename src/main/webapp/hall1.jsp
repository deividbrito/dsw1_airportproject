<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hall 1</title>
</head>
<body>
    <header>
        <h1>Hall 1</h1>
    </header>

    <section>
        <p>Lista de voos no Hall 1:</p>

        <table border="1">
            <thead>
                <tr>
                    <th>Número do voo:</th>
                    <th>Companhia:</th>
                    <th>Horário:</th>
                    <th>Status:</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<FlightData> flightList = (List<FlightData>) request.getAttribute("list_hall1");
                if (flightList != null && !flightList.isEmpty()) {
                    for (FlightData flight : flightList) {
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
                    <td colspan="4">Sem voos no hall 1</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </section>

    <footer>
        <p><a href="index.jsp">Retornar</a></p>
    </footer>
</body>
</html>
