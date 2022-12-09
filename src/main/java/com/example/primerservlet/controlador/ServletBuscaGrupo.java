package com.example.primerservlet.controlador;

import com.example.primerservlet.modelo.GestorConsultas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "buscagrupo", value = "/buscagrupo-servlet")
public class ServletBuscaGrupo extends HttpServlet {

    private GestorConsultas discos = new GestorConsultas();

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String firstName = request.getParameter("nombreGrupo");

        if (firstName != null){
            out.println("Discos de " + firstName +":");
            String[] lista = discos.buscaAutor(firstName);
            out.println("<div>");
            out.println("<ul>");
            for (int i = 0; i < lista.length; i++){
                out.println("<li>" + lista[i] + "</li>");
            }
            out.println("</ul>");
            out.println("</div>");
        }else{
            out.println("Introduzca el nombre del grupo");
            out.println("<form ");
            out.println("method=POST>");
            out.println("Nombre del grupo:");
            out.println("<input type=text size=20 name=nombreGrupo>");
            out.println("<br>");
            out.println("<button type=submit value=Submit>Enviar</button>");
            out.println("</form>");
        }
        out.println("<a href=\"javascript: history.go(-1)\">Volver atras</a>\n");

        out.println("</body></html>");

    }

    public void destroy() {
    }
}
