/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Funcionario;
import model.bean.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("617.941.054-25");
        
        Usuario usuario = new Usuario(
                "123", 
                "123", 
                funcionario);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.salvar(usuario)){
            System.out.println("Usuário criado com sucesso");
        }else{
            fail("Erro ao criar usuário");
        }
    }
    
    @Test
    @Ignore
    public void alterar() {
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("219.538.462-03");
    
        Usuario usuario = new Usuario("bulkyu", "sollua135", funcionario);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.alterar(usuario)){
            System.out.println("Usuário alterado com sucesso");
        }else{
            fail("Erro ao criar alterado");
        }
    }
    
    @Test
    @Ignore
    public void deletar() {
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("219.538.462-03");
    
        Usuario usuario = new Usuario();
        usuario.setFuncionario(funcionario);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.apagar(usuario)){
            System.out.println("Usuário alterado com sucesso");
        }else{
            fail("Erro ao criar alterado");
        }
    }
    
    @Test
    @Ignore
    public void existeCPF(){
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("617.941.054-25");
    
        Usuario usuario = new Usuario();
        usuario.setFuncionario(funcionario);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.verificarExistencia(usuario.getFuncionario().getCpf())){
            System.out.println("CEP Existente");
        }else{
            System.out.println("CEP Inesistente");
        }
    }
    
    @Test
    @Ignore
    public void buscarTodos(){
        UsuarioDAO dao = new UsuarioDAO();
        
        for(Usuario u: dao.buscarTodos()){
            System.out.println(
                    "Usuário: "+u.getUsuario()+  
                    "\nSenha: "+u.getSenha()+  
                    "\nCPF Funcionario: " + u.getFuncionario().getCpf()+
                    "\nNome Funcionario: "+ u.getFuncionario().getNome() +
                    "\nTelefone Funcionario: "+u.getFuncionario().getTelefone()+
                    "\nE-mail Funcionario: "+u.getFuncionario().getEmail()+
                    "\nCargo: "+u.getFuncionario().getCargo()+  
                    "\n--------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void buscarPorCPF(){
        UsuarioDAO dao = new UsuarioDAO();
        String cpf = "617.941.054-25";
        for(Usuario u: dao.buscarCPF(cpf)){
            System.out.println(
                    "Usuário: "+u.getUsuario()+  
                    "\nSenha: "+u.getSenha()+  
                    "\nCPF Funcionario: " + u.getFuncionario().getCpf()+
                    "\nNome Funcionario: "+ u.getFuncionario().getNome() +
                    "\nTelefone Funcionario: "+u.getFuncionario().getTelefone()+
                    "\nE-mail Funcionario: "+u.getFuncionario().getEmail()+
                    "\nCargo: "+u.getFuncionario().getCargo()+  
                    "\n--------------------------------------");
        }
    }
    
    @Test
    public void logar(){
        UsuarioDAO dao = new UsuarioDAO();
        
        String usuario = "123";
        String senha = "12345";
        
        if(dao.validarLogin(usuario, senha)){
            System.out.println("Logado");
        }else{
            System.out.println("Verifique o usuário e senha");
        }
    }
    
}
