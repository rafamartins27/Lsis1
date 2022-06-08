package DB;

import InternalClasses.Equipa;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAL {

    public static void insertClient(Equipa t) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Team (teamName, teamId, creationDate) VALUES (?,?,?)");
            stmt.setString(1, t.getNomeEquipa());
            stmt.setInt(2, t.getIdEquipa());
            stmt.setDate(3, t.getDataCriacao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
