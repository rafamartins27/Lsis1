package DB;

import InternalClasses.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DAL {


    //==============================  CRIAR  ===========================//
    public static void criarCompeticao(Competicao competicao) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Competicao (id_Comp, nome_Comp, data_criacao) VALUES (?,?,?)");
            stmt.setInt(1, competicao.getId_Comp());
            stmt.setString(2, competicao.getNome_Comp());
            stmt.setString(3, competicao.getData_criacao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void criarEquipa(Equipa equipa) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Equipa (id_equipa, Nome, data_criacao) VALUES (?,?,?)");
            stmt.setInt(1, equipa.getId_equipa());
            stmt.setString(2, equipa.getNome());
            stmt.setString(3, equipa.getData_criacao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void criarJuri(ElementosJuri juri) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Juri (id, Nome, id_Competicao) VALUES (?,?,?)");
            stmt.setInt(1, juri.getId());
            stmt.setString(2, juri.getNome());
            stmt.setInt(3, juri.getId_Competicao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void criarRobot(Robot robot) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Robo (id_Robo, nome_robo, macAdress, id_Equipa, id_Competicao) VALUES (?,?,?,?,?)");
            stmt.setInt(1, robot.getId_Robo());
            stmt.setString(2, robot.getNome_robo());
            stmt.setString(3, robot.getMacAdress());
            stmt.setInt(4, robot.getId_Equipa());
            stmt.setInt(5, robot.getId_Competicao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void criarRonda(Ronda ronda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ronda (id_Ronda, tipo, nome, id_Competicao) VALUES (?,?,?,?)");
            stmt.setInt(1, ronda.getId_Ronda());
            stmt.setString(2, ronda.getTipo());
            stmt.setString(3, ronda.getNome());
            stmt.setInt(4, ronda.getId_Competicao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //==============================  PROCURAR  ===========================//

    public static Competicao procurarCompeticao(int id_Comp) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao WHERE id_Comp=?");
            stmt.setInt(1, id_Comp);
            rs = stmt.executeQuery();
            Competicao returnCompeticao = new Competicao();
            if (rs.next()) {
                returnCompeticao.setNome_Comp(rs.getString("nome_Comp"));
                returnCompeticao.setData_criacao(rs.getString("data_criacao"));
            }
            conn.close();
            return returnCompeticao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Equipa procurarEquipa(int id_equipa) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao WHERE id_equipa=?");
            stmt.setInt(1, id_equipa);
            rs = stmt.executeQuery();
            Equipa returnEquipa = new Equipa();
            if (rs.next()) {
                returnEquipa.setNome(rs.getString("Nome"));
                returnEquipa.setData_criacao(rs.getString("data_criacao"));
            }
            conn.close();
            return returnEquipa;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static ElementosJuri procurarJuri(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            ElementosJuri returnJuri = new ElementosJuri();
            if (rs.next()) {
                returnJuri.setNome(rs.getString("Nome"));
                returnJuri.setId_Competicao(rs.getInt("id_Competicao"));
            }
            conn.close();
            return returnJuri;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Robot procurarRobot(int id_Robo) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao WHERE id_Robo=?");
            stmt.setInt(1, id_Robo);
            rs = stmt.executeQuery();
            Robot returnRobot = new Robot();
            if (rs.next()) {
                returnRobot.setNome_robo(rs.getString("nome_robo"));
                returnRobot.setMacAdress(rs.getString("macAdress"));
                returnRobot.setId_Equipa(rs.getInt("id_Equipa"));
                returnRobot.setId_Competicao(rs.getInt("id_Competicao"));
            }
            conn.close();
            return returnRobot;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static Ronda procurarRonda(int id_Ronda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao WHERE id_Ronda=?");
            stmt.setInt(1, id_Ronda);
            rs = stmt.executeQuery();
            Ronda returnRonda = new Ronda();
            if (rs.next()) {
                returnRonda.setTipo(rs.getString("tipo"));
                returnRonda.setNome(rs.getString("nome"));
                returnRonda.setId_Competicao(rs.getInt("id_Competicao"));
            }
            conn.close();
            return returnRonda;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
