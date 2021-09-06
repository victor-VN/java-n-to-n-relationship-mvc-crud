package com.io.victorvn.model;

public class Chat {

    private int id;
    private String nome;
    private String status;
    private int capacidade;
    private String assunto;

    public Chat() {
    }

    public Chat(int id, String nome, String status, int capacidade, String assunto) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.capacidade = capacidade;
        this.assunto = assunto;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                ", capacidade=" + capacidade +
                ", assunto='" + assunto + '\'' +
                '}';
    }
}
