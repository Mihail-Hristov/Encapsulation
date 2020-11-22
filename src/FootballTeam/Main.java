package FootballTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Map<String, Team> teams = new HashMap<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split(";");

            String command = tokens[0];

            try {
                doTheCommand(command, tokens, teams);
            }catch(Exception ignored){
            }


            input = reader.readLine();
        }
    }

    public static void doTheCommand(String command, String[] tokens, Map<String, Team> teams) throws Exception {
        String teamName = tokens[1];
        switch (command) {
            case "Team":
                try {
                    Team team = new Team(teamName);
                    teams.put(teamName, team);
                }catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    throw new Exception("");
                }

                break;
            case "Add":
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);

                if (!teams.containsKey(teamName)) {
                    System.out.println(String.format("Team %s does not exist.", teamName));
                    break;
                }

                try {
                    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    teams.get(teamName).addPlayer(player);
                }catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

                break;
            case "Remove":
                String playerForRemoving = tokens[2];
                teams.get(teamName).removePlayer(teams.get(teamName).getPlayer(playerForRemoving), playerForRemoving);

                break;
            case "Rating":
                if (!teams.containsKey(teamName)) {
                    System.out.println(String.format("Team %s does not exist.", teamName));
                    break;
                }
                System.out.println(String.format("%s - %.0f", teamName, teams.get(teamName).getRating()));

                break;
        }
    }
}
