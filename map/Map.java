package map;
import java.util.ArrayList;

public final class Map {
    private final ArrayList<ArrayList<Character>> playGround;
    public Map(final ArrayList<ArrayList<Character>> playGround) {
        this.playGround = playGround;
    }
    public ArrayList<ArrayList<Character>> getPlayGround() {
        return playGround;
    }

}
