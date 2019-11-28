package main;
import fileio.FileSystem;
import heroes.Player;
import map.Map;
import java.io.IOException;
import java.util.ArrayList;

public final class GameEngine {

    public void fight(final ArrayList<Player> players) {
        for (Player player : players) {
            player.fighting(players);
            player.setNrOfTimesFighting(player.getNrOfTimesFighting() + 1);
        }
        for (Player player : players) {
            player.setFight(false);
        }
    }

    public void startGame(final GameInput gameInput, final ArrayList<Player> players,
                          final Map map, final FileSystem fs) throws IOException {
        for (int i = 0; i < gameInput.getNrOfRounds(); ++i) {
            for (Player player : players) {
                player.dotEffect();
                if (player.getHp() <= 0) {
                    player.setHp(0);
                    player.setDead(true);
                }
            }
            for (Player player : players) {
                player.setNrOfRoundsDOT(player.getNrOfRoundsDOT() - 1);
                if (!player.isStunned()) {
                    player.move(player.getDirections().get(i), map.getPlayGround().
                            get(0).size(), map);
                } else {
                    player.setStunnedRounds(player.getStunnedRounds() - 1);
                    if (player.getStunnedRounds() == 0) {
                        player.setStunned(false);
                    }
                }
            }
            fight(players);
            for (Player player : players) {
                if (player.getHp() < 0) {
                    player.setHp(0);
                }
            }
            for (Player player : players) {
                player.levelUp();
            }
        }

        for (Player player : players) {
            if (player.getHp() > 0) {
                fs.writeWord(player.getType());
                fs.writeCharacter(' ');
                fs.writeInt(player.getLevel());
                fs.writeCharacter(' ');
                fs.writeInt(player.getXp());
                fs.writeCharacter(' ');
                fs.writeInt(player.getHp());
                fs.writeCharacter(' ');
                fs.writeInt(player.getCoordinateY());
                fs.writeCharacter(' ');
                fs.writeInt(player.getCoordinateX());
                fs.writeNewLine();
             } else {
                fs.writeWord(player.getType());
                fs.writeCharacter(' ');
                fs.writeWord("dead");
                fs.writeNewLine();
            }
        }
        fs.close();
    }
}
