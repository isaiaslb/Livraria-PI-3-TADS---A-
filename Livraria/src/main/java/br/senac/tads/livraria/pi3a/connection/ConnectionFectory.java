/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.connection;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernanda
 */


public class ConnectionFectory {
    public static Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/BDLivraria","root"," ");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFectory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQLException ao abrir conexão em ConnectionFectory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFectory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ClassNotFoundException em ConnectionFectory", ex);
        }
    }
}

