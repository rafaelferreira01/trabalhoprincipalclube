/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.superclass.Pessoa;
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.Banco;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Associado extends Pessoa{
    
      private String cpf;
      private String rg;
      private String telefone;
      private Banco banco;
      private ArrayList<Dependente> meusDependentes;
      
      public Associado() {
      }

    public Associado(String cpf, String rg, String telefone, int id, String nome, String dataNascimento) {
        super(id, nome, dataNascimento);
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        meusDependentes = new ArrayList<>();
    }

    public Associado(String cpf, String rg, String telefone, Banco banco, 
            int id, String nome, String dataNascimento) {
        super(id, nome, dataNascimento);
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.banco = banco;
        meusDependentes = new ArrayList<>();
    }
      

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public ArrayList<Dependente> getMeusDependentes() {
        return meusDependentes;
    }

    public void setMeusDependentes(ArrayList<Dependente> meusDependentes) {
        this.meusDependentes = meusDependentes;
    }

     public void addDependente(Dependente dep) {
        this.meusDependentes.add(dep);
    }
    
    public void removeDependente(int indicieDep) {
        this.meusDependentes.remove(indicieDep);
    }
    
}
