/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;
import model.bean.Fornecedor;
import model.bean.Funcionario;
import model.bean.Peca;
import model.bean.Servico;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class ServicoDAOTest {
    
    public ServicoDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        
        Cliente cliente = new Cliente();
        cliente.setCpf("424.799.618-50");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("424.799.618-50");
        
        Servico servico =  new Servico(
                "Reparo Portão", 
                "21/11/2017", 
                "15:20", 
                2, 
                250.33, 
                "Aberto", 
                cliente, 
                funcionario);
        
        ServicoDAO dao = new ServicoDAO();
        
        if(dao.salvar(servico)){
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        } 
    }
    
    @Test
    @Ignore
    public void alterar() {
        
        Cliente cliente = new Cliente();
        cliente.setCpf("424.799.618-50");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("424.799.618-50");
        
        Servico servico =  new Servico(
                "Reparo Portão", 
                "21/11/2017", 
                "16:20", 
                2, 
                250.33, 
                "Aberto", 
                cliente, 
                funcionario);
        
        servico.setId(1);
        
        ServicoDAO dao = new ServicoDAO();
        
        if(dao.alterar(servico)){
            System.out.println("Alterado com sucesso");
        }else{
            fail("Erro ao alterar");
        } 
    }
    
    @Test
    public void atender() {     
        
        Servico servico =  new Servico();        
        servico.setId(2);
        
        ServicoDAO dao = new ServicoDAO();
        
        if(dao.executar(servico)){
            System.out.println("Atendido com sucesso");
        }else{
            fail("Erro ao atender");
        } 
    }
    
    @Test
    public void chamadosAbertos() {
        
        ServicoDAO dao = new ServicoDAO();
        
        for(Servico s: dao.buscarTodosAbertos()){
            System.out.println(
                    "Código de Atendimento: " + s.getId()+
                    "\nDescrição: " + s.getDescicao()+
                    "\nData: " + s.getData()+
                    "\nHora: R$" + s.getHora()+
                    "\nValor: R$" + s.getValor()+
                    "\nCliente: "+ s.getCliente().getNome()+
                    "\nTelefone: "+ s.getCliente().getTelefone()+
                    "\nFuncionário: "+s.getFuncionario().getNome()+
                    "\n--------------------------------------");
        }
    }
    
}
