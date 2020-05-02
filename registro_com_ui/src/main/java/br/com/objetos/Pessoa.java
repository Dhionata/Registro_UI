package br.com.objetos;

public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String cidade;
    private int idade;

    public Pessoa() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void imprimir() {
        System.out.println("-- Pessoa --\nID: " + getId() + "\nNome: " + getNome() + "\nIdade: " + getIdade()
                + "\nEmail: " + getEmail() + "\nCidade: " + getCidade());
    }
}