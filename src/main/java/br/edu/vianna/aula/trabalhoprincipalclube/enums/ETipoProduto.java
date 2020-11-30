/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.enums;

/**
 *
 * @author Leonardo
 */
public enum ETipoProduto {
        ALMOCO(1, "1 - Almoço)"),
	LANCHE(2, "2 - Lanche");
    private int codigo;
    private String descricao;
        
    private ETipoProduto() {
    }
    
    private ETipoProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

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

}
