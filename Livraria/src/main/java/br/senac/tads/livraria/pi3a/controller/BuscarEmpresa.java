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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "BuscarEmpresa", urlPatterns = {"/buscarEmpresa"})
public class BuscarEmpresa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String b = request.getParameter("buscarCnpj");

        EmpresaDao dao = new EmpresaDao();
        Empresa lista = dao.obterEmpresa(b);

        request.setAttribute("listaEmpresa", lista);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("bootstrap/buscarEmpresa.jsp");
        dispatcher.forward(request, response);

        try {
            dispatcher.forward(request, response);
        } catch (IOException ex) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpresaDao emp = new EmpresaDao();
        Empresa empresas = new Empresa();
 
         empresas.setRazao(request.getParameter("razaoBusca"));
        empresas.setIe(request.getParameter("ieBusca"));
        empresas.setTelefone(request.getParameter("telefoneBusca"));
        empresas.setEndereco(request.getParameter("enderecoBusca"));
        empresas.setNumero(request.getParameter("numeroBusca"));
        empresas.setComplemento(request.getParameter("complementoBusca"));
        empresas.setCep(request.getParameter("cepBusca"));
        empresas.setBairro(request.getParameter("bairroBusca"));
        empresas.setCidade(request.getParameter("cidadeBusca"));
        empresas.setEstado(request.getParameter("estadoBusca"));

        try {
            emp.atualizar(empresas);
        } catch (Exception ex) {

        }
        
        //response.sendRedirect("bootstrap/cliente.jsp");

    }

}
