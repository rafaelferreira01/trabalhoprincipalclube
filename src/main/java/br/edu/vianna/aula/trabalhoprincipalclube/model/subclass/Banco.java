/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.model.subclass;

/**
 *
 * @author Leonardo
 */
public class Banco {
    int id;
    String nomeBanco, agencia, conta;

    public Banco() {
    }

    public Banco(int id, String nomeBanco, String agencia, String conta) {
        this.id = id;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
}
