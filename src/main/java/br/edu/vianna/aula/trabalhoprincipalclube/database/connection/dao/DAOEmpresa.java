/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.Mensalidade;
import br.edu.vianna.aula.trabalhoprincipalclube.operacoes.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public class DAOEmpresa implements IDaoGenerics<Empresa, Integer>{


    public void selecionaJF(Empresa e) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "UPDATE empresa SET selecionada = 1 where idempresa = 1; ";
        String comando2 = "UPDATE empresa SET selecionada = 0 where idempresa = 2; ";
        PreparedStatement prepara  = c.prepareStatement(comando);
        PreparedStatement prepara2  = c.prepareStatement(comando2);
        prepara.executeUpdate();
        prepara2.executeUpdate();
    }
    
    public void selecionaMB(Empresa e) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "UPDATE empresa SET selecionada = 1 where idempresa = 2; ";
        String comando2 = "UPDATE empresa SET selecionada = 0 where idempresa = 1; ";
        PreparedStatement prepara  = c.prepareStatement(comando);
        PreparedStatement prepara2  = c.prepareStatement(comando2);
        prepara.executeUpdate();
        prepara2.executeUpdate();
    }
    
    public Empresa buscaEmpresaSelecionada() throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM empresa WHERE selecionada = 1;";
        PreparedStatement prepara  = c.prepareStatement(comando);
         
        Empresa empresa = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            empresa = new Empresa(rs.getInt("idempresa"), 
            rs.getString("unidade"));
        }
        return empresa; 
        
        
        
        
        
        
    }
        
    @Override
    public void inserir(Empresa u) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Empresa u) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Empresa u) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empresa> buscarTodos() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
