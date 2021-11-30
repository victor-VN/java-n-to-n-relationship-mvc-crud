package victorvn.model;

public class Chat {

    private int id;
    private String nome;
    private int capacidade;
    private String assunto;

    public Chat() {
    }

    public Chat(int id, String nome, int capacidade, String assunto) {
        this.id = id;
        this.nome = nome;
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
                ", capacidade=" + capacidade +
                ", assunto='" + assunto + '\'' +
                '}';
    }
}
