/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.Model;

import br.edu.vianna.aula.trabalhoprincipalclube.ClasseFilha.Associado;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Bar {
    ArrayList<Associado> listaAssociados = new ArrayList();
    ArrayList<Produto> listaProdutos = new ArrayList();

    public Bar() {
    }

    public ArrayList<Associado> getListaAssociados() {
        return listaAssociados;
    }

    public void setListaAssociados(ArrayList<Associado> listaAssociados) {
        this.listaAssociados = listaAssociados;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
}
