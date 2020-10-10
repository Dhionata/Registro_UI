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

import static br.com.banco.BuscaBancoSQLite.*;

public class Ui extends JFrame implements ActionListener {
    private static JPanel jPanel1;
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
        this.getTexto_ID().setEditable(false);
        this.getBotao_Editar().setEnabled(false);
        this.getBotao_Excluir().setEnabled(false);

        this.getBotao_Pesquisar().setEnabled(new File("SQLite.db").exists());
    }

    public static void main(final String[] args) {
        try {
            //JOptionPane.showMessageDialog(getjPanel1(), "UIManager vai ser iniciado.");
            UIManager.LookAndFeelInfo[] installedLookAndFeels;
            for (int length = (installedLookAndFeels = UIManager
                    .getInstalledLookAndFeels()).length, i = 0; i < length; ++i) {
                UIManager.LookAndFeelInfo info = installedLookAndFeels[i];
                if ("Windows".equals(info.getName())) {
                    //JOptionPane.showMessageDialog(getjPanel1(), "entrou no if\n nome da classe");
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException
                | InstantiationException ex) {
            Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(getjPanel1(), "Deu ruim na classe");
        }
        //JOptionPane.showMessageDialog(getjPanel1(), "Passou por tudo, vai abrir ;D");
        EventQueue.invokeLater(() -> new Ui().setVisible(true));
    }

    public static JPanel getjPanel1() {
        return jPanel1;
    }

    public static void setjPanel1(JPanel jPanel1) {
        Ui.jPanel1 = jPanel1;
    }

    // parte 'gráfica'
    private void initComponents() {
        Ui.setjPanel1(new JPanel());
        JLabel jLabel1 = new JLabel();
        JPanel jPanel6 = new JPanel();
        JPanel jPanel5 = new JPanel();
        setBotao_Salvar(new JButton());
        setBotao_Editar(new JButton());
        setBotao_Pesquisar(new JButton());
        setBotao_Excluir(new JButton());
        JLabel jLabel6 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        setTexto_ID(new JTextField());
        setTexto_Nome(new JTextField());
        setTexto_Email(new JTextField());
        setTexto_Cidade(new JTextField());
        setTexto_Idade(new JTextField());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setResizable(false);
        Ui.getjPanel1().setBackground(new Color(0, 204, 255));
        Ui.getjPanel1().setBorder(BorderFactory.createTitledBorder(""));
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("Pessoas");
        jLabel1.setToolTipText("");
        GroupLayout jPanel1Layout = new GroupLayout(Ui.getjPanel1());
        Ui.getjPanel1().setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(102, 102, 102).addComponent(jLabel1, -2, 171, -2)
                        .addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1, -1, -1, 32767)
                        .addContainerGap()));
        jPanel6.setBorder(new LineBorder(new Color(0, 204, 255), 1, true));
        getBotao_Salvar().setBackground(new Color(0, 204, 255));
        getBotao_Salvar().setText("Salvar");
        getBotao_Salvar().addActionListener(this);
        getBotao_Editar().setBackground(new Color(0, 204, 255));
        getBotao_Editar().setText("Atualizar");
        getBotao_Editar().addActionListener(this);
        getBotao_Pesquisar().setBackground(new Color(0, 204, 255));
        getBotao_Pesquisar().setText("Pesquisar");
        getBotao_Pesquisar().addActionListener(this);
        getBotao_Excluir().setBackground(new Color(0, 204, 255));
        getBotao_Excluir().setText("Excluir");
        getBotao_Excluir().addActionListener(this);
        final GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(getBotao_Salvar()).addComponent(getBotao_Editar()).addComponent(this.getBotao_Pesquisar())
                .addComponent(getBotao_Excluir()));
        jPanel5Layout.linkSize(0, getBotao_Editar(), getBotao_Excluir(), this.getBotao_Pesquisar(), this.getBotao_Salvar());
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addGap(0, 0, 0)
                        .addComponent(getBotao_Excluir(), -1, -1, 32767).addGap(18, 18, 18)
                        .addComponent(getBotao_Pesquisar(), -1, -1, 32767).addGap(18, 18, 18)
                        .addComponent(getBotao_Editar(), -1, -1, 32767).addGap(18, 18, 18)
                        .addComponent(getBotao_Salvar(), -1, -1, 32767)));
        jLabel6.setText("Nome");
        jLabel8.setText("ID");
        jLabel9.setText("Cidade");
        jLabel10.setText("Email");
        jLabel11.setText("Idade");
        getTexto_ID().setBackground(new Color(0, 204, 255));
        getTexto_ID().setFont(new Font("Arial", Font.BOLD, 14));
        getTexto_ID().addActionListener(this);
        getTexto_Nome().setBackground(new Color(0, 204, 255));
        getTexto_Nome().setFont(new Font("Arial", Font.BOLD, 14));
        getTexto_Nome().addActionListener(this);
        getTexto_Email().setBackground(new Color(0, 204, 255));
        getTexto_Email().setFont(new Font("Arial", Font.BOLD, 14));
        getTexto_Email().addActionListener(this);
        getTexto_Cidade().setBackground(new Color(0, 204, 255));
        getTexto_Cidade().setFont(new Font("Arial", Font.BOLD, 14));
        getTexto_Cidade().addActionListener(this);
        getTexto_Idade().setBackground(new Color(0, 204, 255));
        getTexto_Idade().setFont(new Font("Arial", Font.BOLD, 14));
        getTexto_Idade().addActionListener(this);
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
                                .addComponent(getTexto_ID(), -2, 40, -2)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(getTexto_Nome(), -2, 176, -2)
                                                .addComponent(getTexto_Email(), -2, 176, -2)
                                                .addComponent(getTexto_Cidade(), -2, 176, -2)
                                                .addComponent(getTexto_Idade(), -2, 40, -2))
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
                                        .addComponent(jLabel8, -2, 22, -2).addComponent(this.getTexto_ID(), -2, -1, -2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, -2, 22, -2).addComponent(this.getTexto_Nome(), -2, -1, -2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10, -2, 22, -2).addComponent(this.getTexto_Email(), -2, -1, -2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9, -2, 22, -2).addComponent(this.getTexto_Cidade(), -2, -1, -2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, -2, 22, -2)
                                        .addComponent(this.getTexto_Idade(), -2, -1, -2))))
                        .addContainerGap(-1, 32767)));
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(Ui.getjPanel1(), GroupLayout.Alignment.TRAILING, -1, -1, 32767)
                .addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(jPanel6, -2, -1, -2)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
                        .addComponent(Ui.getjPanel1(), -2, -1, -2).addGap(0, 0, 0).addComponent(jPanel6, -1, -1, 32767)));
        pack();
    }

    // chamando os métodos com o clique do botão
    @Override
    public void actionPerformed(final ActionEvent evt) {
        if (evt.getSource() == getBotao_Excluir()) {
            Botao_ExcluirActionPerformed();
        } else if (evt.getSource() == getBotao_Pesquisar()) {
            Botao_PesquisarActionPerformed();
        } else if (evt.getSource() == getBotao_Editar()) {
            Botao_EditarActionPerformed();
        } else if (evt.getSource() == getBotao_Salvar()) {
            Botao_SalvarActionPerformed();
        } else if (evt.getSource() == getTexto_ID()) {
            Texto_IDActionPerformed();
        } else if (evt.getSource() == getTexto_Cidade()) {
            Texto_CidadeActionPerformed();
        } else if (evt.getSource() == getTexto_Idade()) {
            Texto_IdadeActionPerformed();
        } else if (evt.getSource() == getTexto_Email()) {
            Texto_EmailActionPerformed();
        } else if (evt.getSource() == getTexto_Nome()) {
            Texto_NomeActionPerformed();
        }
    }

    // botões
    private void Botao_EditarActionPerformed() {
        try {
            System.out.println("Botão Atualizar Apertado");

            if (!getTexto_ID().getText().trim().isEmpty() && !getTexto_Nome().getText().trim().isEmpty()
                    && !getTexto_Email().getText().trim().isEmpty()) {
                Pessoa p = Pessoa.createPessoa();
                p.setId(Integer.parseInt(getTexto_ID().getText()));
                p.setNome(getTexto_Nome().getText().trim());
                p.setCidade(getTexto_Cidade().getText().trim());
                p.setEmail(getTexto_Email().getText().trim());
                p.setIdade(Integer.parseInt(getTexto_Idade().getText().trim()));
                AtualizarBancoSQL.createAtualizarBancoSQL(p);
                this.Botao_PesquisarActionPerformed();
            } else {
                if (getTexto_ID().getText().trim().isEmpty()) {
                    System.out.println("Você não pode atualizar alguém não salvo...");
                    JOptionPane.showMessageDialog(getjPanel1(), "Você não pode atualizar alguém não salvo...");
                }
                if (getTexto_Nome().getText().trim().isEmpty()) {
                    System.out.println("Você não pode deixar uma pessoa sem nome...");
                    JOptionPane.showMessageDialog(getjPanel1(), "Você não pode deixar uma pessoa sem nome...");
                }
                if (getTexto_Email().getText().trim().isEmpty()) {
                    System.out.println("Precisa de um e-mail...");
                    JOptionPane.showMessageDialog(getjPanel1(),
                            "Precisamos do e-mail para contato, e ele deve ser único...");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(getjPanel1(), "Então, deu algum problema com números\n--Erro--" + e.getMessage());
            e.printStackTrace();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(getjPanel1(), "Cara.. ocorreu um problema\n--Erro--\n" + e.getMessage());
            e.printStackTrace();
        }

    }

    private void Botao_PesquisarActionPerformed() {
        try {
            System.out.println("Botão Pesquisar Apertado");
            if (!(getTexto_Nome().getText().trim().isEmpty())) {
                Pessoa p;
                p = BuscaNoBancoSQLite(getTexto_Nome().getText().trim());
                if (p.getNome() == null) {
                    JOptionPane.showMessageDialog(Ui.getjPanel1(), "Pessoa Não encontrada!");
                    limparTextos();
                } else {
                    getTexto_ID().setText(Integer.toString(p.getId()));
                    getTexto_Nome().setText(p.getNome().trim());
                    getTexto_Cidade().setText(p.getCidade().trim());
                    getTexto_Email().setText(p.getEmail().trim());
                    getTexto_Idade().setText(Integer.toString(p.getIdade()));
                    getBotao_Excluir().setEnabled(true);
                    getBotao_Editar().setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(getjPanel1(), "Cara... vc tem que preencher o nome pra pesquisar...");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(getjPanel1(),
                    "Problema no botão pesquisar, me reporte por favor...\n--Erro--\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void Botao_ExcluirActionPerformed() {
        try {
            System.out.println("Botão Excluir Apertado");
            int del = JOptionPane.showConfirmDialog(getjPanel1(), "Você tem certeza que quer excluir?", "Deletar",
                    JOptionPane.YES_NO_OPTION);
            if (del == 0) {
                ExcluirDoBancoSQLite.createExcluirDoBancoSQLite(getTexto_Nome().getText());
                limparTextos();
                System.out.println("Confirmado e efetuado a exclusão");
            } else {
                System.out.println("Exclusão não efetuada, botão Cancelar apertado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getjPanel1(),
                    "Então... o botão excluir tá com algum problema, me reporte.\n--Erro--\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void Botao_SalvarActionPerformed() {
        try {
            System.out.println("Botão Salvar Apertado");
            if (!getTexto_Nome().getText().trim().isEmpty() && !getTexto_Idade().getText().trim().isEmpty()
                    && !getTexto_Email().getText().trim().isEmpty() && !getTexto_Cidade().getText().trim().isEmpty()) {
                Pessoa p = Pessoa.createPessoa();
                p.setNome(getTexto_Nome().getText().trim());
                p.setCidade(getTexto_Cidade().getText().trim());
                p.setEmail(getTexto_Email().getText().trim());
                try {
                    p.setIdade(Integer.parseInt(getTexto_Idade().getText().trim()));
                    System.out.println("Setou idade..." + p.getIdade());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(getjPanel1(), "Cara...\ntem q ser um número\n--Erro--\n" + e.getMessage());
                    return;
                }
                System.out.println("Vai tentar inserir...");
                InserirPessoa.createInserirPessoa(p);
                limparTextos();
                getBotao_Pesquisar().setEnabled(new File("SQLite.db").exists());
            } else {
                JOptionPane.showMessageDialog(getjPanel1(), "Olha... vc tem que ter preencher tudo pra salvar...");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getjPanel1(),
                    "Desculpe, Salvar não está funcionando... corretamente...\n--Erro--" + e.getMessage());
            e.printStackTrace();
        }
    }

    // textos
    private void Texto_IDActionPerformed() {
        if (this.getTexto_ID().getText().trim().isEmpty()) {
            limparTextos();
            getBotao_Editar().setEnabled(false);
            getBotao_Excluir().setEnabled(false);
            getBotao_Salvar().setEnabled(true);
        } else {
            getBotao_Editar().setEnabled(true);
            getBotao_Excluir().setEnabled(true);
            getBotao_Salvar().setEnabled(false);
        }
    }

    private void Texto_CidadeActionPerformed() {
    }

    private void Texto_IdadeActionPerformed() {
    }

    private void Texto_EmailActionPerformed() {
    }

    private void Texto_NomeActionPerformed() {
        if (getTexto_Nome().getText().trim().isEmpty()) {
            limparTextos();
        }
    }

    // limpa os textos se clicar 'enter' com o campo 'nome' limpo
    private void limparTextos() {
        getBotao_Editar().setEnabled(false);
        getBotao_Excluir().setEnabled(false);
        getTexto_ID().setText("");
        getTexto_Cidade().setText("");
        getTexto_Email().setText("");
        getTexto_Idade().setText("");
        getTexto_Nome().setText("");
    }

    public JButton getBotao_Editar() {
        return Botao_Editar;
    }

    public void setBotao_Editar(JButton botao_Editar) {
        Botao_Editar = botao_Editar;
    }

    public JButton getBotao_Excluir() {
        return Botao_Excluir;
    }

    public void setBotao_Excluir(JButton botao_Excluir) {
        Botao_Excluir = botao_Excluir;
    }

    public JButton getBotao_Pesquisar() {
        return Botao_Pesquisar;
    }

    public void setBotao_Pesquisar(JButton botao_Pesquisar) {
        Botao_Pesquisar = botao_Pesquisar;
    }

    public JButton getBotao_Salvar() {
        return Botao_Salvar;
    }

    public void setBotao_Salvar(JButton botao_Salvar) {
        Botao_Salvar = botao_Salvar;
    }

    public JTextField getTexto_Cidade() {
        return Texto_Cidade;
    }

    public void setTexto_Cidade(JTextField texto_Cidade) {
        Texto_Cidade = texto_Cidade;
    }

    public JTextField getTexto_Email() {
        return Texto_Email;
    }

    public void setTexto_Email(JTextField texto_Email) {
        Texto_Email = texto_Email;
    }

    public JTextField getTexto_ID() {
        return Texto_ID;
    }

    public void setTexto_ID(JTextField texto_ID) {
        Texto_ID = texto_ID;
    }

    public JTextField getTexto_Idade() {
        return Texto_Idade;
    }

    public void setTexto_Idade(JTextField texto_Idade) {
        Texto_Idade = texto_Idade;
    }

    public JTextField getTexto_Nome() {
        return Texto_Nome;
    }

    public void setTexto_Nome(JTextField texto_Nome) {
        Texto_Nome = texto_Nome;
    }
}