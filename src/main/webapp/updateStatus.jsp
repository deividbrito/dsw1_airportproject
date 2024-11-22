<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atualizar status</title>
</head>
<body>
    <h1>Atualizar status de voo</h1>
    <hr>

    <table border="1">
        <thead>
            <tr>
                <th>Número do voo</th>
                <th>Companhia</th>
                <th>Horário</th>
                <th>Status</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<FlightData> flights = (List<FlightData>) request.getAttribute("flights");
            if (flights != null && !flights.isEmpty()) {
                for (FlightData flight : flights) {
            %>
            <tr>
                <td><%= flight.getFlightNumber() %></td>
                <td><%= flight.getCompany() %></td>
                <td><%= flight.getTime() %></td>
                <td><%= flight.getState().getClass().getSimpleName() %></td>
                <td>
                    <form action="admin.do?action=sendUpdate" method="post">
                        <input type="hidden" name="flightNumber" value="<%= flight.getFlightNumber() %>">
                        <button type="submit"> Atualizar status </button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="5"> Sem voos </td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <br>
    <hr>
    <p><a href="admin.jsp"> Retornar </a></p>
</body>
</html>
