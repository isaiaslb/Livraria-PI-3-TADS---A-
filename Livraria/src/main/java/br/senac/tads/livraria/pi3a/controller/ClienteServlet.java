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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/clienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Usuario.jsp");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("cliente.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String end = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String estado = request.getParameter("estado");
        String cel = request.getParameter("cel");
        String email = request.getParameter("email");

        // Cria um novo contato e salva
        // através do DAO
        Cliente novo = new Cliente(nome, cpf, end, bairro, cep, estado, cel, email);
        ClienteDao dao = new ClienteDao();
        dao.incluirComTransacao(novo);

        // Usa a sessao para manter os dados após
        // redirect (técnica POST-REDIRECT-GET),
        // usado para evitar dupla submissão dos
        // dados
        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoCliente", novo);
        response.sendRedirect("bootstrap/cliente.jsp");

    }
}
