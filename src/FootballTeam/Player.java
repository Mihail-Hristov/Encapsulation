package FootballTeam;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        Validator.validName(name);
        this.name = name;
    }

    private void setEndurance(int endurance) {
        Validator.validRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        Validator.validRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        Validator.validRange(dribble, "dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        Validator.validRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        Validator.validRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

}
