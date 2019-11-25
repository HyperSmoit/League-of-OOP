//package com.tema2.main;

import java.util.ArrayList;

public class GameInput {
    ArrayList<ArrayList<Character>> Map;
    ArrayList<Player> players;
    Integer nrOfPlayers;
    Integer nrOfRounds;
    ArrayList<ArrayList<Character>> directions;

    GameInput(ArrayList<ArrayList<Character>> Map,
              int nrOfPlayers, ArrayList<Player> playersInfo, int nrOfRounds, ArrayList<ArrayList<Character>> directions) {
            this.Map = Map;
            this.nrOfPlayers = nrOfPlayers;
            this.players = playersInfo;
            this.nrOfRounds = nrOfRounds;
            this.directions = directions;
    }


    public ArrayList<ArrayList<Character>> getMap() {
        return Map;
    }

    public int getNrOfPlayers() {
        return nrOfPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getNrOfRounds() {
        return nrOfRounds;
    }

    public ArrayList<ArrayList<Character>> getDirections() {
        return directions;
    }

}
