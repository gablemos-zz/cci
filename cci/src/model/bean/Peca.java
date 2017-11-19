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
public class Peca {
    private int id;
    private String descricao;
    private String unidade;
    private double valor;
    private Fornecedor fornecedor;

    public Peca() {
    }

    public Peca(String descricao, String unidade, double valor, Fornecedor fornecedor) {
        this.descricao = descricao;
        this.unidade = unidade;
        this.valor = valor;
        this.fornecedor = fornecedor;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
}
