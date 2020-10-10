package br.com.banco;

import br.com.ui.*;

import javax.swing.*;
import java.sql.*;
import java.util.Objects;

public final class ExcluirDoBancoSQLite {
    PreparedStatement preparedStatement;

    private ExcluirDoBancoSQLite(final String nome) {
        ConexaoSQLite.conectar();
        final int pID = BuscaBancoSQLite.BuscaIDNoBancoSQLite(nome);
        final String sql = "delete from Pessoa where id = ?;";
        try {
            (preparedStatement = Objects.requireNonNull(ConexaoSQLite.criarPreparedStatement(sql))).setInt(1, pID);
            final int resultado = preparedStatement.executeUpdate();
            System.out.println("Resultado feito!");
            if (resultado == 1) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Deletada!");
            } else {
                JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Não Deletada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(), "Erro ao Excluir!\n--Erro--\n" + e.getMessage());
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    ConexaoSQLite.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Ui.getjPanel1(),
                            "Erro ao fechar o PreparedStatement\n--Erro--\n" + ex.getMessage());
                }
            }
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    ConexaoSQLite.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Ui.getjPanel1(),
                            "Erro ao fechar o PreparedStatement\n--Erro--\n" + ex.getMessage());
                }
            }
        }
    }

    public static void createExcluirDoBancoSQLite(final String nome) {
        new ExcluirDoBancoSQLite(nome);
    }
}