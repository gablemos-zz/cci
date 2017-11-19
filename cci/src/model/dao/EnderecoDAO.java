/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Endereco;

/**
 *
 * @author gabri
 */
public class EnderecoDAO {
    private String sql = "";
    private Connection con = null;
    
    
    public EnderecoDAO(){
    }
    
    //Método INSERT
    public boolean salvar(Endereco endereco){
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO endereco VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getUf());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getRua());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    // TODO Udate    
    // TODO Delete
    
    //Método SELECT *
    public List<Endereco> buscarTodos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM endereco";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Endereco> enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Endereco endereco = new Endereco(
                        rs.getString("cep"), 
                        rs.getString("uf"), 
                        rs.getString("cidade"), 
                        rs.getString("bairro"), 
                        rs.getString("rua"));
                enderecos.add(endereco);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return enderecos;
    }
    
    //Método verifica se um endereço já consta no bd
    public boolean verificarExistencia(String cep){
        con = ConnectionFactory.getConnection();
        sql = "SELECT cep FROM endereco WHERE cep = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cep);
            rs = stmt.executeQuery();            
            return rs.first();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    //Método buscar endereço especifico
    public List<Endereco> buscar(String cep){
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM endereco WHERE cep = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Endereco> enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cep);
            rs = stmt.executeQuery();
            while(rs.next()){
                Endereco endereco = new Endereco(
                        rs.getString("cep"), 
                        rs.getString("uf"), 
                        rs.getString("cidade"), 
                        rs.getString("bairro"), 
                        rs.getString("rua"));
                enderecos.add(endereco);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return enderecos;
    }
}
