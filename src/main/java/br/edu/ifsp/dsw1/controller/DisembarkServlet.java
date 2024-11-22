package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/disembark.do")
public class DisembarkServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FlightDataCollection flightCollection = FlightDataSingleton.getInstance();

            List<FlightData> arrivingFlights = flightCollection.getAllFligthts().stream()
                .filter(flight -> flight.getState() instanceof Arriving)
                .collect(Collectors.toList());

            request.setAttribute("disembarkedFlights", arrivingFlights);

            request.getRequestDispatcher("disembarkationRoom.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("error.jsp?message=Um erro ocorreu enquanto os desembarques eram processados.");
        }
    }
}
