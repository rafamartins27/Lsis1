package InternalClasses;

import java.sql.Date;

public class Equipa {

    private int id_equipa;
    private String Nome;
    private String data_criacao;

    public Equipa() {
    }

    public Equipa(String nome) {
        Nome = nome;
    }

    public Equipa(String Nome, String data_criacao) {
        this.Nome = Nome;
        this.data_criacao = data_criacao;
    }

    public int getId_equipa() {
        return id_equipa;
    }

    public void setId_equipa(int id_equipa) {
        this.id_equipa = id_equipa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    @Override
    public String toString() {
        return "Equipa{" +
                "id_equipa=" + id_equipa +
                ", Nome='" + Nome + '\'' +
                ", data_criacao=" + data_criacao +
                '}';
    }
}
