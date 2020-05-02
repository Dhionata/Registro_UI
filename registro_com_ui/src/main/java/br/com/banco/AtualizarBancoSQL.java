package br.com.banco;

import br.com.objetos.*;
import br.com.ui.*;

import javax.swing.*;
import java.sql.*;

public class AtualizarBancoSQL {
    final ConexaoSQLite conexaoSQLite;
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
                System.out.println("Não atualizou...");
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