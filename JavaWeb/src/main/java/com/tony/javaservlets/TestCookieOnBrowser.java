package com.tony.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCookieOnBrowser extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Detectar se é o primeiro pedido (não tem flag)
        if (request.getParameter("flag") == null) {
            primeiraPagina(request, response);
        } else {
            segundaPagina(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void primeiraPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o URI com que a própria servlet está a ser invocada
        String s = request.getRequestURI() + "?flag=1";
        // Forçar o cliente a enviar um request para que o cookie venha anexado
        // A TAG meta é usada no HEADER. HTTP-EQUIV="refresh" é uma propriedade
        // que diz ao browser para carregar a página indicada no URL
        // quando passarem 0 segundos
        // <META HTTP-EQUIV="refresh"
        // CONTENT="0;URL=http://localhost:8080/JavaWeb/TestCookieOnBrowser?flag=1">
        String meta = "<meta http-equiv=\"refresh\" content=\"0; URL=" + s + "\">";
        // O cookie tem que ser adicionado 'a response antes de escrever
        Cookie c1 = new Cookie("utilizador", "Manuel_Joaquim");
        Cookie c2 = new Cookie("aplicacao", "Contabilidade");
        //aumentar o periodo de vida do cookie
        c1.setMaxAge(120);
        c2.setMaxAge(120);
        //adicionar o cookie à resposta
        response.addCookie(c1);
        response.addCookie(c2);
        // escrever a resposta que consiste numa pagina html com meta tag html
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<htm lang=\"pt\"l>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println(meta);
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    
    private void segundaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>TestCookieOnBrowser</title>");
        out.println("</head>");
        out.println("<body>");
        // Apanhar dados de cookies usando o header...
        String s = request.getHeader("COOKIE");
        if (s != null) {
            out.println("<h2>Valor do(s) cookie(s) retirado do cabeçalho (header)</h2>");
            out.println(s + "<br>");
            // Apanhar dados de cookies usando método especializado
            out.println("<h2>Valor do(s) Cookie(s) retirado(s) com função específica</h2>");
            Cookie[] vC = request.getCookies();
            for (Cookie c : vC) { // for each cookie inside vC
                out.println("<b>Nome do cookie: </b>" + c.getName() + "<br>");
                out.println("<b>Valor do cookie: </b>" + c.getValue() + "<br>");
            }
        } else {
            out.println("<h2>O pedido não inclui cookies. " + "Verifique se estão activados no browser</h2>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}