package br.edu.ifsp.dsw1.controller.command.admcommands;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminSendUpdateCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightDataCollection collection = FlightDataSingleton.getInstance();
        Long flightNumber = Long.parseLong(request.getParameter("flightNumber"));
        collection.updateFlight(flightNumber);
        return "admin.do?action=update";
    }
}
