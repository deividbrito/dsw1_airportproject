package br.edu.ifsp.dsw1.controller.command.totenscommands;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

public class DisembarkCommand implements Command, FlightDataObserver {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightDataCollection collection = FlightDataSingleton.getInstance();
        collection.register(this);
        List<FlightData> arrivingFlights = collection.getAllFligthts().stream()
                .filter(f -> f.getState() instanceof Arriving)
                .collect(Collectors.toList());

        request.setAttribute("arrivingFlights", arrivingFlights);

        return "disembarkRoom.jsp";
    }
    
    @Override
	public void update(FlightData flight) {
		System.out.println("Voo atualizado: " + flight.getFlightNumber());
	}
}
