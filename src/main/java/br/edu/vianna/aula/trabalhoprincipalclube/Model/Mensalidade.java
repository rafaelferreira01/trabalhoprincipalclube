/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.Model;

import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Mensalidade {
    private int idMensalidade,idAssociado;
    private boolean foiPago;
    private Date dataVencimento;

    public Mensalidade() {
    }

    public Mensalidade(int idMensalidade, int idAssociado, boolean foiPago, Date dataVencimento) {
        this.idMensalidade = idMensalidade;
        this.idAssociado = idAssociado;
        this.foiPago = foiPago;
        this.dataVencimento = dataVencimento;
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

    public boolean isFoiPago() {
        return foiPago;
    }

    public void setFoiPago(boolean foiPago) {
        this.foiPago = foiPago;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public double CalcularMensalidade (){
        return 0;
        // Conta do Bar + Mensalidade
    }
}
    