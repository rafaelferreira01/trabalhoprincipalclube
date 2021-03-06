/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Dependente;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.enums.ETipoDependente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Leonardo
 */
public class DAODependente implements IDaoGenerics  <Dependente, Integer> {

    public void inserirComAssociado(Dependente d, Associado ass) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO dependente (nome, data_nasc, tipo,id_dependente, id_associado) "
                + "VALUES (?,?,?,?,?);";
       
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, d.getNome());
        prepara.setString(2, d.getDataNascimento());
        prepara.setString(3, d.getTipo().toString());
        prepara.setInt(4, d.getId());
        prepara.setInt(5, ass.getId());
        

        prepara.executeUpdate();
    }
    
    @Override
    public void inserir(Dependente d) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO dependente (nome, data_nasc, tipo, id_dependente) "
                + "VALUES (?,?,?,?);";
       
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, d.getNome());
        prepara.setString(2, d.getDataNascimento());
        prepara.setString(3, d.getTipo().toString());
        prepara.setInt(4, d.getId());
        

        prepara.executeUpdate();
    }

    @Override
    public void alterar(Dependente d) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE dependente SET "
                + "nome = ?, data_nasc = ?, tipo = ? "
                + "WHERE id_dependente = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, d.getNome());
        prepara.setString(2, d.getDataNascimento());
        prepara.setString(3, d.getTipo().toString());
        prepara.setInt(4, d.getId());
        
        
        prepara.executeUpdate();
    }

    @Override
    public void apagar(Dependente d) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionClube.getConnection();
        
        String comando = "DELETE FROM dependente "
                + "WHERE id_dependente = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setInt(1, d.getId());
        
        prepara.executeUpdate();
    }

    @Override
    public Dependente buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM dependente "
                + "WHERE  id_dependente = ?;"; 
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Dependente dependente = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
             dependente = new Dependente (ETipoDependente.valueOf(rs.getString("tipo")), rs.getInt("id_dependente"),  
                    rs.getString("nome"), rs.getString("data_nasc"));
        }
      
        return dependente;  
    }

    @Override
    public ArrayList<Dependente> buscarTodos() throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM dependente;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Dependente> lista = new ArrayList<>();
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {
            Dependente dependente = new Dependente(ETipoDependente.valueOf(rs.getString("tipo")), rs.getInt("id_dependente"),  
                    rs.getString("nome"), rs.getString("data_nasc"));
            
            lista.add(dependente);
        }
        return lista;  
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Dependente> getDependenteAssociado(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();

        String comando = "select id_dependente, d.nome, tipo, d.data_nasc from dependente d "
                + "inner join associado a on (d.id_associado = a.id_associado) "
                + "where a.id_associado = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Dependente> lista = new ArrayList<>();
        
        prepara.setInt(1, i);
        
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {
            Dependente dependente = new Dependente(ETipoDependente.valueOf(rs.getString("tipo")), rs.getInt("id_dependente"),   
                    rs.getString("nome"), rs.getString("data_nasc"));
            
            lista.add(dependente);
        }
        return lista; 
    }
    
}
