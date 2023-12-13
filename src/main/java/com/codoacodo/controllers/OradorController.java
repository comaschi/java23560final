package com.codoacodo.controllers;

import com.codoacodo.modelo.Orador;
import com.codoacodo.modeloDAO.OradorDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/orador")
public class OradorController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            doGet_Index(req, resp);
        } else if (action.equalsIgnoreCase("display")) {
            doGet_Display(req, resp);
        } else if (action.equalsIgnoreCase("find")) {
            doGet_Find(req, resp);
        } else if (action.equalsIgnoreCase("search")) {
            doGet_Search(req, resp);
        };
    }

    protected void doGet_Index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //crear la instancia de OradorDAO
        OradorDAO dao = new OradorDAO();
        req.setAttribute("listado", dao.listarOradores());
        req.getRequestDispatcher("/listado.jsp").forward(req, resp);

    }

    protected void doGet_Display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        OradorDAO dao = new OradorDAO();
        PrintWriter writer = resp.getWriter();
        writer.print(gson.toJson(dao.listarOradores()));
        writer.flush();
        writer.close();

    }

    protected void doGet_Find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        int id = Integer.parseInt(req.getParameter("id"));
        Gson gson = new Gson();
        OradorDAO dao = new OradorDAO();
        PrintWriter writer = resp.getWriter();
        writer.print(gson.toJson(dao.obtenerPorId(id)));
        writer.flush();
        writer.close();

    }
    protected void doGet_Search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        String value = req.getParameter("value");
        Gson gson = new Gson();
        OradorDAO dao = new OradorDAO();
        PrintWriter writer = resp.getWriter();
        writer.print(gson.toJson(dao.buscar(value)));
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("add")) {
            doPost_Add(req, resp);

        } else if (action.equalsIgnoreCase("delete")) {
            doPost_Delete(req, resp);

        } else if (action.equalsIgnoreCase("update")) {
            doPost_Update(req, resp);

        };

    }

    protected void doPost_Add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String tema = req.getParameter("tema");

        Orador orador = new Orador(nombre, apellido, email, tema, null);
        OradorDAO dao = new OradorDAO();

        dao.crearOrador(orador);

        resp.sendRedirect("orador");

    }

    protected void doPost_Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        //crear la instancia de OradorDAO
        OradorDAO dao = new OradorDAO();
        dao.eliminarOrador(id);
        resp.sendRedirect("orador");
    }
    
    protected void doPost_Update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id =  Long.parseLong(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String tema = req.getParameter("tema");

        Orador orador = new Orador(id ,nombre, apellido, email, tema, null);
        OradorDAO dao = new OradorDAO();

        dao.updateOrador(orador);

        resp.sendRedirect("orador");

    }
}