/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.ClasseFilha;

import br.edu.vianna.aula.trabalhoprincipalclube.Model.Banco;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Associado {
    
      ArrayList<Dependente> listaDependetes = new ArrayList();
      String cpf, rg, telefone;
      Banco banco;

    public ArrayList<Dependente> getListaDependetes() {
        return listaDependetes;
    }

    public void setListaDependetes(ArrayList<Dependente> listaDependetes) {
        this.listaDependetes = listaDependetes;
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

    public Associado(String cpf, String rg, String telefone, Banco banco) {
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.banco = banco;
    }

    public Associado() {
    }
}
