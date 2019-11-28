package main;
import heroes.Player;
import java.util.ArrayList;

public final class GameInput {
    private ArrayList<ArrayList<Character>> map;
    private ArrayList<Player> players;
    private Integer nrOfPlayers;
    private Integer nrOfRounds;
    private ArrayList<ArrayList<Character>> directions;

    GameInput(final ArrayList<ArrayList<Character>> map,
              final int nrOfPlayers, final ArrayList<Player> playersInfo, final int nrOfRounds,
              final ArrayList<ArrayList<Character>> directions) {
            this.map = map;
            this.nrOfPlayers = nrOfPlayers;
            this.players = playersInfo;
            this.nrOfRounds = nrOfRounds;
            this.directions = directions;
    }

    public ArrayList<ArrayList<Character>> getMap() {
        return map;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getNrOfRounds() {
        return nrOfRounds;
    }

}
