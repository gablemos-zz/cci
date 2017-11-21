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
import model.bean.PecaServico;
import model.bean.Servico;

/**
 *
 * @author gabri
 */
public class PecaServicoDAO {
    private String sql = "";
    private Connection con = null;
    
    public PecaServicoDAO() {
    }
    
    public boolean salvar(PecaServico pecaservico){
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO pecaservico (peca_id, servico_id) VALUES (?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pecaservico.getPeca().getId());
            stmt.setInt(2, pecaservico.getServico().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean apagar(PecaServico pecaservico){
        sql = "DELETE FROM pecaservico WHERE id = ?";
        con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pecaservico.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<PecaServico> buscarPorServico(int sid){
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM pecaservico ps INNER JOIN peca p ON p.id = ps.peca_id INNER JOIN  servico s ON s.id = ps.servico_id WHERE s.id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<PecaServico> pecaservicos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            while (rs.next()) { 
                
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("unidade"), 
                        rs.getDouble("valor"));
                
                Servico servico = new Servico(
                        rs.getInt("id"), 
                        rs.getString("descricao"), 
                        rs.getString("data"), 
                        rs.getString("hora"), 
                        rs.getInt("tempo"), 
                        rs.getDouble("valor"), 
                        rs.getString("status"));
                
                PecaServico pecaservico = new PecaServico(
                        rs.getInt("id"),
                        peca, 
                        servico);
                
                pecaservicos.add(pecaservico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return pecaservicos;
    } 
    
    public List<PecaServico> buscarPorId(int psid){
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM pecaservico ps INNER JOIN peca p ON p.id = ps.peca_id INNER JOIN  servico s ON s.id = ps.servico_id WHERE ps.id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<PecaServico> pecaservicos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, psid);
            rs = stmt.executeQuery();
            while (rs.next()) { 
                
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("unidade"), 
                        rs.getDouble("valor"));
                
                Servico servico = new Servico(
                        rs.getInt("id"), 
                        rs.getString("descricao"), 
                        rs.getString("data"), 
                        rs.getString("hora"), 
                        rs.getInt("tempo"), 
                        rs.getDouble("valor"), 
                        rs.getString("status"));
                
                PecaServico pecaservico = new PecaServico(
                        rs.getInt("id"),
                        peca, 
                        servico);
                
                pecaservicos.add(pecaservico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return pecaservicos;
    }
}
