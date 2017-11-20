/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Endereco;
import model.bean.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class FornecedorDAOTest {
    
    public FornecedorDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Endereco endereco = new Endereco();
        endereco.setCep("11111111");
        
        Fornecedor fornecedor =  new Fornecedor(
                "15.210.512/0001-50", 
                "Teste2 Fornecedor2 Ltda.",
                "Teste2 Empresa2",
                "Gabriel",
                "(12)03336-7526",
                "email@email.com",
                endereco);
        
        FornecedorDAO dao = new FornecedorDAO();
        
        if(dao.salvar(fornecedor)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }        
    }
    
    @Test
    @Ignore
    public void alterar(){
        Endereco endereco = new Endereco();
        endereco.setCep("11111111");
        Fornecedor fornecedor =  new Fornecedor(
                "02.775.521/0001-46", 
                "Software House Ltda.",
                "Micrograma Teste Shoftware",
                "Gabriel",
                "(12)03336-7526",
                "email@email.com",
                endereco);
        
        FornecedorDAO dao = new FornecedorDAO();
        
        if(dao.alterar(fornecedor)){
            System.out.println("Alterado com sucesso");
        }else{
            fail("Erro ao Alterar");
        }  
    }
    
    @Test
    @Ignore 
    public void deletar() {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("15.210.512/0001-50");

        FornecedorDAO dao = new FornecedorDAO();

        if (dao.apagar(fornecedor)) {
            System.out.println("Apagado com sucesso");
        } else {
            fail("Erro ao Apagar");
        }
    }
    
    
    
    @Test
    @Ignore
    public void existeCPF(){
        FornecedorDAO dao = new FornecedorDAO();
        String cnpj = "02.775.521/0001-46";
        if(dao.verificarExistencia(cnpj)){
            System.out.println("CEP Existente");
        }else{
            System.out.println("CEP Inesistente");
        }
    }
    
    @Test
    @Ignore
    public void buscarTodos(){
        FornecedorDAO dao = new FornecedorDAO();
        
        for(Fornecedor f: dao.buscarTodos()){
            System.out.println(
                    "CNPJ: " + f.getCnpj()+
                    "\nRazão Social: "+ f.getRsocial()+
                    "\nNome Fantasia: "+f.getNfantasia()+
                    "\nContato: "+f.getContato()+
                    "\nTelefone: "+f.getTelefone()+        
                    "\nE-mail: "+f.getEmail()+        
                    "\nCEP: "+f.getEndereco().getCep()+
                    "\nUF: "+f.getEndereco().getUf()+
                    "\nCidade: "+f.getEndereco().getCidade()+
                    "\nBairro: "+f.getEndereco().getBairro()+
                    "\nRua: "+f.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void buscarPorCPF(){
        FornecedorDAO dao = new FornecedorDAO();
        String cnpj = "02.775.521/0001-46";
        for(Fornecedor f: dao.buscarCPF(cnpj)){
            System.out.println(
                    "CNPJ: " + f.getCnpj()+
                    "\nRazão Social: "+ f.getRsocial()+
                    "\nNome Fantasia: "+f.getNfantasia()+
                    "\nContato: "+f.getContato()+
                    "\nTelefone: "+f.getTelefone()+        
                    "\nE-mail: "+f.getEmail()+        
                    "\nCEP: "+f.getEndereco().getCep()+
                    "\nUF: "+f.getEndereco().getUf()+
                    "\nCidade: "+f.getEndereco().getCidade()+
                    "\nBairro: "+f.getEndereco().getBairro()+
                    "\nRua: "+f.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void buscarPorNome(){
        FornecedorDAO dao = new FornecedorDAO();
        String nome = "Teste";
        for(Fornecedor f: dao.buscarNome(nome)){
            System.out.println(
                    "CNPJ: " + f.getCnpj()+
                    "\nRazão Social: "+ f.getRsocial()+
                    "\nNome Fantasia: "+f.getNfantasia()+
                    "\nContato: "+f.getContato()+
                    "\nTelefone: "+f.getTelefone()+        
                    "\nE-mail: "+f.getEmail()+        
                    "\nCEP: "+f.getEndereco().getCep()+
                    "\nUF: "+f.getEndereco().getUf()+
                    "\nCidade: "+f.getEndereco().getCidade()+
                    "\nBairro: "+f.getEndereco().getBairro()+
                    "\nRua: "+f.getEndereco().getRua()+
                    "\n--------------------------------------");
        }
    }
    
}
