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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

//        @Override
//        public void doPost(HttpServletRequest request,
//                HttpServletResponse response)
//                throws ServletException {
//
//            List<Produtos> lista = new ArrayList<>();
//
//            try {
//
//                ProdutosDao dao = new JDBCProdutosDao();
//                lista = dao.listar();
//
//                request.setAttribute("listaProdutos", lista);
//
//                // Envia a requisição para o processamento na JSP.
//                RequestDispatcher dispatcher = request.getRequestDispatcher("produtos.jsp");
//                try {
//                    dispatcher.forward(request, response);
//                } catch (IOException ex) {
//
//                }
//
//            } catch (Exception ex) {
//                Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//
//    }
 
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
        response.sendRedirect("bootstrap/produto.jsp");
    }
}
//
//    
//

