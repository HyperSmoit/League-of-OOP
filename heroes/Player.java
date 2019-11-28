package heroes;
import map.Map;
import utils.Constants;

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
    private boolean stunned = false;
    private Integer stunnedRounds = 0;
    private Character terrain;
    private boolean fight = false;
    private Integer nrOfRoundsDOT = 0;
    private boolean dead = false;
    private int nrOfTimesFighting = 0;
    private Constants constants = new Constants();

    public final int getNrOfTimesFighting() {
        return nrOfTimesFighting;
    }

    public final void setNrOfTimesFighting(final int nrOfTimesFighting) {
        this.nrOfTimesFighting = nrOfTimesFighting;
    }

    public final boolean isDead() {
        return dead;
    }

    public final void setDead(final boolean dead) {
        this.dead = dead;
    }

    public final Integer getStunnedRounds() {
        return stunnedRounds;
    }

    public final void setStunnedRounds(final Integer stunnedRounds) {
        this.stunnedRounds = stunnedRounds;
    }

    public final Integer getNrOfRoundsDOT() {
        return nrOfRoundsDOT;
    }

    public final void setNrOfRoundsDOT(final Integer nrOfRoundsDOT) {
        this.nrOfRoundsDOT = nrOfRoundsDOT;
    }

    private ArrayList<Character> directions = new ArrayList<>();

    public final Constants getConstants() {
        return constants;
    }

    public Player() {
    }

    public final Integer getCoordinateX() {
        return coordinateX;
    }

    public final Integer getCoordinateY() {
        return coordinateY;
    }

    public final String getType() {
        return type;
    }

    public final Integer getHp() {
        return hp;
    }

    public final Integer getXp() {
        return xp;
    }

    public final Integer getLevel() {
        return level;
    }

    public final void move(final Character direction, final Integer nrLines,
                     final Map map) {
        if (direction.equals('U') && coordinateY >= 1) {
            this.coordinateY--;
        } else if (direction.equals('D') && coordinateY <= nrLines - 1) {
            this.coordinateY++;
        } else if (direction.equals('L') && coordinateX >= 1) {
            this.coordinateX--;
        } else if (direction.equals('R') && coordinateX <= nrLines - 1) {
            this.coordinateX++;
        }
        this.setTerrain(map.getPlayGround().get(getCoordinateY()).get(getCoordinateX()));

    }
    public final void levelUp() {
        if (this.hp > 0) {
            while (xp >= constants.getXpLevelUp() + level * constants.getXpMultiplierLevel()) {
                level++;
                if (this instanceof Rogue) {
                    this.setInitialHp(constants.getBaseHpRogue() + constants.getHpRoguePerLevel()
                            * level);
                } else if (this instanceof Wizard) {
                    this.setInitialHp(constants.getBaseHpWizard()
                            + constants.getHpWizardPerLevel() * level);
                } else if (this instanceof Knight) {
                    this.setInitialHp(constants.getBaseHpKnight()
                            + constants.getHpKnightPerLevel() * level);
                } else if (this instanceof Pyromancer) {
                    this.setInitialHp(constants.getBaseHpPyromancer()
                            + constants.getHpPyromancerPerLevel() * level);
                }
                this.setHp(this.getInitialHp());
            }
        }
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final void setCoordinateX(final Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public final void setCoordinateY(final Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public final void setTerrain(final Character terrain) {
        this.terrain = terrain;
    }

    public final Character getTerrain() {
        return terrain;
    }

    public final boolean isFight() {
        return fight;
    }

    public final void setFight(final boolean fight) {
        this.fight = fight;
    }

    public final ArrayList<Character> getDirections() {
        return directions;
    }

    public final void setHp(final Integer hp) {
        this.hp = hp;
    }

    public final Integer getInitialHp() {
        return initialHp;
    }

    public final void setInitialHp(final Integer initialHp) {
        this.initialHp = initialHp;
    }

    public final void setXp(final Integer xp) {
        this.xp = xp;
    }

    public final void setLevel(final Integer level) {
        this.level = level;
    }

    public final Integer getDmg() {
        return dmg;
    }

    public final void setDmg(final Integer dmg) {
        this.dmg = dmg;
    }

    public final Integer getDot() {
        return dot;
    }

    public final void setDot(final Integer dot) {
        this.dot = dot;
    }

    public final boolean isStunned() {
        return stunned;
    }

    public final void setStunned(final boolean stunned) {
        this.stunned = stunned;
    }

    public void fight(final Player enemy) {

    }

    public final void dotEffect() {
        if (this.getNrOfRoundsDOT() > 0 && this.getHp() > 0) {
            this.setHp(this.getHp() - this.getDot());
            if (this.getNrOfRoundsDOT() == 0) {
                this.setDot(0);
            }
        }
    }

    public final void fighting(final ArrayList<Player> players) {
        for (Player player : players) {
            if (!player.equals(this) && !player.isFight() && !this.fight
                    && player.getHp() > 0 && !player.isDead()) {
                if (player.getCoordinateY() == this.getCoordinateY() && player.getCoordinateX()
                        == this.getCoordinateX() && this.getHp() > 0) {

                    /* The following if else block is to do the same fight even if
                     P1 fights P2 or P2 fights P1. The order doesn't matter, it's the same fight
                     and it works the same
                     i.e. Rogue vs Wizard on Desert it's the same as Wizard vs Rogue on Desert
                     */
                    if (this instanceof Wizard && player instanceof Rogue) {
                        Wizard wizard = (Wizard) this;
                        player.fight(wizard);
                    } else if (this instanceof Wizard && player instanceof Knight) {
                        Wizard wizard = (Wizard) this;
                        player.fight(wizard);
                    } else if (this instanceof Wizard && player instanceof Pyromancer) {
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
