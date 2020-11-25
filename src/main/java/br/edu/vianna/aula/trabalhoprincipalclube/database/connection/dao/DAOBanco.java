/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class DAOBanco implements IDaoGenerics <Banco, Integer>{

    @Override
    public void inserir(Banco b) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO banco (nomeBanco, agencia, conta)"
                + "VALUES (?,?,?);";
       
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, b.getNomeBanco());
        prepara.setString(2, b.getAgencia());
        prepara.setObject(3, b.getConta());
               

        prepara.executeUpdate();
    }

    @Override
    public void alterar(Banco b) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE banco SET "
                + "nomeBanco = ?, agencia = ?, conta = ?"
                + "WHERE id_banco = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, b.getNomeBanco());
        prepara.setString(2, b.getAgencia());
        prepara.setObject(3, b.getConta());
        prepara.setObject(3, b.getId());
        
        prepara.executeUpdate();
    }

    @Override
    public void apagar(Banco b) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "DELETE FROM banco "
                + "WHERE id_banco = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setInt(1, b.getId());
        prepara.executeUpdate();
    }

    @Override
    public Banco buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM banco "
                + "WHERE id_banco = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Banco banco = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            banco = new Banco (rs.getString("nomeBanco"), 
                    rs.getString("agencia"), rs.getString("conta"));
        }
        return banco;  
        
    }

    @Override
    public ArrayList<Banco> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM banco;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Banco> lista = new ArrayList<>();
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {
            Banco banco = new Banco (rs.getString("nomeBanco"), 
                    rs.getString("agencia"), rs.getString("conta"));
            lista.add(banco);
        }
        return lista;   
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
