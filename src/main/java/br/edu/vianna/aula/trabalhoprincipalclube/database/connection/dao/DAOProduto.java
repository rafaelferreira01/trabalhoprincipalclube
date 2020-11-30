/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.enums.ETipoProduto;
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public class DAOProduto implements IDaoGenerics <Produto, Integer> {

    @Override
    public void inserir(Produto p) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO produto (tipo_produto, descricao, valor_produto) "
                + "VALUES (?,?,?);";
        
        

        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setObject(1, p.getTipo());
        prepara.setString(2, p.getDescricao());
        prepara.setDouble(3, p.getValor());

        prepara.executeUpdate();
    }
    

    @Override
    public void alterar(Produto p) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE produto SET "
                + "tipo_produto = ?, descricao = ?, valor_produto = ? "
                + "WHERE id_produto = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setObject(1, p.getTipo());
        prepara.setString(2, p.getDescricao());
        prepara.setDouble(3, p.getValor());
        prepara.setInt(4, p.getId());
        
        prepara.executeUpdate();
    }

    @Override
    public void apagar(Produto u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "DELETE FROM produto "
                + "WHERE id_produto = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, u.getId());
        prepara.executeUpdate();
    }

    @Override
    public Produto buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM produto "
                + "WHERE id_produto = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Produto produto = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            produto = new Produto(ETipoProduto.valueOf(rs.getString("tipo_produto")), 
            rs.getString("descricao"), rs.getDouble("valor"));
        }
        return produto;  
    } 
    
    public Produto buscarPorTipo(String i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM produto "
                + "WHERE tipo_produto = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setString(1, i);
        Produto produto = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            produto = new Produto(ETipoProduto.valueOf(rs.getString("tipo_produto")), 
            rs.getString("descricao"), rs.getDouble("valor_produto"));
        }
        return produto;  
    } 

    @Override
    public ArrayList<Produto> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM produto;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Produto> lista = new ArrayList<>();
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {
            Produto produto = new Produto (ETipoProduto.valueOf(rs.getString("tipo_produto")), 
            rs.getString("descricao"), rs.getDouble("valor"));
            lista.add(produto);
        }
        return lista;   
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}