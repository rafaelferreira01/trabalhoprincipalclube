/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.ClasseFilha;

/**
 *
 * @author Leonardo
 */
public class Dependente {
    private Enum tipo;

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

    public int getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(int idAssociado) {
        this.idAssociado = idAssociado;
    }

    public Dependente() {
    }

    public Dependente(Enum tipo, int idAssociado) {
        this.tipo = tipo;
        this.idAssociado = idAssociado;
    }
    private int idAssociado;

  
}
