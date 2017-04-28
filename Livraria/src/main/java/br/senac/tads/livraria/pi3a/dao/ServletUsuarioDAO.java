/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;

import br.senac.tads.livraria.pi3a.connection.ConnectionFectory;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.sql.Connection;

/**
 *
 * @author Fernanda
 */
public class ServletUsuarioDAO implements UsuarioDAO{
    
    Connection connection;
    
    public ServletUsuarioDAO(){
        connection = ConnectionFectory.getConnection();
    }

    @Override
    public void inserir(Usuario usuario) {
        String SQL = "INSERT INTO ";
    }
    
}
