package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.UsuarioDAO;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Usuario.jsp");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("Usuario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");        
        String email = request.getParameter("email");
        String fixo = request.getParameter("fixo");
        
        

        // Cria um novo contato e salva
        // através do DAO
        Usuario novo = new Usuario(nome,email,fixo);
        UsuarioDAO dao = new UsuarioDAO();
        dao.incluirComTransacao(novo);

        // Usa a sessao para manter os dados após
        // redirect (técnica POST-REDIRECT-GET),
        // usado para evitar dupla submissão dos
        // dados
        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoUsuario", novo);
        response.sendRedirect("resultado.jsp");

//        try {
//
//            String nome = null;
//            String email = null;
//            Integer fixo = 0;
//
////            String nome = request.getParameter("nome");
////            String email = request.getParameter("email");
////            Integer fixo = Integer.parseInt(request.getParameter("fixo"));
//
//            //Verificando se as informações existem no formulario
//            if (request.getParameter("nome") != null && !request.getParameter("nome").isEmpty()) {
//                nome = request.getParameter("nome");
//            }
//            if (request.getParameter("email") != null && !request.getParameter("email").isEmpty()) {
//                email = request.getParameter("email");
//            }
//            if (request.getParameter("fixo") !=null && !request.getParameter("fixo").isEmpty()) {
//                fixo = Integer.parseInt(request.getParameter("fixo"));
//            }
//
//            if (nome.equals(null) || email.equals(null) || fixo == 0) {
//                request.setAttribute("resultado", "Preencha os campos acima!");
//                request.getRequestDispatcher("resultado.jsp").forward(request, response);// Caso ocorra erro será direcionado para pagina resultado
//            } else {
//                new ContatoDB().cadastrar(nome, email, fixo);
//                request.setAttribute("resultado", "Usuário Cadastrado!");
//                request.getRequestDispatcher("resultado.jsp").forward(request, response);// Caso ocorra erro será direcionado para pagina resultado
//            }
//
//        } finally {
//
//        }
//
    }
}
