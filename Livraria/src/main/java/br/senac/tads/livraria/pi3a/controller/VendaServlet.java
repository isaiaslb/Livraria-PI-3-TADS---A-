/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.ClienteDao;
import br.senac.tads.livraria.pi3a.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/vendaServlet"})
public class VendaServlet extends HttpServlet {

    protected void buscaCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String b = request.getParameter("clibusca");

        ClienteDao dao = new ClienteDao();
        Cliente lista = dao.obterCliente(b);
        
        request.getSession().setAttribute("listCliente", lista);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/venda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comando = request.getParameter("comando");
        if (comando.equals("buscaCli")) {
             buscaCli(request, response);  
             return;
        }
        
//        String b = request.getParameter("clibusca");
//
//        ClienteDao dao = new ClienteDao();
//        Cliente lista = dao.obterCliente(b);
//        request.setAttribute("listaCliente", lista);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
