/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.database.connection;

import br.edu.vianna.aula.trabalhoprincipalclube.associado.subclass.Associado;
import br.edu.vianna.aula.trabalhoprincipalclube.database.connection.dao.DAOAssociado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author suporte
 */
public class ConnectionClube {//padrao singleton
    private static Connection conexao;//static - torna essa variavel uma variavel da classe e nao do objeto

    private ConnectionClube() {//construtor private pra nao ser instanciado nenhum objeto desse tipo
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        if(conexao == null){//se nao houver conexao ativa
            
            
            Class.forName("com.mysql.jdbc.Driver");//driver do mysql 8
            //driver mysql 8 com.mysql.cj.jdbc.Driver
            //driver mysql 5 com.mysql.jdbc.Driver
            //driver maria org.mariadb.jdbc.Driver ou com.mysql.jdbc.Driver
                    
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/abrigopet", "root", "belezinha");//conecta local
//            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/abrigopet", "root", "belezinha");//conecta online
        }
        
        return conexao;
        
    }
    
    //provavelmente vai ser apagado depois
    public static void main(String[] args) {
      
//        Associado usu = new Associado();
//        Animal usa = new Gato(ECatRaca.PERSA, 0, "Malaquias", EAnimalSexo.F, "2002", false, false);
//        try {
//            
//            //----testes DAO
//            new DAOAssociado().buscarPorId(usu);
//            new DAOAnimal().inserirAdocao(usa);
//            new DAOAdotante().inserir(usu);
//            new DAOAnimal().inserir(usa);
//            new DAORecurso().alterar(usu);
//            new DAOAdotante().inserir(usu);
//            new DAOUsuario().buscarPorId(7);
//            
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Erro no Main");
//        } catch (SQLException ex) {
//            System.out.println("Erro geral!");
//        }



    //-----------------------TESTAR CONEXAO COM BANCO (RETORNA NOME DO BANCO)
        Connection c = null;
        
        try {
            c = getConnection();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel se conectar ao banco.");
        }
        
        try{
            System.out.println(" " + c.getCatalog());
        } catch (SQLException ex) {
            System.out.println("Erro no Main");
//        } catch (NullPointerException ex) {
//            System.out.println("Objeto Nulo");
        } catch (Exception ex){
            System.out.println("Erro geral!");
        }
        //---------------------------------------------
        
    }
}
