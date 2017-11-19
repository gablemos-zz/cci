/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Servico {
    private int id;
    private String descicao;
    private Date data;
    private Date hora;
    private int tempo;
    private double valor;
    private Cliente cliente;
    private Funcionario funcionario;
    private Peca peca;

    public Servico() {
    }

    public Servico(String descicao, Date data, Date hora, int tempo, double valor, Cliente cliente, Funcionario funcionario, Peca peca) {
        this.descicao = descicao;
        this.data = data;
        this.hora = hora;
        this.tempo = tempo;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.peca = peca;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    
    
    
}
