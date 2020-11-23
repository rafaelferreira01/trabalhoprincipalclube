/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.Model;

/**
 *
 * @author Leonardo
 */
public class Banco {
    int idBanco;
    String nomeBanco, agencia, conta;

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
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

    public Banco(int idBanco, String nomeBanco, String agencia, String conta) {
        this.idBanco = idBanco;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public Banco() {
    }
    
}
