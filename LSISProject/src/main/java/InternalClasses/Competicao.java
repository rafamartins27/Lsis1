package InternalClasses;

import java.sql.Date;

public class Competicao {

    private int id_Comp;
    private String nome_Comp;
    private Date data_criacao;

    public Competicao() {
    }

    public Competicao(String nome_Comp, Date data_criacao) {
        this.nome_Comp = nome_Comp;
        this.data_criacao = data_criacao;
    }

    public int getId_Comp() {
        return id_Comp;
    }

    public void setId_Comp(int id_Comp) {
        this.id_Comp = id_Comp;
    }

    public String getNome_Comp() {
        return nome_Comp;
    }

    public void setNome_Comp(String nome_Comp) {
        this.nome_Comp = nome_Comp;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    @Override
    public String toString() {
        return "Competicao{" +
                "id_Comp=" + id_Comp +
                ", nome_Comp='" + nome_Comp + '\'' +
                ", data_criacao=" + data_criacao +
                '}';
    }
}
