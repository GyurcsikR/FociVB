package hu.progmatic;

import java.util.Objects;

public class VBmatch {
    private int year;
    private String stage;
    private String date;
    private String team_a;
    private String team_b;
    private int goals_a;
    private int goals_b;
    private int penalties_a;
    private int penalties_b;

    public VBmatch() {
    }

    public VBmatch(int year, String stage, String date, String team_a, String team_b, int goals_a, int goals_b, int penalties_a, int penalties_b) {
        this.year = year;
        this.stage = stage;
        this.date = date;
        this.team_a = team_a;
        this.team_b = team_b;
        this.goals_a = goals_a;
        this.goals_b = goals_b;
        this.penalties_a = penalties_a;
        this.penalties_b = penalties_b;
    }
    public VBmatch(String line){
        String[] parts = line.split(";");
        this.year = Integer.parseInt(parts[0]);
        this.stage = parts[1];
        this.date = parts[2];
        this.team_a = parts[3];
        this.team_b = parts[4];
        this.goals_a = Integer.parseInt(parts[5]);
        this.goals_b = Integer.parseInt(parts[6]);

    }
    public int getDifference(){
        return Math.abs(this.goals_a - this.goals_b);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeam_a() {
        return team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public int getGoals_a() {
        return goals_a;
    }

    public void setGoals_a(int goals_a) {
        this.goals_a = goals_a;
    }

    public int getGoals_b() {
        return goals_b;
    }

    public void setGoals_b(int goals_b) {
        this.goals_b = goals_b;
    }

    public int getPenalties_a() {
        return penalties_a;
    }

    public void setPenalties_a(int penalties_a) {
        this.penalties_a = penalties_a;
    }

    public int getPenalties_b() {
        return penalties_b;
    }

    public void setPenalties_b(int penalties_b) {
        this.penalties_b = penalties_b;
    }

    @Override
    public String toString() {
        return "VBmatch{" +
                "year=" + year +
                ", stage='" + stage + '\'' +
                ", date='" + date + '\'' +
                ", team_a='" + team_a + '\'' +
                ", team_b='" + team_b + '\'' +
                ", goals_a=" + goals_a +
                ", goals_b=" + goals_b +
                ", penalties_a=" + penalties_a +
                ", penalties_b=" + penalties_b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VBmatch vBmatch = (VBmatch) o;
        return year == vBmatch.year && goals_a == vBmatch.goals_a && goals_b == vBmatch.goals_b && penalties_a == vBmatch.penalties_a && penalties_b == vBmatch.penalties_b && stage.equals(vBmatch.stage) && date.equals(vBmatch.date) && team_a.equals(vBmatch.team_a) && team_b.equals(vBmatch.team_b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, stage, date, team_a, team_b, goals_a, goals_b, penalties_a, penalties_b);
    }
}
