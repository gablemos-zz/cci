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
import model.bean.Usuario;
import model.bean.Funcionario;

/**
 *
 * @author gabri
 */
public class UsuarioDAO {

    private String sql = "";
    private Connection con = null;

    public UsuarioDAO() {
    }

    //Método INSERT
    public boolean salvar(Usuario usuario) {
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO usuario (usuario, senha, funcionario_cpf) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getFuncionario().getCpf());
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
    public boolean alterar(Usuario usuario) {
        con = ConnectionFactory.getConnection();
        sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE funcionario_cpf = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());           
            stmt.setString(3, usuario.getFuncionario().getCpf());
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
    public boolean apagar(Usuario usuario){
        sql = "DELETE FROM usuario WHERE funcionario_cpf = ?";
        con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getFuncionario().getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Método verifica se um usuario já consta no bd
    public boolean verificarExistencia(String cpf){
        con = ConnectionFactory.getConnection();
        sql = "SELECT funcionario_cpf FROM usuario WHERE funcionario_cpf = ?";
        
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
    public List<Usuario> buscarTodos(){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM usuario u INNER JOIN funcionario f ON f.cpf = u.funcionario_cpf;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("cargo"));
                
                
                Usuario usuario = new Usuario(
                        rs.getString("usuario"),
                        rs.getString("senha"), 
                        funcionario);
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return usuarios;
    }
    

    //Método buscar usuario especifico
    public List<Usuario> buscarCPF(String cpf){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM usuario u INNER JOIN funcionario f ON f.cpf = u.funcionario_cpf WHERE u.funcionario_cpf = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("cargo"));
                
                
                Usuario usuario = new Usuario(
                        rs.getString("usuario"),
                        rs.getString("senha"), 
                        funcionario);
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return usuarios;
    }  
    
    public boolean validarLogin(String usuario, String senha){
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();            
            return rs.first();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public String retornaCargo(String user, String senha){        
        con = ConnectionFactory.getConnection();
        sql = "SELECT * FROM usuario u INNER JOIN funcionario f ON f.cpf = u.funcionario_cpf WHERE u.usuario = ? AND u.senha = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Funcionario funcionario = new Funcionario(
                        rs.getString("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("telefone"), 
                        rs.getString("email"), 
                        rs.getString("cargo"));
                
                
                Usuario usuario = new Usuario(
                        rs.getString("usuario"),
                        rs.getString("senha"), 
                        funcionario);
                
                return usuario.getFuncionario().getCargo();
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
        }        
        return "";
    }  
    
    
}
