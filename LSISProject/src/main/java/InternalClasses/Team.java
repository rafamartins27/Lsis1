package InternalClasses;

import java.sql.Date;

public class Team {

    private int teamId;
    private String teamName;
    private Date creationDate;

    public Team(int teamId, String teamName, Date creationDate) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.creationDate = creationDate;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
