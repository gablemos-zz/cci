/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Fornecedor;
import model.bean.Peca;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class PecaDAOTest {
    
    public PecaDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("42.813.905/0001-20");
        
        Peca peca =  new Peca(
                "Motor", 
                "conjunto",
                305.50,
                fornecedor);
        
        PecaDAO dao = new PecaDAO();
        
        if(dao.salvar(peca)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }        
    }
    
    @Test
    @Ignore
    public void alterar(){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("42.813.905/0001-20");
        
        Peca peca =  new Peca(
                "Motor", 
                "und",
                301.50,
                fornecedor);
        
        peca.setId(3);
        
        PecaDAO dao = new PecaDAO();
        
        if(dao.alterar(peca)){
            System.out.println("Alterado com sucesso");
        }else{
            fail("Erro ao Alterar");
        }  
    }
    
    @Test
    @Ignore 
    public void deletar() {

        Peca peca = new Peca();
        peca.setId(1);

        PecaDAO dao = new PecaDAO();

        if (dao.apagar(peca)) {
            System.out.println("Apagado com sucesso");
        } else {
            fail("Erro ao Apagar");
        }
    }
    
    
    
    @Test
    @Ignore
    public void existePeca(){
        PecaDAO dao = new PecaDAO();
        
        Peca peca = new Peca();
        peca.setId(6);
        
        if(dao.verificarExistencia(peca.getId())){
            System.out.println("Peca já cadastrada");
        }else{
            System.out.println("Peca não cadastrada");
        }
    }
    
    @Test
    @Ignore
    public void buscarTodos(){
        PecaDAO dao = new PecaDAO();
        
        for(Peca p: dao.buscarTodos()){
            System.out.println(
                    "Código: " + p.getId()+
                    "\nDescrição: " + p.getDescricao()+
                    "\nUnidade: " + p.getUnidade()+
                    "\nValor: R$" + p.getValor()+
                    "\nCNPJ: " + p.getFornecedor().getCnpj()+
                    "\nRazão Social: "+ p.getFornecedor().getRsocial()+
                    "\nNome Fantasia: "+p.getFornecedor().getNfantasia()+
                    "\nContato: "+p.getFornecedor().getContato()+
                    "\nTelefone: "+p.getFornecedor().getTelefone()+        
                    "\nE-mail: "+p.getFornecedor().getEmail()+
                    "\n--------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void buscarPorID(){
        PecaDAO dao = new PecaDAO();
        
        Peca peca = new Peca();
        peca.setId(3);
        
        for(Peca p: dao.buscarId(peca.getId())){
            System.out.println(
                    "Código: " + p.getId()+
                    "\nDescrição: " + p.getDescricao()+
                    "\nUnidade: " + p.getUnidade()+
                    "\nValor: R$" + p.getValor()+
                    "\nCNPJ: " + p.getFornecedor().getCnpj()+
                    "\nRazão Social: "+ p.getFornecedor().getRsocial()+
                    "\nNome Fantasia: "+p.getFornecedor().getNfantasia()+
                    "\nContato: "+p.getFornecedor().getContato()+
                    "\nTelefone: "+p.getFornecedor().getTelefone()+        
                    "\nE-mail: "+p.getFornecedor().getEmail()+
                    "\n--------------------------------------");
        }
    }
    
    @Test
    //@Ignore
    public void buscarPorNome(){
        PecaDAO dao = new PecaDAO();
        
        String nome = "o";
        
        for(Peca p: dao.buscarNome(nome)){
            System.out.println(
                    "Código: " + p.getId()+
                    "\nDescrição: " + p.getDescricao()+
                    "\nUnidade: " + p.getUnidade()+
                    "\nValor: R$" + p.getValor()+
                    "\nCNPJ: " + p.getFornecedor().getCnpj()+
                    "\nRazão Social: "+ p.getFornecedor().getRsocial()+
                    "\nNome Fantasia: "+p.getFornecedor().getNfantasia()+
                    "\nContato: "+p.getFornecedor().getContato()+
                    "\nTelefone: "+p.getFornecedor().getTelefone()+        
                    "\nE-mail: "+p.getFornecedor().getEmail()+
                    "\n--------------------------------------");
        }
    }
    
}
