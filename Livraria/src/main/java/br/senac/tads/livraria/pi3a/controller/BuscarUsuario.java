/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;


import br.senac.tads.livraria.pi3a.dao.UsuarioDAO;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "BuscarUsuario", urlPatterns = {"/buscarUsuario"})
public class BuscarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


//        String papel = request.getParameter("papel");
//        request.setAttribute("papelCliente", papel);
        String b = request.getParameter("buscarCpf");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario lista = dao.obterUsuario(b);

        request.setAttribute("listaUsuario", lista);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/buscarUsuario.jsp");
        dispatcher.forward(request, response);

        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAO usu = new UsuarioDAO();
        Usuario usuario = new Usuario();

        String bt1 = request.getParameter("btAlterar"); 
        String bt2 = request.getParameter("btExcluir"); 
        
        usuario.setCpf(request.getParameter("cpfBusca"));
        usuario.setNome(request.getParameter("nomeBusca"));        
        //usuario.setDataNasc(request.getParameter("dataNascBusca"));
        usuario.setSexo(request.getParameter("sexoBusca"));
        usuario.setEmail(request.getParameter("emailBusca"));
        usuario.setTelefone(request.getParameter("telefoneBusca"));
        usuario.setCelular(request.getParameter("celularBusca"));
        usuario.setSetor(request.getParameter("setorBusca"));
        usuario.setSenha(request.getParameter("senhaBusca"));
        usuario.setTipoAcesso(request.getParameter("tipoAcessoBusca"));
        
        if(bt1 != null){  
           usu.alterar(usuario);
        }else if(bt2 != null){
           usu.remover(request.getParameter("cpfBusca"));           
        }   
         
        
         request.getRequestDispatcher("bootstrap/buscarUsuario.jsp").forward(request, response);
        //response.sendRedirect("bootstrap/cliente.jsp");

    }

}
