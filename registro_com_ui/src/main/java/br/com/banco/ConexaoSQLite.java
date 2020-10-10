package br.com.banco;

import br.com.ui.*;

import javax.swing.*;
import java.sql.*;

import static java.lang.System.*;

public class ConexaoSQLite {
    private static Connection conexao;

    public static boolean conectar() {
        out.println("Conectar sendo utilizado...");
        try {
            final String url = "jdbc:sqlite:SQLite.db";
            conexao = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(), "Erro ao Conectar\n--Erro--\n" + ex.getMessage());
            return false;
        }
        out.println("Conectou!");
        return true;
    }

    public static void desconectar() {
        try {
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(), "Erro ao Desconectar\n--Erro--\n" + ex.getMessage());
        }
        out.println("Desconectou!");
    }

    public static Statement criarStatement() {
        try {
            return conexao.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(),
                    "Erro ao Criar Statement\n--Erro--\n" + ex.getMessage());
            return null;
        }
    }

    public static Connection getConexao() {
        return conexao;
    }

    public static PreparedStatement criarPreparedStatement(final String sql) {
        try {
            out.println("PreparedStatement\nSQL:\n" + sql);
            return conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(),
                    "Erro ao Criar o PreparedStatement\n--Erro--\n" + ex.getMessage());
            return null;
        }
    }
}