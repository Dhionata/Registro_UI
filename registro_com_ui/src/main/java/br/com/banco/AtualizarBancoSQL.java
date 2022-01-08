package br.com.banco;

import br.com.objetos.*;
import br.com.ui.*;

import javax.swing.*;
import java.sql.*;
import java.util.Objects;

import static java.lang.System.*;

public final class AtualizarBancoSQL {

    PreparedStatement preparedStatement;

    private AtualizarBancoSQL(final Pessoa p) {
        ConexaoSQLite.conectar();
        out.println("AtuaizarBanco sendo usada...");
        final String sql = "update Pessoa set nome = ?, 'e-mail'= ?,cidade = ?,idade = ? where id = ?;";
        try {
            preparedStatement = ConexaoSQLite.criarPreparedStatement(sql);
            Objects.requireNonNull(preparedStatement).setString(1, p.getNome());
            preparedStatement.setString(2, p.getEmail());
            preparedStatement.setString(3, p.getCidade());
            preparedStatement.setInt(4, p.getIdade());
            preparedStatement.setInt(5, p.getId());
            out.println("-- Pessoa a ser atualizada --");
            p.imprimir();
            int deuCerto = preparedStatement.executeUpdate();
            if (deuCerto == 1) {
                out.println("Atualizou...");
                JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Atualizada!");
            } else {
                out.println("Não atualizou...");
                JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Não Atualizada!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(), "Erro ao atualizar pessoa!" + e.getMessage());
            try {
                preparedStatement.close();
                ConexaoSQLite.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(), ex.getMessage());
            }
        } finally {
            try {
                Objects.requireNonNull(preparedStatement).close();
                ConexaoSQLite.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(), ex.getMessage());
            }
        }
    }

    public static void createAtualizarBancoSQL(final Pessoa p) {
        new AtualizarBancoSQL(p);
    }
}