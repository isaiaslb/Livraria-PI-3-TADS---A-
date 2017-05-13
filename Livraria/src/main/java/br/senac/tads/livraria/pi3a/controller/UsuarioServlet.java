package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.UsuarioDAO;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Usuario.jsp");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/usuario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");        
        
        String sexo = request.getParameter("sexo");
        String email = request.getParameter("email");
        String fixo = request.getParameter("telefone");
        String cel = request.getParameter("celular");
        String setor = request.getParameter("setor");
        String senha = request.getParameter("senha");
        String tipoAcesso = request.getParameter("tipoAcesso");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc;
        
        try {
            dataNasc = sdf.parse(request.getParameter("dataNasc"));
            Usuario novo = new Usuario(nome, email, fixo, cel, setor, sexo, senha, tipoAcesso, dataNasc);
            UsuarioDAO dao = new UsuarioDAO();
            dao.incluirComTransacao(novo);
            
            HttpSession sessao = request.getSession();
        sessao.setAttribute("novoUsuario", novo);
        response.sendRedirect("resultado.jsp");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


        

        // Cria um novo contato e salva
        // através do DAO
       

        // Usa a sessao para manter os dados após
        // redirect (técnica POST-REDIRECT-GET),
        // usado para evitar dupla submissão dos
        // dados
        

    }
}