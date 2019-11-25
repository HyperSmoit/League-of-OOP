import java.util.ArrayList;

public class GameEngine {

    public void fight(ArrayList<Player> players) {
        for (Player player : players) {

        }
    }

    public void startGame(GameInput gameInput, ArrayList<Player> players, Map map) {
        int i = 0;
        for (ArrayList<Character> arr : gameInput.getDirections()) {
            for (Player player : players) {
                player.move(arr.get(players.indexOf(player)), map.getPlayGround().get(0).size(), map);
            }
            System.out.println("RUNDA: " + ++i);

            for (Player player : players) {
                player.fighting(players);
            }
            for (Player player : players) {
                player.setFight(false);
            }

        }
    }

}
