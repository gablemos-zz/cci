/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import controller.ViaCEP;
import controller.ViaCEPException;
import model.bean.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class EnderecoDAOTest {
    
    public EnderecoDAOTest() {
    }

    @Test
    public void Inserir() {
        Endereco endereco = new Endereco("11111111", "EK", "Azeroth", "Ogrimmar", "HORDA");
        EnderecoDAO dao = new EnderecoDAO();
        
        if(dao.salvar(endereco)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }
    }
    
    @Test
    public void InserirViaCEP() throws ViaCEPException {
        String cep = "12306749";
        ViaCEP viaCEP = new ViaCEP(cep);
        
        Endereco endereco = new Endereco(cep, 
                viaCEP.getUf(), 
                viaCEP.getLocalidade(), 
                viaCEP.getBairro(), 
                viaCEP.getLogradouro());
        
        EnderecoDAO dao = new EnderecoDAO();
        
        if(dao.salvar(endereco)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }
    }
    
    @Test
    public void listarTodos(){
        EnderecoDAO dao = new EnderecoDAO();
        
        for(Endereco e: dao.buscarTodos()){
            System.out.println(
                    "CEP: "+e.getCep()+
                    "\nUF: "+e.getUf()+
                    "\nCidade: "+e.getCidade()+
                    "\nBairro: "+e.getBairro()+
                    "\nRua: "+e.getRua()+
                    "\n----------------------------------------------");
        }
        
    }
    
    @Test
    public void existeCEP(){
        EnderecoDAO dao = new EnderecoDAO();
        String cep = "12306749";
        if(dao.verificarExistencia(cep)){
            System.out.println("CEP Existente");
        }else{
            System.out.println("CEP Inesistente");
        }
    }
    
}
