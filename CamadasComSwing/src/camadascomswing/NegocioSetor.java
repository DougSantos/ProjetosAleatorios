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
public class NegocioSetor {

    public void cadastrar(Setor s) throws SetorException {
        //calocar as validações
        DadosSetor dados = DadosSetor.obterInstancia();
        dados.cadastrar(s);
    }

    public ArrayList<Setor> listarTodos() throws SetorException {
        DadosSetor dados = DadosSetor.obterInstancia();
        return dados.listarTodos();
    }
}
