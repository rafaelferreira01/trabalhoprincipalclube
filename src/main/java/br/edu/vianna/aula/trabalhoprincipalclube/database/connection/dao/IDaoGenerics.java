/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public interface IDaoGenerics<C, K> {
    //C -- objeto generico que será passado para a DAO
    //K -- tipo genérico de atributo que será passado para a DAO
    public void inserir(C u) throws ClassNotFoundException, SQLException;//passando o erro pra quem for usar o método
    public void alterar(C u) throws ClassNotFoundException, SQLException;
    public void apagar(C u) throws ClassNotFoundException, SQLException;
    
//busca no banco pela chave passada para a DAO, K é o tipo de dado da chave sendo buscada (int, string, etc...)
    public C buscarPorId(K i) throws ClassNotFoundException, SQLException;

    public ArrayList<C> buscarTodos() throws ClassNotFoundException, SQLException;
    public int count() throws ClassNotFoundException, SQLException;
}
