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
public class Fachada {

    public void cadastrar(Setor s) throws SetorException {
        NegocioSetor dados = new NegocioSetor();
        dados.cadastrar(s);
    }

    public ArrayList<Setor> listarTodosSetores() throws SetorException {
        NegocioSetor dados = new NegocioSetor();
        return dados.listarTodos();
    }

    public void cadastrar(Funcionario f) throws FuncionarioException {
        NegocioFuncionario dados = new NegocioFuncionario();
        dados.cadastrar(f);
    }

    public ArrayList<Funcionario> listarTodosFuncionarios() throws FuncionarioException {
        NegocioFuncionario dados = new NegocioFuncionario();
        return dados.listarTodos();
    }
}
