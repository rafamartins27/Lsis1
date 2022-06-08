package InternalClasses;

public class Ronda {

    private int idRonda;
    private int idCompeticao;
    private String tipoRonda;
    private String nomeRonda;

    public Ronda(int idRonda, int idCompeticao, String tipoRonda, String nomeRonda) {
        this.idRonda++;
        this.idCompeticao = idCompeticao;
        this.tipoRonda = tipoRonda;
        this.nomeRonda = nomeRonda;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public String getTipoRonda() {
        return tipoRonda;
    }

    public void setTipoRonda(String tipoRonda) {
        this.tipoRonda = tipoRonda;
    }

    public String getNomeRonda() {
        return nomeRonda;
    }

    public void setNomeRonda(String nomeRonda) {
        this.nomeRonda = nomeRonda;
    }

    @Override
    public String toString() {
        return "Ronda{" +
                "idRonda=" + idRonda +
                ", idCompeticao=" + idCompeticao +
                ", tipoRonda='" + tipoRonda + '\'' +
                ", nomeRonda='" + nomeRonda + '\'' +
                '}';
    }
}
