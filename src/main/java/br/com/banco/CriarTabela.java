package br.com.banco;

import br.com.ui.Ui;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {

    private CriarTabela() {
    }

    public static CriarTabela createCriarTabela() {
        return new CriarTabela();
    }

    public void criarTabelaPessoa() {
        System.out.println("Criando tabela...");
        final String sql = "CREATE TABLE if not exists Pessoa (id INTEGER PRIMARY KEY,nome VARCHAR (100) NOT NULL UNIQUE ON CONFLICT ROLLBACK, idade INT (3),cidade VARCHAR (50),[e-mail] VARCHAR (50) UNIQUE ON CONFLICT ROLLBACK);";
        try {
            ConexaoSQLite.conectar();
            final Statement stmt = ConexaoSQLite.criarStatement();
            assert stmt != null;
            stmt.execute(sql);
            System.out.println("Tabela Criada!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(), "Erro ao conectar\n--Erro--\n" + ex.getMessage());
        }
    }
}
