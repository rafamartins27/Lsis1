package InternalClasses;

public class Ronda {

    private int id_Ronda;
    private String tipo;
    private String nome;
    private int id_Competicao;

    public Ronda() {
    }

    public Ronda(String tipo, int id_Competicao) {
        this.tipo = tipo;
        this.id_Competicao = id_Competicao;
    }

    public Ronda(int id_Competicao, String tipo, String nome) {
        this.id_Competicao = id_Competicao;
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getId_Ronda() {
        return id_Ronda;
    }

    public void setId_Ronda(int id_Ronda) {
        this.id_Ronda = id_Ronda;
    }

    public int getId_Competicao() {
        return id_Competicao;
    }

    public void setId_Competicao(int id_Competicao) {
        this.id_Competicao = id_Competicao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Ronda{" +
                "id_Ronda=" + id_Ronda +
                ", id_Competicao=" + id_Competicao +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome +
                '}';
    }
}
