package br.com.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.UI.UI_Principal;
import br.com.objetos.Pessoa;

public class BuscaBancoSQLite {
    private static ConexaoSQLite conexaoSQLite;
    private static ResultSet resultSet;
    private static PreparedStatement Pstmt;
    private static Statement stmt;

    static {
	BuscaBancoSQLite.conexaoSQLite = new ConexaoSQLite();
    }

    public static Pessoa BuscaNoBancoSQLite(final String nome) {
	System.out.println("BuscaNoBancoSQLite sendo utiizado..");
	BuscaBancoSQLite.conexaoSQLite.conectar();
	final Pessoa p = new Pessoa();
	final String query = "select * from Pessoa where nome like ?;";
	System.out.println("Nome da pessoa: " + nome);
	try {
	    (BuscaBancoSQLite.Pstmt = BuscaBancoSQLite.conexaoSQLite.criarPreparedStatement(query)).setString(1,
		    "%" + nome + "%");
	    System.out.println("Passou pelo nome");
	    BuscaBancoSQLite.resultSet = BuscaBancoSQLite.Pstmt.executeQuery();
	    System.out.println("Setou o result");
	    while (BuscaBancoSQLite.resultSet.next()) {
		p.setId(BuscaBancoSQLite.resultSet.getInt("id"));
		p.setNome(BuscaBancoSQLite.resultSet.getString("nome"));
		p.setCidade(BuscaBancoSQLite.resultSet.getString("cidade"));
		p.setEmail(BuscaBancoSQLite.resultSet.getString("e-mail"));
		p.setIdade(BuscaBancoSQLite.resultSet.getInt("idade"));
		System.out.println("\nID: " + p.getId());
		System.out.println("Nome: " + p.getNome());
		System.out.println("Idade: " + p.getIdade());
		System.out.println("Cidade: " + p.getCidade());
		System.out.println("E-mail: " + p.getEmail());
	    }
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1,
		    "Erro na QUERY com PARAMETROS\n--Erro--\n" + e.getMessage());
	    try {
		BuscaBancoSQLite.resultSet.close();
		System.out.println("Fechou o resultSet 1");
		BuscaBancoSQLite.Pstmt.close();
		System.out.println("Fechou o preparedSteti... 1");
		BuscaBancoSQLite.conexaoSQLite.desconectar();
	    } catch (SQLException e2) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1,
			"Erro ao FECHAR a QUERY!\n--Erro--\n" + e2.getMessage());
	    }
	} finally {
	    try {
		BuscaBancoSQLite.resultSet.close();
		System.out.println("Fechou o resultSet 2 ");
		BuscaBancoSQLite.Pstmt.close();
		System.out.println("Fechou o preparedSteti... 2");
		BuscaBancoSQLite.conexaoSQLite.desconectar();
	    } catch (SQLException e2) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1,
			"Erro ao FECHAR a QUERY!\n--Erro--\n" + e2.getMessage());
	    }
	}
	if (p.getId() != 0) {
	    System.out.println("Tem ID!");
	} else {
	    System.out.println("\nNão tem ID, n tem no banco.");
	}
	return p;
    }

    public static int BuscaIDNoBancoSQLite(final String nome) {
	BuscaBancoSQLite.conexaoSQLite.conectar();
	int i = -1;
	final String sql = "select id from Pessoa where nome like ?";
	try {
	    (BuscaBancoSQLite.Pstmt = BuscaBancoSQLite.conexaoSQLite.criarPreparedStatement(sql)).setString(1,
		    "%" + nome + "%");
	    i = BuscaBancoSQLite.Pstmt.executeQuery().getInt("id");
	} catch (Exception e) {
	    System.out.println("Erro ao buscar ID no banco\n\n" + e.getMessage());
	    try {
		BuscaBancoSQLite.Pstmt.close();
		BuscaBancoSQLite.conexaoSQLite.desconectar();
	    } catch (SQLException e2) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1,
			"Erro ao fechar Busca por ID\n\n" + e2.getMessage());
	    }
	    return i;
	} finally {
	    try {
		BuscaBancoSQLite.Pstmt.close();
		BuscaBancoSQLite.conexaoSQLite.desconectar();
	    } catch (SQLException e2) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1,
			"Erro ao fechar Busca por ID\n\n" + e2.getMessage());
	    }
	}
	return i;
    }

    public static void BuscaNoBancoSQLite() {
	BuscaBancoSQLite.conexaoSQLite.conectar();
	final String query2 = "select * from Pessoa;";
	try {
	    BuscaBancoSQLite.stmt = BuscaBancoSQLite.conexaoSQLite.criarStatement();
	    BuscaBancoSQLite.resultSet = BuscaBancoSQLite.stmt.executeQuery(query2);
	    while (BuscaBancoSQLite.resultSet.next()) {
		System.out.println("\nID: " + BuscaBancoSQLite.resultSet.getInt("id"));
		System.out.println("Nome: " + BuscaBancoSQLite.resultSet.getString("nome"));
		System.out.println("Idade: " + BuscaBancoSQLite.resultSet.getInt("idade"));
		System.out.println("E-mail: " + BuscaBancoSQLite.resultSet.getString("e-mail"));
		System.out.println("Cidade: " + BuscaBancoSQLite.resultSet.getString("cidade"));
	    }
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro na query2!\n--Erro--\n" + e.getMessage());
	    try {
		BuscaBancoSQLite.resultSet.close();
		BuscaBancoSQLite.stmt.close();
		BuscaBancoSQLite.conexaoSQLite.desconectar();
	    } catch (SQLException e2) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao FECHAR a query2!" + e2.getMessage());
	    }
	    return;
	} finally {
	    try {
		BuscaBancoSQLite.resultSet.close();
		BuscaBancoSQLite.stmt.close();
		BuscaBancoSQLite.conexaoSQLite.desconectar();
	    } catch (SQLException e2) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao FECHAR a query2!" + e2.getMessage());
	    }
	}
	try {
	    BuscaBancoSQLite.resultSet.close();
	    BuscaBancoSQLite.stmt.close();
	    BuscaBancoSQLite.conexaoSQLite.desconectar();
	} catch (SQLException e2) {
	    JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Erro ao FECHAR a query2!" + e2.getMessage());
	}
    }
}