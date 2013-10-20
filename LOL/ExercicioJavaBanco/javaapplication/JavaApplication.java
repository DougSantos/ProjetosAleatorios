/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas
 */
public class JavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
            if (achou == false) {
                sqlQuery = "CREATE TABLE funcionarios"
                        + "(matricula INTEGER, nome VARCHAR(100), cpf VARCHAR(50), rg VARCHAR (50))";
                callBd.executeQuery(sqlQuery);
                JOptionPane.showMessageDialog(null, "ok");
            }else{
                System.out.println("ya");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                banco.desconectar();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
        /*try {
            Statement callBd;
            ResultSet getResult;
            String sqlQuery;
            ConexaoBd banco = new ConexaoBd();
            Statement con = banco.conectar();
            boolean existe = false;

            callBd = banco.conectar();
            String sql = "SELECT tablename FROM pg_catalog.pg_tables\n"
                    + "WHERE schemaname NOT IN ('pg_catalog', 'information_schema', 'pg_toast')\n"
                    + "ORDER BY tablename";

            getResult = callBd.executeQuery(sql);

            while (getResult.next()) {
                if (getResult.getString(1).equals("funcionarios")) {
                    existe = true;
                    break;
                }
            }
            try {
                if (existe == false) {
                    sqlQuery = "CREATE TABLE funcionarios"
                            + "(matricula INTEGER, nome VARCHAR(100), cpf VARCHAR(50), rg VARCHAR (50), PRIMARY KEY (matricula))";
                    getResult = callBd.executeQuery(sqlQuery);
                    System.out.println("criou");
                } else {
                    System.out.println("ja criado");
                }
            } catch (Exception e) {
                if (e.getMessage().equals("Nenhum resultado foi retornado pela consulta.")){
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Eaê");
                }
                
            }

            if (existe == false) {
                System.out.println(" naoachou");
            } else {
                System.out.println("achou");
            }

            banco.desconectar();
            System.out.println("ok");
        } catch (Exception ex) {
            if (ex.getMessage().equals("ERRO: valor é muito longo para tipo character(11)")) {
                System.out.println("Informe apenas 11 caracteres");
            }
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        // TODO code application logic here
    }*/
}
