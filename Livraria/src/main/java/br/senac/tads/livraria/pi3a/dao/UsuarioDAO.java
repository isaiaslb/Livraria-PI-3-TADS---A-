package br.senac.tads.livraria.pi3a.dao;

import br.senac.tads.livraria.pi3a.connection.ConexaoBD;
import br.senac.tads.livraria.pi3a.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaias
 */
public class UsuarioDAO extends ConexaoBD {

    public Usuario obterUsuario(String idUsuario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Usuario p = new Usuario();

        String sql = "SELECT * FROM usuario where cpf = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            System.out.println(idUsuario);
            stmt.setString(1, idUsuario);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                p.setId(resultados.getInt("cod_user"));
                p.setNome(resultados.getString("nome"));
                p.setCpf(resultados.getString("cpf"));
                p.setDataNasc(resultados.getDate("dtNasc"));
                p.setSexo(resultados.getString("sexo"));
                p.setEmail(resultados.getString("email"));
                p.setTelefone(resultados.getString("fixo"));
                p.setCelular(resultados.getString("cel"));
                p.setSetor(resultados.getString("setor"));               
                p.setSenha(resultados.getString("senha")); 
                p.setTipoAcesso(resultados.getString("tpAcesso"));
                p.setTipoEmpresa(resultados.getString("tpempresa"));

            }
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
        return p;
    }
    public void alterar(Usuario usuario){
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "UPDATE usuario SET nome=?, email=?, fixo=?, enabled=true, cel=?, setor=?,"
                + "sexo=?, senha=?, tp_acesso=?,empresa = ?, cpf=? "
                + "WHERE cod_user=?";
        try {
            conn = obterConexao();

             stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getCelular());
            stmt.setString(5, usuario.getSetor());
            stmt.setString(6, usuario.getSexo());
            stmt.setString(7, usuario.getSenha());
            stmt.setString(8, usuario.getTipoAcesso());            
            stmt.setString(9, usuario.getTipoEmpresa());            
            stmt.setString(10, usuario.getCpf());            
            stmt.setInt(11, usuario.getId());

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
    public List<Usuario> listar() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT cod_user, nome, email, fixo, cel, setor, sexo, senha, tp_acesso,empresa , dtnasc, cpf"
                + "FROM bdlivraria";

        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("cod_user");
                String nome = resultados.getString("nome");
                String cpf = resultados.getString("cpf");
                String sexo = resultados.getString("sexo");
                String email = resultados.getString("email");
                String fixo = resultados.getString("telefone");
                String cel = resultados.getString("celular");
                String setor = resultados.getString("setor");
                String senha = resultados.getString("senha");
                String tipoAcesso = resultados.getString("tipoAcesso");
                String tipoEmpresa = resultados.getString("tipoEmpresa");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataNasc = null;

                // Cria um novo contato e salva
                // através do DAO
                Usuario usuario = new Usuario(nome, cpf, email, fixo, cel, setor, sexo, senha, tipoAcesso,tipoEmpresa, dataNasc);

                lista.add(usuario);
            }

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
        return lista;
    }
    public void incluirComTransacao(Usuario usuario) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO usuario (nome,"
                + "email, fixo, cel, setor, sexo, senha, tp_acesso,empresa , dtnasc, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();

            conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getCelular());
            stmt.setString(5, usuario.getSetor());
            stmt.setString(6, usuario.getSexo());
            stmt.setString(7, usuario.getSenha());
            stmt.setString(8, usuario.getTipoAcesso());
            stmt.setString(9, usuario.getTipoEmpresa());
            stmt.setDate(10, (java.sql.Date) usuario.getDataNasc());
            stmt.setString(11, usuario.getCpf());
            stmt.execute();

            // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
            // Neste exemplo, o ID é gerado automaticamente.
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idNovo = generatedKeys.getInt(1);
                usuario.setId(idNovo);
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

        String sql = "INSERT INTO usuario (nome,"
                + "email, fixo, cel, setor, sexo, senha, tp_acesso,empresa ,dtnasc,cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getCelular());
            stmt.setString(5, usuario.getSetor());
            stmt.setString(6, usuario.getSexo());
            stmt.setString(7, usuario.getSenha());
            stmt.setString(8, usuario.getTipoAcesso());
            stmt.setString(9, usuario.getTipoEmpresa());
            stmt.setDate(10, (java.sql.Date) usuario.getDataNasc());

            stmt.executeUpdate();

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
    public Usuario autenticacao(Usuario usuario) throws ClassNotFoundException {
        Usuario usuRetorno = null;
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

        try {
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                usuRetorno = new Usuario();
                usuRetorno.setId(resultado.getInt("cod_user"));
                usuRetorno.setNome(resultado.getString("nome"));
                usuRetorno.setSenha(resultado.getString("senha"));
                usuRetorno.setTipoAcesso(resultado.getString("tp_acesso"));
                usuRetorno.setTipoEmpresa(resultado.getString("empresa"));

            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuRetorno;
    }
}