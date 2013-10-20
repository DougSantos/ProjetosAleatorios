/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camadascomswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author professor
 */
public class ConexaoBd {

    Statement stmt;
    Connection conn;

    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarSqlServer();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Statement conectarPostGreSql() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String local = "localhost";
        String banco = "TeAmoMelo";
        String usuario = "postgres";
        String senha = "123456";
        conn = DriverManager.getConnection("jdbc:postgresql://"
                + local + "/" + banco
                + "?charSet=LATIN1", usuario,
                senha);
        //stmt = conn.createStatement();
        return conn.createStatement();
        //return stmt;
    }

    private Statement conectarSqlServer() throws ClassNotFoundException, SQLException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=IMIH";
        String usuario = "douglas";
        String senha = "101025";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }

    private Statement conectarMySql() throws ClassNotFoundException, SQLException {
        try {

            String driver = "com.mysql.jdbc.Driver";
            String dataBaseName = "teAmoProfessorMelo";
            String url = "jdbc:mysql://localhost:3306/";
            String usuario = "root";
            String senha = "";
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url + dataBaseName, usuario, senha);
            stmt = conn.createStatement();
            return stmt;
        } catch (InstantiationException ex) {
            throw new SQLException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    private Statement conectarOdbc() throws ClassNotFoundException, SQLException {
        /* Tenta se conectar ao Driver */
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        /* nome do banco que voce deu anteriormente ao seu alias */
        //String nomeOdbc = "TeAmoProfessorMeloAccess";
        //String nomeOdbc = "connMelo";
        String nomeOdbc = "PostgreSQL30";
        //String nomeOdbc = "TeAmoProfessoMeloPostGre";
        conn = DriverManager.getConnection("jdbc:odbc:" + nomeOdbc);// PostgreSQl35W
        stmt = conn.createStatement();
        return stmt;
    }

    public void inserir(Setor s) throws SQLException, Exception {

        //abrindo a conexao
        Statement conex = conectar();
        //instrucao sql correspondente a insersao do aluno
        String sql = "INSERT INTO setor (nome, codigo)";
        sql += "VALUES ('" + s.getNome() + "', " + s.getCodigo() + ")";
        //executando a instrucao sql
        conex.execute(sql);

        //fechando a conexao com o banco de dados
        desconectar();
    }

    public ArrayList<Setor> listarTodosSetores() throws Exception {
        //abrindo a conexao
        Statement conex = conectar();
        ArrayList<Setor> retorno = new ArrayList<Setor>();
        //instrucao sql correspondente a selecao dos setores
        String sql = "select codigo, nome from setor ;";
        try {
            //executando a instruÃ§Ã£o sql
            ResultSet rs = conex.executeQuery(sql);
            while (rs.next()) {
                Setor setor = new Setor();
                setor.setCodigo(rs.getInt("codigo"));
                setor.setNome(rs.getString("nome"));
                retorno.add(setor);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        //fechando a conexÃ£o com o banco de dados
        desconectar();
        return retorno;
    }
    /*
     public void remover(Aluno aluno) throws Exception {
     //validaÃ§Ã£o das informaÃ§Ãµes do aluno
     if (aluno == null) {
     throw new Exception("O aluno nÃ£o foi instanciado");
     }
     if (aluno.getMatricula() <= 0) {
     throw new Exception("Informar a matrÃ­cula do aluno");
     }

     //abrindo a conexÃ£o
     Statement conex = conectar();
     //instruÃ§Ã£o sql correspondente a remoÃ§Ã£o do aluno
     String sql = "delete from aluno where matricula = "
     + aluno.getMatricula();
     try {
     //executando a instruÃ§Ã£o sql
     conex.execute(sql);
     } catch (SQLException e) {
     //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
     throw new Exception("Erro ao executar remoÃ§Ã£o: " + e.getMessage());
     }
     //fechando a conexÃ£o com o banco de dados
     desconectar();
     }

     public void inserir(Aluno aluno) throws Exception {
     //validaÃ§Ã£o das informaÃ§Ãµes do aluno

     if (aluno == null) {
     throw new Exception("O aluno nÃ£o foi instanciado");
     }
     if (aluno.getMatricula() <= 0) {
     throw new Exception("Informar a matrÃ­cula do aluno");
     }
     if (aluno.getNome() == null || aluno.getNome().trim().equals("")) {
     throw new Exception("Informar o nome do aluno");
     }
     //abrindo a conexÃ£o
     Statement conex = conectar();
     //instruÃ§Ã£o sql correspondente a inserÃ§Ã£o do aluno
     String sql = "INSERT INTO aluno (nome, matricula)";
     sql += "VALUES ('" + aluno.getNome() + "', "
     + aluno.getMatricula() + ")";
     try {
     //executando a instruÃ§Ã£o sql
     conex.execute(sql);
     } catch (SQLException e) {
     //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
     throw new Exception("Erro ao executar inserÃ§Ã£o: " + e.getMessage());
     }
     //fechando a conexÃ£o com o banco de dados
     desconectar();
     }

     public void atualizar(Aluno aluno) throws Exception {
     //validaÃ§Ã£o das informaÃ§Ãµes do aluno
     if (aluno == null) {
     throw new Exception("O aluno nÃ£o foi instanciado");
     }
     if (aluno.getMatricula() <= 0) {
     throw new Exception("Informar a matrÃ­cula do aluno");
     }
     if (aluno.getNome() == null || aluno.getNome().trim().equals("")) {
     throw new Exception("Informar o nome do aluno");
     }
     //abrindo a conexÃ£o
     Statement conex = conectar();
     //instruÃ§Ã£o sql correspondente a atualizaÃ§Ã£o do aluno
     String sql = "update aluno set " + " nome = '" + aluno.getNome()
     + "' where matricula = " + aluno.getMatricula();
     try {
     //executando a instruÃ§Ã£o sql
     conex.execute(sql);
     } catch (SQLException e) {
     //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
     throw new Exception("Erro ao executar atualizaÃ§Ã£o: " + e.getMessage());
     }
     //fechando a conexÃ£o com o banco de dados
     desconectar();
     }

     public ArrayList<Aluno> listarTodos() throws Exception {
     //abrindo a conexÃ£o
     Statement conex = conectar();
     ArrayList<Aluno> retorno = new ArrayList<Aluno>();
     //instruÃ§Ã£o sql correspondente a seleÃ§Ã£o dos alunos
     String sql = "SELECT matricula, nome FROM aluno order by nome";
     try {
     //executando a instruÃ§Ã£o sql
     ResultSet rs = conex.executeQuery(sql);
     while (rs.next()) {
     Aluno aluno = new Aluno();
     aluno.setMatricula(rs.getInt("matricula"));
     aluno.setNome(rs.getString("nome"));
     retorno.add(aluno);
     }
     } catch (SQLException e) {
     //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
     throw new Exception("Erro ao executar consulta: " + e.getMessage());
     }
     //fechando a conexÃ£o com o banco de dados
     desconectar();
     return retorno;
     }

     //mÃ©todos para manipular contatos e enderecos
     public void inserir(Contato contato) throws Exception {
     //abrindo a conexÃ£o
     Statement conex = conectar();
     try {

     //instruÃ§Ã£o sql correspondente a inserÃ§Ã£o do aluno
     String sql = "INSERT INTO contato (nome, codigo)";
     sql += "VALUES ('" + contato.getNome() + "', "
     + contato.getCodigo() + ")";
     //executando a instruÃ§Ã£o sql
     conex.execute(sql);
     } catch (SQLException e) {
     //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
     throw new Exception("Erro ao executar inserÃ§Ã£o(contato): " + e.getMessage());
     }
     try {
     String sqlEndereco = "insert into endereco(logradouro, complemento, bairro, cidade, uf, cep, codigo_contato)";
     sqlEndereco += "values('" + contato.endereco.getLogradouro() + "'";
     sqlEndereco += ",'" + contato.endereco.getComplemento() + "'";
     sqlEndereco += ",'" + contato.endereco.getBairro() + "'";
     sqlEndereco += ",'" + contato.endereco.getCidade() + "'";
     sqlEndereco += ",'" + contato.endereco.getUf() + "'";
     sqlEndereco += ",'" + contato.endereco.getCep() + "'";
     sqlEndereco += "," + contato.getCodigo() + ")";
     conex.execute(sqlEndereco);
     } catch (SQLException ex) {
     throw new Exception("Erro ao executar inserÃ§Ã£o(EndereÃ§o): " + ex.getMessage());
     }

     //fechando a conexÃ£o com o banco de dados
     desconectar();
     }

     public ArrayList<Contato> listarContatos(Contato filtro) throws Exception {
     //abrindo a conexÃ£o
     Statement conex = conectar();
     ArrayList<Contato> retorno = new ArrayList<Contato>();
     //instruÃ§Ã£o sql correspondente a seleÃ§Ã£o dos alunos
     String sql = "SELECT contato.Codigo, contato.nome, "
     + "endereco.logradouro, endereco.complemento, "
     + "endereco.bairro, endereco.cidade, "
     + "endereco.uf, endereco.cep "
     + "FROM contato, endereco "
     + "where contato.codigo = endereco.codigo_contato ";
     if(filtro.getNome().trim().equals("") == false){
     sql += " and contato.nome = '" + filtro.getNome()+"'";
     }
       

     try {
     //executando a instruÃ§Ã£o sql
     ResultSet rs = conex.executeQuery(sql);
     while (rs.next()) {
     Contato contato = new Contato();
     contato.setCodigo(rs.getInt("Codigo"));
     contato.setNome(rs.getString("nome"));
     contato.endereco.setLogradouro(rs.getString("logradouro"));
     contato.endereco.setComplemento(rs.getString("complemento"));
     contato.endereco.setBairro(rs.getString("bairro"));
     contato.endereco.setCidade(rs.getString("cidade"));
     contato.endereco.setUf(rs.getString("uf"));
     contato.endereco.setCep(rs.getString("cep"));

     retorno.add(contato);
     }
     } catch (SQLException e) {
     //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
     throw new Exception("Erro ao executar consulta: " + e.getMessage());
     }
     //fechando a conexÃ£o com o banco de dados
     desconectar();
     return retorno;
     }
     */
}
