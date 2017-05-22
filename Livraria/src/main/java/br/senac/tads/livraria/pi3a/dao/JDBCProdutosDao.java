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
import java.sql.Statement;
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

    public JDBCProdutosDao() {
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
                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, produto.getProdFilial());
            ps.setString(2, produto.getProdNome());
            ps.setString(3, produto.getProdAutor());
            ps.setString(4, produto.getProdGenero());
            ps.setInt(5, produto.getProdQtd());
            ps.setDouble(6, produto.getProdValCompra());
            ps.setDouble(7, produto.getProdValVenda());
            ps.setString(8, produto.getProdDesc());

            ps.executeUpdate();

            ps.close();
            //conecta.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException ("Erro ao incluir um novo registro de produtos JDBCProdutosDao");
        }
    }
 
    @Override
    public void remover(int id) {
        try {
            String sql = "DELETE FROM PRODUTOS WHERE PRODID= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException ("Erro ao deletar registro de produtos JDBCProdutosDao");
        }
        
    }

    @Override
    public List<Produtos> listar() {
        List<Produtos> produtos = new ArrayList<Produtos>();
        try {
            String sql = "SELECT * FROM PRODUTOS";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                //produto.setIdProd(rs.getInt("PRODID"));
                produto.setProdFilial(rs.getInt("PRODFILIAL"));
                produto.setProdNome(rs.getString("PRODNOME"));
                produto.setProdAutor(rs.getString("PRODAUTOR"));
                produto.setProdGenero(rs.getString("PRODGENERO"));
                produto.setProdQtd(rs.getInt("PRODQTD"));
                produto.setProdValCompra(rs.getDouble("PRODVALCOMPRA"));
                produto.setProdValVenda(rs.getDouble("PRODVALVENDA"));
                produto.setProdDesc(rs.getString("PRODDESC"));
                produtos.add(produto);
                
                ps.close();
                rs.close();
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar Produtos em JDBCProdutosDao");
        }

    }

    @Override
    public Produtos buscar(String produto, String autor) {
        try {
            Produtos p = new Produtos();
            String sql = "SELECT * FROM PRODUTOS WHERE PRODNOME = ? OR PRODAUTOR = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, produto);
            ps.setString(2, autor);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            //p.setIdProd(rs.getInt("PRODID"));
            p.setProdFilial(rs.getInt("PRODFILIAL"));
            p.setProdNome(rs.getString("PRODNOME"));
            p.setProdAutor(rs.getString("PRODAUTOR"));
            p.setProdGenero(rs.getString("PRODGENERO"));
            p.setProdQtd(rs.getInt("PRODQTD"));
            p.setProdValCompra(rs.getDouble("PRODVALCOMPRA"));
            p.setProdValVenda(rs.getDouble("PRODVALVENDA"));
            p.setProdDesc(rs.getString("PRODDESC"));
            
            ps.close();
            rs.close();
            
            return p;
                        
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar registro de produtos JDBCProdutosDao");
        }
        
    }

    @Override
    public void alterar(Produtos produto) {
        try {
            String sql = "UPDATE PRODUTOS SET PRODFILIAL=?,PRODNOME=?,PRODAUTOR=?,"
                    +"PRODGENERO=?,PRODQTD=?,PRODVALCOMPRA=?,PRODVALVENDA=?,PRODDESC=? WHERE PRODID=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, produto.getProdFilial());
            ps.setString(2, produto.getProdNome());
            ps.setString(3, produto.getProdAutor());
            ps.setString(4, produto.getProdGenero());
            ps.setInt(5, produto.getProdQtd());
            ps.setDouble(6, produto.getProdValCompra());
            ps.setDouble(7, produto.getProdValVenda());
            ps.setString(8, produto.getProdDesc());
            //ps.setInt(9, produto.getId());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao atualizar o registro de produtos JDBCProdutosDao");
        }
    }

}
