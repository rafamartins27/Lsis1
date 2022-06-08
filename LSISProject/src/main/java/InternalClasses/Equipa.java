package InternalClasses;

import java.sql.Date;

public class Equipa {

    private int idEquipa;
    private String nomeEquipa;
    private Date dataCriacao;

    public Equipa(int idEquipa, String nomeEquipa, Date dataCriacao) {
        this.idEquipa = idEquipa;
        this.nomeEquipa = nomeEquipa;
        this.dataCriacao = dataCriacao;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNomeEquipa() {
        return nomeEquipa;
    }

    public void setNomeEquipa(String nomeEquipa) {
        this.nomeEquipa = nomeEquipa;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Equipa{" +
                "idEquipa=" + idEquipa +
                ", nomeEquipa='" + nomeEquipa + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
