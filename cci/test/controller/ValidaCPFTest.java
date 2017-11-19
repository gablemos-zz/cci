/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabri
 */
public class ValidaCPFTest {
    
    public ValidaCPFTest() {
    }    
    
    @Test
    public void validoCPF() {
        String cpf = "436.923.818-83";
        if (ValidaCPF.isCPF(cpf) == true) {
            System.out.printf("CPF Válido !!!\n");
        } else {
            System.out.printf("Erro, CPF invalido !!!\n");
        }
    }
    
    @Test
    public void grandeCPF() {
        String cpf = "436.923.818-839";
        if (ValidaCPF.isCPF(cpf) == true) {
            System.out.printf("CPF Válido !!!\n");
        } else {
            System.out.printf("Erro, CPF invalido Grande !!!\n");
        }
    }
    
    @Test
    public void letraCPF() {
        String cpf = "436.923.818-8E";
        if (ValidaCPF.isCPF(cpf) == true) {
            System.out.printf("CPF Válido !!!\n");
        } else {
            System.out.printf("Erro, CPF invalido com letra!!!\n");
        }
    }
    
    @Test
    public void sequenciaCPF() {
        String cpf = "111.111.111-11";
        if (ValidaCPF.isCPF(cpf) == true) {
            System.out.printf("CPF Válido !!!\n");
        } else {
            System.out.printf("Erro, CPF invalido sequencial !!!\n");
        }
    }
    
}
