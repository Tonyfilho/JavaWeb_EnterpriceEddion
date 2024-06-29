package com.tony.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class PedidoParametrosNValores extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>" + this.getServletName() + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + this.getServletName() + "</h2>");
        // Ler escolhas feitas pelas Checkboxes
        String[] values = request.getParameterValues("checkboxMusica");
        if (values != null) {
            out.println("<h3>Tipos de musica escolhidos com checkbox</h3>");
            for (int i = 0; i < values.length; i++) {
                out.println("<br>" + values[i]);
            }
        } else {
            out.println("<h3>Não foram escolhidos tipos de musicas com as checkboxes</h3>");
        }
        // lêr escolhas feitas pela SELECTION BOX
        values = request.getParameterValues("listaEscolhaMusica");
        if (values != null) {
            out.println("<h3>Tipos de musica escolhidos com selection</h3>");
            for (int i = 0; i < values.length; i++) {
                out.println("<br>" + values[i]);
            }
        } else {
            out.println("<h3>Não foram escolhidos tipos de musicas com a selection</h3>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}