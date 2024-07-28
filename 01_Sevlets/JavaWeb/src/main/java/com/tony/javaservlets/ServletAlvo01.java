package com.tony.javaservlets;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletAlvo01 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>ServletAlvo01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>ServletAlvo01</h3>");
        out.println("Servlet REFERER=" + request.getHeader("REFERER"));
        listaParametros(request, out);
        listaAtributos(request, out);
        out.println("<br><hr>");
        out.println("<a href=\"AnalisarPedidoHTTP.html\">" + "Regressar ao formulário </a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void listaParametros(HttpServletRequest req, PrintWriter out) throws ServletException, IOException {
        out.println("<h3>Lista de parâmetros</h3>");
        int n = 0;
        Enumeration<String> eNames = req.getParameterNames();
        while (eNames.hasMoreElements()) {
            String name = (String) eNames.nextElement();
            out.println("<b>Nome=</b>" + name);
            String values[] = req.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    out.println("  <b>Valor=</b>" + values[i]);
                    n++;
                }
            }
            out.println("<br>");
        }
        if (n == 0) {
            out.println("Não foram passados parâmetros!<br>");
        }
    }

    private void listaAtributos(HttpServletRequest req, PrintWriter out) throws ServletException, IOException {
        out.println("<h3>Lista de atributos</h3>");
        int n = 0;
        Enumeration<String> eNames = req.getAttributeNames();
        while (eNames.hasMoreElements()) {
            String name = (String) eNames.nextElement();
            out.println("<b>Nome=</b>" + name);
            out.println("  <b>Valor=</b>" + req.getAttribute(name) + "<br>");
            n++;
        }
        if (n == 0) {
            out.println("Não foram passados Atributos!<br>");
        }
    }
}