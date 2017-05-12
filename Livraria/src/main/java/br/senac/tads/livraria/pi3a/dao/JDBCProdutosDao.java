/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;


//import br.senac.tads.livraria.pi3a.connection.ConnectionFectory;
import br.senac.tads.livraria.pi3a.connection.ConexaoBD;
import br.senac.tads.livraria.pi3a.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcus
 */
public class JDBCProdutosDao extends ConexaoBD implements ProdutosDao {
    
     Connection conn = null;
    
    public JDBCProdutosDao(){
         try { 
             conn = obterConexao();
//        conecta = ConnectionFectory.conecta();
//             
         } catch (SQLException ex) {
             Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    @Override
    public void inserir(Produtos produto) {
        try {

            String sql = "INSERT INTO PRODUTOS (PRODFILIAL, PRODNOME, PRODAUTOR, PRODGENERO, PRODQTD, PRODVALCOMPRA, PRODVALVENDA, PRODDESC) VALUES"
                    +"(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Produtos.getFilialProd());
            ps.setString(2, Produtos.getNomeProd());
            ps.setString(2, Produtos.getAutorProd());
            ps.setString(3, Produtos.getGeneroProd());
            ps.setInt(4, Produtos.getQtdProd());
            ps.setDouble(5, Produtos.getValCompraProd());
            ps.setDouble(6, Produtos.getValVendaProd());
            ps.setString(7, Produtos.getDescProd());
            
            ps.executeUpdate();
            
            ps.close();
            //conecta.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Integer id) {
     String sql = "DELETE FROM PRODUTOS WHERE PRODID = (?)";
     
        
    }

    @Override
    public List<Produtos> listar() {
         List<Produtos> produtos = new ArrayList<Produtos>();
         try {
             String sql = "SELECT * FROM PRODUTOS";
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Produtos produto = new Produtos();
                 produto.setIdProd(rs.getInt("PRODID"));
                 produto.setFilialProd(rs.getInt("PRODFILIAL"));
                 produto.setNomeProd(rs.getString("PRODNOME"));
                 produto.setAutorProd(rs.getString("PRODAUTOR"));
                 produto.setGeneroProd(rs.getString("PRODGENERO"));
                 produto.setQtdProd(rs.getInt("PRODQTD"));
                 produto.setValCompraProd(rs.getDouble("PRODVALCOMPRA"));
                 produto.setValVendaProd(rs.getDouble("PRODVALVENDA"));
                 produto.setDescProd(rs.getString("PRODDESC"));
                 produtos.add(produto);
             }
             return produtos;
         } catch (SQLException ex) {
             Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Erro ao Listar Produtos em JDBCProdutosDao");
         }
         
    }

    @Override
    public Produtos buscar(String produto, String Autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Produtos produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
