/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication;

import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
public class Fachada {
    NegociosFuncionario negocio;

    public Fachada() {
        this.negocio = new NegociosFuncionario();
    }
    
    public void cadastrarFuncionario(Funcionario f) throws Exception{
        negocio.cadastrarFuncionario(f);
        
    }
    public void alterarFuncionario(int posicao,Funcionario f) throws Exception{
        negocio.alterarFuncionario(posicao, f);
    }
    public void removerFuncionario(int posicao) throws Exception{
        negocio.removerFuncionario(posicao);
        
    }
    public ArrayList<Funcionario> listarFunc() throws Exception{
        return negocio.listarFunc();
    }
    public ArrayList<Funcionario> listarFuncPrefix(String prefix) throws Exception{
        return negocio.listarFuncPrefix(prefix);
        
    }
    public ArrayList<Funcionario> listarFuncSufix(String sufix) throws Exception{
        return negocio.listarFuncSufix(sufix);
        
    }
    public ArrayList<Funcionario> listarFuncWith(String conteudo) throws Exception{
        
       return negocio.listarFuncWith(conteudo);
        
    }


}