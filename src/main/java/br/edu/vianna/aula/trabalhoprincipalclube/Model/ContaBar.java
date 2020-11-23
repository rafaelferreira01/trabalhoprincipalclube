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
public class ContaBar {
    
    private Date data; 
    public int idAssociado;
    private double valor;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(int idAssociado) {
        this.idAssociado = idAssociado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ContaBar(Date data, int idAssociado, double valor) {
        this.data = data;
        this.idAssociado = idAssociado;
        this.valor = valor;
    }

    public ContaBar() {
    }
}
