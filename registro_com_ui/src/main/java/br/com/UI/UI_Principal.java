package br.com.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import br.com.banco.AtualizarBancoSQL;
import br.com.banco.BuscaBancoSQLite;
import br.com.banco.ExcluirDoBancoSQLite;
import br.com.banco.InserirPessoa;
import br.com.objetos.Pessoa;

public class UI_Principal extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton Botao_Editar;
    private JButton Botao_Excluir;
    private JButton Botao_Pesquisar;
    private JButton Botao_Salvar;
    private JTextField Texto_Cidade;
    private JTextField Texto_Email;
    private JTextField Texto_ID;
    private JTextField Texto_Idade;
    private JTextField Texto_Nome;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    public static JPanel jPanel1;
    private JPanel jPanel5;
    private JPanel jPanel6;

    public UI_Principal() {
	this.initComponents();
	this.setLocationRelativeTo(null);
	this.Texto_ID.setEditable(false);
	this.Botao_Editar.setEnabled(false);
	this.Botao_Excluir.setEnabled(false);
    }

    private void initComponents() {
	UI_Principal.jPanel1 = new JPanel();
	this.jLabel1 = new JLabel();
	this.jPanel6 = new JPanel();
	this.jPanel5 = new JPanel();
	this.Botao_Salvar = new JButton();
	this.Botao_Editar = new JButton();
	this.Botao_Pesquisar = new JButton();
	this.Botao_Excluir = new JButton();
	this.jLabel6 = new JLabel();
	this.jLabel8 = new JLabel();
	this.jLabel9 = new JLabel();
	this.jLabel10 = new JLabel();
	this.jLabel11 = new JLabel();
	this.Texto_ID = new JTextField();
	this.Texto_Nome = new JTextField();
	this.Texto_Email = new JTextField();
	this.Texto_Cidade = new JTextField();
	this.Texto_Idade = new JTextField();
	this.setDefaultCloseOperation(3);
	this.setAlwaysOnTop(true);
	this.setCursor(new Cursor(0));
	this.setResizable(false);
	UI_Principal.jPanel1.setBackground(new Color(0, 204, 255));
	UI_Principal.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
	this.jLabel1.setFont(new Font("Arial", 0, 18));
	this.jLabel1.setHorizontalAlignment(0);
	this.jLabel1.setText("Pessoas");
	this.jLabel1.setToolTipText("");
	GroupLayout jPanel1Layout = new GroupLayout(UI_Principal.jPanel1);
	UI_Principal.jPanel1.setLayout(jPanel1Layout);
	jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup().addGap(102, 102, 102)
			.addComponent(this.jLabel1, -2, 171, -2).addContainerGap(-1, 32767)));
	jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
			.addComponent(this.jLabel1, -1, -1, 32767).addContainerGap()));
	this.jPanel6.setBorder(new LineBorder(new Color(0, 204, 255), 1, true));
	this.Botao_Salvar.setBackground(new Color(0, 204, 255));
	this.Botao_Salvar.setText("Salvar");
	this.Botao_Salvar.addActionListener(this);
	this.Botao_Editar.setBackground(new Color(0, 204, 255));
	this.Botao_Editar.setText("Atualizar");
	this.Botao_Editar.addActionListener(this);
	this.Botao_Pesquisar.setBackground(new Color(0, 204, 255));
	this.Botao_Pesquisar.setText("Pesquisar");
	this.Botao_Pesquisar.addActionListener(this);
	this.Botao_Excluir.setBackground(new Color(0, 204, 255));
	this.Botao_Excluir.setText("Excluir");
	this.Botao_Excluir.addActionListener(this);
	final GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
	this.jPanel5.setLayout(jPanel5Layout);
	jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addComponent(this.Botao_Salvar).addComponent(this.Botao_Editar).addComponent(this.Botao_Pesquisar)
		.addComponent(this.Botao_Excluir));
	jPanel5Layout.linkSize(0, this.Botao_Editar, this.Botao_Excluir, this.Botao_Pesquisar, this.Botao_Salvar);
	jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel5Layout.createSequentialGroup().addGap(0, 0, 0)
			.addComponent(this.Botao_Excluir, -1, -1, 32767).addGap(18, 18, 18)
			.addComponent(this.Botao_Pesquisar, -1, -1, 32767).addGap(18, 18, 18)
			.addComponent(this.Botao_Editar, -1, -1, 32767).addGap(18, 18, 18)
			.addComponent(this.Botao_Salvar, -1, -1, 32767)));
	this.jLabel6.setText("Nome");
	this.jLabel8.setText("ID");
	this.jLabel9.setText("Cidade");
	this.jLabel10.setText("Email");
	this.jLabel11.setText("Idade");
	this.Texto_ID.setBackground(new Color(0, 204, 255));
	this.Texto_ID.setFont(new Font("Arial", 1, 14));
	this.Texto_ID.addActionListener(this);
	this.Texto_Nome.setBackground(new Color(0, 204, 255));
	this.Texto_Nome.setFont(new Font("Arial", 1, 14));
	this.Texto_Nome.addActionListener(this);
	this.Texto_Email.setBackground(new Color(0, 204, 255));
	this.Texto_Email.setFont(new Font("Arial", 1, 14));
	this.Texto_Email.addActionListener(this);
	this.Texto_Cidade.setBackground(new Color(0, 204, 255));
	this.Texto_Cidade.setFont(new Font("Arial", 1, 14));
	this.Texto_Cidade.addActionListener(this);
	this.Texto_Idade.setBackground(new Color(0, 204, 255));
	this.Texto_Idade.setFont(new Font("Arial", 1, 14));
	this.Texto_Idade.addActionListener(this);
	final GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
	this.jPanel6.setLayout(jPanel6Layout);
	jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup().addContainerGap()
			.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.jLabel6, -2, 45, -2).addComponent(this.jLabel10, -2, 45, -2)
				.addComponent(this.jLabel8, -2, 45, -2).addComponent(this.jLabel9, -2, 45, -2)
				.addComponent(this.jLabel11, -2, 45, -2))
			.addGap(18, 18, 18)
			.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this.Texto_ID, -2, 40, -2)
				.addGroup(jPanel6Layout.createSequentialGroup()
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(this.Texto_Nome, -2, 176, -2)
						.addComponent(this.Texto_Email, -2, 176, -2)
						.addComponent(this.Texto_Cidade, -2, 176, -2)
						.addComponent(this.Texto_Idade, -2, 40, -2))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767)
					.addComponent(this.jPanel5, -2, -1, -2)))
			.addContainerGap()));
	jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
			.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel6Layout.createSequentialGroup().addGap(52, 52, 52).addComponent(this.jPanel5,
				-2, -1, -2))
			.addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.jLabel8, -2, 22, -2).addComponent(this.Texto_ID, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.jLabel6, -2, 22, -2)
					.addComponent(this.Texto_Nome, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.jLabel10, -2, 22, -2)
					.addComponent(this.Texto_Email, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.jLabel9, -2, 22, -2)
					.addComponent(this.Texto_Cidade, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(this.jLabel11, -2, 22, -2)
					.addComponent(this.Texto_Idade, -2, -1, -2))))
			.addContainerGap(-1, 32767)));
	final GroupLayout layout = new GroupLayout(this.getContentPane());
	this.getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addComponent(UI_Principal.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
		.addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.jPanel6, -2, -1, -2)));
	layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(layout.createSequentialGroup().addComponent(UI_Principal.jPanel1, -2, -1, -2).addGap(0, 0, 0)
			.addComponent(this.jPanel6, -1, -1, 32767)));
	this.pack();
    }

    @Override
    public void actionPerformed(final ActionEvent evt) {
	if (evt.getSource() == this.Botao_Excluir) {
	    this.Botao_ExcluirActionPerformed(evt);
	} else if (evt.getSource() == this.Botao_Pesquisar) {
	    this.Botao_PesquisarActionPerformed(evt);
	} else if (evt.getSource() == this.Botao_Editar) {
	    this.Botao_EditarActionPerformed(evt);
	} else if (evt.getSource() == this.Botao_Salvar) {
	    this.Botao_SalvarActionPerformed(evt);
	} else if (evt.getSource() == this.Texto_ID) {
	    this.Texto_IDActionPerformed(evt);
	} else if (evt.getSource() == this.Texto_Cidade) {
	    this.Texto_CidadeActionPerformed(evt);
	} else if (evt.getSource() == this.Texto_Idade) {
	    this.Texto_IdadeActionPerformed(evt);
	} else if (evt.getSource() == this.Texto_Email) {
	    this.Texto_EmailActionPerformed(evt);
	} else if (evt.getSource() == this.Texto_Nome) {
	    this.Texto_NomeActionPerformed(evt);
	}
    }

    private void Botao_EditarActionPerformed(final ActionEvent evt) {
	System.out.println("Botão Atualizar Apertado");

	if (!Texto_ID.getText().isBlank() && !Texto_Nome.getText().isBlank() && !Texto_Email.getText().isBlank()) {
	    Pessoa p = new Pessoa();
	    p.setId(Integer.parseInt(Texto_ID.getText()));
	    p.setNome(Texto_Nome.getText());
	    p.setCidade(Texto_Cidade.getText());
	    p.setEmail(Texto_Email.getText());
	    p.setIdade(Integer.parseInt(Texto_Idade.getText()));
	    new AtualizarBancoSQL(p);
	    this.Botao_PesquisarActionPerformed(evt);
	} else {
	    if (Texto_ID.getText().isBlank()) {
		System.out.println("Você não pode atualizar alguém não salvo...");
		JOptionPane.showMessageDialog(jPanel1, "Você não pode atualizar alguém não salvo...");
	    }
	    if (Texto_Nome.getText().isBlank()) {
		System.out.println("Você não pode deixar uma pessoa sem nome...");
		JOptionPane.showMessageDialog(jPanel1, "Você não pode deixar uma pessoa sem nome...");
	    }
	    if (Texto_Email.getText().isBlank()) {
		System.out.println("Precisa de um e-mail...");
		JOptionPane.showMessageDialog(jPanel1, "Precisamos do e-mail para contato, e ele deve ser único...");
	    }
	}

    }

    private void Botao_PesquisarActionPerformed(final ActionEvent evt) {
	System.out.println("Botão Pesquisar Apertado");
	if (!Texto_Nome.getText().isBlank()) {
	    Pessoa p = new Pessoa();
	    p = BuscaBancoSQLite.BuscaNoBancoSQLite(this.Texto_Nome.getText());
	    if (p.getNome() == null) {
		JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Pessoa Não encontrada!");
		this.limparTextos();
	    } else {
		this.Texto_ID.setText(Integer.toString(p.getId()));
		this.Texto_Nome.setText(p.getNome());
		this.Texto_Cidade.setText(p.getCidade());
		this.Texto_Email.setText(p.getEmail());
		this.Texto_Idade.setText(Integer.toString(p.getIdade()));
		this.Botao_Excluir.setEnabled(true);
		this.Botao_Editar.setEnabled(true);
	    }
	} else {
	    JOptionPane.showMessageDialog(jPanel1, "Cara... vc tem que preencher o nome pra pesquisar...");
	}
    }

    private void Botao_ExcluirActionPerformed(final ActionEvent evt) {
	System.out.println("Botão Excluir Apertado");
	new ExcluirDoBancoSQLite(Texto_Nome.getText());
	this.limparTextos();
    }

    private void Botao_SalvarActionPerformed(final ActionEvent evt) {
	System.out.println("Botão Salvar Apertado");
	if (!Texto_Nome.getText().isBlank() && !Texto_Idade.getText().isBlank() && !Texto_Email.getText().isBlank()
		&& !Texto_Cidade.getText().isBlank()) {
	    Pessoa p = new Pessoa();
	    p.setNome(Texto_Nome.getText());
	    p.setCidade(Texto_Cidade.getText());
	    p.setEmail(Texto_Email.getText());
	    try {
		p.setIdade(Integer.parseInt(Texto_Idade.getText()));
		System.out.println("Setou idade..." + p.getIdade());
	    } catch (Exception e) {
		JOptionPane.showMessageDialog(jPanel1, "Cara...\ntem q ser um número\n--Erro--\n" + e.getMessage());
		return;
	    }
	    System.out.println("Vai tentar inserir...");
	    new InserirPessoa(p);
	    this.limparTextos();
	} else {
	    JOptionPane.showMessageDialog(jPanel1, "Olha... vc tem que ter preencher tudo pra salvar...");
	}
    }

    private void Texto_IDActionPerformed(final ActionEvent evt) {
	if (this.Texto_ID.getText().isBlank()) {
	    this.limparTextos();
	    this.Botao_Editar.setEnabled(false);
	    this.Botao_Excluir.setEnabled(false);
	    this.Botao_Salvar.setEnabled(true);
	} else {
	    this.Botao_Editar.setEnabled(true);
	    this.Botao_Excluir.setEnabled(true);
	    this.Botao_Salvar.setEnabled(false);
	}
    }

    private void Texto_CidadeActionPerformed(final ActionEvent evt) {
    }

    private void Texto_IdadeActionPerformed(final ActionEvent evt) {
    }

    private void Texto_EmailActionPerformed(final ActionEvent evt) {
    }

    private void Texto_NomeActionPerformed(final ActionEvent evt) {
	if (this.Texto_Nome.getText().isBlank()) {
	    this.limparTextos();
	}
    }

    public static void main(final String[] args) {
	try {
	    UIManager.LookAndFeelInfo[] installedLookAndFeels;
	    for (int length = (installedLookAndFeels = UIManager
		    .getInstalledLookAndFeels()).length, i = 0; i < length; ++i) {
		final UIManager.LookAndFeelInfo info = installedLookAndFeels[i];
		if ("Windows".equals(info.getName())) {
		    UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(UI_Principal.class.getName()).log(Level.SEVERE, null, ex);
	} catch (InstantiationException ex2) {
	    Logger.getLogger(UI_Principal.class.getName()).log(Level.SEVERE, null, ex2);
	} catch (IllegalAccessException ex3) {
	    Logger.getLogger(UI_Principal.class.getName()).log(Level.SEVERE, null, ex3);
	} catch (UnsupportedLookAndFeelException ex4) {
	    Logger.getLogger(UI_Principal.class.getName()).log(Level.SEVERE, null, ex4);
	}
	EventQueue.invokeLater(() -> new UI_Principal().setVisible(true));
    }

    /*
     * public Pessoa pegarPessoa(final int cod) { final Pessoa p = new Pessoa(); int
     * i = 0; System.out.println(this.Texto_Nome.getText()); if
     * (this.Texto_Nome.getText().isBlank()) {
     * System.out.println("entrou no nome como ''"); do { try {
     * p.setNome(JOptionPane.showInputDialog(UI_Principal.jPanel1,
     * "O nome é obrigatório!")); if (p.getNome().isBlank()) { i = 0; } else { i =
     * 1; } } catch (Exception e) {
     * JOptionPane.showMessageDialog(UI_Principal.jPanel1, e.getMessage()); i = 0; }
     * } while (i == 0); } else { p.setNome(this.Texto_Nome.getText()); } if
     * (this.Texto_Idade.getText().isBlank()) { do { try {
     * p.setIdade(Integer.parseInt(JOptionPane.showInputDialog(UI_Principal.jPanel1,
     * "Insira Um Valor Numérico para a idade!!!"))); if (p.getIdade() == 0) { i =
     * 1; } else { i = 0; } } catch (NumberFormatException e2) {
     * JOptionPane.showMessageDialog(UI_Principal.jPanel1, "Isso é um número?\n\n" +
     * e2.getMessage(), "Deu Ruim...", 0); i = 1; } } while (i == 1); } else {
     * p.setIdade(Integer.parseInt(this.Texto_Idade.getText())); } if
     * (this.Texto_Email.getText().isBlank()) { do { try {
     * p.setEmail(JOptionPane.showInputDialog(UI_Principal.jPanel1,
     * "Informe seu Email\nO e-mail é obrigatório!")); if (p.getEmail().isBlank()) {
     * i = 1; } else { i = 0; } } catch (Exception ex) {
     * JOptionPane.showMessageDialog(UI_Principal.jPanel1, ex.getMessage()); i = 1;
     * } } while (i == 1); } else { p.setEmail(this.Texto_Email.getText()); } if
     * (this.Texto_Cidade.getText().isBlank()) { do { try {
     * p.setCidade(JOptionPane.showInputDialog(this.jLabel1,
     * "Informe sua cidade por favor...")); if (p.getCidade().isBlank()) { i = 1; }
     * else { i = 0; } } catch (Exception ex) { i = 1;
     * JOptionPane.showMessageDialog(this.jLabel1, ex.getMessage()); } } while (i ==
     * 1); } else { p.setCidade(this.Texto_Cidade.getText()); } if (cod == 1) {
     * p.setId(Integer.parseInt(this.Texto_ID.getText())); } return p; }
     */

    private void limparTextos() {
	this.Botao_Editar.setEnabled(false);
	this.Botao_Excluir.setEnabled(false);
	this.Texto_ID.setText("");
	this.Texto_Cidade.setText("");
	this.Texto_Email.setText("");
	this.Texto_Idade.setText("");
	this.Texto_Nome.setText("");
    }
}