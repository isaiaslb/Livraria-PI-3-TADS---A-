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
 * @author Douglas
 */
public class EmpresaDao extends ConexaoBD {

    public Empresa obterEmpresa(String idEmpresa) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Empresa p = new Empresa();

        String sql = "SELECT * FROM empresa where cnpj = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            System.out.println(idEmpresa);
            stmt.setString(1, idEmpresa);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                
               p.setRazao(resultados.getString("rz_social"));
                p.setCnpj(resultados.getString("cnpj"));
                p.setIe(resultados.getString("ins_estad"));
                p.setTelefone(resultados.getString("tel"));
                p.setEndereco(resultados.getString("endereco"));
                p.setNumero(resultados.getString("numero"));
                p.setComplemento(resultados.getString("complemento"));
                 p.setCep(resultados.getString("cep"));
                p.setBairro(resultados.getString("bairro"));
                p.setCidade(resultados.getString("cidade"));
                p.setEstado(resultados.getString("estado"));

//                p = new Cliente(nome, cpf, endereco, bairro, cep, estado, cel, email);
//                break;
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
        Connection conn = null;

       String sql = "SELECT cod_user, RZ_SOCIAL,CNPJ,INS_ESTAD,TEL,ENDERECO,NUMERO,COMPLEMENTO,CEP,BAIRRO,CIDADE,ESTADO"
                + "FROM bdlivraria";

        List<Empresa> lista = new ArrayList<Empresa>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("COD_EMP");
                String razao = resultados.getString("RZ_SOCIAL");
                String cnpj = resultados.getString("cnpj");
                String ie = resultados.getString("INS_ESTAD");
                String telefone = resultados.getString("tel");
                String endereco = resultados.getString("endereco");
                String numero = resultados.getString("numero");
                String complemento = resultados.getString("complemento");
                String cep = resultados.getString("cep");
                String bairro = resultados.getString("bairro");
                String cidade = resultados.getString("cidade");
                String estado = resultados.getString("Estado");

               
                Empresa empresa = new Empresa(id, razao, cnpj, ie, telefone, endereco, numero, complemento, cep, bairro, cidade, estado);
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
 
       public void atualizar(Empresa empresa) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE Empresa SET rz_social=?,"
                + "ins_estad=?, tel=?, endereco=?, numero=?, complemento=?, cep=?,bairro=?,cidade=?,estado=? "
                + "WHERE cnpj=?";
        try {
            conn = obterConexao();

             stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresa.getRazao());
            stmt.setString(2, empresa.getIe());
            stmt.setString(3, empresa.getTelefone());
            stmt.setString(4, empresa.getNumero());
            stmt.setString(5, empresa.getComplemento());
            stmt.setString(6, empresa.getCep());
            stmt.setString(7, empresa.getBairro());
            stmt.setString(8, empresa.getCidade());
            stmt.setString(9, empresa.getEstado());
            stmt.setString(10, empresa.getEstado());
            stmt.setString(11, empresa.getCnpj());

            stmt.executeUpdate();

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
    
    
    public void incluirComTransacao(Empresa empresa) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO EMPRESA (RZ_SOCIAL,CNPJ,INS_ESTAD,TEL,ENDERECO,NUMERO,COMPLEMENTO,CEP,BAIRRO,CIDADE,ESTADO) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, empresa.getRazao());
            stmt.setString(2, empresa.getCnpj());
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
        Connection conn = null;

        String sql = "INSERT INTO EMPRESA (RZ_SOCIAL,CNPJ,INS_ESTAD,TEL,ENDERECO,NUMERO,COMPLEMENTO,CEP,BAIRRO,CIDADE,ESTADO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
             stmt = conn.prepareStatement(sql);
            stmt.setString(1, empresa.getRazao());
            stmt.setString(2, empresa.getCnpj());
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
}
