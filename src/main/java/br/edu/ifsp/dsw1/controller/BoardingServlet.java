package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boarding.do")
public class BoardingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FlightDataCollection flightCollection = FlightDataSingleton.getInstance();

            List<FlightData> boardingFlights = flightCollection.getAllFligthts().stream()
                .filter(flight -> flight.getState() instanceof Boarding)
                .collect(Collectors.toList());

            request.setAttribute("boardingFlights", boardingFlights);

            request.getRequestDispatcher("boarding.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("error.jsp?message=Um erro ocorreu ao processar os embarques");
        }
    }
}
