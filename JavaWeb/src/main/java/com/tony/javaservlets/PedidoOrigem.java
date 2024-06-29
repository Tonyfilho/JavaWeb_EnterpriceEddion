package com.tony.javaservlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class PedidoOrigem extends HttpServlet {
    
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
        out.println("<tr><th>Método</th><th>Valor devolvido</th></tr>");
        out.println("<tr><td> getContextPath() </td><td>" + request.getContextPath() + "</td></tr>");
        out.println("<tr><td> getLocalAddr() </td><td>" + request.getLocalAddr() + "</td></tr>");
        out.println("<tr><td> getLocalName() </td><td>" + request.getLocalName() + "</td></tr>");
        out.println("<tr><td> getLocalPort() </td><td>" + request.getLocalPort() + "</td></tr>");
        out.println("<tr><td> getMethod() </td><td>" + request.getMethod() + "</td></tr>");
        out.println("<tr><td> getProtocol() </td><td>" + request.getProtocol() + "</td></tr>");
        out.println("<tr><td> getRemoteAddr() </td><td>" + request.getRemoteAddr() + "</td></tr>");
        out.println("<tr><td> getRemoteHost() </td><td>" + request.getRemoteHost() + "</td></tr>");
        out.println("<tr><td> getRemotePort() </td><td>" + request.getRemotePort() + "</td></tr>");
        out.println("<tr><td> getRemoteUser() </td><td>" + request.getRemoteUser() + "</td></tr>");
        out.println("<tr><td> getScheme() </td><td>" + request.getScheme() + "</td></tr>");
        out.println("<tr><td> getServerName() </td><td>" + request.getServerName() + "</td></tr>");
        out.println("<tr><td> getServerPort() </td><td>" + request.getServerPort() + "</td></tr>");
        out.println("<tr><td>Request URL</td><td>" + request.getRequestURL() + "</td></tr>");
        out.println("<tr><td>Request URI</td><td>" + request.getRequestURI() + "</td></tr>");
        out.println("<tr><td>Servlet path</td><td>" + request.getServletPath() + "</td></tr>");
        out.println("<tr><td>Path info</td><td>" + request.getPathInfo() + "</td></tr>");
        out.println("<tr><td>Path translated</td><td>" + request.getPathTranslated() + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}