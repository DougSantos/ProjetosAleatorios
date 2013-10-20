/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camadascomswing;

import java.util.ArrayList;

/**
 *
 * @author professor
 */
public class DadosFuncionario {

    private ArrayList<Funcionario> listaFuncionario;
    private static DadosFuncionario instancia;

    public static DadosFuncionario obterInstancia() {
        if (instancia == null) {
            instancia = new DadosFuncionario();
        }
        return instancia;
    }

    private DadosFuncionario() {
        this.listaFuncionario = new ArrayList<Funcionario>();
    }

    public void cadastrar(Funcionario s) throws FuncionarioException {
        this.listaFuncionario.add(s);
    }

    public ArrayList<Funcionario> listarTodos() throws FuncionarioException {
        return (ArrayList<Funcionario>) this.listaFuncionario.clone();
    }
}
