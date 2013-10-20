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
public class NegocioFuncionario {

    public void cadastrar(Funcionario f) throws FuncionarioException {
        //calocar as validações
        ArrayList<Funcionario> lista = this.listarTodos();
        boolean achei = false;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getMatricula() == f.getMatricula()){
                achei = true;
                break;
            }
        }
        if(achei == true){
            //criar uma exceção
        }
        
        DadosFuncionario dados = DadosFuncionario.obterInstancia();
        dados.cadastrar(f);
    }

    public ArrayList<Funcionario> listarTodos() throws FuncionarioException {
        DadosFuncionario dados = DadosFuncionario.obterInstancia();
        return dados.listarTodos();
    }
}
