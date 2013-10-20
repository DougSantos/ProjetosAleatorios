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
public class DadosSetor {

    private ArrayList<Setor> listaSetores;
    private static DadosSetor instancia;

    public static DadosSetor obterInstancia() {
        if (instancia == null) {
            instancia = new DadosSetor();
        }
        return instancia;
    }

    private DadosSetor() {
        this.listaSetores = new ArrayList<Setor>();
    }

    public void cadastrar(Setor s) throws SetorException {
        this.listaSetores.add(s);
    }

    public void cadastrarBd(Setor s) throws SetorException {
        // Criando as variáveis de conexão e de statement
        Connection con;
        Statement stmt;
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Abrindo a conexão com o servidor MAURO, login sa e sem senha
            
            con = DriverManager.getConnection("jdbc:sqlserver://c1-36:1433;DatabaseName=melo;", "melo", "123");

            stmt = con.createStatement();

            // Criando a instrução a partir do SELECT que está dentro da variável query
            ResultSet rs = stmt.executeQuery("select * from setor");
            //Fechamdno a instrução e a conexão
            stmt.close();
            con.close();
        } catch (SQLException ex) {
           throw new SetorException(ex.getMessage());
        }  catch (java.lang.ClassNotFoundException ex) {
            throw new SetorException("Erro driver: "+ex.getMessage());
        }
    }

    public ArrayList<Setor> listarTodos() throws SetorException {
        return (ArrayList<Setor>) this.listaSetores.clone();
    }
}
