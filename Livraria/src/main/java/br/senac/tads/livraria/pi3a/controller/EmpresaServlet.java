/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.dao.EmpresaDao;
import br.senac.tads.livraria.pi3a.model.Empresa;
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
 * @author Antonio
 */
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/EmpresaServlet"})
public class EmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Usuario.jsp");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("Empresa.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String razao = request.getParameter("RZ_SOCIAL");
        String cnpj = request.getParameter("cnpj");
        String ie = request.getParameter("INS_ESTAD");
        String telefone = request.getParameter("tel");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        // Cria um novo contato e salva
        // através do DAO
        Empresa nova = new Empresa(razao,cnpj,ie,telefone,endereco,numero,complemento,cep,bairro,cidade,estado);
        EmpresaDao dao = new EmpresaDao();
        dao.incluirComTransacao(nova);

        // Usa a sessao para manter os dados após
        // redirect (técnica POST-REDIRECT-GET),
        // usado para evitar dupla submissão dos
        // dados
        HttpSession sessao = request.getSession();
        sessao.setAttribute("novaEmpresa", nova);
        response.sendRedirect("bootstrap/empresa.jsp");

    }
}
