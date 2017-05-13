/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;

import br.senac.tads.livraria.pi3a.connection.ConexaoBD;
import br.senac.tads.livraria.pi3a.model.Empresa;
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
 * @author Antonio
 */
public class EmpresaDao extends ConexaoBD {

    Connection conn = null;
    public Empresa obterContato(int idEmpresa) {
        PreparedStatement stmt = null;
        
        Empresa p = null;

        String sql = "SELECT cnpj, razao, ie, telefone, end, numero, complemento, cep,bairro,cidade,estado"
                + "FROM bdlivraria WHERE cod_user = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, idEmpresa);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("COD_EMP");
                String cnpj = resultados.getString("cnpj");
                String razao = resultados.getString("razao");
                String ie = resultados.getString("ie");
                String telefone = resultados.getString("telefone");
                String end = resultados.getString("endereco");
                String numero = resultados.getString("numero");
                String complemento = resultados.getString("complemento");
                String cep = resultados.getString("cep");
                String bairro = resultados.getString("bairro");
                String cidade = resultados.getString("cidade");
                String estado = resultados.getString("Estado");
                
                p = new Empresa(cnpj, razao, ie, telefone, end, numero, complemento, cep,bairro,cidade,estado);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return p;
    }
    
    
    

    public List<Empresa> listar() {
        Statement stmt = null;
     

        String sql = "SELECT cod_user, cnpj, razao, ie, telefone, end, numero, complemento, cep,bairro,cidade,estado"
                + "FROM bdlivraria";

        List<Empresa> lista = new ArrayList<Empresa>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("COD_EMP");
                String cnpj = resultados.getString("cnpj");
                String razao = resultados.getString("razao");
                String ie = resultados.getString("ie");
                String telefone = resultados.getString("telefone");
                String end = resultados.getString("endereco");
                String numero = resultados.getString("numero");
                String complemento = resultados.getString("complemento");
                String cep = resultados.getString("cep");
                String bairro = resultados.getString("bairro");
                String cidade = resultados.getString("cidade");
                String estado = resultados.getString("Estado");

                Empresa empresa = new Empresa(id, cnpj, razao, ie, telefone, end, numero, complemento, cep,bairro,cidade,estado);
                lista.add(empresa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }

    // http://stackoverflow.com/questions/17459094/getting-id-after-insert-within-a-transaction-oracle
    // http://www.mkyong.com/jdbc/jdbc-transaction-example/
    public void incluirComTransacao(Empresa empresa) {
        PreparedStatement stmt = null;
        

        String sql = "INSERT INTO EMPRESA (cnpj, razao, ie, telefone, end, numero, complemento, cep,bairro,cidade,estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, empresa.getCnpj());
            stmt.setString(2, empresa.getRazao());
            stmt.setString(3, empresa.getIe());
            stmt.setString(4, empresa.getTelefone());
            stmt.setString(5, empresa.getEndereco());
            stmt.setString(6, empresa.getNumero());
            stmt.setString(7, empresa.getComplemento());
            stmt.setString(8, empresa.getCep());
            stmt.setString(9, empresa.getBairro());
            stmt.setString(10, empresa.getCidade());
            stmt.setString(11, empresa.getEstado());

            stmt.execute();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                empresa.setId(idNovo);
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
                Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            try {
                // Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
                if (conn != null & !conn.isClosed()) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    

    public void incluir(Empresa empresa) {
        PreparedStatement stmt = null;
     

        String sql = "INSERT INTO EMPRESA (cnpj, razao, ie, telefone, end, numero, complemento, cep,bairro,cidade,estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresa.getCnpj());
            stmt.setString(2, empresa.getRazao());
            stmt.setString(3, empresa.getIe());
            stmt.setString(4, empresa.getTelefone());
            stmt.setString(5, empresa.getEndereco());
            stmt.setString(6, empresa.getNumero());
            stmt.setString(7, empresa.getComplemento());
            stmt.setString(8, empresa.getCep());
            stmt.setString(9, empresa.getBairro());
            stmt.setString(10, empresa.getCidade());
            stmt.setString(11, empresa.getEstado());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void remover(int id) {
        try {
            String sql = "DELETE FROM EMPRESA WHERE COD_EMP= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException ("Erro ao deletar registro de Empresa EmpresaDao");
        }
        
    }
}
