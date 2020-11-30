/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.aula.trabalhoprincipalclube.operacoes;

/**
 *
 * @author suporte
 */
public class Operacoes {
    

    public static String verificaLogin(String login, String senha){
        
        if(login.equals("admin") && senha.equals("123")){
            return "Admin";
        }else{
            return null;
        }
        
    }
    
}
