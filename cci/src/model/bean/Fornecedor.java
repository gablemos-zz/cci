/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author gabri
 */
public class Fornecedor {
   private String cnpj; 
   private String rsocial;
   private String nfantasia;
   private String contato;
   private String telefone;
   private String email;
   private Endereco endereco;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String rsocial, String nfantasia, String contato, String telefone, String email, Endereco endereco) {
        this.cnpj = cnpj;
        this.rsocial = rsocial;
        this.nfantasia = nfantasia;
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public String getNfantasia() {
        return nfantasia;
    }

    public void setNfantasia(String nfantasia) {
        this.nfantasia = nfantasia;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
   
}
