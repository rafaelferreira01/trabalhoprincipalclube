/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.operacoes;

/**
 *
 * @author suporte
 */
public class Empresa {
    private int id;
    private String unidade;

    public Empresa() {
    }

    public Empresa(int id, String unidade) {
        this.id = id;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    
    
    
}
