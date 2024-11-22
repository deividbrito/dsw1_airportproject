package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logservlet.do")
public class LogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String USERNAME_VALIDO = "admin";
    private static final String SENHA_VALIDA = "admin";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            response.sendRedirect("login.jsp?error=invalid");
            return;
        }
        
        if (USERNAME_VALIDO.equals(username) && SENHA_VALIDA.equals(password)) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("user", username);
            response.sendRedirect("admin.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
