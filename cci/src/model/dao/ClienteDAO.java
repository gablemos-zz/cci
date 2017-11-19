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
import model.bean.Cliente;
import model.bean.Endereco;

/**
 *
 * @author gabri
 */
public class ClienteDAO {

    private String sql = "";
    private Connection con = null;

    public ClienteDAO() {
    }

    //Método INSERT
    public boolean salvar(Cliente cliente) {
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO cliente VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco().getCep());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    // TODO Udate 
    public boolean alterar(Cliente cliente) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, endereco_cep = ? WHERE cpf = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco().getCep());            
            stmt.setString(5, cliente.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    // TODO Delete
    public boolean apagar(Cliente cliente){
        sql = "DELETE FROM cliente WHERE cpf = ?";
        con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Método verifica se um cliente já consta no bd
    public boolean verificarExistencia(String cpf){
        con = ConnectionFactory.getConnection();
        sql = "SELECT cpf FROM cliente WHERE cpf = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();            
            return rs.first();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    //Método SELECT *
    public List<Cliente> buscarTodos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM cliente c INNER JOIN endereco e ON e.cep = c.endereco_cep;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Endereco endereco = new Endereco(
                        rs.getString("cep"), 
                        rs.getString("uf"), 
                        rs.getString("cidade"), 
                        rs.getString("bairro"), 
                        rs.getString("rua"));
                
                
                Cliente cliente = new Cliente(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"), 
                        endereco);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return clientes;
    }
    

    //Método buscar cliente especifico
    public List<Cliente> buscarCPF(String cpf){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM cliente c INNER JOIN endereco e ON e.cep = c.endereco_cep WHERE c.cpf = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Endereco endereco = new Endereco(
                        rs.getString("cep"), 
                        rs.getString("uf"), 
                        rs.getString("cidade"), 
                        rs.getString("bairro"), 
                        rs.getString("rua"));
                
                
                Cliente cliente = new Cliente(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"), 
                        endereco);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return clientes;
    }  
    
    //Método buscar clientes pelo nome
    public List<Cliente> buscarNome(String nome){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM cliente c INNER JOIN endereco e ON e.cep = c.endereco_cep WHERE c.nome LIKE ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Endereco endereco = new Endereco(
                        rs.getString("cep"), 
                        rs.getString("uf"), 
                        rs.getString("cidade"), 
                        rs.getString("bairro"), 
                        rs.getString("rua"));
                
                
                Cliente cliente = new Cliente(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"), 
                        endereco);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return clientes;
    }
}
