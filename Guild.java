package guild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guild {
    String name;
    int capacity;
    List<Player> roster;

    public Guild (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer (Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer (String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                roster.remove(i);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer (String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                roster.get(i).setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer (String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                roster.get(i).setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass (String clazz) {
        Player player = null;
        Player[] kickedPlayers = new Player[roster.size()];
        for (int i = 0; i < roster.size(); i++) {
            if (this.roster.get(i).getClazz().equals(clazz)) {
                player = this.roster.remove(i);
                i--;

                Arrays.fill(kickedPlayers, player);
            }
        }

        return kickedPlayers;
    }

    public int count () {
        return this.roster.size();
    }

    public String report () {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Players in the guild: %s:", this.name)).append(System.lineSeparator());

        this.roster.forEach(e -> {
                builder.append(e.toString()).append(System.lineSeparator());
        });

        return builder.toString().trim();
    }
}
