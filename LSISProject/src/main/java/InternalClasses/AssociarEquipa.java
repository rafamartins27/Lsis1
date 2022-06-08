package InternalClasses;

import java.sql.Date;

public class AssociarEquipa {

    private int idAssEquipa;
    private int idCompeticao;
    private int idEquipa;
    private Date dataAssEquipa;

    public AssociarEquipa(int idAssEquipa, int idCompeticao, int idEquipa, Date dataAssEquipa) {
        this.idAssEquipa++;
        this.idCompeticao = idCompeticao;
        this.idEquipa = idEquipa;
        this.dataAssEquipa = dataAssEquipa;
    }

    public int getIdAssEquipa() {
        return idAssEquipa;
    }

    public void setIdAssEquipa(int idAssEquipa) {
        this.idAssEquipa = idAssEquipa;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public Date getDataAssEquipa() {
        return dataAssEquipa;
    }

    public void setDataAssEquipa(Date dataAssEquipa) {
        this.dataAssEquipa = dataAssEquipa;
    }

    @Override
    public String toString() {
        return "AssociarEquipa{" +
                "idAssEquipa=" + idAssEquipa +
                ", idCompeticao=" + idCompeticao +
                ", idEquipa=" + idEquipa +
                ", dataAssEquipa=" + dataAssEquipa +
                '}';
    }
}
