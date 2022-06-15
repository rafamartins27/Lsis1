package InternalClasses;

public class ElementosJuri {

    private int id;
    private String Nome;

    private int id_Competicao;

    public ElementosJuri() {
    }

    public ElementosJuri(int id, String Nome, int id_Competicao) {
        this.id = id;
        this.Nome = Nome;
        this.id_Competicao = id_Competicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getId_Competicao() {
        return id_Competicao;
    }

    public void setId_Competicao(int id_Competicao) {
        this.id_Competicao = id_Competicao;
    }

    @Override
    public String toString() {
        return "ElementosJuri{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", id_Competicao='" + id_Competicao +
                '}';
    }
}
