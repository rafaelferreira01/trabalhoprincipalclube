/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Dependente;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.ContaBar;
import br.edu.vianna.aula.trabalhoprincipalclube.operacoes.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public class DAOContaBar implements IDaoGenerics<ContaBar, Integer>{
    
    public void inserirContaBar(Associado a) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO conta_bar (id_associado, valor_conta) "
                + "VALUES ((SELECT MAX(id_associado) FROM associado),0);";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.executeUpdate();
    }
    
    public void apagarContaBar(Associado a) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        String sql = "DELETE FROM conta_bar WHERE id_associado = ?;";//comando
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        prepara.setInt(1, a.getId());//primeira '?'
        prepara.executeUpdate();//executar comando
    }
    
    public void realizarVendaEmpresa(Associado a, double i, int idEmpresa) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();//pegando a conexao la do ConnectionAbrigo
        String sql = "UPDATE conta_bar SET valor_conta = valor_conta + ?, empresa = ? "
                + "WHERE id_associado = ?";//comando
        PreparedStatement prepara  = c.prepareStatement(sql);//preparando
        prepara.setDouble(1, i);//primeira '?'
        prepara.setInt(2, idEmpresa);//primeira '?'
        prepara.setInt(3, a.getId());//primeira '?'
        prepara.executeUpdate();//executar comando
        
    }

    @Override
    public void inserir(ContaBar u) throws ClassNotFoundException, SQLException {
        
    }

    @Override
    public void alterar(ContaBar u) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(ContaBar u) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContaBar buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ContaBar> buscarTodos() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
