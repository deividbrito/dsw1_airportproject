package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.totenscommands.DisembarkCommand;
import br.edu.ifsp.dsw1.controller.command.totenscommands.BoardingCommand;
import br.edu.ifsp.dsw1.controller.command.totenscommands.Hall1Command;
import br.edu.ifsp.dsw1.controller.command.totenscommands.Hall2Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/totens.do")
public class TotensController extends HttpServlet {
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
            case "hall1":
            	command = new Hall1Command();
                break;
            case "hall2":
            	command = new Hall2Command();
                break;
            case "disembark":
            	command = new DisembarkCommand();
                break;
            case "boarding":
            	command = new BoardingCommand();
            default:
            	command = new ErrorCommand();
                break;
        }
	    String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);	    
    }
}

