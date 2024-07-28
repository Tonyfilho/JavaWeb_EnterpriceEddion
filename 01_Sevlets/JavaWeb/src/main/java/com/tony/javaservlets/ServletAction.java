package com.tony.javaservlets;



//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //redirecionamento com forward
        //request.setAttribute("OK", "O pedido passou por ServletAction");
        //RequestDispatcher rd = request.getRequestDispatcher("ServletAlvo01");
        //rd.forward(request, response);
        //redirecionamento com sendRedirect()
        
        // redirecionamento com sendRedirect()
        //response.sendRedirect("ServletAlvo01");
    	
    	/*ou*/
    	/*Com este tipo de redirecionamento não é possível enviar o objeto 
    	 * HttpServletRequest à segunda servlet, pelo que a única maneira 
    	 * de passar parâmetros é usando o URL do redirecionamento, como 
    	 * mostra a alteração apresentada no exemplo abaixo, feita no método doGet() 
    	 * de ServletAction:**/
        response.sendRedirect("ServletAlvo01?"+request.getQueryString());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}