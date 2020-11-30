/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.ConnectionClube;
import br.edu.vianna.aula.trabalhoprincipalclube.model.subclass.Mensalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public class DAOMensalidade implements IDaoGenerics <Mensalidade, Integer> {

    
    public Mensalidade buscarPorIdAssociado(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM mensalidade "
                + "WHERE id_associado = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Mensalidade mensalidade = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            mensalidade = new Mensalidade (rs.getBoolean("pagamento_pendente"), 
            rs.getInt("dia_vencimento"), rs.getDouble("valor_mensalidade"));
        }
        return mensalidade; 
    }
            
            
    public void inserirMensalidade(Mensalidade m, Associado a) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO mensalidade (id_associado, dia_vencimento) "
                + "VALUES ((SELECT MAX(id_associado) FROM associado), ?);";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setInt(1, m.getMes());
                System.out.println("sdsd");
        prepara.executeUpdate();
    }
    
    @Override
    public void inserir(Mensalidade m) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "INSERT INTO mensalidade (pagamento_pendente, data_vencimento, valor_mensalidade) "
                + "VALUES (?,?,?);";
        
        

        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setBoolean(1, m.isPagamentoPendente());
        prepara.setInt(2, m.getMes());
        prepara.setDouble(3, m.getValorMensalidade());

        prepara.executeUpdate();
    }

    public void alterar(Mensalidade m) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE mensalidade SET "
                + "pagamento_pendente = ?, data_vencimento = ?, valor_mensalidade = ? "
                + "WHERE id_mensalidade = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setBoolean(1, m.isPagamentoPendente());
        prepara.setInt(2, m.getMes());
        prepara.setDouble(3, m.getValorMensalidade());
        prepara.setInt(4, m.getIdMensalidade());
        
        prepara.executeUpdate();
    }
    
    public void alterar(Mensalidade m, Associado a) throws ClassNotFoundException, SQLException {
       Connection c = ConnectionClube.getConnection();
        
        String comando = "UPDATE mensalidade SET dia_vencimento = ? WHERE id_associado = ?;";
        
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        prepara.setInt(1, m.getMes());
        prepara.setInt(2, a.getId());
        
        prepara.executeUpdate();
    }
    

    @Override
    public void apagar(Mensalidade u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "DELETE FROM mensalidade "
                + "WHERE id_mensalidade = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, u.getIdMensalidade());
        prepara.executeUpdate();
    }

    @Override
    public Mensalidade buscarPorId(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM mensalidade "
                + "WHERE id_mensalidade = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Mensalidade mensalidade = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            mensalidade = new Mensalidade (rs.getBoolean("pagamento_pendente"), 
            rs.getInt("data_vencimento"), rs.getDouble("valor_mensalidade"));
        }
        return mensalidade; 
    }
    
    @Override
    public ArrayList<Mensalidade> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "SELECT * FROM mensalidade;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        
        ArrayList<Mensalidade> lista = new ArrayList<>();
        ResultSet rs = prepara.executeQuery();
        
        while(rs.next()) {//usando construtor sem Banco
            ArrayList<Mensalidade> listaMensalidade = new ArrayList<>();
            Mensalidade mensalidade = new Mensalidade (rs.getBoolean("pagamento_pendente"), 
            rs.getInt("data_vencimento"), rs.getDouble("valor_mensalidade"));
            lista.add(mensalidade);
        }
        return lista;    
    }   
    

    @Override
    public int count() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void apagarMensalidade(Associado u) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        String comando = "DELETE FROM mensalidade "
                + "WHERE id_associado = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, u.getId());
        prepara.executeUpdate();
    }
    
//    public Mensalidade verificarPendencia(Mensalidade m) throws ClassNotFoundException, SQLException {
//        Connection c = ConnectionClube.getConnection();
//        
//        String comando = "SELECT * FROM mensalidade WHERE id_associado = ?;";
//        System.out.println(""+m.getIdAssociado());
//        PreparedStatement prepara  = c.prepareStatement(comando);
//        prepara.setInt(1, m.getIdAssociado());
//         
//        Mensalidade mensalidade = null;
//        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
//        
//        while(rs.next()) {
//            mensalidade = new Mensalidade (rs.getBoolean("pagamento_pendente"), 
//            rs.getInt("data_vencimento"), rs.getDouble("valor_mensalidade"));
//        }
//        return mensalidade; 
//    }
    
    public Mensalidade verificarPendenciaIDAssociado(Integer i) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionClube.getConnection();
        
        String comando = "SELECT * FROM mensalidade "
                + "WHERE id_associado = ?;";
        PreparedStatement prepara  = c.prepareStatement(comando);
        prepara.setInt(1, i);
         
        Mensalidade mensalidade = null;
        ResultSet rs = prepara.executeQuery();//objeto ResultSet recebe todos os elementos da tabela buscada
        
        while(rs.next()) {
            mensalidade = new Mensalidade (rs.getBoolean("pagamento_pendente"), 
            rs.getInt("data_vencimento"), rs.getDouble("valor_mensalidade"));
        }
            return mensalidade; 
    }
    

    
}
