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
public class JDBCProdutosDao extends ConexaoBD implements ProdutosDao{

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

    public void inserir(Produtos produto) {
        try {

            String sql = "INSERT INTO PRODUTOS (PRODFILIAL, PRODNOME, PRODAUTOR, PRODGENERO, PRODQTD, PRODVALCOMPRA, PRODVALVENDA, PRODDESC) VALUES"
                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, produto.getFilialProd());
            ps.setString(2, produto.getNomeProd());
            ps.setString(3, produto.getAutorProd());
            ps.setString(4, produto.getGeneroProd());
            ps.setInt(5, produto.getQtdProd());
            ps.setDouble(6, produto.getValCompraProd());
            ps.setDouble(7, produto.getValVendaProd());
            ps.setString(8, produto.getDescProd());

            ps.executeUpdate();

            ps.close();
            //conecta.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao incluir um novo registro de produtos JDBCProdutosDao");
        }
    }

    public void remover(int id) {
        try {
            String sql = "DELETE FROM PRODUTOS WHERE PRODID= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao deletar registro de produtos JDBCProdutosDao");
        }

    }

    public List<Produtos> listar() {
        List<Produtos> produtos = new ArrayList<Produtos>();
        try {
            String sql = "SELECT * FROM PRODUTOS";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos();
                //produto.setIdProd(rs.getInt("PRODID"));
                produto.setFilialProd(rs.getInt("PRODFILIAL"));
                produto.setNomeProd(rs.getString("PRODNOME"));
                produto.setAutorProd(rs.getString("PRODAUTOR"));
                produto.setGeneroProd(rs.getString("PRODGENERO"));
                produto.setQtdProd(rs.getInt("PRODQTD"));
                produto.setValCompraProd(rs.getDouble("PRODVALCOMPRA"));
                produto.setValVendaProd(rs.getDouble("PRODVALVENDA"));
                produto.setDescProd(rs.getString("PRODDESC"));
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

    public Produtos buscar(String produto, String autor)  {

        // String sql = "SELECT * FROM produtos WHERE id_produtos = " + id + " AND deletado_produtos = false";
        String sql = "SELECT * FROM PRODUTOS WHERE nome_prod = ?";

        try (
                //Cria um statement para executar as instruções SQL
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, produto);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet rs = ps.executeQuery();

            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (rs.next()) {
                Produtos produtos = new Produtos();

                produtos.setIdProd(rs.getInt("PRODID"));
                produtos.setFilialProd(rs.getInt("PRODFILIAL"));
                produtos.setNomeProd(rs.getString("PRODNOME"));
                produtos.setGeneroProd(rs.getString("PRODGENERO"));
                produtos.setAutorProd(rs.getString("PRODAUTOR"));
                produtos.setQtdProd(rs.getInt("PRODQTD"));
                produtos.setValCompraProd(rs.getDouble("PRODVALCOMPRA"));
                produtos.setValVendaProd(rs.getInt("PRODVALVENDA"));
                produtos.setDescProd(rs.getString("PRODDESC"));

                return produtos;

            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar registro de produtos JDBCProdutosDao");
        }
        return null;
    }
        

//        try {
//            Produtos p = new Produtos();
//            String sql = "SELECT * FROM PRODUTOS WHERE PRODNOME = ? OR PRODAUTOR = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            
//            ps.setString(1, produto);
//            ps.setString(2, autor);
//            ResultSet rs = ps.executeQuery();
//            
//            rs.next();
//            
//            //p.setIdProd(rs.getInt("PRODID"));
//            p.setFilialProd(rs.getInt("PRODFILIAL"));
//            p.setNomeProd(rs.getString("PRODNOME"));
//            p.setAutorProd(rs.getString("PRODAUTOR"));
//            p.setGeneroProd(rs.getString("PRODGENERO"));
//            p.setQtdProd(rs.getInt("PRODQTD"));
//            p.setValCompraProd(rs.getDouble("PRODVALCOMPRA"));
//            p.setValVendaProd(rs.getDouble("PRODVALVENDA"));
//            p.setDescProd(rs.getString("PRODDESC"));
//            
//            ps.close();
//            rs.close();
//            
//            return p;
//                        
//        } catch (SQLException ex) {
//            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("Erro ao buscar registro de produtos JDBCProdutosDao");
//        }
//        
    

    public void alterar(Produtos produto) {
        try {
            String sql = "UPDATE PRODUTOS SET PRODFILIAL=?,PRODNOME=?,PRODAUTOR=?,"
                    + "PRODGENERO=?,PRODQTD=?,PRODVALCOMPRA=?,PRODVALVENDA=?,PRODDESC=? WHERE PRODID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, produto.getFilialProd());
            ps.setString(2, produto.getNomeProd());
            ps.setString(3, produto.getAutorProd());
            ps.setString(4, produto.getGeneroProd());
            ps.setInt(5, produto.getQtdProd());
            ps.setDouble(6, produto.getValCompraProd());
            ps.setDouble(7, produto.getValVendaProd());
            ps.setString(8, produto.getDescProd());
            //ps.setInt(9, produto.getId());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCProdutosDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao atualizar o registro de produtos JDBCProdutosDao");
        }
    }

}
