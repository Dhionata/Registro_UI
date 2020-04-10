package br.com.banco;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.UI.UI_Principal;

public class CriarTabela {
    private final ConexaoSQLite conexaoSQLite;

    public CriarTabela(final ConexaoSQLite conexao) {
	this.conexaoSQLite = conexao;
    }

    public void criarTabelaPessoa() {
	System.out.println("Criando tabela...");
	final String sql = "CREATE TABLE if not exists Pessoa (id INTEGER PRIMARY KEY,nome VARCHAR (100) NOT NULL UNIQUE ON CONFLICT ROLLBACK, idade INT (3),cidade VARCHAR (50),[e-mail] VARCHAR (50) UNIQUE ON CONFLICT ROLLBACK);";
	boolean conectou = false;
	try {
	    conectou = this.conexaoSQLite.conectar();
	    final Statement stmt = this.conexaoSQLite.criarStatement();
	    stmt.execute(sql);
	    System.out.println("Tabela Criada!");
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao conectar\n--Erro--\n" + ex.getMessage());
	    return;
	} finally {
	    if (conectou) {
		this.conexaoSQLite.desconectar();
	    }
	}
    }
}