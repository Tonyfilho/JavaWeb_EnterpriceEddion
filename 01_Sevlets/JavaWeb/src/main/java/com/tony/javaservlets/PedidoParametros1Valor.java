package com.tony.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
public class PedidoParametros1Valor extends HttpServlet {
    
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
        out.println("<table border=\"1\">");
        int n = 0;
        Enumeration<String> eNames = request.getParameterNames();
        while (eNames.hasMoreElements()) {
            String name = (String) eNames.nextElement();
            out.println("<tr><td>" + name + "</td><td>" + request.getParameter(name) + "</td></tr>");
            n++;
        }
        if (n == 0) {
            out.println("<tr><td>Não foram passados parâmetros!</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}