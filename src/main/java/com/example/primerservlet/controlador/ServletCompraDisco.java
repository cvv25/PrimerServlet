package com.example.primerservlet.controlador;

import com.example.primerservlet.modelo.GestorConsultas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "compradisco", value = "/compradisco-servlet")
public class ServletCompraDisco extends HttpServlet {

    private GestorConsultas discos = new GestorConsultas();

    public void init() {
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String codigo = request.getParameter("codigo");

        if (codigo != null) {
            int numero = Integer.parseInt(codigo);

            String lista = discos.bajaDisco(numero);
            out.println("<ul>");
            out.println("<li>" + lista + "</li>");
        } else {
            out.println("Introduzca el codigo del disco: ");
            out.println("<form ");
            out.println("method=POST>");
            out.println("Codigo del disco:");
            out.println("<input type=number size=20 name=codigo>");
            out.println("<br>");
            out.println("<button type=submit value=Submit>Enviar</button>");
            out.println("</form>");

        }
        out.println("<a href=\"javascript: history.go(-1)\">Volver atras</a>\n");
        out.println("</body></html>");
    }

}
