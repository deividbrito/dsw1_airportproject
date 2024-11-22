package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.admcommands.RegisterFlightCommand;
import br.edu.ifsp.dsw1.controller.command.admcommands.AdminLoginCommand;
import br.edu.ifsp.dsw1.controller.command.admcommands.AdminLogoutCommand;
import br.edu.ifsp.dsw1.controller.command.admcommands.AdminSendUpdateCommand;
import br.edu.ifsp.dsw1.controller.command.admcommands.AdminUpdateCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Command command;

        switch (action) {
            case "login":
            	command = new AdminLoginCommand();
                break;
            case "logout":
            	command = new AdminLogoutCommand();
                break;
            case "register":
            	command = new RegisterFlightCommand();
                break;
            case "update":
            	command = new AdminUpdateCommand();
                break;
            case "sendUpdate":
            	command = new AdminSendUpdateCommand();
                break;
            default:
            	command = new ErrorCommand();
                break;
        }
        String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
    }
}
