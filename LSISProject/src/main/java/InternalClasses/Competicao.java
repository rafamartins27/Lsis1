package InternalClasses;

import java.sql.Date;

public class Competicao {

    private int idCompeticao;
    private String nomeCompeticao;
    private Date dataCompeticao;

    public Competicao(int idCompeticao, String nomeCompeticao, Date dataCompeticao) {
        this.idCompeticao++;
        this.nomeCompeticao = nomeCompeticao;
        this.dataCompeticao = dataCompeticao;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public Date getDataCompeticao() {
        return dataCompeticao;
    }

    public void setDataCompeticao(Date dataCompeticao) {
        this.dataCompeticao = dataCompeticao;
    }

    @Override
    public String toString() {
        return "Competicao{" +
                "idCompeticao=" + idCompeticao +
                ", nomeCompeticao='" + nomeCompeticao + '\'' +
                ", dataCompeticao=" + dataCompeticao +
                '}';
    }
}
