/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.ClassePai;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Pessoa {

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Pessoa(int idPessoa, String nome, Date dataDeNascimento) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Pessoa() {
    }
    
    private int idPessoa;
    private String nome;
    private Date dataDeNascimento; 
    
}
