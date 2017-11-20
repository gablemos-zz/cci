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
public class ValidaCNPJTest {
    
    public ValidaCNPJTest() {
    }

    @Test
    public void valoresIguais() {
        String cnpj = "44.444.444/4444-44";
        
        if(ValidaCNPJ.isCNPJ(cnpj)){
            System.out.println("CNPJ Válido");
        }else{
            fail("CNPJ Invalido, valor iguais");
        }
    }
    
    @Test
    public void valorValido() {
        String cnpj = "43.644.253/0001-00";
        
        if(ValidaCNPJ.isCNPJ(cnpj)){
            System.out.println("CNPJ Válido");
        }else{
            fail("CNPJ Invalido");
        }
    }
    
    @Test
    public void valorLongo() {
        String cnpj = "43.644.253/0001-000";
        
        if(ValidaCNPJ.isCNPJ(cnpj)){
            System.out.println("CNPJ Válido");
        }else{
            fail("CNPJ Invalido, valor longo");
        }
    }
    
    @Test
    public void valorCurto() {
        String cnpj = "43.644.253/0001-0";
        
        if(ValidaCNPJ.isCNPJ(cnpj)){
            System.out.println("CNPJ Válido");
        }else{
            fail("CNPJ Invalido, valor curto");
        }
    }
    
    @Test
    public void valorLetra() {
        String cnpj = "43.644.253/0001-0A";
        
        if(ValidaCNPJ.isCNPJ(cnpj)){
            System.out.println("CNPJ Válido");
        }else{
            fail("CNPJ Invalido, valor não numérico");
        }
    }
    
}
