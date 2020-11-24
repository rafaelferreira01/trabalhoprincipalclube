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
public class ContaBar {
    
    private String data; 
    public int id;
    private double valor;

    public ContaBar() {
    }

    public ContaBar(String data, int idAssociado, double valor) {
        this.data = data;
        this.id = idAssociado;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
