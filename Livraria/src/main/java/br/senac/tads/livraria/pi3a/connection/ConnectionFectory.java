///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.senac.tads.livraria.pi3a.connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// *
// * @author Fernanda
// */
//public final class ConnectionFectory {
//
//    private Connection con;
//    private final String url = "jdbc:mysql://localhost:3306/bdlivraria";
//    private final String usr = "root";
//    private final String pass = "";
//
//    public ConnectionFectory() {
//        conecta();
//    }
//
//    public Connection conecta() {
//        con = null; //informando que a conexão não esta vazia
//        try {
//            Class.forName("com.mysql.jdbc.Driver"); //estanciando o drive de conexão com o banco
//            System.out.println("Conexão com Banco de Dados estabelecida");
//            con = DriverManager.getConnection(url, usr, pass);
//        } catch (SQLException sqle) {
//            System.out.println("Erro SQLException ao abrir conexão em ConnectionFectory" + sqle.getMessage());
//        } catch (ClassNotFoundException cnfe) {
//            System.out.println("Erro ClassNotFoundException em ConnectionFectory" + cnfe.getMessage());
//        }
//
//        return con;
//    }
//
//    public void closeConnection() {
//
//        try {
//            if (con != null) {
//                con.close();
//                System.out.println("Conexão com Banco de Dados encerrada");
//            }
//
//        } catch (SQLException sqle) {
//            System.out.println(" Erro ao Fechar Conexão com Banco de Dados: \n " + sqle.getMessage());
//        }
//    }
//
//    //metodo para obter os dados da conexão sem ter que abrir e fechar o tempo todo novas conexões
//    public Connection getCon() {
//        return con;
//    }
//
//}
