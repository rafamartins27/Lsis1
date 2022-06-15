package InternalClasses;

public class AssociarJuri {

    private int idAssJuri;
    private int idJuri;
    private int idCompeticao;

    public AssociarJuri(int idAssJuri, int idJuri, int idCompeticao) {
        this.idAssJuri = idAssJuri;
        this.idJuri = idJuri;
        this.idCompeticao = idCompeticao;
    }

    public int getIdAssJuri() {
        return idAssJuri;
    }

    public void setIdAssJuri(int idAssJuri) {
        this.idAssJuri = idAssJuri;
    }

    public int getIdJuri() {
        return idJuri;
    }

    public void setIdJuri(int idJuri) {
        this.idJuri = idJuri;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    @Override
    public String toString() {
        return "AssociarJuri{" +
                "idAssJuri=" + idAssJuri +
                ", idJuri=" + idJuri +
                ", idCompeticao=" + idCompeticao +
                '}';
    }
}
