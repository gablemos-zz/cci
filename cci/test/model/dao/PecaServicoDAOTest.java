/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Peca;
import model.bean.PecaServico;
import model.bean.Servico;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabri
 */
public class PecaServicoDAOTest {
    
    public PecaServicoDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Peca peca = new Peca();
        peca.setId(5);
        
        Servico servico = new Servico();
        servico.setId(2);
        
        PecaServico pecaservico = new PecaServico(peca, servico);
        
        PecaServicoDAO dao = new PecaServicoDAO();
        
        if(dao.salvar(pecaservico)){
            System.out.println("inserido com sucesso");
        }else{
            fail("Erro ao inserir");
        }
    }
    
    @Test
    @Ignore
    public void apagar() {        
        PecaServico pecaservico = new PecaServico();
        pecaservico.setId(1);
        
        PecaServicoDAO dao = new PecaServicoDAO();
        
        if(dao.apagar(pecaservico)){
            System.out.println("removido com sucesso");
        }else{
            fail("Erro ao remover");
        }
    }
    
    @Test
    public void buscar(){
        PecaServicoDAO dao = new PecaServicoDAO();
        
        for(PecaServico ps: dao.buscarPorServico(2)){
            System.out.println(
                    "Código: " + ps.getId()+
                            "\nPeça: " + ps.getPeca().getDescricao()+
                            "\nServiço: " +ps.getServico().getStatus() +
                    "\n--------------------------------------");
        }
    }
    
}
