/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Dependente;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
 
    public class DAOAssociado implements IDaoGenerics <Associado, Integer>{

    @Override
    public void inserir(Associado a) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO usuario (nome, data_nasc, cpf,rg,telefone) "
                + "VALUES (?,?,?,?,?);";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, a.getNome());
        prepara.setString(2, a.getDataNascimento());
        prepara.setString(3, a.getCpf());
        prepara.setString(4, a.getRg());
        prepara.setString(5, a.getTelefone());

        prepara.executeUpdate();
        
      
    }

    @Override
    public void alterar(Associado a) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE associado SET "
                + "nome = ?, data_nasc = ?, cpf = ?, rg = ?, telefone = ?"
                + "WHERE id_associado = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, a.getNome());
        prepara.setString(2, a.getDataNascimento());
        prepara.setString(3, a.getCpf());
        prepara.setString(4, a.getRg());
        prepara.setString(5, a.getTelefone());
        prepara.setInt(6, a.getIdPessoa());
        
        
        prepara.executeUpdate();
    }

    @Override
    public void apagar(Associado a) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "DELETE FROM associado "
                + "WHERE id_associado = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, a.getIdPessoa());
        prepara.executeUpdate();
    }

    @Override
    public Associado buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM associado "
                + "WHERE  id_associado = ?;"; 
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Associado associado = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {//usando construtor sem Banco
            associado = new Associado (rs.getString("cpf"), rs.getString("rg"), 
                    rs.getString("telefone"), rs.getString("nome"),rs.getString("data_nasc"));
            
            associado.setMeusDependentes(new DAODependente().getDependenteAssociado(rs.getInt("id_associado")));
        }
        return associado;  
        
    }

    @Override
    public ArrayList<Associado> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM associado;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Associado> lista = new ArrayList<>();
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {//usando construtor sem Banco
            ArrayList<Dependente> listaDependentes = new ArrayList<>();
            Associado associado = new Associado (rs.getString("cpf"), rs.getString("rg"), 
                    rs.getString("telefone"), rs.getString("nome"),rs.getString("dataNascimento"));
            lista.add(associado);
        }
        return lista;    
    }   
    

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    }