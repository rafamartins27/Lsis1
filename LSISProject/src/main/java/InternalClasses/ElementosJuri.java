package InternalClasses;

public class ElementosJuri {

    private int idJuri;
    private String nomeJuri;

    public ElementosJuri(int idJuri, String nomeJuri) {
        this.idJuri++;
        this.nomeJuri = nomeJuri;
    }

    public int getIdJuri() {
        return idJuri;
    }

    public void setIdJuri(int idJuri) {
        this.idJuri = idJuri;
    }

    public String getNomeJuri() {
        return nomeJuri;
    }

    public void setNomeJuri(String nomeJuri) {
        this.nomeJuri = nomeJuri;
    }

    @Override
    public String toString() {
        return "ElementosJuri{" +
                "idJuri=" + idJuri +
                ", nomeJuri='" + nomeJuri + '\'' +
                '}';
    }
}
