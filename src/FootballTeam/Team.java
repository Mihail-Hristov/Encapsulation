package FootballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void removePlayer(Player player, String name) {
        if (!this.players.remove(player)) {
            System.out.println(String.format("Player %s is not in %s team.", name, this.getName()));
        }
    }

    public double getRating() {

        return players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum();
    }
}
