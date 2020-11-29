/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.superclass.Pessoa;

/**
 *
 * @author Leonardo
 */
public class Dependente extends Pessoa{
    private Enum tipo;
    private Associado associado;

    public Dependente() {
    }

    public Dependente(Enum tipo, int id, String nome, String dataNascimento) {
        super(id, nome, dataNascimento);
        this.tipo = tipo;
    }

    public Dependente(Enum tipo, Associado associado, int id, String nome, String dataNascimento) {
        super(id, nome, dataNascimento);
        this.tipo = tipo;
        this.associado = associado;
    }

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }
}
