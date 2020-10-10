package br.com.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import br.com.banco.AtualizarBancoSQL;
import br.com.banco.BuscaBancoSQLite;
import br.com.banco.ExcluirDoBancoSQLite;
import br.com.banco.InserirPessoa;
import br.com.objetos.Pessoa;

public class Ui extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static JPanel jPanel1;
    private JButton Botao_Editar;
    private JButton Botao_Excluir;
    private JButton Botao_Pesquisar;
    private JButton Botao_Salvar;
    private JTextField Texto_Cidade;
    private JTextField Texto_Email;
    private JTextField Texto_ID;
    private JTextField Texto_Idade;
    private JTextField Texto_Nome;

    public Ui() {
	this.initComponents();
	this.setLocationRelativeTo(null);
	this.Texto_ID.setEditable(false);
	this.Botao_Editar.setEnabled(false);
	this.Botao_Excluir.setEnabled(false);

	this.Botao_Pesquisar.setEnabled(new File("SQLite.db").exists());
    }

    public static void main(final String[] args) {
	try {
	    JOptionPane.showMessageDialog(jPanel1, "UIManager vai ser iniciado.");
	    UIManager.LookAndFeelInfo[] installedLookAndFeels;
	    for (int length = (installedLookAndFeels = UIManager
		    .getInstalledLookAndFeels()).length, i = 0; i < length; ++i) {
		UIManager.LookAndFeelInfo info = installedLookAndFeels[i];
		if ("Windows".equals(info.getName())) {
		    JOptionPane.showMessageDialog(jPanel1, "entrou no if\n nome da classe");
		    UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException
		| InstantiationException ex) {
	    Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
	    JOptionPane.showMessageDialog(jPanel1, "Deu ruim na classe");
	}
	JOptionPane.showMessageDialog(jPanel1, "Passou por tudo, vai abrir ;D");
	EventQueue.invokeLater(() -> new Ui().setVisible(true));
    }

    // parte 'gráfica'
    private void initComponents() {
	Ui.jPanel1 = new JPanel();
	JLabel jLabel1 = new JLabel();
	JPanel jPanel6 = new JPanel();
	JPanel jPanel5 = new JPanel();
	this.Botao_Salvar = new JButton();
	this.Botao_Editar = new JButton();
	this.Botao_Pesquisar = new JButton();
	this.Botao_Excluir = new JButton();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();
	JLabel jLabel10 = new JLabel();
	JLabel jLabel11 = new JLabel();
	this.Texto_ID = new JTextField();
	this.Texto_Nome = new JTextField();
	this.Texto_Email = new JTextField();
	this.Texto_Cidade = new JTextField();
	this.Texto_Idade = new JTextField();
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	this.setAlwaysOnTop(true);
	this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	this.setResizable(false);
	Ui.jPanel1.setBackground(new Color(0, 204, 255));
	Ui.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
	jLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
	jLabel1.setHorizontalAlignment(0);
	jLabel1.setText("Pessoas");
	jLabel1.setToolTipText("");
	GroupLayout jPanel1Layout = new GroupLayout(Ui.jPanel1);
	Ui.jPanel1.setLayout(jPanel1Layout);
	jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup().addGap(102, 102, 102).addComponent(jLabel1, -2, 171, -2)
			.addContainerGap(-1, 32767)));
	jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, -1, -1, 32767)
			.addContainerGap()));
	jPanel6.setBorder(new LineBorder(new Color(0, 204, 255), 1, true));
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
	final GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
	jPanel5.setLayout(jPanel5Layout);
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
	jLabel6.setText("Nome");
	jLabel8.setText("ID");
	jLabel9.setText("Cidade");
	jLabel10.setText("Email");
	jLabel11.setText("Idade");
	this.Texto_ID.setBackground(new Color(0, 204, 255));
	this.Texto_ID.setFont(new Font("Arial", Font.BOLD, 14));
	this.Texto_ID.addActionListener(this);
	this.Texto_Nome.setBackground(new Color(0, 204, 255));
	this.Texto_Nome.setFont(new Font("Arial", Font.BOLD, 14));
	this.Texto_Nome.addActionListener(this);
	this.Texto_Email.setBackground(new Color(0, 204, 255));
	this.Texto_Email.setFont(new Font("Arial", Font.BOLD, 14));
	this.Texto_Email.addActionListener(this);
	this.Texto_Cidade.setBackground(new Color(0, 204, 255));
	this.Texto_Cidade.setFont(new Font("Arial", Font.BOLD, 14));
	this.Texto_Cidade.addActionListener(this);
	this.Texto_Idade.setBackground(new Color(0, 204, 255));
	this.Texto_Idade.setFont(new Font("Arial", Font.BOLD, 14));
	this.Texto_Idade.addActionListener(this);
	final GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
	jPanel6.setLayout(jPanel6Layout);
	jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup().addContainerGap()
			.addGroup(jPanel6Layout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel6, -2, 45, -2)
				.addComponent(jLabel10, -2, 45, -2).addComponent(jLabel8, -2, 45, -2)
				.addComponent(jLabel9, -2, 45, -2).addComponent(jLabel11, -2, 45, -2))
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
					.addComponent(jPanel5, -2, -1, -2)))
			.addContainerGap()));
	jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
			.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel6Layout.createSequentialGroup().addGap(52, 52, 52).addComponent(jPanel5, -2, -1,
				-2))
			.addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel8, -2, 22, -2).addComponent(this.Texto_ID, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel6, -2, 22, -2).addComponent(this.Texto_Nome, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel10, -2, 22, -2).addComponent(this.Texto_Email, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel9, -2, 22, -2).addComponent(this.Texto_Cidade, -2, -1, -2))
				.addGap(18, 18, 18)
				.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel11, -2, 22, -2)
					.addComponent(this.Texto_Idade, -2, -1, -2))))
			.addContainerGap(-1, 32767)));
	final GroupLayout layout = new GroupLayout(this.getContentPane());
	this.getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addComponent(Ui.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
		.addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(jPanel6, -2, -1, -2)));
	layout.setVerticalGroup(
		layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
			.addComponent(Ui.jPanel1, -2, -1, -2).addGap(0, 0, 0).addComponent(jPanel6, -1, -1, 32767)));
	this.pack();
    }

    // chamando os métodos com o clique do botão
    @Override
    public void actionPerformed(final ActionEvent evt) {
	if (evt.getSource() == this.Botao_Excluir) {
	    this.Botao_ExcluirActionPerformed();
	} else if (evt.getSource() == this.Botao_Pesquisar) {
	    this.Botao_PesquisarActionPerformed();
	} else if (evt.getSource() == this.Botao_Editar) {
	    this.Botao_EditarActionPerformed();
	} else if (evt.getSource() == this.Botao_Salvar) {
	    this.Botao_SalvarActionPerformed();
	} else if (evt.getSource() == this.Texto_ID) {
	    this.Texto_IDActionPerformed();
	} else if (evt.getSource() == this.Texto_Cidade) {
	    this.Texto_CidadeActionPerformed();
	} else if (evt.getSource() == this.Texto_Idade) {
	    this.Texto_IdadeActionPerformed();
	} else if (evt.getSource() == this.Texto_Email) {
	    this.Texto_EmailActionPerformed();
	} else if (evt.getSource() == this.Texto_Nome) {
	    this.Texto_NomeActionPerformed();
	}
    }

    // botões
    private void Botao_EditarActionPerformed() {
	try {
	    System.out.println("Botão Atualizar Apertado");

	    if (!Texto_ID.getText().trim().isEmpty() && !Texto_Nome.getText().trim().isEmpty()
		    && !Texto_Email.getText().trim().isEmpty()) {
		Pessoa p = new Pessoa();
		p.setId(Integer.parseInt(Texto_ID.getText()));
		p.setNome(Texto_Nome.getText().trim());
		p.setCidade(Texto_Cidade.getText().trim());
		p.setEmail(Texto_Email.getText().trim());
		p.setIdade(Integer.parseInt(Texto_Idade.getText().trim()));
		new AtualizarBancoSQL(p);
		this.Botao_PesquisarActionPerformed();
	    } else {
		if (Texto_ID.getText().trim().isEmpty()) {
		    System.out.println("Você não pode atualizar alguém não salvo...");
		    JOptionPane.showMessageDialog(jPanel1, "Você não pode atualizar alguém não salvo...");
		}
		if (Texto_Nome.getText().trim().isEmpty()) {
		    System.out.println("Você não pode deixar uma pessoa sem nome...");
		    JOptionPane.showMessageDialog(jPanel1, "Você não pode deixar uma pessoa sem nome...");
		}
		if (Texto_Email.getText().trim().isEmpty()) {
		    System.out.println("Precisa de um e-mail...");
		    JOptionPane.showMessageDialog(jPanel1,
			    "Precisamos do e-mail para contato, e ele deve ser único...");
		}
	    }
	} catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(jPanel1, "Então, deu algum problema com números\n--Erro--" + e.getMessage());
	    e.printStackTrace();
	} catch (HeadlessException e) {
	    JOptionPane.showMessageDialog(jPanel1, "Cara.. ocorreu um problema\n--Erro--\n" + e.getMessage());
	    e.printStackTrace();
	}

    }

    private void Botao_PesquisarActionPerformed() {
	try {
	    System.out.println("Botão Pesquisar Apertado");
	    if (!Texto_Nome.getText().trim().isEmpty()) {
		Pessoa p;
		p = BuscaBancoSQLite.BuscaNoBancoSQLite(this.Texto_Nome.getText().trim());
		if (p.getNome() == null) {
		    JOptionPane.showMessageDialog(Ui.jPanel1, "Pessoa Não encontrada!");
		    this.limparTextos();
		} else {
		    this.Texto_ID.setText(Integer.toString(p.getId()));
		    this.Texto_Nome.setText(p.getNome().trim());
		    this.Texto_Cidade.setText(p.getCidade().trim());
		    this.Texto_Email.setText(p.getEmail().trim());
		    this.Texto_Idade.setText(Integer.toString(p.getIdade()));
		    this.Botao_Excluir.setEnabled(true);
		    this.Botao_Editar.setEnabled(true);
		}
	    } else {
		JOptionPane.showMessageDialog(jPanel1, "Cara... vc tem que preencher o nome pra pesquisar...");
	    }
	} catch (HeadlessException e) {
	    JOptionPane.showMessageDialog(jPanel1,
		    "Problema no botão pesquisar, me reporte por favor...\n--Erro--\n" + e.getMessage());
	    e.printStackTrace();
	}
    }

    private void Botao_ExcluirActionPerformed() {
	try {
	    System.out.println("Botão Excluir Apertado");
	    int del = JOptionPane.showConfirmDialog(jPanel1, "Você tem certeza que quer excluir?", "Deletar",
		    JOptionPane.YES_NO_OPTION);
	    if (del == 0) {
		new ExcluirDoBancoSQLite(Texto_Nome.getText());
		this.limparTextos();
		System.out.println("Confirmado e efetuado a exclusão");
	    } else {
		System.out.println("Exclusão não efetuada, botão Cancelar apertado");
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jPanel1,
		    "Então... o botão excluir tá com algum problema, me reporte.\n--Erro--\n" + e.getMessage());
	    e.printStackTrace();
	}
    }

    private void Botao_SalvarActionPerformed() {
	try {
	    System.out.println("Botão Salvar Apertado");
	    if (!Texto_Nome.getText().trim().isEmpty() && !Texto_Idade.getText().trim().isEmpty()
		    && !Texto_Email.getText().trim().isEmpty() && !Texto_Cidade.getText().trim().isEmpty()) {
		Pessoa p = new Pessoa();
		p.setNome(Texto_Nome.getText().trim());
		p.setCidade(Texto_Cidade.getText().trim());
		p.setEmail(Texto_Email.getText().trim());
		try {
		    p.setIdade(Integer.parseInt(Texto_Idade.getText().trim()));
		    System.out.println("Setou idade..." + p.getIdade());
		} catch (Exception e) {
		    JOptionPane.showMessageDialog(jPanel1, "Cara...\ntem q ser um número\n--Erro--\n" + e.getMessage());
		    return;
		}
		System.out.println("Vai tentar inserir...");
		new InserirPessoa(p);
		this.limparTextos();
		this.Botao_Pesquisar.setEnabled(new File("SQLite.db").exists());
	    } else {
		JOptionPane.showMessageDialog(jPanel1, "Olha... vc tem que ter preencher tudo pra salvar...");
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jPanel1,
		    "Desculpe, Salvar não está funcionando... corretamente...\n--Erro--" + e.getMessage());
	    e.printStackTrace();
	}
    }

    // textos
    private void Texto_IDActionPerformed() {
	if (this.Texto_ID.getText().trim().isEmpty()) {
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

    private void Texto_CidadeActionPerformed() {
    }

    private void Texto_IdadeActionPerformed() {
    }

    private void Texto_EmailActionPerformed() {
    }

    private void Texto_NomeActionPerformed() {
	if (this.Texto_Nome.getText().trim().isEmpty()) {
	    this.limparTextos();
	}
    }

    // limpa os textos se clicar 'enter' com o campo 'nome' limpo
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