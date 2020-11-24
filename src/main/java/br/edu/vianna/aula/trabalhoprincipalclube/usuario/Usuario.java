/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.usuario;

import br.edu.vianna.aula.trabalhoprincipalclube.usuario.IUsuario;

/**
 *
 * @author suporte
 */
public class Usuario implements IUsuario{
    
    private int id;
    private String nome;
    private String userName;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String userName, String senha) {
        this.id = id;
        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
