/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.UsuarioDAO;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//@WebServlet("/Autenticador")package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.UsuarioDAO;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//@WebServlet("/Autenticador")
@WebServlet(name = "Autenticador", urlPatterns = {"/Autenticador"})
public class Autenticador extends HttpServlet {
    // private static final long serialversionUID = 1l;

    public Autenticador() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            Usuario usu = new Usuario();
            usu.setNome(nome);
            usu.setSenha(senha);

            UsuarioDAO usuDao = new UsuarioDAO();
            Usuario usuAutenticado = usuDao.autenticacao(usu);

            if (usuAutenticado != null) {

               HttpSession session = request.getSession();
                session.setAttribute("usuAutenticado", usuAutenticado);
                request.getRequestDispatcher("bootstrap/index.jsp").forward(request, response);

            } else {
                response.sendRedirect("erroLogin.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}