/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.JDBCProdutosDao;
import br.senac.tads.livraria.pi3a.model.Produtos;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernanda
 */
@WebServlet(name = "BuscarProduto", urlPatterns = {"/buscarProduto"})
public class BuscarProduto extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String bProduto = request.getParameter("buscaProduto");        
        
         JDBCProdutosDao dao = new JDBCProdutosDao();
         Produtos busca = dao.buscar(bProduto);         
         request.setAttribute("buscaProdutos", busca);
         
         RequestDispatcher dispatcher
                 = request.getRequestDispatcher("bootstrap/buscarProduto.jsp");
         dispatcher.forward(request, response);
        
         try {
             dispatcher.forward(request, response);
         } catch (IOException ex){
             
         }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        JDBCProdutosDao dao = new JDBCProdutosDao();
        Produtos prod = new Produtos();        
        prod.setProdId(Integer.parseInt(request.getParameter("bId")));
        prod.setProdFilial(Integer.parseInt(request.getParameter("bFilial")));
        prod.setProdNome(request.getParameter("bNome"));
        prod.setProdAutor(request.getParameter("bAutor"));
        prod.setProdGenero(request.getParameter("bGenero"));
        prod.setProdQtd(Integer.parseInt(request.getParameter("bQtd")));
        prod.setProdValCompra(Double.parseDouble(request.getParameter("bValCompra")));
        prod.setProdValVenda(Double.parseDouble(request.getParameter("bValVenda")));
        prod.setProdDesc(request.getParameter("bDesc"));                
        
        //request.getSession().setAttribute("prod", prod);
        dao.alterar(prod);
        
        //request.setAttribute("livro", resultadoPesquisa);
        //request.getServletContext().setAttribute("livro", resultadoPesquisa);
        request.getRequestDispatcher("bootstrap/buscarProduto.jsp").forward(request, response);
        //response.sendRedirect("/bootstrap/buscarProduto.jsp");
        //response.sendRedirect(request.getContextPath() + "/bootstrap/buscarProduto.jsp");
    }
    
}
