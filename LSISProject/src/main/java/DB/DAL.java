package DB;

import InternalClasses.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAL {

    public static void insertClient(Team t) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Team (teamName, teamId, creationDate) VALUES (?,?,?)");
            stmt.setString(1, t.getTeamName());
            stmt.setInt(2, t.getTeamId());
            stmt.setDate(3, t.getCreationDate());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
