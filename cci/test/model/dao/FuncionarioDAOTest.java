/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Funcionario;
import model.bean.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class FuncionarioDAOTest {
    
    public FuncionarioDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Endereco endereco = new Endereco();
        endereco.setCep("11111111");
        Funcionario funcionario =  new Funcionario(
                "222.222.222-20", 
                "Gabriel Lemos", 
                "(12)98216-2512", 
                "gabriel@google.com", 
                "Técnico",
                endereco);
        
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if(dao.salvar(funcionario)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }        
    }
    
    @Test
    @Ignore
    public void existeCPF(){
        FuncionarioDAO dao = new FuncionarioDAO();
        String cpf = "222.222.222-22";
        if(dao.verificarExistencia(cpf)){
            System.out.println("CEP Existente");
        }else{
            System.out.println("CEP Inesistente");
        }
    }
    
    @Test
    @Ignore
    public void alterar(){
        Endereco endereco = new Endereco();
        endereco.setCep("11111111");
        Funcionario funcionario =  new Funcionario(
                "222.222.222-22", 
                "Rafaela Elias Lemos", 
                "(12)98216-2512", 
                "gabriel@google.com", 
                "Técnico",
                endereco);
        
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if(dao.alterar(funcionario)){
            System.out.println("Alterado com sucesso");
        }else{
            fail("Erro ao Alterar");
        }  
    }
    
    @Test
    @Ignore
    public void deletar() {

        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("222.222.222-22");

        FuncionarioDAO dao = new FuncionarioDAO();

        if (dao.apagar(funcionario)) {
            System.out.println("Apagado com sucesso");
        } else {
            fail("Erro ao Apagar");
        }
    }
    
    @Test
    @Ignore
    public void buscarTodos(){
        FuncionarioDAO dao = new FuncionarioDAO();
        
        for(Funcionario c: dao.buscarTodos()){
            System.out.println(
                    "CPF: " + c.getCpf() +
                    "\nNome: "+ c.getNome() +
                    "\nTelefone"+c.getTelefone()+
                    "\nE-mail"+c.getEmail()+
                    "\nCargo: "+c.getCargo()+        
                    "\nCEP"+c.getEndereco().getCep()+
                    "\nUF"+c.getEndereco().getUf()+
                    "\nCidade"+c.getEndereco().getCidade()+
                    "\nBairro"+c.getEndereco().getBairro()+
                    "\nRua"+c.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void buscarPorCPF(){
        FuncionarioDAO dao = new FuncionarioDAO();
        String cpf = "222.222.222-20";
        for(Funcionario c: dao.buscarCPF(cpf)){
            System.out.println(
                    "CPF: " + c.getCpf() +
                    "\nNome: "+ c.getNome() +
                    "\nTelefone"+c.getTelefone()+
                    "\nE-mail"+c.getEmail()+
                    "\nCargo: "+c.getCargo()+        
                    "\nCEP"+c.getEndereco().getCep()+
                    "\nUF"+c.getEndereco().getUf()+
                    "\nCidade"+c.getEndereco().getCidade()+
                    "\nBairro"+c.getEndereco().getBairro()+
                    "\nRua"+c.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void buscarPorNome(){
        FuncionarioDAO dao = new FuncionarioDAO();
        String nome = "Lem";
        for(Funcionario c: dao.buscarNome(nome)){
            System.out.println(
                   "CPF: " + c.getCpf() +
                    "\nNome: "+ c.getNome() +
                    "\nTelefone"+c.getTelefone()+
                    "\nE-mail"+c.getEmail()+
                    "\nCargo: "+c.getCargo()+        
                    "\nCEP"+c.getEndereco().getCep()+
                    "\nUF"+c.getEndereco().getUf()+
                    "\nCidade"+c.getEndereco().getCidade()+
                    "\nBairro"+c.getEndereco().getBairro()+
                    "\nRua"+c.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
}
