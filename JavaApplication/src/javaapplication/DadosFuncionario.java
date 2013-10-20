/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas
 */
public class DadosFuncionario extends ConexaoBd {

    Statement callBd;
    ResultSet getResult;
    String sqlQuery;

    public void cadastrarFuncionario(Funcionario f) throws Exception {
        try {
            this.callBd = conectar();
            this.sqlQuery = "INSERT INTO funcionarios VALUES"
                    + "(" + f.getMatricula() + ",'" + f.getNome() + "','" + f.getCpf() + "','" + f.getRg() + "')";
            this.callBd.execute(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }

    public void alterarFuncionario(int posicao, Funcionario f) throws Exception {

        try {

            this.callBd = conectar();
            this.sqlQuery = "UPDATE funcionarios SET"
                    + " nome = '" + f.getNome() + "', cpf = '" + f.getCpf() + "', rg = '" + f.getRg() + "' WHERE matricula = " + posicao;
            this.callBd.execute(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }

    public void removerFuncionario(int matricula) throws Exception {

        try {
            this.callBd = conectar();
            this.sqlQuery = "DELETE FROM funcionarios WHERE "
                    + "matricula = " + matricula;
            this.callBd.execute(sqlQuery);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }

    public ArrayList<Funcionario> listarFunc() throws Exception {
        try {
            ArrayList<Funcionario> exibidor = new ArrayList<>();
            this.callBd = conectar();
            this.sqlQuery = "SELECT * FROM funcionarios";
            this.getResult = this.callBd.executeQuery(sqlQuery);
            while (getResult.next()) {
                Funcionario funcExibidor = new Funcionario();
                funcExibidor.setMatricula(getResult.getInt("matricula"));
                funcExibidor.setNome(getResult.getString("nome"));
                funcExibidor.setCpf(getResult.getString("cpf"));
                funcExibidor.setRg(getResult.getString("rg"));
                exibidor.add(funcExibidor);
            }
            return exibidor;
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }

    }

    public ArrayList<Funcionario> listarFuncPrefix(String prefix) throws Exception {
         try {
            ArrayList<Funcionario> exibidor = new ArrayList<>();
            this.callBd = conectar();
            this.sqlQuery = "SELECT * FROM funcionarios WHERE nome like '" + prefix + "%'";
            this.getResult = this.callBd.executeQuery(sqlQuery);
           // if(getResult.next() == true){
            while (getResult.next()) {
                Funcionario funcExibidor = new Funcionario();
                funcExibidor.setMatricula(getResult.getInt("matricula"));
                funcExibidor.setNome(getResult.getString("nome"));
                funcExibidor.setCpf(getResult.getString("cpf"));
                funcExibidor.setRg(getResult.getString("rg"));
                exibidor.add(funcExibidor);
            }
           // }
            return exibidor;
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }

    public ArrayList<Funcionario> listarFuncSufix(String sufix) throws Exception {
        try {
            ArrayList<Funcionario> exibidor = new ArrayList<>();
            this.callBd = conectar();
            this.sqlQuery = "SELECT * FROM funcionarios WHERE nome like '%" + sufix + "'";
            this.getResult = this.callBd.executeQuery(sqlQuery);
            while (getResult.next()) {
                Funcionario funcExibidor = new Funcionario();
                funcExibidor.setMatricula(getResult.getInt("matricula"));
                funcExibidor.setNome(getResult.getString("nome"));
                funcExibidor.setCpf(getResult.getString("cpf"));
                funcExibidor.setRg(getResult.getString("rg"));
                exibidor.add(funcExibidor);
            }
            return exibidor;
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }

    public ArrayList<Funcionario> listarFuncWith(String conteudo) throws Exception {
        try {
            ArrayList<Funcionario> exibidor = new ArrayList<>();
            this.callBd = conectar();
            this.sqlQuery = "SELECT * FROM funcionarios WHERE nome like '%" + conteudo + "%'";
            this.getResult = this.callBd.executeQuery(sqlQuery);
            while (getResult.next()) {
                Funcionario funcExibidor = new Funcionario();
                funcExibidor.setMatricula(getResult.getInt("matricula"));
                funcExibidor.setNome(getResult.getString("nome"));
                funcExibidor.setCpf(getResult.getString("cpf"));
                funcExibidor.setRg(getResult.getString("rg"));
                exibidor.add(funcExibidor);
            }
            return exibidor;
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                desconectar();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }

    public static void checkTableFuncionarios() throws Exception {
        ConexaoBd banco = new ConexaoBd();
        try {
            Statement callBd;
            ResultSet getResult;
            String sqlQuery;
            boolean achou = false;
            callBd = banco.conectar();
            String sql = "SELECT tablename FROM pg_catalog.pg_tables\n"
                    + "WHERE schemaname NOT IN ('pg_catalog', 'information_schema', 'pg_toast')\n"
                    + "ORDER BY tablename";

            getResult = callBd.executeQuery(sql);
            while (getResult.next()) {
                if (getResult.getString(1).equals("funcionarios")) {
                    achou = true;

                }

            }
            try {
                if (achou == false) {
                    sqlQuery = "CREATE TABLE funcionarios"
                            + "(matricula INTEGER, nome VARCHAR(100), cpf VARCHAR(50), rg VARCHAR (50))";
                    callBd.executeQuery(sqlQuery);
                    JOptionPane.showMessageDialog(null, "ok");
                }
            } catch (Exception e) {
                if (e.getMessage().equals("Nenhum resultado foi retornado pela consulta.")) {

                } else {
                    throw new Exception(e.getMessage());
                }
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                banco.desconectar();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }

    }

    public static void checkTable() throws Exception {
        try {
            ConexaoBd banco = new ConexaoBd();
            Statement callBd = banco.conectar();
            ResultSet getResult;
            String sqlQuery;
            boolean existe = false;
            sqlQuery = "SELECT tablename FROM pg_catalog.pg_tables\n"
                    + "WHERE schemaname NOT IN ('pg_catalog', 'information_schema', 'pg_toast') AND tablename = 'funcionarios'\n"
                    + "ORDER BY tablename";
            existe = callBd.executeQuery(sqlQuery).next();

            if (existe == false) {
                sqlQuery = "CREATE TABLE funcionarios"
                        + "(matricula INTEGER, nome VARCHAR(100), cpf VARCHAR(50), rg VARCHAR (50))";
                callBd.execute(sqlQuery);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
