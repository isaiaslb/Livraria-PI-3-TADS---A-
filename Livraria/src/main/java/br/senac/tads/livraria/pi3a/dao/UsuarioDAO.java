/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;

import br.senac.tads.livraria.pi3a.connection.ConexaoBD;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernanda
 */
//public interface UsuarioDAO {
//    public void inserir(Usuario usuario);
//    
//}
public class UsuarioDAO extends ConexaoBD {

  public Usuario obterContato(int idUsuario) {
    PreparedStatement stmt = null;
    Connection conn = null;
    Usuario p = null;

//    String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL "
//	    + "FROM TB_CONTATO WHERE ID_CONTATO = ?";
    
    String sql = "SELECT cod_user, nome, email, fixo" + "FROM bdlivraria WHERE cod_user = ?";
    
    try {
      conn = obterConexao();
      stmt = conn.prepareStatement(sql);
      stmt.setLong(1, idUsuario);
      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {
	int id = resultados.getInt("cod_user");
	String nome = resultados.getString("nome");
	//Date dataNasc = resultados.getDate("DT_NASCIMENTO");
        String email = resultados.getString("email");
        String fixo = resultados.getString("fixo");
	
	
	p = new Usuario(nome, email,fixo);
	break;
      }
    } catch (SQLException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      // Código colocado aqui para garantir que a conexão com o banco
      // seja sempre fechada, independentemente se executado com sucesso
      // ou erro.
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return p;
  }

  public List<Usuario> listar() {
    Statement stmt = null;
    Connection conn = null;

//    String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL "
//	    + "FROM TB_CONTATO";

    String sql = "SELECT cod_user, nome, email,fixo " + "FROM bdlivraria";

    List<Usuario> lista = new ArrayList<Usuario>();
    try {
      conn = obterConexao();
      stmt = conn.createStatement();
      ResultSet resultados = stmt.executeQuery(sql);

     // DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

      while (resultados.next()) {
	int id = resultados.getInt("cod_user");
	String nome = resultados.getString("nome");        
	String email = resultados.getString("email");
        String fixo = resultados.getString("fixo");
        //Date dataNasc = resultados.getDate("DT_NASCIMENTO");
//                System.out.println(String.valueOf(id) + ", " + nome + ", "
//                        + formatadorData.format(dataNasc) + ", " + email + ", "
//                        + telefone);
	Usuario usuario = new Usuario(id, nome, email,fixo);
	lista.add(usuario);
      }

    } catch (SQLException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      // Código colocado aqui para garantir que a conexão com o banco
      // seja sempre fechada, independentemente se executado com sucesso
      // ou erro.
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return lista;
  }

  // http://stackoverflow.com/questions/17459094/getting-id-after-insert-within-a-transaction-oracle
  // http://www.mkyong.com/jdbc/jdbc-transaction-example/
  public void incluirComTransacao(Usuario usuario) {
    PreparedStatement stmt = null;
    Connection conn = null;

//    String sql = "INSERT INTO TB_CONTATO "
//	    + "(NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) "
//	    + "VALUES (?, ?, ?, ?, ?)";
    
    String sql = "INSERT INTO usuario (nome, email,fixo) values(?,?,?)";
    try {
      conn = obterConexao();

      conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, usuario.getNome());      
      stmt.setString(2, usuario.getEmail());
      stmt.setString(3, usuario.getFixo());
      //stmt.setDate(2, new java.sql.Date(usuario.getDtNascimento().getTime()));
      //stmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));

      stmt.execute();

      // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
      // Neste exemplo, o ID é gerado automaticamente.
      ResultSet generatedKeys = stmt.getGeneratedKeys();
      if (generatedKeys.next()) {
	int idNovo = generatedKeys.getInt(1);
	usuario.setId(idNovo);
	System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));

	// Executar próximos INSERTs USANDO O ID novo.
      }
      conn.commit();
    } catch (SQLException ex) {
      try {
	// Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
	if (conn != null & !conn.isClosed()) {
	  conn.rollback();
	}
      } catch (SQLException ex1) {
	Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      try {
	// Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
	if (conn != null & !conn.isClosed()) {
	  conn.rollback();
	}
      } catch (SQLException ex1) {
	Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public void incluir(Usuario usuario) {
    PreparedStatement stmt = null;
    Connection conn = null;

//    String sql = "INSERT INTO TB_CONTATO "
//	    + "(NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) "
//	    + "VALUES (?, ?, ?, ?, ?)";
    
    String sql = "INSERT INTO usuario (nome, email, fixo) values(?,?,?)";
    
    try {
      conn = obterConexao();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario.getNome());
      //stmt.setDate(2, new java.sql.Date(usuario.getDtNascimento().getTime()));
      stmt.setString(2, usuario.getEmail());
      stmt.setString(3, usuario.getFixo());      
      //stmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
      stmt.executeUpdate();
      //System.out.println("Registro incluido com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

}

