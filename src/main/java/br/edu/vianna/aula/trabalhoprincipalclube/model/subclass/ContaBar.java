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
    public Associado associado;
    private double valor;

    public ContaBar(String data, Associado associado, double valor) {
        this.data = data;
        this.associado = associado;
        this.valor = valor;
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
