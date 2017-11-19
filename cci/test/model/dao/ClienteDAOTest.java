/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;
import model.bean.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Endereco endereco = new Endereco();
        endereco.setCep("11111111");
        Cliente cliente =  new Cliente(
                "222.222.222-22", 
                "Gabriel Lemos", 
                "(12)98216-2512", 
                "gabriel@google.com", 
                endereco);
        
        ClienteDAO dao = new ClienteDAO();
        
        if(dao.salvar(cliente)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }        
    }
    
    @Test
    public void existeCPF(){
        ClienteDAO dao = new ClienteDAO();
        String cpf = "111.222.333-44";
        if(dao.verificarExistencia(cpf)){
            System.out.println("CEP Existente");
        }else{
            System.out.println("CEP Inesistente");
        }
    }
    
    @Test
    public void alterar(){
        Endereco endereco = new Endereco();
        endereco.setCep("11111111");
        Cliente cliente =  new Cliente(
                "222.222.222-22", 
                "Gabriel Elias Lemos", 
                "(12)98216-2512", 
                "gabriel@google.com", 
                endereco);
        
        ClienteDAO dao = new ClienteDAO();
        
        if(dao.alterar(cliente)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }  
    }
    
    @Test
    @Ignore
    public void deletar() {

        Cliente cliente = new Cliente();
        cliente.setCpf("111.111.111-11");

        ClienteDAO dao = new ClienteDAO();

        if (dao.apagar(cliente)) {
            System.out.println("Apagado com sucesso");
        } else {
            fail("Erro ao Apagar");
        }
    }
    
    @Test
    @Ignore
    public void buscarTodos(){
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c: dao.buscarTodos()){
            System.out.println(
                    "CPF: " + c.getCpf() +
                    "\nNome: "+ c.getNome() +
                    "\nTelefone"+c.getTelefone()+
                    "\nE-mail"+c.getEmail()+
                    "\nCEP"+c.getEndereco().getCep()+
                    "\nUF"+c.getEndereco().getUf()+
                    "\nCidade"+c.getEndereco().getCidade()+
                    "\nBairro"+c.getEndereco().getBairro()+
                    "\nRua"+c.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
}
