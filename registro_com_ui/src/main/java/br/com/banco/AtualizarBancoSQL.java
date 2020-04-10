package br.com.banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.UI.UI_Principal;
import br.com.objetos.Pessoa;

public class AtualizarBancoSQL {
    ConexaoSQLite conexaoSQLite;
    PreparedStatement preparedStatement;

    public AtualizarBancoSQL(final Pessoa p) {
	this.conexaoSQLite = new ConexaoSQLite();
	System.out.println("AtuaizarBanco sendo usada...");
	this.conexaoSQLite.conectar();
	final String sql = "update Pessoa set nome = ?, 'e-mail'= ?,cidade = ?,idade = ? where id = ?;";
	try {
	    (this.preparedStatement = this.conexaoSQLite.criarPreparedStatement(sql)).setString(1, p.getNome());
	    this.preparedStatement.setString(2, p.getEmail());
	    this.preparedStatement.setString(3, p.getCidade());
	    this.preparedStatement.setInt(4, p.getIdade());
	    this.preparedStatement.setInt(5, p.getId());
	    System.out.println("-- Pessoa a ser atualizada --");
	    p.imprimir();
	    final int deuCerto = this.preparedStatement.executeUpdate();
	    if (deuCerto == 1) {
		System.out.println("Atualizou...");
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Atualizada!");
	    } else {
		System.out.println("N\u00e3o atualizou...");
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Não Atualizada!");
	    }
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao atualizar pessoa!" + e.getMessage());
	    try {
		this.preparedStatement.close();
		this.conexaoSQLite.desconectar();
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, ex.getMessage());
	    }
	    return;
	} finally {
	    try {
		this.preparedStatement.close();
		this.conexaoSQLite.desconectar();
	    } catch (SQLException ex) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, ex.getMessage());
	    }
	}
    }
}