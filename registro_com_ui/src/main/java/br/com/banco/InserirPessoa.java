package br.com.banco;

import br.com.objetos.*;
import br.com.ui.*;

import javax.swing.*;
import java.sql.*;

public final class InserirPessoa {

    private static void inserirPessoa(final Pessoa p) {
        ConexaoSQLite.conectar();
        System.out.println("InserirPessoa sendo utilizada...");
        final CriarTabela tabela = CriarTabela.createCriarTabela();
        tabela.criarTabelaPessoa();
        final String sqlInsert = "insert into Pessoa (nome,idade,'e-mail',cidade) values(?,?,?,?);";
        final PreparedStatement preparedStatement = ConexaoSQLite.criarPreparedStatement(sqlInsert);
        try {
            System.out.println("-- Pessoa a ser inserida --");
            p.imprimir();
            assert preparedStatement != null;
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setInt(2, p.getIdade());
            preparedStatement.setString(3, p.getEmail());
            preparedStatement.setString(4, p.getCidade());
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Salva!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Não inserida!\n--Erro--\n" + ex.getMessage());
            System.out.println("Pessoa não inserida\n--Erro--\n" + ex.getMessage());
        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex2) {
                    JOptionPane.showMessageDialog(Ui.getjPanel1(),
                            "Erro ao fechar o PreparedStatement\n--Erro--\n" + ex2.getMessage());
                }
            }
            ConexaoSQLite.desconectar();
        }
    }

    public static void createInserirPessoa(final Pessoa p) {
        inserirPessoa(p);
    }
}