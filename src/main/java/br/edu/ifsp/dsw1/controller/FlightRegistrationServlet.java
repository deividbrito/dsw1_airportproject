package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;

@WebServlet("/registerFlight.do")
public class FlightRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long flightNumber = Long.parseLong(request.getParameter("flightNumber"));
            String airlineCompany = request.getParameter("airlineCompany");
            String scheduledTime = request.getParameter("scheduledTime");

            FlightData newFlight = new FlightData(flightNumber, airlineCompany, scheduledTime);
            newFlight.setState(Arriving.getInstance());
            
            FlightDataCollection flightCollection = FlightDataSingleton.getInstance();
            flightCollection.insertFlight(newFlight);

            response.sendRedirect("admin.jsp");

        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp?message=Invalid flight number");
        } catch (Exception e) {
            response.sendRedirect("error.jsp?message=An error occurred while processing the flight registration");
        }
    }
}
