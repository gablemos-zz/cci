/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Servico;

/**
 *
 * @author gabri
 */
public class ServicoDAO {
    private String sql = "";
    private Connection con = null;

    public ServicoDAO() {
    }
    
    public boolean salvar(Servico servico){
        con = ConnectionFactory.getConnection();
        sql = "INSERT INTO servico (descricao, agenda, tempo, valor, cliente_cpf, funcionario_cpf)VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, servico.getDescicao());
            return true;
        }catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
