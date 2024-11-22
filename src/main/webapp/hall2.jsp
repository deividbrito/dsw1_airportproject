<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hall 2</title>
</head>
<body>
    <header>
        <h1>Hall 2:</h1>
    </header>

    <section>
        <hr>
        <h2>Lista de voos no Hall 2:</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>Número de voo:</th>
                    <th>Companhia Aérea:</th>
                    <th>Horário:</th>
                    <th>Status:</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<FlightData> flightList = (List<FlightData>) request.getAttribute("list_hall2");
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
                        <td colspan="4">Sem voos registrados no Hall 2</td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </section>

    <footer>
        <hr>
        <p><a href="index.jsp">Retornar</a></p>
    </footer>
</body>
</html>
