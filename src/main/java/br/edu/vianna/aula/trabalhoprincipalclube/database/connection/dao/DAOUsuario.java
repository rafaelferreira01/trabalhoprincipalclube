/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao.DAOUsuario;
import br.edu.vianna.aula.trabalhoprincipalclube.operacoes.Operacoes;
import br.edu.vianna.aula.trabalhoprincipalclube.usuario.Usuario;
import br.edu.vianna.aula.trabalhoprincipalclube.usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public class DAOUsuario implements IDaoGenerics<Usuario, Integer>{
    /*passando para a IDaoGenerics o tipo de objeto(Usuario) e o tipo da chave primaria(Integer),
    referentes respectivamente ao C e ao K que serão recebidos no IDaoGenerics*/

    @Override
    public void inserir(Usuario u) throws ClassNotFoundException, SQLException {
        
        //CONECTAR
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        
        //MONTAR COMANDO SQL
        String sql = "INSERT INTO usuario (nome, username, senha) "
                + "VALUES (?,?,?);";//cada '?' equivale a um parametro que será passado ao banco
        
        //PREPARA EXECUÇÃO
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        
        //TROCA DE VALORES -- cada numero reperenta o que será passado na '?' acima
        prepara.setString(1, u.getNome());//primeira '?'
        prepara.setString(2, u.getUserName());//segunda '?'
        prepara.setString(3, u.getSenha());//terceira '?'
        
        //EXECUÇÃO
        prepara.executeUpdate();//executar comando
    }

    @Override
    public void alterar(Usuario u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        
        String sql = "UPDATE usuario SET "//comando
                + "nome = ?, "
                + "username = ?, "
                + "senha = ? "
                + "WHERE idusuario = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        
        prepara.setString(1, u.getNome());//primeira '?'
        prepara.setString(2, u.getUserName());//segunda '?'
        prepara.setString(3, u.getSenha());//terceira '?'
        prepara.setInt(4, u.getId());
        
        prepara.executeUpdate();//executar comando
    }

    @Override
    public void apagar(Usuario u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        String sql = "DELETE FROM usuario WHERE idusuario = ?;";//comando
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        prepara.setInt(1, u.getId());//primeira '?'
        prepara.executeUpdate();//executar comando
    }

    @Override
    public Usuario buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        String sql = "SELECT * FROM usuario WHERE idusuario = ?;";//comando
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        prepara.setInt(1, i);//primeira '?'
         
        Usuario usuario = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {//para cada entrada no banco faça
            //instancie um objeto do tipo abaixo com as informações contidas no banco
            usuario = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), 
                    rs.getString("username"), rs.getString("senha"));
            //System.out.println(""+usuario.getNome());
        }
        return usuario;  
    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        String sql = "SELECT * FROM usuario;";//comando
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        
        ArrayList<Usuario> lista = new ArrayList<>();//instancia arraylist
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {//para cada entrada no banco faça
            //instancie um objeto do tipo abaixo com as informações contidas no banco
            Usuario usuario = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), 
                    rs.getString("username"), rs.getString("senha"));
            //System.out.println(""+usuario.getNome());
            lista.add(usuario);//adicione o objeto no arraylist
        }
        return lista;    
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario verificarLoginSenha(String login, String senha) throws ClassNotFoundException, SQLException{
    Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        String sql = "SELECT * FROM usuario WHERE username = ? and senha = ?;";//comando
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        
        prepara.setString(1, login);
        prepara.setString(2, senha);
         
        ResultSet rs = prepara.executeQuery();
        
        Usuario usuario = null;
        
        while(rs.next()) {
            usuario = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), 
                    rs.getString("username"), rs.getString("senha"));
        }
        
        return usuario;  
    }
    
    
    
}
