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
    private double valor_e1;

    public ContaBar(String data, Associado associado, double valor) {
        this.data = data;
        this.associado = associado;
        this.valor_e1 = valor;
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

    public double getValor_e1() {
        return valor_e1;
    }

    public void setValor_e1(double valor_e1) {
        this.valor_e1 = valor_e1;
    }
    
}
