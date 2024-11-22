package br.edu.ifsp.dsw1.controller.command.admcommands;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterFlightCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long flightNumber = Long.parseLong(request.getParameter("number"));
        String airlineCompany = request.getParameter("company");
        String arrivalTime = request.getParameter("time");

        FlightData flight = new FlightData(flightNumber, airlineCompany, arrivalTime);
        flight.setState(Arriving.getInstance());

        FlightDataCollection collection = FlightDataSingleton.getInstance();
        collection.insertFlight(flight);

        return "admin.jsp";
    }
}
