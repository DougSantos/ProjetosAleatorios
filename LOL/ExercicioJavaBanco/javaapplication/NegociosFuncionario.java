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
public class NegociosFuncionario {

    DadosFuncionario dados;

    public NegociosFuncionario() {
        this.dados = new DadosFuncionario();
    }

    public void cadastrarFuncionario(Funcionario f) throws Exception {
        if(f.getNome() == null) {
            throw new Exception("O Nome nao poede ser nulo");
        }
        if (f.getNome().trim().equals("")) {
            throw new Exception("O Nome nao pode ser vazio");
        }
        if (f.getCpf().length() < 11) {
            throw new Exception("O CPF deve conter mais de 11 caracteres");
        }
        if (f.getCpf() == null) {
            throw new Exception("O CPF nao pode ser nulo");
        }
        if (f.getCpf().trim().equals("")) {
            throw new Exception("o CPF nao pode ser vazio");
        }
        if (verificaCpf(f) == true) {
            throw new Exception("O CPF nao pode ser repetido");
        }
        if (f.getRg() == null) {
            throw new Exception("O RG nao poede ser nulo");
        }

        if (f.getNome().trim().equals("")) {
            throw new Exception("O Nome nao pode ser vazio");
        }

        if (f.getRg().length() < 4) {
            throw new Exception("O RG Informado deve conter mais de 4 caracteres");
        }
        if(verificaMatricula(f) == true){
            throw new Exception("A Matricula Informada já existe");
        }
            
        dados.cadastrarFuncionario(f);
    }

    public void alterarFuncionario(int posicao,Funcionario f) throws Exception {
        if(f.getNome() == null) {
            throw new Exception("O Nome nao poede ser nulo");
        }
        if (f.getNome().trim().equals("")) {
            throw new Exception("O Nome nao pode ser vazio");
        }
        if (f.getCpf().length() < 11) {
            throw new Exception("O CPF deve conter mais de 11 caracteres");
        }
        if (f.getCpf() == null) {
            throw new Exception("O CPF nao pode ser nulo");
        }
        if (f.getCpf().trim().equals("")) {
            throw new Exception("o CPF nao pode ser vazio");
        }
        if (f.getRg() == null) {
            throw new Exception("O RG nao poede ser nulo");
        }

        if (f.getNome().trim().equals("")) {
            throw new Exception("O Nome nao pode ser vazio");
        }

        if (f.getRg().length() < 4) {
            throw new Exception("O RG Informado deve conter mais de 4 caracteres");
        }
        dados.alterarFuncionario(posicao,f);
    }

    public void removerFuncionario(int posicao) throws Exception {
        dados.removerFuncionario(posicao);
    }

    public ArrayList<Funcionario> listarFunc() throws Exception {
        return dados.listarFunc();
    }


    public ArrayList<Funcionario> listarFuncPrefix(String prefix) throws Exception {
        return dados.listarFuncPrefix(prefix);
    }

    public ArrayList<Funcionario> listarFuncSufix(String sufix) throws Exception {
        return dados.listarFuncSufix(sufix);
        
    }

    public ArrayList<Funcionario> listarFuncWith(String conteudo) throws Exception {
        return dados.listarFuncWith(conteudo);
    }
    

    private boolean verificaMatricula(Funcionario func) throws Exception {
        boolean EstaRep = false;
        for (int i = 0; i < listarFunc().size(); ++i) {
            if (func.getMatricula() == listarFunc().get(i).getMatricula()) {
                EstaRep = true;
                break;
            }
        }
        return EstaRep;
    }

    private boolean verificaCpf(Funcionario func) throws Exception {
        boolean EstaRep = false;
        for (int i = 0; i < listarFunc().size(); ++i) {
            if (func.getCpf().equals(listarFunc().get(i).getCpf()) == true) {
                EstaRep = true;
            }
        }
        return EstaRep;
    }


    public int parseNum(String entrada) throws Exception , NumberFormatException {
        if (entrada == null) {
            throw new Exception("Campo com valor nulo");
        } else
            if(isInt(entrada) == true){
                return Integer.parseInt(entrada);
            } else {
                throw new Exception("Informe Apenas Números");
            }
    }
    private boolean isInt(String Numero){
        
        try{
        Integer.parseInt(Numero);
        return true;
        }catch(Exception e){
            return false;
        
        }
    }
}