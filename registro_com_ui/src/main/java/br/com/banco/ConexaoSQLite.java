package br.com.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.UI.UI_Principal;

public class ConexaoSQLite {
    private Connection conexao;

    public boolean conectar() {
	System.out.println("Conectar sendo utilizado...");
	try {
	    final String url = "jdbc:sqlite:SQLite.db";
	    this.conexao = DriverManager.getConnection(url);
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao Conectar\n--Erro--\n" + ex.getMessage());
	    return false;
	}
	System.out.println("Conectou!");
	return true;
    }

    public boolean desconectar() {
	try {
	    if (!this.conexao.isClosed()) {
		this.conexao.close();
	    }
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao Desconectar\n--Erro--\n" + ex.getMessage());
	}
	System.out.println("Desconectou!");
	return true;
    }

    public Statement criarStatement() {
	try {
	    return this.conexao.createStatement();
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1,
		    "Erro ao Criar Statement\n--Erro--\n" + ex.getMessage());
	    return null;
	}
    }

    public Connection getConexao() {
	return this.conexao;
    }

    public PreparedStatement criarPreparedStatement(final String sql) {
	try {
	    System.out.println("PreparedStatement\nSQL:\n" + sql);
	    return this.conexao.prepareStatement(sql);
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1,
		    "Erro ao Criar o PreparedStatement\n--Erro--\n" + ex.getMessage());
	    return null;
	}
    }
}