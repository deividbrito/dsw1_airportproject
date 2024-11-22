package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;

@WebServlet("/updateStatus.do")
public class FlightUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	FlightDataCollection collection = FlightDataSingleton.getInstance();
    	
        List<FlightData> flights = collection.getAllFligthts();
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("updateState.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	FlightDataCollection collection = FlightDataSingleton.getInstance();
        Long flightNumber = Long.parseLong(request.getParameter("flightNumber"));
        collection.updateFlight(flightNumber);
        response.sendRedirect("updateStatus.do");
    }
}
