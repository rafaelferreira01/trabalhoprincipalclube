/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.model.subclass;

import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Mensalidade {
    private int idMensalidade,idAssociado;
    private boolean PagamentoPendente;
    private String dataVencimento;
    private double valorMensalidade;

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidae) {
        this.valorMensalidade = valorMensalidae;
    }

    public Mensalidade() {
    }

    public Mensalidade(boolean PagamentoPendente, String dataVencimento, double valorMensalidade) {
        this.PagamentoPendente = PagamentoPendente;
        this.dataVencimento = dataVencimento;
        this.valorMensalidade = valorMensalidade;
    }

    public Mensalidade(int idAssociado, boolean PagamentoPendente, String dataVencimento, double valorMensalidade) {
      
        this.idAssociado = idAssociado;
        this.PagamentoPendente = PagamentoPendente;
        this.dataVencimento = dataVencimento;
        this.valorMensalidade = valorMensalidade;
    }

  

    public int getIdMensalidade() {
        return idMensalidade;
    }

    public void setIdMensalidade(int idMensalidade) {
        this.idMensalidade = idMensalidade;
    }

    public int getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(int idAssociado) {
        this.idAssociado = idAssociado;
    }

    public boolean isPagamentoPendente() {
        return PagamentoPendente;
    }

    public void setPagamentoPendente(boolean PagamentoPendente) {
        this.PagamentoPendente = PagamentoPendente;
    }

   
    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double CalcularMensalidade (){
        return 0;
        // Conta do Bar + Mensalidade
    }
}
    