/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.EmpresaDao;
import br.senac.tads.livraria.pi3a.model.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernanda
 */

@WebServlet(name = "BuscarEmpresa", urlPatterns = {"/buscarEmpresa"})
public class BuscarEmpresa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String papel = request.getParameter("papel");
//        request.setAttribute("papelCliente", papel);


        String b = request.getParameter("buscarCnpj");

        EmpresaDao dao = new EmpresaDao();
        Empresa lista = dao.obterContato(1);

        request.setAttribute("listaEmpresa", lista);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/buscarEmpresa.jsp");
        dispatcher.forward(request, response);

        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {

        }

    }
}