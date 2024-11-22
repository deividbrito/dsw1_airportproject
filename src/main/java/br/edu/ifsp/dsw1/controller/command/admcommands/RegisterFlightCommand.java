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
        String flightNumberStr = request.getParameter("number");
        String airlineCompany = request.getParameter("company");
        String arrivalTime = request.getParameter("time");

        FlightDataCollection collection = FlightDataSingleton.getInstance();

        Long flightNumber;
        if (flightNumberStr != null && !flightNumberStr.trim().isEmpty()) {
            try {
                flightNumber = Long.parseLong(flightNumberStr);
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessageRegistration", "Número de voo inválido.");
                return "flightRegistration.jsp";
            }
        } else {
            request.setAttribute("errorMessageRegistration", "O número do voo é obrigatório.");
            return "flightRegistration.jsp";
        }

        boolean flightExists = collection.getAllFligthts().stream()
                .anyMatch(f -> f.getFlightNumber().equals(flightNumber));

        if (flightExists) {
            request.setAttribute("errorMessageRegistration", "Já existe um voo com este número.");
            return "flightRegistration.jsp";
        }

        FlightData flight = new FlightData(flightNumber, airlineCompany, arrivalTime);
        flight.setState(Arriving.getIntance());
        collection.insertFlight(flight);

        request.setAttribute("registrationSuccess", "Voo cadastrado com sucesso.");

        return "flightRegistration.jsp";
    }
}
