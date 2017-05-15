/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.JDBCProdutosDao;
import br.senac.tads.livraria.pi3a.dao.ProdutosDao;
import br.senac.tads.livraria.pi3a.model.Produtos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcus
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/Produtos"})
public class ProdutoServlet extends HttpServlet {
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/produto.jsp");
        dispatcher.forward(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        int filial = Integer.parseInt(request.getParameter("PRODFILIAL"));
        String produto = request.getParameter("PRODNOME");
        String autor = request.getParameter("PRODAUTOR");
        String genero = request.getParameter("PRODGENERO");
        int qtd = Integer.parseInt(request.getParameter("PRODQTD"));
        double valCompra = Double.parseDouble(request.getParameter("PRODVALCOMPRA"));
        double valVenda = Double.parseDouble(request.getParameter("PRODVALVENDA"));
        String descricao = request.getParameter("PRODDESC");
        
        

        // Cria um novo contato e salva
        // através do DAO
        Produtos novo = new Produtos(filial, produto, autor, genero, qtd, valCompra, valVenda, descricao);
        ProdutosDao dao = new JDBCProdutosDao();
        dao.inserir(novo);

        // Usa a sessao para manter os dados após
        // redirect (técnica POST-REDIRECT-GET),
        // usado para evitar dupla submissão dos
        // dados
        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoProduto", novo);
        response.sendRedirect("resultado.jsp");
    }

    

}
