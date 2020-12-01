/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.model.subclass;
import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class ContaBar {
    
    private String data; 
    private Associado associado;
    private double valor;
    private boolean pendente;

    public boolean isPendente() {
        return pendente;
    }

    public void setPendente(boolean pendente) {
        this.pendente = pendente;
    }

    public ContaBar(String data, Associado associado, double valor, boolean pendente) {
        this.data = data;
        this.associado = associado;
        this.valor = valor;
        this.pendente = pendente;
    }
    
    public ContaBar(Associado associado, double valor, boolean pendente) {
        this.associado = associado;
        this.valor = valor;
        this.pendente = pendente;
    }
    
    public ContaBar(double valor, boolean pendente) {
        this.valor = valor;
        this.pendente = pendente;
    }
    
    public ContaBar() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
