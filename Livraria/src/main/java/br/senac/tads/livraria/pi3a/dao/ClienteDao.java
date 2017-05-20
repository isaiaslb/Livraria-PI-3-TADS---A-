/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;

import br.senac.tads.livraria.pi3a.connection.ConexaoBD;
import br.senac.tads.livraria.pi3a.model.Cliente;
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
 * @author Douglas
 */
public class ClienteDao extends ConexaoBD {

    public Cliente obterCliente(String idCliente) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Cliente p = new Cliente();

        String sql = "SELECT * FROM cliente where cpf = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            System.out.println(idCliente);
            stmt.setString(1, idCliente);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
//                int id = resultados.getInt("COD_CLI");
//                String nome = resultados.getString("nome");
//                String cpf = resultados.getString("cpf");
//                String endereco = resultados.getString("endereco");
//                String bairro = resultados.getString("bairro");
//                String cep = resultados.getString("cep");
//                String estado = resultados.getString("estado");
//                String cel = resultados.getString("cel");
//                String email = resultados.getString("email");                
                //p.setId(resultados.getInt("cod_cli"));
                p.setNome(resultados.getString("nome"));
                p.setCpf(resultados.getString("cpf"));
                p.setEnd(resultados.getString("endereco"));
                p.setBairro(resultados.getString("bairro"));
                p.setCep(resultados.getString("cep"));
                p.setEstado(resultados.getString("estado"));
                p.setCel(resultados.getString("cel"));
                p.setEmail(resultados.getString("email"));

//                p = new Cliente(nome, cpf, endereco, bairro, cep, estado, cel, email);
//                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return p;
    }

    public List<Cliente> listar() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT cod_user, nome, cpf, endereco, bairro, cep, estado, cel, email"
                + "FROM bdlivraria";

        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("COD_CLI");
                String nome = resultados.getString("nome");
                String cpf = resultados.getString("cpf");
                String endereco = resultados.getString("endereco");
                String bairro = resultados.getString("bairro");
                String cep = resultados.getString("cep");
                String estado = resultados.getString("estado");
                String cel = resultados.getString("cel");
                String email = resultados.getString("email");

                Cliente cliente = new Cliente(id, nome, cpf, endereco, bairro, cep, estado, cel, email);
                lista.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    // http://stackoverflow.com/questions/17459094/getting-id-after-insert-within-a-transaction-oracle
    // http://www.mkyong.com/jdbc/jdbc-transaction-example/
    public void incluirComTransacao(Cliente cliente) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO CLIENTE (nome,"
                + "cpf, endereco, bairro, cep, estado, cel, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEnd());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCel());
            stmt.setString(8, cliente.getEmail());

            stmt.execute();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                cliente.setId(idNovo);
                System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));

            }
            conn.commit();
        } catch (SQLException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void incluir(Cliente cliente) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO CLIENTE (nome,"
                + "cpf, endereco, bairro, cep, estado, cel, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEnd());
            stmt.setString(4, cliente.getBairro());
            stmt.setString(5, cliente.getCep());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCel());
            stmt.setString(8, cliente.getEmail());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
