/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.UsuarioDAO;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaias
 */
@WebServlet(name = "BuscarUsuario", urlPatterns = {"/buscarUsuario"})
public class BuscarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        String papel = request.getParameter("papel");
//        request.setAttribute("papelCliente", papel);
        String b = request.getParameter("buscarNome");
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario lista = dao.obterUsuario(b);

        request.setAttribute("listaUsuario", lista);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/buscarUsuario.jsp");
        dispatcher.forward(request, response);

        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {

        }

    }

}
