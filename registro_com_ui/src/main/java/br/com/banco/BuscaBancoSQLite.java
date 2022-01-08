package br.com.banco;

import br.com.objetos.Pessoa;
import br.com.ui.Ui;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static br.com.banco.ConexaoSQLite.conectar;
import static br.com.banco.ConexaoSQLite.criarPreparedStatement;
import static java.lang.System.out;

public class BuscaBancoSQLite {
    private static ResultSet resultSet;
    private static PreparedStatement pstmt;

    public static Pessoa BuscaNoBancoSQLite(final String nome) {
        out.println("BuscaNoBancoSQLite sendo utiizado..");
        conectar();
        Pessoa p = Pessoa.createPessoa();
        final String query = "select * from Pessoa where nome like ?;";
        out.println("Nome da pessoa: " + nome);
        try {
            pstmt = criarPreparedStatement(query);
            assert pstmt != null;
            pstmt.setString(1,
                    "%" + nome + "%");
            out.println("Passou pelo nome");
            resultSet = pstmt.executeQuery();
            out.println("Setou o result");
            while (resultSet.next()) {
                p.setId(resultSet.getInt("id"));
                out.println("\nID: " + p.getId());
                p.setNome(resultSet.getString("nome"));
                out.println("Nome: " + p.getNome());
                p.setCidade(resultSet.getString("cidade"));
                out.println("Idade: " + p.getIdade());
                p.setEmail(resultSet.getString("e-mail"));
                out.println("Cidade: " + p.getCidade());
                p.setIdade(resultSet.getInt("idade"));
                out.println("E-mail: " + p.getEmail());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Ui.getjPanel1(),
                    "Erro na QUERY com PARAMETROS\n--Erro--\n" + e.getMessage());
            try {
                resultSet.close();
                out.println("Fechou o resultSet 1");
                pstmt.close();
                out.println("Fechou o preparedSteti... 1");
                ConexaoSQLite.desconectar();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(),
                        "Erro ao FECHAR a QUERY!\n--Erro--\n" + e2.getMessage());
            }
        } finally {
            try {
                resultSet.close();
                out.println("Fechou o resultSet 2 ");
                pstmt.close();
                out.println("Fechou o preparedSteti... 2");
                ConexaoSQLite.desconectar();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(),
                        "Erro ao FECHAR a QUERY!\n--Erro--\n" + e2.getMessage());
            }
        }
        if (p.getId() != 0) {
            out.println("Tem ID!");
        } else {
            out.println("\nNão tem ID, n tem no banco.");
        }
        return p;
    }

    public static int BuscaIDNoBancoSQLite(final String nome) {
        ConexaoSQLite.conectar();
        int i = -1;
        final String sql = "select id from Pessoa where nome like ?";
        try {
            (Objects.requireNonNull(pstmt = criarPreparedStatement(sql))).setString(1,
                    "%" + nome + "%");
            i = pstmt.executeQuery().getInt("id");
        } catch (Exception e) {
            out.println("Erro ao buscar ID no banco\n\n" + e.getMessage());
            try {
                pstmt.close();
                ConexaoSQLite.desconectar();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(Ui.getjPanel1(),
                        "Erro ao fechar Busca por ID\n\n" + e2.getMessage());
            }
            return i;
        }
        return i;
    }
}