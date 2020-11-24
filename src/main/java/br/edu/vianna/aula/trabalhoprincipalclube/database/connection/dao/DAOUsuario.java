/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao.IDaoGenerics;
import br.edu.vianna.aula.trabalhoprincipalclube.usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class DAOUsuario implements IDaoGenerics <Usuario, Integer>{

    @Override
    public void inserir(Usuario u) throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO usuario (nome, username, senha) "
                + "VALUES (?,?,?);";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, u.getNome());
        prepara.setString(2, u.getUserName());
        prepara.setString(3, u.getSenha());

        prepara.executeUpdate();
    }

    @Override
    public void alterar(Usuario u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE usuario SET "
                + "nome = ?, username = ?, senha = ? "
                + "WHERE idusuario = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setString(1, u.getNome());
        prepara.setString(2, u.getUserName());
        prepara.setString(3, u.getSenha());
        prepara.setInt(4, u.getId());
        
        prepara.executeUpdate();
    }

    @Override
    public void apagar(Usuario u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "DELETE FROM usuario "
                + "WHERE idusuario = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, u.getId());
        prepara.executeUpdate();
    }

    @Override
    public Usuario buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM usuario "
                + "WHERE idusuario = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Usuario usuario = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            usuario = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), 
                    rs.getString("username"), rs.getString("senha"));
        }
        return usuario;  
    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM usuario;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Usuario> lista = new ArrayList<>();
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {
            Usuario usuario = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), 
                    rs.getString("username"), rs.getString("senha"));
            lista.add(usuario);
        }
        return lista;    
    }   

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
