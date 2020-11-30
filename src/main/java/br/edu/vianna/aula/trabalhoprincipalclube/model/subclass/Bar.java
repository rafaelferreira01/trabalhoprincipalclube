/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.model.subclass;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Bar {
    private ArrayList<Produto> listaProdutos;
      private ArrayList<Associado> listaAssociados;

    public Bar() {
    }

    public Bar(ArrayList<Produto> listaProdutos, ArrayList<Associado> listaAssociados) {
        this.listaProdutos = listaProdutos;
        this.listaAssociados = listaAssociados;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    public void addProduto(Produto prod) {
        this.listaProdutos.add(prod);
    }
    
    public void removeProduto(int indicieProd) {
        this.listaProdutos.remove(indicieProd);
    }

    public ArrayList<Associado> getListaAssociados() {
        return listaAssociados;
    }

    public void setListaAssociados(ArrayList<Associado> listaAssociados) {
        this.listaAssociados = listaAssociados;
    }

    public void addAssociado(Associado ass) {
        this.listaAssociados.add(ass);
    }
    
    public void removeAssociado(int indicieAss) {
        this.listaAssociados.remove(indicieAss);
    }
    
}
