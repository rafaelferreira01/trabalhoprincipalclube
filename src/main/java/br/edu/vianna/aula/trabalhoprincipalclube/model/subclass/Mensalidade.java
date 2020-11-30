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
    private int mes;
    private double valorMensalidade;

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidae) {
        this.valorMensalidade = valorMensalidae;
    }

    public Mensalidade() {
    }

    public Mensalidade(int diaVencimento) {
        this.mes = diaVencimento;
    }

   
    
    

    public Mensalidade(boolean PagamentoPendente, int mes, double valorMensalidade) {
        this.PagamentoPendente = PagamentoPendente;
        this.mes = mes;
        this.valorMensalidade = valorMensalidade;
    }

    public Mensalidade(int idAssociado, boolean PagamentoPendente, int mes, double valorMensalidade) {
      
        this.idAssociado = idAssociado;
        this.PagamentoPendente = PagamentoPendente;
        this.mes = mes;
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

   
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double CalcularMensalidade (){
        return 0;
        // Conta do Bar + Mensalidade
    }
}
    