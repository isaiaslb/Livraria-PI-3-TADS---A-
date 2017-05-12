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
 * @author Marcus
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/Produtos"})
public class ProdutoServlet extends HttpServlet {
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("produto.jsp");
        dispatcher.forward(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int filial = Integer.parseInt(request.getParameter("filial"));
        String produto = request.getParameter("produto");
        String autor = request.getParameter("autor");
        String genero = request.getParameter("genero");
        int qtd = Integer.parseInt(request.getParameter("qtd"));
        double valCompra = Double.parseDouble(request.getParameter("valCompra"));
        double valVenda = Double.parseDouble(request.getParameter("valVenda"));
        String descricao = request.getParameter("descricao");
        
        

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
        sessao.setAttribute("novoUsuario", novo);
        response.sendRedirect("resultado.jsp");
    }

    

}
