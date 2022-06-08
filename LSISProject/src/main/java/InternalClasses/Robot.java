package InternalClasses;

public class Robot {

    private int idRobot;
    private int idEquipa;
    private String nomeRobot;
    private String MACAdress;

    public Robot(int idRobot, int idEquipa, String nomeRobot, String MACAdress) {
        this.idRobot++;
        this.idEquipa = idEquipa;
        this.nomeRobot = nomeRobot;
        this.MACAdress = MACAdress;
    }

    public int getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNomeRobot() {
        return nomeRobot;
    }

    public void setNomeRobot(String nomeRobot) {
        this.nomeRobot = nomeRobot;
    }

    public String getMACAdress() {
        return MACAdress;
    }

    public void setMACAdress(String MACAdress) {
        this.MACAdress = MACAdress;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "idRobot=" + idRobot +
                ", idEquipa=" + idEquipa +
                ", nomeRobot='" + nomeRobot + '\'' +
                ", MACAdress='" + MACAdress + '\'' +
                '}';
    }
}
