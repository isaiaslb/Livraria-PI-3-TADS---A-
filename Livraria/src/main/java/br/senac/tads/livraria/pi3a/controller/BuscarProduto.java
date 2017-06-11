/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.JDBCProdutosDao;
import br.senac.tads.livraria.pi3a.model.Produtos;

import java.io.IOException;
import java.util.Vector;
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
@WebServlet(name = "BuscarProduto", urlPatterns = {"/buscarProduto"})
public class BuscarProduto extends HttpServlet {

    protected void buscaProd(HttpServletRequest request, HttpServletResponse response)
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
        } catch (IOException ex) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comando = request.getParameter("comando");

        if (comando.equals("buscaProd")) {
            buscaProd(request, response);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bt1 = request.getParameter("btAlterar");
        String bt2 = request.getParameter("btExcluir");
        String bt3 = request.getParameter("btAdicionar");

        JDBCProdutosDao dao = new JDBCProdutosDao();
        Produtos prod = new Produtos();
        prod.setProdId(Integer.parseInt(request.getParameter("bId")));
        prod.setProdFilial(Integer.parseInt(request.getParameter("bFilial")));
        prod.setProdNome(request.getParameter("bNome"));
        prod.setProdAutor(request.getParameter("bAutor"));
        prod.setProdGenero(request.getParameter("bGenero"));
        prod.setProdQtd(Integer.parseInt(request.getParameter("bQtd")));
        prod.setProdVal(Double.parseDouble(request.getParameter("bVal")));
        prod.setProdDesc(request.getParameter("bDesc"));

        //request.getSession().setAttribute("prod", prod);
        if (bt1 != null) {
            dao.alterar(prod);
            response.sendRedirect("bootstrap/buscarProduto.jsp");
        } else if (bt2 != null) {
            dao.remover(Integer.parseInt(request.getParameter("bId")));
            response.sendRedirect("bootstrap/buscarProduto.jsp");
        } else if (bt3 != null) {
            HttpSession session = request.getSession();

            Vector carrinho = (Vector) session.getAttribute("carrinho");

            if (carrinho == null) {
                carrinho = new Vector();
                session.setAttribute("carrinho", carrinho);
            }
            
            carrinho.add(prod);
            
           response.sendRedirect("bootstrap/venda.jsp");
        }
        //request.setAttribute("livro", resultadoPesquisa);
        //request.getServletContext().setAttribute("livro", resultadoPesquisa);
//        request.getRequestDispatcher("bootstrap/buscarProduto.jsp").forward(request, response);
        //response.sendRedirect("/bootstrap/buscarProduto.jsp");
        //response.sendRedirect(request.getContextPath() + "/bootstrap/buscarProduto.jsp");
    }

}
