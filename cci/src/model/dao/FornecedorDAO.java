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
import model.bean.Fornecedor;
import model.bean.Endereco;

/**
 *
 * @author gabri
 */
public class FornecedorDAO {

    private String sql = "";
    private Connection con = null;

    public FornecedorDAO() {
    }

    //Método INSERT
    public boolean salvar(Fornecedor fornecedor) {
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO fornecedor VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getRsocial());
            stmt.setString(3, fornecedor.getNfantasia());
            stmt.setString(4, fornecedor.getContato());
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setString(6, fornecedor.getEmail());
            stmt.setString(7, fornecedor.getEndereco().getCep());
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
    public boolean alterar(Fornecedor fornecedor) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE fornecedor SET rsocial = ?, nfantasia = ?, contato = ?, telefone = ?, email = ?, endereco_cep = ? WHERE cnpj = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getRsocial());
            stmt.setString(2, fornecedor.getNfantasia());
            stmt.setString(3, fornecedor.getContato());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getEndereco().getCep());            
            stmt.setString(7, fornecedor.getCnpj());
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
    public boolean apagar(Fornecedor fornecedor){
        sql = "DELETE FROM fornecedor WHERE cnpj = ?";
        con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Método verifica se um fornecedor já consta no bd
    public boolean verificarExistencia(String cnpj){
        con = ConnectionFactory.getConnection();
        sql = "SELECT cnpj FROM fornecedor WHERE cnpj = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cnpj);
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
    public List<Fornecedor> buscarTodos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM fornecedor f INNER JOIN endereco e ON e.cep = f.endereco_cep;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedors = new ArrayList<>();
        
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
                
                
                Fornecedor fornecedor = new Fornecedor(
                        rs.getString("cnpj"),
                        rs.getString("rsocial"),
                        rs.getString("nfantasia"),
                        rs.getString("contato"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        endereco);
                
                fornecedors.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return fornecedors;
    }
    

    //Método buscar fornecedor especifico
    public List<Fornecedor> buscarCPF(String cpf){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM fornecedor f INNER JOIN endereco e ON e.cep = f.endereco_cep WHERE f.cnpj = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedors = new ArrayList<>();
        
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
                
                
                Fornecedor fornecedor = new Fornecedor(
                        rs.getString("cnpj"),
                        rs.getString("rsocial"),
                        rs.getString("nfantasia"),
                        rs.getString("contato"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        endereco);
                
                fornecedors.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return fornecedors;
    }  
    
    //Método buscar fornecedors pelo nome
    public List<Fornecedor> buscarNome(String nome){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM fornecedor f INNER JOIN endereco e ON e.cep = f.endereco_cep WHERE (f.rsocial LIKE ? OR f.nfantasia LIKE ?);";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedors = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            stmt.setString(2, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Endereco endereco = new Endereco(
                        rs.getString("cep"), 
                        rs.getString("uf"), 
                        rs.getString("cidade"), 
                        rs.getString("bairro"), 
                        rs.getString("rua"));
                
                
                Fornecedor fornecedor = new Fornecedor(
                        rs.getString("cnpj"),
                        rs.getString("rsocial"),
                        rs.getString("nfantasia"),
                        rs.getString("contato"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        endereco);
                
                fornecedors.add(fornecedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return fornecedors;
    }
    
}
