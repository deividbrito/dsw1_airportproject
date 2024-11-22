package br.edu.ifsp.dsw1.controller.command.totenscommands;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardingCommand implements Command, FlightDataObserver {

    private boolean isRegistered = false;
    private boolean canUnregister = false;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightDataCollection collection = FlightDataSingleton.getInstance();


        if (!isRegistered) {
            collection.register(this);
            isRegistered = true;
        }

        List<FlightData> boardingFlights = collection.getAllFligthts().stream()
                .filter(f -> f.getState() instanceof Boarding)
                .collect(Collectors.toList());

        request.setAttribute("boardingFlights", boardingFlights);

        if (canUnregister && isRegistered) {
            collection.unregister(this);
            isRegistered = false;
            canUnregister = false;
        }

        return "boarding.jsp";
    }

    @Override
    public void update(FlightData flight) {
        if (flight.getState() instanceof Boarding) {
            System.out.println("Voo atualizado: " + flight.getFlightNumber() + " para o estado: " + flight.getState().getClass().getSimpleName());
            canUnregister = true;
        }
    }
}
