package InternalClasses;

public class Robot {

    private int id_Robo;
    private String nome_robo;
    private String macAdress;
    private int id_Equipa;
    private int id_Competicao;

    public Robot() {
    }

    public Robot(String nome_robo, String macAdress, int id_Equipa) {
        this.nome_robo = nome_robo;
        this.macAdress = macAdress;
        this.id_Equipa = id_Equipa;
    }

    public Robot(int id_Robo, int id_Equipa, String nome_robo, String macAdress, int id_Competicao) {
        this.id_Robo = id_Robo;
        this.id_Equipa = id_Equipa;
        this.nome_robo = nome_robo;
        this.macAdress = macAdress;
        this.id_Competicao = id_Competicao;
    }

    public int getId_Robo() {
        return id_Robo;
    }

    public void setId_Robo(int id_Robo) {
        this.id_Robo = id_Robo;
    }

    public int getId_Equipa() {
        return id_Equipa;
    }

    public void setId_Equipa(int id_Equipa) {
        this.id_Equipa = id_Equipa;
    }

    public String getNome_robo() {
        return nome_robo;
    }

    public void setNome_robo(String nome_robo) {
        this.nome_robo = nome_robo;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public int getId_Competicao() {
        return id_Competicao;
    }

    public void setId_Competicao(int id_Competicao) {
        this.id_Competicao = id_Competicao;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id_Robo=" + id_Robo +
                ", nome_robo='" + nome_robo + '\'' +
                ", macAdress='" + macAdress + '\'' +
                ", id_Equipa=" + id_Equipa + '\'' +
                ", id_Competicao=" + id_Competicao +
                '}';
    }
}
