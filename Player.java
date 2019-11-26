import java.util.ArrayList;

public class Player {
    private String type;
    private Integer coordinateX;
    private Integer coordinateY;
    private Integer hp;
    private Integer initialHp;
    private Integer xp = 0;
    private Integer level = 0;
    private Integer dmg;
    private Integer dot; //dot stands for Damage over Time
    private Integer stunned = 0;
    private Character terrain;
    boolean fight = false;
    private Integer nrOfRoundsDOT = 0;
    private boolean dead = false;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Integer getNrOfRoundsDOT() {
        return nrOfRoundsDOT;
    }

    public void setNrOfRoundsDOT(Integer nrOfRoundsDOT) {
        this.nrOfRoundsDOT = nrOfRoundsDOT;
    }

    private ArrayList<Character> directions = new ArrayList<>();


    public Player() {
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public String getType() {
        return type;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getLevel() {
        return level;
    }

    public void move(Character direction, Integer nrLines, Map map) {
        if (direction.equals('U') && coordinateY >= 1) {
            this.coordinateY--;
        } else if (direction.equals('D') && coordinateY <= nrLines - 1) {
            this.coordinateY++;
        } else if (direction.equals('L') && coordinateX >= 1) {
            this.coordinateX--;
        } else if (direction.equals('R') && coordinateX <= nrLines - 1) {
            this.coordinateX++;
        }
        this.setTerrain(map.getPlayGround().get(getCoordinateX()).get(getCoordinateY()));

    }
    public void levelUp() {
        while (xp >= 250 + level*50) {
            level++;
            if (this instanceof Rogue) {
                this.setInitialHp(600 + 40 * level);
            } else if (this instanceof Wizard) {
                this.setInitialHp(400 + 30 * level);
            } else if (this instanceof Knight) {
                this.setInitialHp(900 + 80 * level);
            } else if (this instanceof Pyromancer) {
                this.setInitialHp(500 + 50 * level);
            }
            this.setHp(this.getInitialHp());
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setTerrain(Character terrain) {
        this.terrain = terrain;
    }

    public Character getTerrain() {
        return terrain;
    }

    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }

    public ArrayList<Character> getDirections() {
        return directions;
    }

    public void setDirections(ArrayList<Character> directions) {
        this.directions = directions;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getInitialHp() {
        return initialHp;
    }

    public void setInitialHp(Integer initialHp) {
        this.initialHp = initialHp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDmg() {
        return dmg;
    }

    public void setDmg(Integer dmg) {
        this.dmg = dmg;
    }

    public Integer getDot() {
        return dot;
    }

    public void setDot(Integer dot) {
        this.dot = dot;
    }

    public Integer getStunned() {
        return stunned;
    }

    public void setStunned(Integer stunned) {
        this.stunned = stunned;
    }
    public void fight(Player enemy) {

    }

    public void dotEffect() {
        if (this.getNrOfRoundsDOT() > 0 && this.getHp() > 0) {
            this.setHp(this.getHp() - this.getDot());
            this.setNrOfRoundsDOT(this.getNrOfRoundsDOT() - 1);
            if (this.getNrOfRoundsDOT() == 0) {
                this.setDot(0);
            }
        }
    }

    public void fighting(ArrayList<Player> players) {
        for (Player player : players) {
            if (player.equals(this) == false && player.isFight() == false && this.fight == false && player.getHp() > 0) {
                if (player.getCoordinateY() == this.getCoordinateY() && player.getCoordinateX() == this.getCoordinateX() && this.getHp() > 0) {
                    if (this instanceof Wizard && player instanceof Rogue) {
                        Wizard wizard = (Wizard) this;
                        player.fight(wizard);
                    } else {
                        this.fight(player);
                    }
                }
            }
        }
    }


}
