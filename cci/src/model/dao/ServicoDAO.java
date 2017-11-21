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
import model.bean.Funcionario;
import model.bean.Servico;
import model.bean.Usuario;

/**
 *
 * @author gabri
 */
public class ServicoDAO {
    private String sql = "";
    private Connection con = null;
    
    
    public ServicoDAO(){
    }
    
    //Método INSERT
    public boolean salvar(Servico servico){
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO servico (descricao, data, hora, tempo, valor, status, cliente_cpf, funcionario_cpf) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, servico.getDescicao());
            stmt.setString(2, servico.getData());
            stmt.setString(3, servico.getHora());
            stmt.setInt(4, servico.getTempo());
            stmt.setDouble(5, servico.getValor());
            stmt.setString(6, servico.getStatus());
            stmt.setString(7, servico.getCliente().getCpf());
            stmt.setString(8, servico.getFuncionario().getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
        // Udate 
    public boolean alterar(Servico servico) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE servico SET descricao = ?, data = ?, hora = ?, tempo = ?, valor = ?, status = ?, cliente_cpf = ?, funcionario_cpf = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, servico.getDescicao());
            stmt.setString(2, servico.getData());
            stmt.setString(3, servico.getHora());
            stmt.setInt(4, servico.getTempo());
            stmt.setDouble(5, servico.getValor());
            stmt.setString(6, servico.getStatus());
            stmt.setString(7, servico.getCliente().getCpf());
            stmt.setString(8, servico.getFuncionario().getCpf());
            stmt.setInt(9, servico.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //ao encerrar um serviço mudar status pra concluido
    public boolean executar(Servico servico) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE servico SET status = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "Feito");
            stmt.setInt(2, servico.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Método verifica se um usuario já consta no bd
    public boolean verificarExistencia(int id){
        con = ConnectionFactory.getConnection();
        sql = "SELECT id FROM servico WHERE id = ?";
        
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
    public List<Servico> buscarTodosAbertos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM servico s INNER JOIN funcionario f ON f.cpf = s.funcionario_cpf INNER JOIN cliente c ON c.cpf = s.cliente_cpf WHERE status = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Servico> servicos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "Aberto");
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("cargo"));
                
                Cliente cliente = new Cliente(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"));
                
                
                Servico servico = new Servico(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getInt("tempo"),
                        rs.getDouble("valor"),
                        rs.getString("status"),
                        cliente,
                        funcionario);
                
                servicos.add(servico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return servicos;
    }
    
    //Método SELECT *
    public List<Servico> buscarId(int id){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM servico s INNER JOIN funcionario f ON f.cpf = s.funcionario_cpf INNER JOIN cliente c ON c.cpf = s.cliente_cpf WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Servico> servicos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("cargo"));
                
                Cliente cliente = new Cliente(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"));
                
                
                Servico servico = new Servico(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getInt("tempo"),
                        rs.getDouble("valor"),
                        rs.getString("status"),
                        cliente,
                        funcionario);
                
                servicos.add(servico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return servicos;
    }
    
}
