package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hall1.do")
public class Hall1Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FlightDataCollection flightCollection = FlightDataSingleton.getInstance();

            List<FlightData> takingOffFlights = flightCollection.getAllFligthts().stream()
                .filter(flight -> flight.getState() instanceof TakingOff)
                .collect(Collectors.toList());

            request.setAttribute("hall1Flights", takingOffFlights);

            request.getRequestDispatcher("hall1.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect("error.jsp?message=Um erro ocorreu enquanto as informações do Hall 1 eram processadas.");
        }
    }
}
