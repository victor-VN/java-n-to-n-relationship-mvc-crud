package com.io.victorvn.model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String avatar;
    private String descricao;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String avatar, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.avatar = avatar;
        this.descricao = descricao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
