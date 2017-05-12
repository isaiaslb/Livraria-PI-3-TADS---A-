//package br.senac.tads.livraria.pi3a.connection;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// *
// * @author Fernanda
// */
//public class ContatoDB {
//
//    private PreparedStatement select;
//    private PreparedStatement update;
//    private ResultSet rs;
//    private final ConnectionFectory con;
//    
//    //abrindo conexao ao banco quando class for estanciada
//    public ContatoDB(){
//        con = new ConnectionFectory();
//    }
//    
//    public int cadastrar(String nome,String email,Integer fixo){
//        int res = 0;
//        try{
//            if(con.getCon()==null)
//                con.conecta();
//            
//            String sql = "INSERT INTO usuario (nome,email,fixo) values(?,?,?)";
//        
//            update = con.getCon().prepareStatement(sql);
//            update.setString(1,nome);
//            update.setString(2,email);
//            update.setInt(3,fixo);
//            
//            res = update.executeUpdate();
//            
//            update.close();
//            con.closeConnection();
//            
//        }catch (SQLException ex) {
//            System.out.println(" Erro: " + ex.getMessage());
//        }
//        return res;        
//    }
    
//    public int cadastrar(String nome,String dtnasc,String sexo,String email,String cel,
//                          String fixo,String setor,String acesso,String senha){
//        int res = 0;
//        try{
//            if(con.getCon()==null)
//                con.conecta();
//            String sql = "insert into usuario (NOME, DTNASC, SEXO, EMAIL, CEL, FIXO, SETOR, TP_ACESSO, SENHA) values(?,?,?,?,?,?,?,?,?)";
//        
//            update = con.getCon().prepareStatement(sql);
//            update.setString(1,nome);
//            update.setString(2,dtnasc);
//            update.setString(3,sexo);
//            update.setString(4,email);
//            update.setString(5,cel);
//            update.setString(6,fixo);
//            update.setString(7,setor);
//            update.setString(8,acesso);
//            update.setString(9,senha);
//            
//            res = update.executeUpdate();
//            
//            update.close();
//            con.closeConnection();
//            
//        }catch (SQLException ex) {
//            System.out.println(" Erro: " + ex.getMessage());
//        }
//        
//        
//        return res;        
//    }

//}
