import java.util.ArrayList;

public class GameEngine {

    public void fight(ArrayList<Player> players) {
        for (Player player : players) {
            player.fighting(players);
        }

        for (Player player : players) {
            player.setFight(false);
        }
    }

    public void startGame(GameInput gameInput, ArrayList<Player> players, Map map) {
        for (int i = 0; i < gameInput.getNrOfRounds(); ++i) {
            System.out.println("Inceputul rundei  " + i);
            for (Player player : players) {
                System.out.println(player.getHp());
              //  System.out.println("POZITIA: " + player.getCoordinateX() + " " + player.getCoordinateY());
                player.dotEffect();
            }
            fight(players);
            System.out.println("FINALUL RUNDEI:  " + i);
            for (Player player : players) {
                System.out.println(player.getHp());
                player.move(player.getDirections().get(i), map.getPlayGround().get(0).size(), map);
              //  System.out.println("POZITIA DUPA MUTARE: " + player.getCoordinateX() + " " + player.getCoordinateY());
                if (player instanceof Rogue) {

                } else if (player instanceof Wizard) {


                } else if (player instanceof Pyromancer) {

                } else if (player instanceof  Knight) {

                }
            }
        }
        fight(players);
        System.out.println("THE END");
        for (Player player : players) {
            player.levelUp();
            System.out.println(player.getType() + " " + player.getLevel() + " " + player.getXp() + " " + player.getHp());
        }
    }

}
