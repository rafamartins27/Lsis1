package InternalClasses;

public class AssociarRobot {

    private int idAssRobot;
    private int idRobot;
    private int idRonda;
    private double velocidade;
    private double tempo;

    public AssociarRobot(int idAssRobot, int idRobot, int idRonda, double velocidade, double tempo) {
        this.idAssRobot = idAssRobot;
        this.idRobot = idRobot;
        this.idRonda = idRonda;
        this.velocidade = velocidade;
        this.tempo = tempo;
    }

    public int getIdAssRobot() {
        return idAssRobot;
    }

    public void setIdAssRobot(int idAssRobot) {
        this.idAssRobot = idAssRobot;
    }

    public int getIdRobot() {
        return idRobot;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "AssociarRobot{" +
                "idAssRobot=" + idAssRobot +
                ", idRobot=" + idRobot +
                ", idRonda=" + idRonda +
                ", velocidade=" + velocidade +
                ", tempo=" + tempo +
                '}';
    }
}
