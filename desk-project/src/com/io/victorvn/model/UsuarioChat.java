package com.io.victorvn.model;


public class UsuarioChat {

    private int id;
    private Usuario usuario;
    private Chat chat;
    private String favorito;
    private String admin;

    public UsuarioChat() {
    }

    public UsuarioChat(int id, Usuario usuario, Chat chat, String favorito, String admin) {
        this.id = id;
        this.usuario = usuario;
        this.chat = chat;
        this.favorito = favorito;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "UsuarioChat{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", chat=" + chat +
                ", favorito='" + favorito + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
