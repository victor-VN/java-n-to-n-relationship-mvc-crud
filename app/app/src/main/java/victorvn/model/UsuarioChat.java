package victorvn.model;


public class UsuarioChat {

    private int id;
    private Usuario usuario;
    private Chat chat;

    public UsuarioChat() {
    }

    public UsuarioChat(int id, Usuario usuario, Chat chat) {
        this.id = id;
        this.usuario = usuario;
        this.chat = chat;
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

    @Override
    public String toString() {
        return "UsuarioChat{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", chat=" + chat +
                '}';
    }
}
