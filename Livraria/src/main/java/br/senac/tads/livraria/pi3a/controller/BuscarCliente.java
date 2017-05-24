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
@WebServlet(name = "BuscarCliente", urlPatterns = {"/buscarCliente"})
public class BuscarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


//        String papel = request.getParameter("papel");
//        request.setAttribute("papelCliente", papel);
        String b = request.getParameter("buscarCnpj");

        ClienteDao dao = new ClienteDao();
        Cliente lista = dao.obterCliente(b);

        request.setAttribute("listaCliente", lista);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/buscarCliente.jsp");
        dispatcher.forward(request, response);

        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         Cliente cli = new Cliente();
         cli.setNome(request.getParameter("nome"));
         cli.setCpf(request.getParameter("cpf"));
         cli.setEnd(request.getParameter("endereco"));
         cli.setBairro(request.getParameter("bairro"));
         cli.setCep(request.getParameter("cep"));
         cli.setEstado(request.getParameter("estado"));
         cli.setCel(request.getParameter("cel"));
         cli.setEmail(request.getParameter("email"));
        
        ClienteDao dao = new ClienteDao();
        dao.atualizar(cli);
        
        HttpSession sessao = request.getSession();
        sessao.setAttribute("atualizaCliente", cli);
        response.sendRedirect("bootstrap/buscarCliente.jsp");
        

    }

}
