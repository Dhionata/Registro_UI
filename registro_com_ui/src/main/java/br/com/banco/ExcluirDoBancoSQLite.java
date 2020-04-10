package br.com.banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.UI.UI_Principal;

public class ExcluirDoBancoSQLite {
    ConexaoSQLite conexaoSQLite;
    PreparedStatement preparedStatement;

    public ExcluirDoBancoSQLite(final String nome) {
	this.conexaoSQLite = new ConexaoSQLite();
	final int pID = BuscaBancoSQLite.BuscaIDNoBancoSQLite(nome);
	this.conexaoSQLite.conectar();
	final String sql = "delete from Pessoa where id = ?;";
	try {
	    (this.preparedStatement = this.conexaoSQLite.criarPreparedStatement(sql)).setInt(1, pID);
	    final int resultado = this.preparedStatement.executeUpdate();
	    System.out.println("Resultado feito!");
	    if (resultado == 1) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Deletada!");
	    } else {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Não Deletada!");
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao Excluir!\n--Erro--\n" + e.getMessage());
	    if (this.preparedStatement != null) {
		try {
		    this.preparedStatement.close();
		    this.conexaoSQLite.desconectar();
		} catch (SQLException ex) {
		    JOptionPane.showMessageDialog(UI_Principal.jPanel1,
			    "Erro ao fechar o PreparedStatement\n--Erro--\n" + ex.getMessage());
		}
	    }
	    return;
	} finally {
	    if (this.preparedStatement != null) {
		try {
		    this.preparedStatement.close();
		    this.conexaoSQLite.desconectar();
		} catch (SQLException ex) {
		    JOptionPane.showMessageDialog(UI_Principal.jPanel1,
			    "Erro ao fechar o PreparedStatement\n--Erro--\n" + ex.getMessage());
		}
	    }
	}
    }
}