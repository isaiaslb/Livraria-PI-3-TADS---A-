/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.JDBCProdutosDao;
import br.senac.tads.livraria.pi3a.model.Produtos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernanda
 */
@WebServlet("/buscar-produto")
public class BuscarProduto extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JDBCProdutosDao dao = new JDBCProdutosDao();
        String livro = request.getParameter("titulo");
        Produtos resultadoPesquisa = dao.buscar(livro, null);
        
        //request.setAttribute("livro", resultadoPesquisa);
        request.getServletContext().setAttribute("livro", resultadoPesquisa);
        //request.getRequestDispatcher("bootstrap/buscarProduto.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/bootstrap/buscarProduto.jsp");
    }
    
}
