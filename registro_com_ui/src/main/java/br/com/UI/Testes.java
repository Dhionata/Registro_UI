
package br.com.UI;

import br.com.banco.ConexaoSQLite;
import br.com.banco.CriarTabela;
import br.com.objetos.Pessoa;

public class Testes {

    public static void main(String[] args) {
	ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

	CriarTabela criarTabela = new CriarTabela(conexaoSQLite);

	criarTabela.criarTabelaPessoa();

	Pessoa p = new Pessoa();
	p.setNome("Dhionata");
	p.setEmail("testandoprincipal");
    }
}
