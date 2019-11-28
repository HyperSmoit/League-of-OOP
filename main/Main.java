package main;
import heroes.Player;
import map.Map;

import java.io.IOException;
import java.util.ArrayList;

abstract class Main {

    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        GameEngine gameEngine = new GameEngine();
        ArrayList<Player> players = gameInput.getPlayers();
        Map map = new Map(gameInput.getMap());
        gameEngine.startGame(gameInput, players, map, gameInputLoader.getFs());
    }
}
