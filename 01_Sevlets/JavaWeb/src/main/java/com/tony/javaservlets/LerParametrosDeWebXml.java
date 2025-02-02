package com.tony.javaservlets;



import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebInitParam;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LerParametrosDeWebXml extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig conf = this.getServletConfig();
        String host = null;
        String port = null;
        String dbSchema = null;
        String user = null;
        String password = null;
        host     = conf.getInitParameter("host");
        port     = conf.getInitParameter("port");
        dbSchema = conf.getInitParameter("dbSchema");
        user     = conf.getInitParameter("user");
        password = conf.getInitParameter("password");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>LerParametroDeWebXml</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border=\"1\">");
        out.println("<tr><td>host    </td><td>" + host     + "</td></tr>");
        out.println("<tr><td>port    </td><td>" + port     + "</td></tr>");
        out.println("<tr><td>dbSchema</td><td>" + dbSchema + "</td></tr>");
        out.println("<tr><td>user    </td><td>" + user     + "</td></tr>");
        out.println("<tr><td>password</td><td>" + password + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
