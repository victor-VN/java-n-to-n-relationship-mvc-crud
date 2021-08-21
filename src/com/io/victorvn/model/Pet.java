package com.io.victorvn.model;

public class Pet {

    private int id;
    private String nome;
    private String tipo;
    private String idade;

    public Pet() {
    }

    public Pet(int id, String nome, String tipo, String idade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }
}
