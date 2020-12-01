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
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.ContaBar;
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
public class DAOContaBar implements IDaoGenerics<ContaBar, Integer>{
    
    
    public void pagarMensalidade(Mensalidade m, Integer i) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE conta_bar SET pagamento_pendente = 0, valor_conta = 0 WHERE id_associado = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setInt(1, i);
        
        prepara.executeUpdate();
        
    }
    
    public ContaBar buscarPorIDAssociado(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM conta_bar WHERE id_associado = ?;"; 
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        ContaBar conta = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            
            conta = new ContaBar(rs.getDouble("valor_conta"),rs.getBoolean("pagamento_pendente"));
        }
        System.out.println(""+conta.getValor());
      
        return conta;  
    }
    
    
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
