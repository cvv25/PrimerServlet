package com.example.primerservlet.controlador;

import com.example.primerservlet.modelo.GestorConsultas;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "listaGrupos", value = "/listagrupos-servlet")
public class ServletListaGrupos extends HttpServlet {
    GestorConsultas aliho = new GestorConsultas();

    public void init() {    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String listAutores[] = aliho.listaAutores();

        for (int i =    0; i <= aliho.listaAutores().length; i++) {
            out.println("<h4>" + listAutores[i] + "</h4><br>");
        }
        out.println("<a href=\"javascript: history.go(-1)\">Volver atras </a>\n");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}




