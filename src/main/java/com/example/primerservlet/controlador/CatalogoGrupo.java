package com.example.primerservlet.controlador;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "catalogoGrupo", value = "/catalogogrupo-servlet")
public class CatalogoGrupo extends HttpServlet {
    private String message;

    public void init() {
        message = "Lista Grupos del catalogo";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}