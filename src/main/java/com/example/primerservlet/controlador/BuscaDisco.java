package com.example.primerservlet.controlador;


import java.io.*;

import com.example.primerservlet.modelo.GestorConsultas;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "buscaDisco", value = "/buscadisco-servlet")
public class BuscaDisco extends HttpServlet {
    private String message;

    public void init() {
        message = "Busca discos de un grupo";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        GestorConsultas a = new GestorConsultas();
        String e = String.valueOf(a.buscaAutor("Los Planetas"));



        out.println("<html><body>");
        out.println("<h1>" + e + "Hola Jejej" + "</h1>");
        out.println("</body></html>");
    }



    public void destroy() {
    }
}