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
    private String data;
    private String hora;
    private int tempo;
    private double valor;
    private String status;
    private Cliente cliente;
    private Funcionario funcionario;

    public Servico() {
    }

    public Servico(int id, String descicao, String data, String hora, int tempo, double valor, String status, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.descicao = descicao;
        this.data = data;
        this.hora = hora;
        this.tempo = tempo;
        this.valor = valor;
        this.status = status;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
    
    public Servico(int id, String descicao, String data, String hora, int tempo, double valor, String status) {
        this.id = id;
        this.descicao = descicao;
        this.data = data;
        this.hora = hora;
        this.tempo = tempo;
        this.valor = valor;
        this.status = status;
    }
    
    public Servico(int id, String descicao, String data, String hora, int tempo, double valor, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.descicao = descicao;
        this.data = data;
        this.hora = hora;
        this.tempo = tempo;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Servico(String descicao, String data, String hora, int tempo, double valor, String status, Cliente cliente, Funcionario funcionario) {
        this.descicao = descicao;
        this.data = data;
        this.hora = hora;
        this.tempo = tempo;
        this.valor = valor;
        this.status = status;
        this.cliente = cliente;
        this.funcionario = funcionario;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    
    
}
