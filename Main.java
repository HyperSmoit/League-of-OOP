import java.util.ArrayList;

//package com.tema2.main;
public class Main {

    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        GameEngine gameEngine = new GameEngine();
        ArrayList<Player> players = gameInput.getPlayers();
        Map map = new Map(gameInput.getMap());
        gameEngine.startGame(gameInput, players, map);

        // write your code here
    }
}
