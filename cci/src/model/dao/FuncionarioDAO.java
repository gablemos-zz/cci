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
import model.bean.Funcionario;
import model.bean.Endereco;

/**
 *
 * @author gabri
 */
public class FuncionarioDAO {

    private String sql = "";
    private Connection con = null;

    public FuncionarioDAO() {
    }

    //Método INSERT
    public boolean salvar(Funcionario funcionario) {
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO funcionario VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getEndereco().getCep());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    // Udate 
    public boolean alterar(Funcionario funcionario) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE funcionario SET nome = ?, telefone = ?, email = ?, cargo = ?, endereco_cep = ? WHERE cpf = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getTelefone());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getCargo());
            stmt.setString(5, funcionario.getEndereco().getCep());            
            stmt.setString(6, funcionario.getCpf());
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
    public boolean apagar(Funcionario funcionario){
        sql = "DELETE FROM funcionario WHERE cpf = ?";
        con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Método verifica se um funcionario já consta no bd
    public boolean verificarExistencia(String cpf){
        con = ConnectionFactory.getConnection();
        sql = "SELECT cpf FROM funcionario WHERE cpf = ?";
        
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
    public List<Funcionario> buscarTodos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM funcionario f INNER JOIN endereco e ON e.cep = f.endereco_cep;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
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
                
                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"), 
                        rs.getString("cargo"), 
                        endereco);
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return funcionarios;
    }
    

    //Método buscar funcionario especifico
    public List<Funcionario> buscarCPF(String cpf){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM funcionario c INNER JOIN endereco e ON e.cep = c.endereco_cep WHERE c.cpf = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
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
                
                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cargo"),
                        endereco);
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return funcionarios;
    }  
    
    //Método buscar funcionarios pelo nome
    public List<Funcionario> buscarNome(String nome){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM funcionario c INNER JOIN endereco e ON e.cep = c.endereco_cep WHERE c.nome LIKE ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
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
                
                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"), 
                        rs.getString("cargo"),
                        endereco);
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return funcionarios;
    }
    
}
