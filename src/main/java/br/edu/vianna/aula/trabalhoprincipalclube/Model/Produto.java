/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.Model;

/**
 *
 * @author Leonardo
 */
class Produto {
    private int idProduto;
    private Enum tipo;
    private String descricao;
    private double valor;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto(int idProduto, Enum tipo, String descricao, double valor) {
        this.idProduto = idProduto;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto() {
    }
}
