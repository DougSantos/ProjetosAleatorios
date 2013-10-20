/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camadascomswing;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author professor
 */
public class CamadasComSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*
             1º passo camada a ser desenvolvida é: Classes basicas
             2º passo criar a camada de dados - acessaremos os dados na memória
             3º passo criar as camadas de negócio
             4º passo criar a fachada
             */


            ConexaoBd con = new ConexaoBd();
            con.conectar();
            con.desconectar();
            JOptionPane.showMessageDialog(null, "Sucesso");

            /*Setor s = new Setor();
             s.setNome("financeiro");
             s.setCodigo(3);
             //con.inserir(s);
             System.out.println("Cadastrou");
             /*ArrayList<Setor> retorno = con.listarTodosSetores();
             for (Setor setor : retorno) {
             JOptionPane.showMessageDialog(null, setor.getNome());
             }*/

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problema na classe de conn: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problema no SQL: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }
}
