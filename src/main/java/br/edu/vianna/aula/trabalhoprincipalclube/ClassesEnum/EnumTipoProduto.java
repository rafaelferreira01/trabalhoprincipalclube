/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.ClassesEnum;

/**
 *
 * @author Leonardo
 */
public enum EnumTipoProduto {
        Almoco(1, "1 - Almoço)"),
	Filho(2, "2 - Lanche");

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private EnumTipoProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private EnumTipoProduto() {
    }
        
        private int codigo;
        private String descricao;
}
