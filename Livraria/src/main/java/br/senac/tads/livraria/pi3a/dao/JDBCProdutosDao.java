/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;


import br.senac.tads.livraria.pi3a.connection.ConnectionFectory;
import br.senac.tads.livraria.pi3a.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcus
 */
public class JDBCProdutosDao implements ProdutosDao{
    
     Connection conecta;
    
    public JDBCProdutosDao(){
    
        conecta = ConnectionFectory.conecta();
             
    }
    @Override
    public void inserir(Produtos produto) {
        try {
            String sql = "INSERT INTO produtos (prodFilial, prodNome, prodAutor, prodGenero, prodQtd, prodValCompra, prodValVenda, prodDesc) VALUES"
                    +"(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conecta.prepareStatement(sql);
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
 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produtos> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
