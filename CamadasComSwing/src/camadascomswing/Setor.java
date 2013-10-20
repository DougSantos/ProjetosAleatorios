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
public class Setor {
    private int codigo;
    private String nome;
    private ArrayList<Funcionario> listaFuncionarios;
    
    public Setor(){
        this.listaFuncionarios = new ArrayList<Funcionario>();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the listaFuncionarios
     */
    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    /**
     * @param listaFuncionarios the listaFuncionarios to set
     */
    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
}
