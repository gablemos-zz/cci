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
import model.bean.Peca;

/**
 *
 * @author gabri
 */
public class PecaDAO {

    private String sql = "";
    private Connection con = null;

    public PecaDAO() {
    }

    //Método INSERT
    public boolean salvar(Peca peca) {
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO peca (descricao, unidade, valor, fornecedor_cnpj) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, peca.getDescricao());
            stmt.setString(2, peca.getUnidade());
            stmt.setDouble(3, peca.getValor());
            stmt.setString(4, peca.getFornecedor().getCnpj());
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
    public boolean alterar(Peca peca) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE peca SET descricao = ?, unidade = ?, valor = ?, fornecedor_cnpj = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, peca.getDescricao());
            stmt.setString(2, peca.getUnidade());
            stmt.setDouble(3, peca.getValor());
            stmt.setString(4, peca.getFornecedor().getCnpj());
            stmt.setInt(5, peca.getId());
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
    public boolean apagar(Peca peca){
        sql = "DELETE FROM peca WHERE id = ?";
        con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, peca.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Método verifica se um peca já consta no bd
    public boolean verificarExistencia(int id){
        con = ConnectionFactory.getConnection();
        sql = "SELECT id FROM peca WHERE id = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
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
    public List<Peca> buscarTodos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM peca p INNER JOIN fornecedor f ON f.cnpj = p.fornecedor_cnpj;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Peca> pecas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Fornecedor fornecedor = new Fornecedor(                        
                        rs.getString("cnpj"), 
                        rs.getString("rsocial"), 
                        rs.getString("nfantasia"), 
                        rs.getString("contato"), 
                        rs.getString("telefone"), 
                        rs.getString("email"));
                
                
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("unidade"), 
                        rs.getDouble("valor"), 
                        fornecedor);
                
                pecas.add(peca);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return pecas;
    }
    

    //Método buscar peca especifico
    public List<Peca> buscarId(int id){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM peca p INNER JOIN fornecedor f ON f.cnpj = p.fornecedor_cnpj WHERE p.id = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Peca> pecas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Fornecedor fornecedor = new Fornecedor(                        
                        rs.getString("cnpj"), 
                        rs.getString("rsocial"), 
                        rs.getString("nfantasia"), 
                        rs.getString("contato"), 
                        rs.getString("telefone"), 
                        rs.getString("email"));
                
                
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("unidade"), 
                        rs.getDouble("valor"), 
                        fornecedor);
                
                pecas.add(peca);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return pecas;
    }
    
    //Método buscar fornecedors pelo nome
    public List<Peca> buscarNome(String nome){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM peca p INNER JOIN fornecedor f ON f.cnpj = p.fornecedor_cnpj WHERE p.descricao LIKE ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Peca> pecas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Fornecedor fornecedor = new Fornecedor(                        
                        rs.getString("cnpj"), 
                        rs.getString("rsocial"), 
                        rs.getString("nfantasia"), 
                        rs.getString("contato"), 
                        rs.getString("telefone"), 
                        rs.getString("email"));
                
                
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("unidade"), 
                        rs.getDouble("valor"), 
                        fornecedor);
                
                pecas.add(peca);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return pecas;
    }
    
}
