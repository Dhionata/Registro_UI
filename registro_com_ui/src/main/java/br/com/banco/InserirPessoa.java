package br.com.banco;

import br.com.objetos.*;
import br.com.ui.*;

import javax.swing.*;
import java.sql.*;

public class InserirPessoa {
    final ConexaoSQLite conexaoSQLite;

    public InserirPessoa(final Pessoa p) {
        this.conexaoSQLite = new ConexaoSQLite();
        System.out.println("InserirPessoa sendo utilizada...");
        final CriarTabela tabela = new CriarTabela(this.conexaoSQLite);
        tabela.criarTabelaPessoa();
        this.conexaoSQLite.conectar();
        final String sqlInsert = "insert into Pessoa (nome,idade,'e-mail',cidade) values(?,?,?,?);";
        final PreparedStatement preparedStatement = this.conexaoSQLite.criarPreparedStatement(sqlInsert);
        try {
            System.out.println("-- Pessoa a ser inserida --");
            p.imprimir();
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setInt(2, p.getIdade());
            preparedStatement.setString(3, p.getEmail());
            preparedStatement.setString(4, p.getCidade());
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Salva!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Não inserida!\n--Erro--\n" + ex.getMessage());
            System.out.println("Pessoa não inserida\n--Erro--\n" + ex.getMessage());
        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex2) {
                    JOptionPane.showMessageDialog(UI_Principal.jPanel1,
                            "Erro ao fechar o PreparedStatement\n--Erro--\n" + ex2.getMessage());
                }
            }
            this.conexaoSQLite.desconectar();
        }
    }
}